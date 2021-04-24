package com.guohuaijiang.window1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.guohuaijiang.dao.ClientDao;
import com.guohuaijiang.model.Client;
import com.guohuaijiang.util.JDBCUtil;
import com.guohuaijiang.util.StringUtil;
import com.guohuaijiang.window3.CheckClientInformation;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

/**
 * 客户信息登记的实现
 * 
 * @author 小江
 *
 */
public class ClientInformation extends JFrame {

	private JPanel contentPane;
	private JTextField clientTxt;
	private JTextField genderTxt;
	private JTextField idNumberTxt;
	private JTextField phoneNumberTxt;
	private JTextField homeAddressTxt;

	private JDBCUtil jdbc = new JDBCUtil();
	private ClientDao clientDao = new ClientDao();

	public static void main(String[] args) {
		/**
		 * Launch the application.
		 */

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientInformation frame = new ClientInformation();
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
	public ClientInformation() {
		setResizable(false);
		setTitle("\u6C7D\u8F66\u7EF4\u4FEE\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 814, 520);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("\u5BA2\u6237\u5355\u4F4D\u7BA1\u7406");
		label.setIcon(new ImageIcon(ClientInformation.class.getResource("/icon/\u4FE1\u606F.png")));
		label.setForeground(new Color(0, 255, 255));
		label.setFont(new Font("华文彩云", Font.BOLD, 40));
		label.setBounds(259, 12, 314, 68);
		contentPane.add(label);

		JLabel label_1 = new JLabel("\u5BA2\u6237\u59D3\u540D\uFF1A");
		label_1.setForeground(Color.GREEN);
		label_1.setFont(new Font("宋体", Font.BOLD, 20));
		label_1.setBounds(143, 94, 116, 29);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("\u59D3\u522B    \uFF1A");
		label_2.setForeground(Color.GREEN);
		label_2.setFont(new Font("宋体", Font.BOLD, 20));
		label_2.setBounds(143, 150, 116, 29);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		label_3.setForeground(Color.GREEN);
		label_3.setFont(new Font("宋体", Font.BOLD, 20));
		label_3.setBounds(143, 212, 116, 29);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("\u7535\u8BDD\u53F7\u7801\uFF1A");
		label_4.setForeground(Color.GREEN);
		label_4.setFont(new Font("宋体", Font.BOLD, 20));
		label_4.setBounds(143, 279, 116, 29);
		contentPane.add(label_4);

		JLabel label_5 = new JLabel("\u5BB6\u5EAD\u4F4F\u5740\uFF1A");
		label_5.setForeground(Color.GREEN);
		label_5.setFont(new Font("宋体", Font.BOLD, 20));
		label_5.setBounds(143, 335, 116, 29);
		contentPane.add(label_5);

		clientTxt = new JTextField();
		clientTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		clientTxt.setBounds(259, 93, 385, 35);
		contentPane.add(clientTxt);
		clientTxt.setColumns(5);

		genderTxt = new JTextField();
		genderTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		genderTxt.setColumns(5);
		genderTxt.setBounds(259, 154, 385, 35);
		contentPane.add(genderTxt);

		idNumberTxt = new JTextField();
		idNumberTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		idNumberTxt.setColumns(16);
		idNumberTxt.setBounds(259, 206, 385, 35);
		contentPane.add(idNumberTxt);

		phoneNumberTxt = new JTextField();
		phoneNumberTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		phoneNumberTxt.setColumns(11);
		phoneNumberTxt.setBounds(259, 273, 385, 35);
		contentPane.add(phoneNumberTxt);

		homeAddressTxt = new JTextField();
		homeAddressTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		homeAddressTxt.setColumns(30);
		homeAddressTxt.setBounds(259, 335, 385, 35);
		contentPane.add(homeAddressTxt);

		/**
		 * 返回上一层
		 */
		JButton btnNewButton = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u5C42");
		btnNewButton.setIcon(new ImageIcon(ClientInformation.class.getResource("/icon/\u8FD4\u56DE2.png")));
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		btnNewButton.setBounds(14, 413, 172, 41);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				FunctionImpl frame = new FunctionImpl();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});

		/**
		 * 确认录入信息
		 */
		JButton btnNewButton_1 = new JButton("\u786E\u8BA4\u5F55\u5165");
		btnNewButton_1.setIcon(
				new ImageIcon(ClientInformation.class.getResource("/icon/confirm_24px_1232396_easyicon.net.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cliectAddActionPerformed(e);
			}
		});
		btnNewButton_1.setForeground(SystemColor.textHighlight);
		btnNewButton_1.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		btnNewButton_1.setBounds(413, 413, 172, 41);
		contentPane.add(btnNewButton_1);

		/**
		 * 信息重置
		 */
		JButton button = new JButton("\u4FE1\u606F\u91CD\u7F6E");
		button.setIcon(
				new ImageIcon(ClientInformation.class.getResource("/icon/Circulation_24px_1099171_easyicon.net.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		button.setForeground(SystemColor.textHighlight);
		button.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		button.setBounds(216, 413, 172, 41);
		contentPane.add(button);
		
		/**
		 * 客户信息查询事件处理
		 */
		JButton button_1 = new JButton("\u4FE1\u606F\u67E5\u8BE2");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckClientInformation frame = new CheckClientInformation();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});
		button_1.setIcon(new ImageIcon(ClientInformation.class.getResource("/icon/\u67E5\u8BE22.png")));
		button_1.setForeground(SystemColor.textHighlight);
		button_1.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		button_1.setBounds(622, 413, 172, 41);
		contentPane.add(button_1);
		
		/**
		 * 插入背景
		 */
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/icon/31.jpg"));
        JLabel jl = new JLabel(icon);
        jl.setText("");
        jl.setBounds(0, 0, 808, 485);	        
        contentPane.add(jl, new Integer(Integer.MIN_VALUE));
	}

	/**
	 * 确认录入信息事件处理
	 * 
	 * @param e
	 */
	private void cliectAddActionPerformed(ActionEvent evt) {
		String clientName = this.clientTxt.getText();
		String gender = this.genderTxt.getText();
		String idNumber = this.idNumberTxt.getText();
		String phoneNumber = this.phoneNumberTxt.getText();
		String homeAddress = this.homeAddressTxt.getText();

		/**
		 * 判断文本框内容是否为空
		 */
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
		Client clientType = new Client(clientName, gender, idNumber, phoneNumber, homeAddress);
		Connection conn = null;
		try {
			conn = jdbc.getConnection();
			int n = clientDao.add(conn, clientType);
			if (n == 1) {
				JOptionPane.showMessageDialog(null, "信息录入成功！");
				resetValue();
			} else {
				JOptionPane.showMessageDialog(null, "信息录入失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "信息录入失败！");
		} finally {
			try {
				jdbc.closeCon(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 重置信息事件处理
	 * 
	 * @param e
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		this.resetValue();
	}

	/**
	 * 重置表单
	 */
	private void resetValue() {
		this.clientTxt.setText("");
		this.genderTxt.setText("");
		this.idNumberTxt.setText("");
		this.phoneNumberTxt.setText("");
		this.homeAddressTxt.setText("");
	}
}
