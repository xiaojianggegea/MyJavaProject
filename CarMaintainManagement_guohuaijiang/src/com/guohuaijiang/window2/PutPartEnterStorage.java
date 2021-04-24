package com.guohuaijiang.window2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.guohuaijiang.dao.PartsDao;
import com.guohuaijiang.model.Client;
import com.guohuaijiang.model.Parts;
import com.guohuaijiang.util.JDBCUtil;
import com.guohuaijiang.util.StringUtil;

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
 * 零件入库功能的实现
 * 
 * @author 小江
 *
 */
public class PutPartEnterStorage extends JFrame {

	private JPanel contentPane;
	private JTextField PartsNameTxt;
	private JTextField PartsNumberTxt;
	private JTextField PartsPriceTxt;

	private JDBCUtil jdbc = new JDBCUtil();
	private PartsDao partsDao = new PartsDao();

	public static void main(String[] args) {
		/**
		 * Launch the application.
		 */

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PutPartEnterStorage frame = new PutPartEnterStorage();
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
	public PutPartEnterStorage() {
		setResizable(false);
		setTitle("\u6C7D\u8F66\u7EF4\u4FEE\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 421);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("\u6DFB\u52A0\u96F6\u4EF6\u5165\u5E93");
		label.setIcon(new ImageIcon(PutPartEnterStorage.class.getResource("/icon/\u52A0.png")));
		label.setForeground(Color.CYAN);
		label.setFont(new Font("华文彩云", Font.BOLD, 40));
		label.setBounds(163, 13, 295, 47);
		contentPane.add(label);

		JLabel label_1 = new JLabel("\u96F6\u4EF6\u540D  \uFF1A");
		label_1.setForeground(Color.GREEN);
		label_1.setFont(new Font("宋体", Font.BOLD, 20));
		label_1.setBounds(120, 112, 108, 30);
		contentPane.add(label_1);

		PartsNameTxt = new JTextField();
		PartsNameTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		PartsNameTxt.setBounds(242, 112, 134, 32);
		contentPane.add(PartsNameTxt);
		PartsNameTxt.setColumns(10);

		JLabel label_2 = new JLabel("\u96F6\u4EF6\u6570\u91CF\uFF1A");
		label_2.setForeground(Color.GREEN);
		label_2.setFont(new Font("宋体", Font.BOLD, 20));
		label_2.setBounds(120, 171, 105, 30);
		contentPane.add(label_2);

		PartsNumberTxt = new JTextField();
		PartsNumberTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		PartsNumberTxt.setColumns(10);
		PartsNumberTxt.setBounds(242, 173, 134, 30);
		contentPane.add(PartsNumberTxt);

		JLabel label_3 = new JLabel("\u96F6\u4EF6\u4EF7\u683C\uFF1A");
		label_3.setForeground(Color.GREEN);
		label_3.setFont(new Font("宋体", Font.BOLD, 20));
		label_3.setBounds(120, 237, 108, 30);
		contentPane.add(label_3);

		PartsPriceTxt = new JTextField();
		PartsPriceTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		PartsPriceTxt.setColumns(10);
		PartsPriceTxt.setBounds(242, 237, 134, 32);
		contentPane.add(PartsPriceTxt);

		/**
		 * 返回上一层(采购管理（PurchaseInterfaceImpl）)
		 */
		JButton btnNewButton = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u5C42");
		btnNewButton.setIcon(new ImageIcon(PutPartEnterStorage.class.getResource("/icon/\u8FD4\u56DE2.png")));
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		btnNewButton.setBounds(35, 300, 161, 41);
		contentPane.add(btnNewButton);
		/**
		 * 返回事件处理
		 */
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PurchaseInterface frame = new PurchaseInterface();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});

		/**
		 * 确认入库
		 */
		JButton btnNewButton_1 = new JButton("\u786E\u8BA4\u5165\u5E93");
		btnNewButton_1.setIcon(
				new ImageIcon(PutPartEnterStorage.class.getResource("/icon/confirm_24px_1232396_easyicon.net.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PartsAddActionPerformed(e);
			}
		});
		btnNewButton_1.setForeground(SystemColor.textHighlight);
		btnNewButton_1.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		btnNewButton_1.setBounds(420, 300, 148, 41);
		contentPane.add(btnNewButton_1);

		/**
		 * 信息重置
		 */
		JButton button = new JButton("\u4FE1\u606F\u91CD\u7F6E");
		button.setIcon(new ImageIcon(
				PutPartEnterStorage.class.getResource("/icon/Circulation_24px_1099171_easyicon.net.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		button.setForeground(SystemColor.textHighlight);
		button.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		button.setBounds(220, 300, 161, 41);
		contentPane.add(button);
		
		/**
		 * 插入背景
		 */
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/icon/01.jpg"));
        JLabel jl = new JLabel(icon);
        jl.setText("");
        jl.setBounds(0, 0, 594, 386);	        
        contentPane.add(jl, new Integer(Integer.MIN_VALUE));
	}

	/**
	 * 确认录入事件的处理
	 * 
	 * @param evt
	 */
	protected void PartsAddActionPerformed(ActionEvent evt) {

		String partsName = this.PartsNameTxt.getText();
		String partsNumber = this.PartsNumberTxt.getText();
		String partsPrice = this.PartsPriceTxt.getText();
		/**
		 * 判断文本框内容是否为空
		 */
		if (StringUtil.isEmpty(partsName)) {
			JOptionPane.showMessageDialog(null, "零件名不能为空！");
			return;
		}
		if (StringUtil.isEmpty(partsNumber)) {
			JOptionPane.showMessageDialog(null, "零件数量不能为空！");
			return;
		}
		if (StringUtil.isEmpty(partsPrice)) {
			JOptionPane.showMessageDialog(null, "零件价格不能为空！");
			return;
		}
		Parts parts = new Parts(partsName, partsNumber, partsPrice);
		Connection conn = null;
		try {
			conn = jdbc.getConnection();
			int n = partsDao.add(conn, parts);
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
	 * 信息重置事件的处理
	 * 
	 * @param e
	 */
	protected void resetValueActionPerformed(ActionEvent evt) {

		this.resetValue();
	}

	/**
	 * 重置信息
	 */
	private void resetValue() {
		this.PartsNameTxt.setText("");
		this.PartsNumberTxt.setText("");
		this.PartsPriceTxt.setText("");
	}
}
