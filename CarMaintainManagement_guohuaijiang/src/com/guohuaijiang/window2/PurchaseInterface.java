package com.guohuaijiang.window2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.guohuaijiang.window1.MainMenuImpl;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

/**
 * 采购管理菜单的实现
 * 
 * @author 小江
 *
 */
public class PurchaseInterface extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		/**
		 * Launch the application.
		 */

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PurchaseInterface frame = new PurchaseInterface();
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
	public PurchaseInterface() {
		setBackground(SystemColor.activeCaption);
		setResizable(false);
		setTitle("\u6C7D\u8F66\u7EF4\u4FEE\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 543);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("\u91C7\u8D2D\u7BA1\u7406\u83DC\u5355");
		label.setIcon(new ImageIcon(PurchaseInterface.class.getResource("/icon/\u91C7\u8D2D\u83DC\u5355.png")));
		label.setForeground(new Color(255, 255, 0));
		label.setFont(new Font("华文琥珀", Font.PLAIN, 40));
		label.setBounds(100, 13, 298, 47);
		contentPane.add(label);

		/**
		 * 添加零件入库(PutPartEnterStorage)
		 */
		JButton button = new JButton("\u6DFB\u52A0\u96F6\u4EF6\u5165\u5E93");
		button.setIcon(new ImageIcon(PurchaseInterface.class.getResource("/icon/\u5165\u5E93.png")));
		button.setForeground(SystemColor.textHighlight);
		button.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		button.setBounds(142, 101, 206, 47);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PutPartEnterStorage frame = new PutPartEnterStorage();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});

		/**
		 * 添加零件出库(PutPartOutStorage)
		 */
		JButton button_1 = new JButton("\u6DFB\u52A0\u96F6\u4EF6\u51FA\u5E93");
		button_1.setIcon(new ImageIcon(PurchaseInterface.class.getResource("/icon/\u51FA\u5E93.png")));
		button_1.setForeground(SystemColor.textHighlight);
		button_1.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		button_1.setBounds(142, 189, 206, 47);
		contentPane.add(button_1);
		button_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PutPartOutStorage frame = new PutPartOutStorage();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});

		/**
		 * 查看零件全部库存(CheckInventory)
		 */
		JButton button_2 = new JButton("\u67E5\u770B\u96F6\u4EF6\u5E93\u5B58");
		button_2.setIcon(new ImageIcon(PurchaseInterface.class.getResource("/icon/\u67E5\u8BE22.png")));
		button_2.setForeground(SystemColor.textHighlight);
		button_2.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		button_2.setBounds(142, 294, 206, 47);
		contentPane.add(button_2);
		button_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CheckInventory frame = new CheckInventory();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});

		/**
		 * 返回上一层
		 */
		JButton button_3 = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u5C42");
		button_3.setIcon(new ImageIcon(PurchaseInterface.class.getResource("/icon/\u8FD4\u56DE2.png")));
		button_3.setForeground(SystemColor.textHighlight);
		button_3.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		button_3.setBounds(142, 393, 206, 47);
		contentPane.add(button_3);
		button_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainMenuImpl frame = new MainMenuImpl();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/icon/30.jpg"));
        JLabel jl = new JLabel(icon);
        jl.setText("");
        jl.setBounds(0, 0, 495, 508);	        
        contentPane.add(jl, new Integer(Integer.MIN_VALUE));

	}
}
