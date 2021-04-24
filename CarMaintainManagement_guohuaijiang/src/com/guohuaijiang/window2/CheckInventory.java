package com.guohuaijiang.window2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.guohuaijiang.dao.CarDao;
import com.guohuaijiang.dao.CarMaintainDao;
import com.guohuaijiang.dao.PartsDao;
import com.guohuaijiang.model.Car;
import com.guohuaijiang.model.CarMaintain;
import com.guohuaijiang.model.Parts;
import com.guohuaijiang.util.JDBCUtil;
import com.guohuaijiang.util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

/**
 * 查询全部库存功能的实现
 * 
 * @author 小江
 *
 */
public class CheckInventory extends JFrame {

	private JPanel contentPane;
	private JTable partsInformationTable;

	private JDBCUtil jdbc = new JDBCUtil();
	private PartsDao partsDao = new PartsDao();
	private JTextField idTxt;
	private JTextField partsNameTxt;
	private JTextField partsQuantityTxt;
	private JTextField partsPriceTxt;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckInventory frame = new CheckInventory();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CheckInventory() {
		setResizable(false);
		setTitle("\u6C7D\u8F66\u7EF4\u4FEE\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 716);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u67E5\u770B\u96F6\u4EF6\u5E93\u5B58");
		lblNewLabel.setIcon(new ImageIcon(CheckInventory.class.getResource("/icon/\u67E5\u8BE2.png")));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("华文彩云", Font.BOLD, 40));
		lblNewLabel.setBounds(199, 13, 316, 47);
		contentPane.add(lblNewLabel);

		/**
		 * 返回上一层(采购管理（PurchaseInterfaceImpl）)
		 */

		JLabel label = new JLabel("\u96F6\u4EF6\u4FE1\u606F");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("宋体", Font.BOLD, 20));
		label.setBounds(319, 73, 84, 24);
		contentPane.add(label);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(86, 110, 531, 262);
		contentPane.add(scrollPane);

		partsInformationTable = new JTable();
		partsInformationTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				partsInformationTableMousePressed(e);
			}
		});
		partsInformationTable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "\u7F16\u53F7",
				"\u96F6\u4EF6\u540D", "\u96F6\u4EF6\u6570\u91CF", "\u96F6\u4EF6\u4EF7\u683C" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(partsInformationTable);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null,
				Color.BLUE));
		panel.setBounds(86, 385, 531, 218);
		contentPane.add(panel);
		panel.setLayout(null);

		/**
		 * 信息修改
		 */
		JButton button_1 = new JButton("\u4FEE\u6539");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				partsInformationUpdateActionEvent(e);
			}
		});
		button_1.setIcon(new ImageIcon(CheckInventory.class.getResource("/icon/\u7EF4\u62A4\u83DC\u5355.png")));
		button_1.setBounds(207, 171, 110, 34);
		panel.add(button_1);
		button_1.setForeground(SystemColor.textHighlight);
		button_1.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		JButton btnNewButton = new JButton("\u5220\u9664");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				partsInformationDeleteActionEvent(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(CheckInventory.class.getResource("/icon/\u5220\u9664.png")));
		btnNewButton.setBounds(357, 171, 118, 34);
		panel.add(btnNewButton);
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setFont(new Font("华文琥珀", Font.PLAIN, 20));

		JLabel label_1 = new JLabel("\u7F16\u53F7    \uFF1A");
		label_1.setForeground(Color.GRAY);
		label_1.setFont(new Font("宋体", Font.BOLD, 20));
		label_1.setBounds(14, 41, 110, 24);
		panel.add(label_1);

		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		idTxt.setBounds(124, 43, 74, 24);
		panel.add(idTxt);
		idTxt.setColumns(10);

		JLabel label_2 = new JLabel("\u96F6\u4EF6\u540D  \uFF1A");
		label_2.setForeground(Color.GRAY);
		label_2.setFont(new Font("宋体", Font.BOLD, 20));
		label_2.setBounds(264, 41, 124, 24);
		panel.add(label_2);

		partsNameTxt = new JTextField();
		partsNameTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		partsNameTxt.setColumns(10);
		partsNameTxt.setBounds(381, 43, 105, 24);
		panel.add(partsNameTxt);

		JLabel label_3 = new JLabel("\u96F6\u4EF6\u6570\u91CF\uFF1A");
		label_3.setForeground(Color.GRAY);
		label_3.setFont(new Font("宋体", Font.BOLD, 20));
		label_3.setBounds(14, 117, 110, 24);
		panel.add(label_3);

		partsQuantityTxt = new JTextField();
		partsQuantityTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		partsQuantityTxt.setColumns(10);
		partsQuantityTxt.setBounds(124, 119, 105, 24);
		panel.add(partsQuantityTxt);

		JLabel label_4 = new JLabel("\u96F6\u4EF6\u4EF7\u683C\uFF1A");
		label_4.setForeground(Color.GRAY);
		label_4.setFont(new Font("宋体", Font.BOLD, 20));
		label_4.setBounds(264, 117, 110, 24);
		panel.add(label_4);

		partsPriceTxt = new JTextField();
		partsPriceTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		partsPriceTxt.setColumns(10);
		partsPriceTxt.setBounds(381, 119, 105, 24);
		panel.add(partsPriceTxt);
		JButton button = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u5C42");
		button.setBounds(42, 621, 162, 41);
		contentPane.add(button);
		button.setIcon(new ImageIcon(CheckInventory.class.getResource("/icon/\u8FD4\u56DE2.png")));
		button.setForeground(SystemColor.textHighlight);
		button.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PurchaseInterface frame = new PurchaseInterface();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});
		this.fillTable(new Parts());
		
		/**
		 * 插入背景
		 */
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/icon/02.jpg"));
        JLabel jl = new JLabel(icon);
        jl.setText("");
        jl.setBounds(0, 0, 719, 681);	        
        contentPane.add(jl, new Integer(Integer.MIN_VALUE));
	}
/**
 * 零件信息删除事件处理
 * @param e
 */
	private void partsInformationDeleteActionEvent(ActionEvent evt) {
		String id = idTxt.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要删除的记录！");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "确定要删除该记录吗？");
		if (n == 0) {
			Connection conn = null;

			try {
				conn = jdbc.getConnection();
				int deleteNum = partsDao.delete(conn, id);
				if (deleteNum == 1) {
					JOptionPane.showMessageDialog(null, "删除成功！");
					this.resetValue();
					this.fillTable(new Parts());
				} else {
					JOptionPane.showMessageDialog(null, "删除失败！");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					jdbc.closeCon(conn);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "删除失败！");
					e.printStackTrace();
				}
			}
		}

		
	}

	/**
	 * 零件信息修改事件处理
	 * 
	 * @param e
	 */
	private void partsInformationUpdateActionEvent(ActionEvent evt) {

		String id = idTxt.getText();
		String partsName = partsNameTxt.getText();
		String partsQuantity = partsQuantityTxt.getText();
		String partsPrice = partsPriceTxt.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录！");
			return;
		}
		if (StringUtil.isEmpty(partsName)) {
			JOptionPane.showMessageDialog(null, "零件名不能为空！");
			return;
		}
		if (StringUtil.isEmpty(partsQuantity)) {
			JOptionPane.showMessageDialog(null, "零件数量不能为空！");
			return;
		}
		if (StringUtil.isEmpty(partsPrice)) {
			JOptionPane.showMessageDialog(null, "零件价格不能为空！");
			return;
		}
		

		Parts parts = new Parts(Integer.parseInt(id), partsName,partsQuantity,partsPrice);
		Connection conn = null;
		try {
			conn = jdbc.getConnection();
			int modifyNum = partsDao.update(conn, parts);
			if (modifyNum == 1) {
				JOptionPane.showMessageDialog(null, "修改成功！");
				this.resetValue();
				this.fillTable(new Parts());
			} else {
				JOptionPane.showMessageDialog(null, "修改失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				jdbc.closeCon(conn);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "修改失败！");
				e.printStackTrace();
			}
		}

	}

	/**
	 * 表格重置
	 */
	private void resetValue() {
		this.idTxt.setText("");		
		this.partsNameTxt.setText("");
		this.partsQuantityTxt.setText("");
		this.partsPriceTxt.setText("");		
	}

	/**
	 * 表格行点击事件处理
	 * 
	 * @param e
	 */
	private void partsInformationTableMousePressed(MouseEvent e) {
		int row = partsInformationTable.getSelectedRow();
		idTxt.setText((String) partsInformationTable.getValueAt(row, 0));
		partsNameTxt.setText((String) partsInformationTable.getValueAt(row, 1));
		partsQuantityTxt.setText((String) partsInformationTable.getValueAt(row, 2));
		partsPriceTxt.setText((String) partsInformationTable.getValueAt(row, 3));

	}

	/**
	 * 初始化表格
	 */
	private void fillTable(Parts parts) {
		DefaultTableModel dtm = (DefaultTableModel) partsInformationTable.getModel();
		dtm.setRowCount(0);
		Connection conn = null;
		try {
			conn = jdbc.getConnection();
			ResultSet rs = partsDao.list(conn, parts);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("PartsName"));
				v.add(rs.getString("PartsNumber"));
				v.add(rs.getString("PartsPrice"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				jdbc.closeCon(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
