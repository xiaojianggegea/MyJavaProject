package com.guohuaijiang.window3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.guohuaijiang.dao.CarDao;
import com.guohuaijiang.dao.CarMaintainDao;
import com.guohuaijiang.model.Car;
import com.guohuaijiang.model.CarMaintain;
import com.guohuaijiang.util.JDBCUtil;
import com.guohuaijiang.util.StringUtil;
import com.guohuaijiang.window1.CarMaintainImpl;
import com.guohuaijiang.window1.MainMenuImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

/**
 * 查询车辆维修信息的实现
 * 
 * @author 小江
 *
 */
public class CheckCaMaintainrInformation extends JFrame {

	private JPanel contentPane;
	private JTable carMaintainTable;
	private JTextField CarNumberTxt;

	private JDBCUtil jdbc = new JDBCUtil();
	private CarMaintainDao carMaintainDao = new CarMaintainDao();
	private JTextField idTxt;
	private JTextField carNumberTxt;
	private JTextField partsNameTxt;
	private JTextField partsQuantityTxt;
	private JTextField repairNumberTxt;
	private JTextField repairWhenTxt;
	private JTextField repairCostTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckCaMaintainrInformation frame = new CheckCaMaintainrInformation();
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
	public CheckCaMaintainrInformation() {
		setResizable(false);
		setTitle("\u6C7D\u8F66\u7EF4\u4FEE\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 866, 769);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("\u7EF4\u4FEE\u4FE1\u606F");
		label.setIcon(new ImageIcon(CheckCaMaintainrInformation.class.getResource("/icon/\u67E5\u8BE2.png")));
		label.setForeground(Color.BLUE);
		label.setFont(new Font("华文彩云", Font.BOLD, 40));
		label.setBounds(334, 13, 236, 47);
		contentPane.add(label);

		/**
		 * 返回上一层
		 */
		JButton button = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u5C42");
		button.setIcon(new ImageIcon(CheckCaMaintainrInformation.class.getResource("/icon/\u8FD4\u56DE2.png")));
		button.setForeground(SystemColor.textHighlight);
		button.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		button.setBounds(14, 668, 187, 41);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				SynthesizeInquire frame = new SynthesizeInquire();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 119, 733, 242);
		contentPane.add(scrollPane);

		carMaintainTable = new JTable();
		carMaintainTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				carMaintainTableMousePressed(e);
			}
		});
		carMaintainTable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u7F16\u53F7", "\u8F66\u724C\u53F7\u7801", "\u96F6\u4EF6\u540D",
						"\u96F6\u4EF6\u6570\u91CF", "\u7EF4\u4FEE\u5DE5\u53F7", "\u7EF4\u4FEE\u65F6\u95F4",
						"\u7EF4\u4FEE\u8D39\u7528" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(carMaintainTable);
		this.fillTable(new CarMaintain());

		JLabel label_1 = new JLabel(
				"\u8F93\u5165\u8F66\u724C\u53F7\u7801\u8FDB\u884C\u7EF4\u4FEE\u4FE1\u606F\u67E5\u8BE2\uFF1A");
		label_1.setForeground(Color.GRAY);
		label_1.setFont(new Font("宋体", Font.BOLD, 20));
		label_1.setBounds(57, 82, 334, 24);
		contentPane.add(label_1);

		CarNumberTxt = new JTextField();
		CarNumberTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		CarNumberTxt.setBounds(405, 79, 212, 27);
		contentPane.add(CarNumberTxt);
		CarNumberTxt.setColumns(10);

		JButton button_3 = new JButton("\u67E5\u8BE2");
		button_3.setIcon(new ImageIcon(CheckCaMaintainrInformation.class.getResource("/icon/\u67E5\u8BE22.png")));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carNumberSearchActionPerformed(e);
			}
		});
		button_3.setForeground(SystemColor.textHighlight);
		button_3.setFont(new Font("华文琥珀", Font.BOLD, 20));
		button_3.setBounds(663, 75, 113, 31);
		contentPane.add(button_3);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null,
				Color.BLUE));
		panel.setBounds(51, 382, 733, 247);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel label_2 = new JLabel("\u7F16\u53F7\uFF1A");
		label_2.setForeground(Color.GRAY);
		label_2.setFont(new Font("宋体", Font.BOLD, 20));
		label_2.setBounds(20, 28, 72, 25);
		panel.add(label_2);

		idTxt = new JTextField();
		idTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		idTxt.setEditable(false);
		idTxt.setBounds(129, 28, 86, 24);
		panel.add(idTxt);
		idTxt.setColumns(10);

		JLabel label_3 = new JLabel("\u8F66\u724C\u53F7\u7801\uFF1A");
		label_3.setForeground(Color.GRAY);
		label_3.setFont(new Font("宋体", Font.BOLD, 20));
		label_3.setBounds(20, 76, 116, 25);
		panel.add(label_3);

		JLabel label_4 = new JLabel("\u96F6\u4EF6\u540D\uFF1A");
		label_4.setForeground(Color.GRAY);
		label_4.setFont(new Font("宋体", Font.BOLD, 20));
		label_4.setBounds(229, 76, 116, 25);
		panel.add(label_4);

		JLabel label_5 = new JLabel("\u96F6\u4EF6\u6570\u91CF\uFF1A");
		label_5.setForeground(Color.GRAY);
		label_5.setFont(new Font("宋体", Font.BOLD, 20));
		label_5.setBounds(457, 76, 116, 25);
		panel.add(label_5);

		JLabel label_6 = new JLabel("\u7EF4\u4FEE\u5DE5\u53F7\uFF1A");
		label_6.setForeground(Color.GRAY);
		label_6.setFont(new Font("宋体", Font.BOLD, 20));
		label_6.setBounds(20, 135, 116, 25);
		panel.add(label_6);

		JLabel label_7 = new JLabel("\u7EF4\u4FEE\u65F6\u95F4\uFF1A");
		label_7.setForeground(Color.GRAY);
		label_7.setFont(new Font("宋体", Font.BOLD, 20));
		label_7.setBounds(229, 135, 116, 25);
		panel.add(label_7);

		JLabel label_8 = new JLabel("\u7EF4\u4FEE\u8D39\u7528\uFF1A");
		label_8.setForeground(Color.GRAY);
		label_8.setFont(new Font("宋体", Font.BOLD, 20));
		label_8.setBounds(457, 135, 116, 25);
		panel.add(label_8);

		JButton button_2 = new JButton("\u4FEE\u6539");
		button_2.setIcon(
				new ImageIcon(CheckCaMaintainrInformation.class.getResource("/icon/\u7EF4\u62A4\u83DC\u5355.png")));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carMaintainUpdateActionEvent(e);
			}
		});
		button_2.setBounds(344, 193, 122, 41);
		panel.add(button_2);
		button_2.setForeground(SystemColor.textHighlight);
		button_2.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		JButton button_1 = new JButton("\u5220\u9664");
		button_1.setIcon(new ImageIcon(CheckCaMaintainrInformation.class.getResource("/icon/\u5220\u9664.png")));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carMaintainDeleteActionEvent(e);
			}
		});
		button_1.setBounds(508, 194, 122, 41);
		panel.add(button_1);
		button_1.setForeground(SystemColor.textHighlight);
		button_1.setFont(new Font("华文琥珀", Font.PLAIN, 20));

		carNumberTxt = new JTextField();
		carNumberTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		carNumberTxt.setBounds(129, 78, 86, 25);
		panel.add(carNumberTxt);
		carNumberTxt.setColumns(10);

		partsNameTxt = new JTextField();
		partsNameTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		partsNameTxt.setBounds(333, 78, 97, 24);
		panel.add(partsNameTxt);
		partsNameTxt.setColumns(10);

		partsQuantityTxt = new JTextField();
		partsQuantityTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		partsQuantityTxt.setBounds(577, 78, 108, 24);
		panel.add(partsQuantityTxt);
		partsQuantityTxt.setColumns(10);

		repairNumberTxt = new JTextField();
		repairNumberTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		repairNumberTxt.setBounds(129, 137, 86, 24);
		panel.add(repairNumberTxt);
		repairNumberTxt.setColumns(10);

		repairWhenTxt = new JTextField();
		repairWhenTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		repairWhenTxt.setBounds(333, 137, 97, 24);
		panel.add(repairWhenTxt);
		repairWhenTxt.setColumns(10);

		repairCostTxt = new JTextField();
		repairCostTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		repairCostTxt.setBounds(577, 137, 108, 24);
		panel.add(repairCostTxt);
		repairCostTxt.setColumns(10);
		
		/**
		 * 信息录入事件处理
		 */
		JButton button_4 = new JButton("\u4FE1\u606F\u5F55\u5165");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarMaintainImpl frame = new CarMaintainImpl();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});
		button_4.setIcon(new ImageIcon(CheckCaMaintainrInformation.class.getResource("/icon/\u4FE1\u606F.png")));
		button_4.setForeground(SystemColor.textHighlight);
		button_4.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		button_4.setBounds(626, 668, 187, 41);
		contentPane.add(button_4);
		
		/**
		 * 插入背景
		 */
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/icon/37.jpg"));
        JLabel jl = new JLabel(icon);
        jl.setText("");
        jl.setBounds(0, 0, 860, 734);	        
        contentPane.add(jl, new Integer(Integer.MIN_VALUE));
	}

	/**
	 * 车辆维修信息删除事件处理
	 * 
	 * @param e
	 */
	private void carMaintainDeleteActionEvent(ActionEvent evt) {
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
				int deleteNum = carMaintainDao.delete(conn, id);
				if (deleteNum == 1) {
					JOptionPane.showMessageDialog(null, "删除成功！");
					this.resetValue();
					this.fillTable(new CarMaintain());
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
	 * 车辆维修信息修改事件的处理
	 * 
	 * @param e
	 */
	private void carMaintainUpdateActionEvent(ActionEvent evt) {
		String id = idTxt.getText();
		String carNumber = carNumberTxt.getText();
		String partsName = partsNameTxt.getText();
		String partsQuantity = partsQuantityTxt.getText();
		String repairNumber = repairNumberTxt.getText();
		String repairWhen = repairWhenTxt.getText();
		String repairCost = repairCostTxt.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录！");
			return;
		}
		if (StringUtil.isEmpty(carNumber)) {
			JOptionPane.showMessageDialog(null, "车牌号码不能为空！");
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
		if (StringUtil.isEmpty(repairNumber)) {
			JOptionPane.showMessageDialog(null, "维修工号不能为空！");
			return;
		}

		if (StringUtil.isEmpty(repairWhen)) {
			JOptionPane.showMessageDialog(null, "维修时间不能为空！");
			return;
		}
		if (StringUtil.isEmpty(repairCost)) {
			JOptionPane.showMessageDialog(null, "维修费用不能为空！");
			return;
		}

		CarMaintain carMaintain = new CarMaintain(Integer.parseInt(id), carNumber, partsName, partsQuantity,repairNumber, repairWhen, repairCost);
		Connection conn = null;
		try {
			conn = jdbc.getConnection();
			int modifyNum = carMaintainDao.update(conn, carMaintain);
			if (modifyNum == 1) {
				JOptionPane.showMessageDialog(null, "修改成功！");
				this.resetValue();
				this.fillTable(new CarMaintain());
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
	 * 重置表单
	 */
	private void resetValue() {
		this.idTxt.setText("");
		this.carNumberTxt.setText("");
		this.partsNameTxt.setText("");
		this.partsQuantityTxt.setText("");
		this.repairNumberTxt.setText("");
		this.repairWhenTxt.setText("");
		this.repairCostTxt.setText("");

	}

	/**
	 * 表格行点击事件处理
	 * 
	 * @param e
	 */
	private void carMaintainTableMousePressed(MouseEvent e) {
		int row = carMaintainTable.getSelectedRow();
		idTxt.setText((String) carMaintainTable.getValueAt(row, 0));
		carNumberTxt.setText((String) carMaintainTable.getValueAt(row, 1));
		partsNameTxt.setText((String) carMaintainTable.getValueAt(row, 2));
		partsQuantityTxt.setText((String) carMaintainTable.getValueAt(row, 3));
		repairNumberTxt.setText((String) carMaintainTable.getValueAt(row, 4));
		repairWhenTxt.setText((String) carMaintainTable.getValueAt(row, 5));
		repairCostTxt.setText((String) carMaintainTable.getValueAt(row, 6));

	}

	/**
	 * 按车牌号码查询车辆基本信息事件处理
	 */
	private void carNumberSearchActionPerformed(ActionEvent evt) {
		String carNumber = this.CarNumberTxt.getText();
		CarMaintain carMaintain = new CarMaintain();
		carMaintain.setCarNumber(carNumber);
		this.fillTable(carMaintain);
	}

	/**
	 * 初始化表格
	 */

	private void fillTable(CarMaintain carMaintain) {
		DefaultTableModel dtm = (DefaultTableModel) carMaintainTable.getModel();
		dtm.setRowCount(0);
		Connection conn = null;
		try {
			conn = jdbc.getConnection();
			ResultSet rs = carMaintainDao.list(conn, carMaintain);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("CarNumber"));
				v.add(rs.getString("PartsName"));
				v.add(rs.getString("PartsQuantity"));
				v.add(rs.getString("RepairNumber"));
				v.add(rs.getString("RepairWhen"));
				v.add(rs.getString("RepairCost"));
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
