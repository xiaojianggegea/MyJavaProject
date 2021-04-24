package com.guohuaijiang.window1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.guohuaijiang.dao.UserDao;
import com.guohuaijiang.model.User;
import com.guohuaijiang.util.JDBCUtil;
import com.guohuaijiang.util.StringUtil;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * 登陆界面的实现
 * 
 * @author 小江
 *
 */
public class LoginInterface extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTxt;
	private JPasswordField passwordTxt;

	private JDBCUtil jdbc = new JDBCUtil();
	private UserDao userDao = new UserDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginInterface frame = new LoginInterface();
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
	public LoginInterface() {
		setTitle("\u6C7D\u8F66\u7EF4\u4FEE\u7BA1\u7406\u7CFB\u7EDF");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 364);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("\u7EF4\u4FEE\u7CFB\u7EDF\u767B\u5F55");
		lblNewLabel.setBounds(80, 13, 317, 52);
		lblNewLabel.setIcon(new ImageIcon(LoginInterface.class.getResource("/icon/Car_Repair_Blue_48px_1078991_easyicon.net.png")));
		lblNewLabel.setFont(new Font("华文彩云", Font.BOLD, 40));
		lblNewLabel.setForeground(new Color(51, 255, 255));

		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1.setBounds(80, 128, 122, 31);
		lblNewLabel_1.setIcon(new ImageIcon(LoginInterface.class.getResource("/icon/User_24px_516302_easyicon.net.png")));
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("华文琥珀", Font.PLAIN, 20));

		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801    \uFF1A");
		lblNewLabel_2.setBounds(80, 194, 119, 33);
		lblNewLabel_2.setIcon(new ImageIcon(LoginInterface.class.getResource("/icon/Change_Password_24px_529182_easyicon.net.png")));
		lblNewLabel_2.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		lblNewLabel_2.setForeground(Color.GRAY);

		userNameTxt = new JTextField();
		userNameTxt.setBounds(216, 130, 137, 24);
		userNameTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		userNameTxt.setColumns(10);

		passwordTxt = new JPasswordField();
		passwordTxt.setBounds(216, 197, 137, 24);
		passwordTxt.setFont(new Font("宋体", Font.PLAIN, 20));

		/**
		 * 重置信息
		 */
		JButton btnNewButton = new JButton("\u91CD\u7F6E\u4FE1\u606F");
		btnNewButton.setBounds(30, 265, 155, 40);
		btnNewButton.setIcon(new ImageIcon(LoginInterface.class.getResource("/icon/Circulation_24px_1099171_easyicon.net.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setFont(new Font("华文琥珀", Font.PLAIN, 20));

		/**
		 * 确认登录
		 */
		JButton btnNewButton_1 = new JButton("\u786E\u8BA4\u767B\u9646");
		btnNewButton_1.setBounds(286, 265, 155, 41);
		btnNewButton_1.setIcon(new ImageIcon(LoginInterface.class.getResource("/icon/confirm_24px_1232396_easyicon.net.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		btnNewButton_1.setForeground(SystemColor.textHighlight);
		btnNewButton_1.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_1);
		contentPane.add(userNameTxt);
		contentPane.add(lblNewLabel_2);
		contentPane.add(passwordTxt);
		contentPane.add(btnNewButton);
		contentPane.add(btnNewButton_1);
		
		/**
		 * 插入背景
		 */
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/icon/13.jpg"));
        JLabel jl = new JLabel(icon);
        jl.setText("");
        jl.setBounds(-14, 0, 509, 329);	        
        contentPane.add(jl, new Integer(Integer.MIN_VALUE));

	}

	/**
	 * 登录事件处理
	 * 
	 * @param e
	 */
	private void loginActionPerformed(ActionEvent evt) {
		String userName = this.userNameTxt.getText();
		String password = new String(this.passwordTxt.getPassword());
		if (StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;
		}
		if (StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		}
		User user = new User(userName, password);
		Connection conn = null;
		try {
			conn = jdbc.getConnection();
			User currentUser = userDao.login(conn, user);
			if (currentUser != null) {
				JOptionPane.showMessageDialog(null, "登录成功！");
				dispose();
				MainMenuImpl frame = new MainMenuImpl();
				frame.setVisible(true);
				dispose();
				frame.setLocationRelativeTo(null);
			} else {
				JOptionPane.showMessageDialog(null, "用户名或密码错误！");
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
	 * 重置信息事件处理
	 * 
	 * @param e
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		this.userNameTxt.setText("");
		this.passwordTxt.setText("");
	}
}
