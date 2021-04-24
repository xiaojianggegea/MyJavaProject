package com.guohuaijiang.window3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.guohuaijiang.dao.ClientDao;
import com.guohuaijiang.model.Client;
import com.guohuaijiang.util.JDBCUtil;
import com.guohuaijiang.util.StringUtil;
import com.guohuaijiang.window1.ClientInformation;

import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

/**
 * 实现客户信息查询的实现
 * 
 * @author 小江
 *
 */
public class CheckClientInformation extends JFrame {

	private JPanel contentPane;
	private JTable clientInformationTable;
	private JTextField clientNumberTxt;

	private JDBCUtil jdbc = new JDBCUtil();
	private ClientDao clientDao = new ClientDao();
	private JTextField idTxt;
	private JTextField clientNameTxt;
	private JTextField genderTxt;
	private JTextField IDNumberTxt;
	private JTextField phoneNumberTxt;
	private JTextField HomeAddressTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckClientInformation frame = new CheckClientInformation();
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
	public CheckClientInformation() {
		setResizable(false);
		setTitle("\u6C7D\u8F66\u7EF4\u4FEE\u7BA1\u7406\u7CFB\u7EDF");
		setBackground(new Color(224, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1110, 768);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setForeground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u5BA2\u6237\u4FE1\u606F");
		lblNewLabel.setIcon(new ImageIcon(CheckClientInformation.class.getResource("/icon/\u67E5\u8BE2.png")));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("华文彩云", Font.BOLD, 40));
		lblNewLabel.setBounds(429, 13, 252, 54);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(77, 117, 948, 231);
		contentPane.add(scrollPane);

		clientInformationTable = new JTable();
		clientInformationTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				clientTableMousePressed(e);
			}
		});
		clientInformationTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u5BA2\u6237\u59D3\u540D", "\u6027\u522B", "\u8EAB\u4EFD\u8BC1\u53F7\u7801", "\u7535\u8BDD\u53F7\u7801", "\u5BB6\u5EAD\u4F4F\u5740"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(clientInformationTable);
		this.fillTable(new Client());

		JLabel label = new JLabel(
				"\u8BF7\u8F93\u5165\u8EAB\u4EFD\u8BC1\u53F7\u7801\u8FDB\u884C\u4FE1\u606F\u67E5\u8BE2\uFF1A");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("宋体", Font.BOLD, 20));
		label.setBounds(77, 75, 338, 29);
		contentPane.add(label);

		clientNumberTxt = new JTextField();
		clientNumberTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		clientNumberTxt.setBounds(402, 70, 409, 34);
		contentPane.add(clientNumberTxt);
		clientNumberTxt.setColumns(10);

		/**
		 * 返回上一层
		 */
		JButton button = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u5C42");
		button.setIcon(new ImageIcon(CheckClientInformation.class.getResource("/icon/\u8FD4\u56DE2.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SynthesizeInquire frame = new SynthesizeInquire();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});
		button.setForeground(SystemColor.textHighlight);
		button.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		button.setBounds(77, 679, 197, 41);
		contentPane.add(button);

		JButton buttenCheck = new JButton("\u67E5\u8BE2");
		buttenCheck.setIcon(new ImageIcon(CheckClientInformation.class.getResource("/icon/\u67E5\u8BE22.png")));
		buttenCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientIDNumberSearchActionPerformed(e);
			}
		});
		buttenCheck.setForeground(SystemColor.textHighlight);
		buttenCheck.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		buttenCheck.setBounds(889, 70, 113, 33);
		contentPane.add(buttenCheck);

		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u8868\u5355\u64CD\u4F5C",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel.setBounds(77, 417, 948, 221);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel label_1 = new JLabel("\u7F16\u53F7      \uFF1A");
		label_1.setFont(new Font("宋体", Font.BOLD, 20));
		label_1.setForeground(Color.GRAY);
		label_1.setBounds(14, 34, 146, 24);
		panel.add(label_1);

		idTxt = new JTextField();
		idTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		idTxt.setEditable(false);
		idTxt.setBounds(174, 36, 58, 24);
		panel.add(idTxt);
		idTxt.setColumns(10);

		JLabel label_2 = new JLabel("\u5BA2\u6237\u59D3\u540D\uFF1A");
		label_2.setForeground(Color.GRAY);
		label_2.setFont(new Font("宋体", Font.BOLD, 20));
		label_2.setBounds(352, 34, 105, 24);
		panel.add(label_2);

		clientNameTxt = new JTextField();
		clientNameTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		clientNameTxt.setBounds(471, 36, 129, 24);
		panel.add(clientNameTxt);
		clientNameTxt.setColumns(10);

		JLabel label_3 = new JLabel("\u6027\u522B   \uFF1A");
		label_3.setForeground(Color.GRAY);
		label_3.setFont(new Font("宋体", Font.BOLD, 20));
		label_3.setBounds(633, 34, 102, 24);
		panel.add(label_3);

		genderTxt = new JTextField();
		genderTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		genderTxt.setBounds(730, 36, 65, 24);
		panel.add(genderTxt);
		genderTxt.setColumns(10);

		JLabel label_4 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\u7801\uFF1A");
		label_4.setForeground(Color.GRAY);
		label_4.setFont(new Font("宋体", Font.BOLD, 20));
		label_4.setBounds(14, 106, 146, 25);
		panel.add(label_4);

		IDNumberTxt = new JTextField();
		IDNumberTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		IDNumberTxt.setBounds(174, 108, 164, 24);
		panel.add(IDNumberTxt);
		IDNumberTxt.setColumns(10);

		JLabel label_5 = new JLabel("\u7535\u8BDD\u53F7\u7801\uFF1A");
		label_5.setForeground(Color.GRAY);
		label_5.setFont(new Font("宋体", Font.BOLD, 20));
		label_5.setBounds(352, 108, 105, 21);
		panel.add(label_5);

		phoneNumberTxt = new JTextField();
		phoneNumberTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		phoneNumberTxt.setBounds(471, 108, 129, 24);
		panel.add(phoneNumberTxt);
		phoneNumberTxt.setColumns(10);

		JLabel label_6 = new JLabel("\u5BB6\u5EAD\u4F4F\u5740\uFF1A");
		label_6.setForeground(Color.GRAY);
		label_6.setFont(new Font("宋体", Font.BOLD, 20));
		label_6.setBounds(630, 109, 105, 22);
		panel.add(label_6);

		HomeAddressTxt = new JTextField();
		HomeAddressTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		HomeAddressTxt.setBounds(730, 108, 204, 24);
		panel.add(HomeAddressTxt);
		HomeAddressTxt.setColumns(10);

		/**
		 * 修改
		 */
		JButton button_1 = new JButton("\u4FEE\u6539");
		button_1.setIcon(new ImageIcon(CheckClientInformation.class.getResource("/icon/\u7EF4\u62A4\u83DC\u5355.png")));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientInformationUpdateActionEvent(e);
			}
		});
		button_1.setBounds(480, 167, 120, 41);
		panel.add(button_1);
		button_1.setForeground(SystemColor.textHighlight);
		button_1.setFont(new Font("华文琥珀", Font.PLAIN, 20));

		/**
		 * 删除
		 */
		JButton button_2 = new JButton("\u5220\u9664");
		button_2.setIcon(new ImageIcon(CheckClientInformation.class.getResource("/icon/\u5220\u9664.png")));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientInformationDeleteActionEvent(e);
			}
		});
		button_2.setBounds(693, 167, 120, 41);
		panel.add(button_2);
		button_2.setForeground(SystemColor.textHighlight);
		button_2.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		
		/**
		 * 客户信息录入事件处理
		 */
		JButton button_3 = new JButton("\u4FE1\u606F\u5F55\u5165");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientInformation frame = new ClientInformation();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});
		button_3.setIcon(new ImageIcon(CheckClientInformation.class.getResource("/icon/\u4FE1\u606F.png")));
		button_3.setForeground(SystemColor.textHighlight);
		button_3.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		button_3.setBounds(828, 679, 197, 41);
		contentPane.add(button_3);
		
		/**
		 * 插入背景
		 */
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/icon/36.jpg"));
        JLabel jl = new JLabel(icon);
        jl.setText("");
        jl.setBounds(0, 0, 1104, 733);	        
        contentPane.add(jl, new Integer(Integer.MIN_VALUE));
	}

	/**
	 * 客户信息删除事件的处理
	 * 
	 * @param e
	 */
	private void clientInformationDeleteActionEvent(ActionEvent evt) {
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
				int deleteNum = clientDao.delete(conn, id);
				if (deleteNum == 1) {
					JOptionPane.showMessageDialog(null, "删除成功！");
					this.resetValue();
					this.fillTable(new Client());
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
	 * 客户信息修改事件的处理
	 * 
	 * @param e
	 */
	private void clientInformationUpdateActionEvent(ActionEvent evt) {
		String id = idTxt.getText();
		String clientName = clientNameTxt.getText();
		String gender = genderTxt.getText();
		String idNumber = IDNumberTxt.getText();
		String phoneNumber = phoneNumberTxt.getText();
		String homeAddress = HomeAddressTxt.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录！");
			return;
		}
		if (StringUtil.isEmpty(clientName)) {
			JOptionPane.showMessageDialog(null, "客户姓名不能为空！");
			return;
		}
		if (StringUtil.isEmpty(gender)) {
			JOptionPane.showMessageDialog(null, "性别不能为空！");
			return;
		}
		if (StringUtil.isEmpty(idNumber)) {
			JOptionPane.showMessageDialog(null, "身份证号码不能为空！");
			return;
		}
		if (StringUtil.isEmpty(phoneNumber)) {
			JOptionPane.showMessageDialog(null, "电话号码不能为空！");
			return;
		}
		if (StringUtil.isEmpty(homeAddress)) {
			JOptionPane.showMessageDialog(null, "家庭住址不能为空！");
			return;
		}
		Client client = new Client(Integer.parseInt(id), clientName, gender, idNumber, phoneNumber, homeAddress);
		Connection conn = null;
		try {
			conn = jdbc.getConnection();
			int modifyNum = clientDao.update(conn, client);
			if (modifyNum == 1) {
				JOptionPane.showMessageDialog(null, "修改成功！");
				this.resetValue();
				this.fillTable(new Client());
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
	 * 表格行点击事件处理
	 * 
	 * @param evt
	 */
	private void clientTableMousePressed(MouseEvent evt) {
		int row = clientInformationTable.getSelectedRow();
		idTxt.setText((String) clientInformationTable.getValueAt(row, 0));
		clientNameTxt.setText((String) clientInformationTable.getValueAt(row, 1));
		genderTxt.setText((String) clientInformationTable.getValueAt(row, 2));
		IDNumberTxt.setText((String) clientInformationTable.getValueAt(row, 3));
		phoneNumberTxt.setText((String) clientInformationTable.getValueAt(row, 4));
		HomeAddressTxt.setText((String) clientInformationTable.getValueAt(row, 5));
	}

	/**
	 * 确认按身份证号码查询信息事件处理
	 * 
	 * @param e
	 */
	private void clientIDNumberSearchActionPerformed(ActionEvent evt) {
		String clientIDNumber = this.clientNumberTxt.getText();
		Client client = new Client();
		client.setIDNumber(clientIDNumber);
		this.fillTable(client);
	}

	/**
	 * 初始化表格
	 */
	private void fillTable(Client client) {
		DefaultTableModel dtm = (DefaultTableModel) clientInformationTable.getModel();
		dtm.setRowCount(0);
		Connection conn = null;
		try {
			conn = jdbc.getConnection();
			ResultSet rs = clientDao.list(conn, client);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("clientName"));
				v.add(rs.getString("Gender"));
				v.add(rs.getString("IDNumber"));
				v.add(rs.getString("PhoneNumber"));
				v.add(rs.getString("HomeAddress"));
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

	/**
	 * 重置表单
	 */
	private void resetValue() {
		this.idTxt.setText("");
		this.clientNameTxt.setText("");
		this.genderTxt.setText("");
		this.IDNumberTxt.setText("");
		this.phoneNumberTxt.setText("");
		this.HomeAddressTxt.setText("");
	}
}
