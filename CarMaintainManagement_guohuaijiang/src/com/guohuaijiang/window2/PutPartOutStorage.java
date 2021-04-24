package com.guohuaijiang.window2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

/**
 * 零件出库功能的实现
 * 
 * @author 小江
 *
 */
public class PutPartOutStorage extends JFrame {

	private JPanel contentPane;
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
					PutPartOutStorage frame = new PutPartOutStorage();
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
	public PutPartOutStorage() {
        
		setResizable(false);
		setTitle("\u6C7D\u8F66\u7EF4\u4FEE\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 594, 349);
		contentPane.add(panel);
		/**
		 * 插入背景
		 */
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/icon/04.jpg"));
		

		JLabel label = new JLabel("\u6DFB\u52A0\u96F6\u4EF6\u51FA\u5E93");
		label.setIcon(new ImageIcon(PutPartOutStorage.class.getResource("/icon/\u51FA\u5E93.png")));
		label.setForeground(Color.CYAN);
		label.setFont(new Font("华文彩云", Font.BOLD, 40));
		label.setBounds(171, 13, 280, 47);
		panel.add(label);

		JLabel label_1 = new JLabel("\u96F6\u4EF6\u540D  \uFF1A");
		label_1.setForeground(Color.GREEN);
		label_1.setFont(new Font("宋体", Font.BOLD, 20));
		label_1.setBounds(120, 112, 108, 30);
		panel.add(label_1);

		partsNameTxt = new JTextField();
		partsNameTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		partsNameTxt.setColumns(10);
		partsNameTxt.setBounds(242, 112, 134, 32);
		panel.add(partsNameTxt);

		JLabel label_2 = new JLabel("\u96F6\u4EF6\u6570\u91CF\uFF1A");
		label_2.setForeground(Color.GREEN);
		label_2.setFont(new Font("宋体", Font.BOLD, 20));
		label_2.setBounds(120, 171, 105, 30);
		panel.add(label_2);

		partsQuantityTxt = new JTextField();
		partsQuantityTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		partsQuantityTxt.setColumns(10);
		partsQuantityTxt.setBounds(242, 173, 134, 30);
		panel.add(partsQuantityTxt);

		JLabel label_3 = new JLabel("\u96F6\u4EF6\u4EF7\u683C\uFF1A");
		label_3.setForeground(Color.GREEN);
		label_3.setFont(new Font("宋体", Font.BOLD, 20));
		label_3.setBounds(120, 237, 108, 30);
		panel.add(label_3);

		partsPriceTxt = new JTextField();
		partsPriceTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		partsPriceTxt.setColumns(10);
		partsPriceTxt.setBounds(242, 237, 134, 32);
		panel.add(partsPriceTxt);
		

		/**
		 * 返回上一层
		 */
		JButton button = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u5C42");
		button.setIcon(new ImageIcon(PutPartOutStorage.class.getResource("/icon/\u8FD4\u56DE2.png")));
		button.setForeground(SystemColor.textHighlight);
		button.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		button.setBounds(14, 290, 169, 39);
		panel.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PurchaseInterface frame = new PurchaseInterface();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});

		/**
		 * 确认出库
		 */
		JButton button_1 = new JButton("\u786E\u8BA4\u51FA\u5E93");
		button_1.setIcon(
				new ImageIcon(PutPartOutStorage.class.getResource("/icon/confirm_24px_1232396_easyicon.net.png")));
		button_1.setForeground(SystemColor.textHighlight);
		button_1.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		button_1.setBounds(399, 290, 169, 39);
		panel.add(button_1);
		
		JButton button_2 = new JButton("\u4FE1\u606F\u91CD\u7F6E");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				partsInformationresetValueActionPerformed(e);
			}
		});
		button_2.setIcon(new ImageIcon(PutPartOutStorage.class.getResource("/icon/Circulation_24px_1099171_easyicon.net.png")));
		button_2.setForeground(SystemColor.textHighlight);
		button_2.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		button_2.setBounds(213, 289, 163, 41);
		panel.add(button_2);
		JLabel jl = new JLabel(icon);
		jl.setBounds(0, 0, 594, 349);
		panel.add(jl);
		jl.setText("");
		
	}
/**
 * 信息重置事件处理
 * @param evt
 */
	private void partsInformationresetValueActionPerformed(ActionEvent evt) {
		this.resetValue();
		
	}
	/**
	 * 重置表格
	 */
	private void resetValue() {
		this.partsNameTxt.setText("");
		this.partsQuantityTxt.setText("");
		this.partsPriceTxt.setText("");
	}
}
