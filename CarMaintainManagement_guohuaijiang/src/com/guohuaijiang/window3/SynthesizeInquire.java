package com.guohuaijiang.window3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.guohuaijiang.window1.MainMenuImpl;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

/**
 * 综合查询菜单的实现
 * 
 * @author 小江
 *
 */
public class SynthesizeInquire extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SynthesizeInquire frame = new SynthesizeInquire();
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
	public SynthesizeInquire() {
		setResizable(false);
		setTitle("\u6C7D\u8F66\u7EF4\u4FEE\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 459);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("\u7EFC\u5408\u67E5\u8BE2\u83DC\u5355");
		label.setIcon(new ImageIcon(SynthesizeInquire.class.getResource("/icon/\u67E5\u8BE2.png")));
		label.setForeground(new Color(255, 255, 0));
		label.setFont(new Font("华文琥珀", Font.PLAIN, 40));
		label.setBounds(25, 13, 339, 57);
		contentPane.add(label);

		/**
		 * 查询客户信息
		 */
		JButton button_1 = new JButton("\u67E5\u8BE2\u5BA2\u6237\u4FE1\u606F");
		button_1.setIcon(new ImageIcon(SynthesizeInquire.class.getResource("/icon/\u67E5\u8BE22.png")));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckClientInformation frame = new CheckClientInformation();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});
		button_1.setForeground(SystemColor.textHighlight);
		button_1.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		button_1.setBounds(85, 98, 198, 41);
		contentPane.add(button_1);

		/**
		 * 查询车辆信息
		 */
		JButton button = new JButton("\u67E5\u8BE2\u8F66\u8F86\u4FE1\u606F");
		button.setIcon(new ImageIcon(SynthesizeInquire.class.getResource("/icon/\u67E5\u8BE22.png")));
		button.setForeground(SystemColor.textHighlight);
		button.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		button.setBounds(85, 181, 197, 41);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckCarInformationInquire frame = new CheckCarInformationInquire();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});

		/**
		 * 查询维修信息
		 */
		JButton button1 = new JButton("\u67E5\u8BE2\u7EF4\u4FEE\u4FE1\u606F");
		button1.setIcon(new ImageIcon(SynthesizeInquire.class.getResource("/icon/\u67E5\u8BE22.png")));
		button1.setForeground(SystemColor.textHighlight);
		button1.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		button1.setBounds(86, 265, 195, 41);
		contentPane.add(button1);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckCaMaintainrInformation frame = new CheckCaMaintainrInformation();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});

		/**
		 * 返回上一层
		 */
		JButton button2 = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u5C42");
		button2.setIcon(new ImageIcon(SynthesizeInquire.class.getResource("/icon/\u8FD4\u56DE2.png")));
		button2.setForeground(SystemColor.textHighlight);
		button2.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		button2.setBounds(88, 341, 195, 41);
		contentPane.add(button2);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenuImpl frame = new MainMenuImpl();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});

		ImageIcon icon = new ImageIcon(this.getClass().getResource("/icon/23.jpg"));
        JLabel jl = new JLabel(icon);
        jl.setText("");
        jl.setBounds(0, 0, 364, 424);	        
        contentPane.add(jl, new Integer(Integer.MIN_VALUE));

	}
}
