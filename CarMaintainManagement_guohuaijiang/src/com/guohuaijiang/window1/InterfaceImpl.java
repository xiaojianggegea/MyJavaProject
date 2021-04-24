package com.guohuaijiang.window1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

/**
 * 欢迎界面的实现
 * 
 * @author 小江
 *
 */
public class InterfaceImpl extends JFrame {

	private JPanel contentPane;

	private JTextField textFieid;
	private JTextField textFieid1;
	private JTextField textFieid2;
	private JTextField textFieid3;
	private JTextField textFieid4;

	/**
	 * Create the frame.
	 */
	public InterfaceImpl() {

		setResizable(false);
		setTitle("\u6C7D\u8F66\u7EF4\u4FEE\u7BA1\u7406\u7CFB\u7EDF");
		setBackground(Color.ORANGE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 455);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setForeground(Color.MAGENTA);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u7EF4\u4FEE\u7BA1\u7406\u7CFB\u7EDF\uFF01");
		lblNewLabel.setForeground(new Color(0, 255, 255));
		lblNewLabel.setFont(new Font("华文彩云", Font.BOLD, 60));
		lblNewLabel.setBounds(336, 185, 452, 96);
		contentPane.add(lblNewLabel);

		JLabel label_1 = new JLabel("\u6B22\u8FCE\u4F7F\u7528\u6C7D\u8F66");
		label_1.setForeground(new Color(0, 255, 255));
		label_1.setFont(new Font("华文彩云", Font.BOLD, 60));
		label_1.setBounds(69, 84, 452, 96);
		contentPane.add(label_1);

		/**
		 * 确认进入
		 */
		JButton button = new JButton("\u70B9\u51FB\u8FDB\u5165");
		button.setBackground(new Color(0, 0, 51));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginInterface frame = new LoginInterface();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});
		button.setIcon(new ImageIcon(InterfaceImpl.class.getResource("/icon/enter_32px_1210134_easyicon.net.png")));
		button.setForeground(new Color(255, 255, 255));
		button.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		button.setBounds(678, 379, 156, 41);
		contentPane.add(button);

		/**
		 * 插入背景
		 */
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/icon/12.jpg"));
		JLabel jl = new JLabel(icon);
		jl.setForeground(new Color(255, 255, 255));
		jl.setText("\u6B22\u8FCE");
		jl.setBounds(-15, 0, 895, 435);
		contentPane.add(jl, new Integer(Integer.MIN_VALUE));
	}
}
