package com.guohuaijiang.window1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.guohuaijiang.window2.PurchaseInterface;
import com.guohuaijiang.window3.SynthesizeInquire;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

/**
 * 用户菜单的实现
 * 
 * @author 小江
 *
 */
public class MainMenuImpl extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenuImpl frame = new MainMenuImpl();
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
	public MainMenuImpl() {
		setTitle("\u6C7D\u8F66\u7EF4\u4FEE\u7BA1\u7406\u7CFB\u7EDF");
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 374);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/**
		 * 车辆维护菜单
		 */
		JButton btnNewButton = new JButton("\u8F66\u8F86\u7EF4\u62A4");
		btnNewButton.setIcon(new ImageIcon(MainMenuImpl.class.getResource("/icon/\u7EF4\u62A4\u83DC\u5355.png")));
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		btnNewButton.setBounds(58, 105, 192, 48);
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
		 * 采购管理菜单
		 */
		JButton button = new JButton("\u91C7\u8D2D\u7BA1\u7406");
		button.setIcon(new ImageIcon(MainMenuImpl.class.getResource("/icon/\u91C7\u8D2D\u83DC\u5355.png")));
		button.setForeground(SystemColor.textHighlight);
		button.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		button.setBounds(292, 105, 192, 48);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PurchaseInterface frame = new PurchaseInterface();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});

		/**
		 * 综合查询菜单
		 */
		JButton button_1 = new JButton("\u7EFC\u5408\u67E5\u8BE2");
		button_1.setIcon(new ImageIcon(MainMenuImpl.class.getResource("/icon/\u67E5\u8BE2\u83DC\u5355.png")));
		button_1.setForeground(SystemColor.textHighlight);
		button_1.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		button_1.setBounds(58, 222, 192, 48);
		contentPane.add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SynthesizeInquire frame = new SynthesizeInquire();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});

		JLabel label = new JLabel("\u7CFB\u7EDF\u4E3B\u83DC\u5355");
		label.setIcon(new ImageIcon(MainMenuImpl.class.getResource("/icon/menu_32px_1230156_easyicon.net.png")));
		label.setForeground(new Color(0, 255, 255));
		label.setFont(new Font("华文彩云", Font.BOLD, 40));
		label.setBounds(150, 13, 278, 48);
		contentPane.add(label);

		/**
		 * 返回上一层
		 */
		JButton button_2 = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u5C42");
		button_2.setIcon(new ImageIcon(MainMenuImpl.class.getResource("/icon/\u8FD4\u56DE2.png")));
		button_2.setForeground(SystemColor.textHighlight);
		button_2.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		button_2.setBounds(292, 222, 192, 48);
		contentPane.add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceImpl frame = new InterfaceImpl();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});

		ImageIcon icon = new ImageIcon(this.getClass().getResource("/icon/15.jpg"));
        JLabel jl = new JLabel(icon);
        jl.setText("");
        jl.setBounds(0, 0, 545, 339);	        
        contentPane.add(jl, new Integer(Integer.MIN_VALUE));
	}
}
