package com.guohuaijiang.window1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

/**
 * 车辆维护菜单的实现
 * 
 * @author 小江
 *
 */
public class FunctionImpl extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FunctionImpl frame = new FunctionImpl();
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
	public FunctionImpl() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 546);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("\u8F66\u8F86\u7EF4\u62A4\u83DC\u5355");
		label.setIcon(new ImageIcon(FunctionImpl.class.getResource("/icon/\u7EF4\u62A4\u83DC\u5355.png")));
		label.setForeground(new Color(255, 255, 0));
		label.setFont(new Font("华文琥珀", Font.PLAIN, 40));
		label.setBounds(134, 13, 288, 47);
		contentPane.add(label);

		/**
		 * 客户信息管理(ClientInterfaceImpl)
		 */
		JButton btnNewButton = new JButton("\u5BA2\u6237\u4FE1\u606F\u7BA1\u7406");
		btnNewButton.setIcon(
				new ImageIcon(FunctionImpl.class.getResource("/icon/\u5BA2\u6237\u4FE1\u606F\u5F55\u5165.png")));
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setFont(new Font("华文琥珀", Font.PLAIN, 25));
		btnNewButton.setBounds(150, 96, 246, 47);
		contentPane.add(btnNewButton);
		/**
		 * 客户信息管理事件处理
		 */
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientInformation frame = new ClientInformation();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});

		/**
		 * 车辆信息管理(CarInformationImpl)
		 */
		JButton button = new JButton("\u8F66\u8F86\u4FE1\u606F\u7BA1\u7406");
		button.setIcon(
				new ImageIcon(FunctionImpl.class.getResource("/icon/\u5BA2\u6237\u4FE1\u606F\u5F55\u5165.png")));
		button.setForeground(SystemColor.textHighlight);
		button.setFont(new Font("华文琥珀", Font.PLAIN, 25));
		button.setBounds(150, 189, 246, 47);
		contentPane.add(button);
		/**
		 * 车辆信息管理事件处理
		 */
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarInformationImpl frame = new CarInformationImpl();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});

		/**
		 * 车辆维修信息管理
		 */
		JButton button_1 = new JButton("\u7EF4\u4FEE\u4FE1\u606F\u7BA1\u7406");
		button_1.setIcon(
				new ImageIcon(FunctionImpl.class.getResource("/icon/\u5BA2\u6237\u4FE1\u606F\u5F55\u5165.png")));
		button_1.setForeground(SystemColor.textHighlight);
		button_1.setFont(new Font("华文琥珀", Font.PLAIN, 25));
		button_1.setBounds(150, 289, 246, 47);
		contentPane.add(button_1);
		/**
		 * 车辆维修信息管理事件处理
		 */

		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarMaintainImpl frame = new CarMaintainImpl();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});

		/**
		 * 返回上一层
		 */
		JButton button_2 = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u5C42");
		button_2.setIcon(new ImageIcon(FunctionImpl.class.getResource("/icon/\u8FD4\u56DE2.png")));
		button_2.setForeground(SystemColor.textHighlight);
		button_2.setFont(new Font("华文琥珀", Font.PLAIN, 25));
		button_2.setBounds(150, 383, 246, 39);
		contentPane.add(button_2);
		/**
		 * 返回上一层事件处理
		 */
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenuImpl frame = new MainMenuImpl();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});

		/**
		 * 插入背景
		 */
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/icon/17.jpg"));
        JLabel jl = new JLabel(icon);
        jl.setText("");
        jl.setBounds(0, 0, 565, 511);	        
        contentPane.add(jl, new Integer(Integer.MIN_VALUE));
	}

}
