package com.guohuaijiang.window1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.guohuaijiang.dao.CarMaintainDao;
import com.guohuaijiang.model.CarMaintain;
import com.guohuaijiang.util.JDBCUtil;
import com.guohuaijiang.util.StringUtil;
import com.guohuaijiang.window3.CheckCaMaintainrInformation;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

/**
 * 车辆维修信息登记的实现
 * 
 * @author 小江
 *
 */
public class CarMaintainImpl extends JFrame {

	private JPanel contentPane;
	private JTextField CarNumberTxt;
	private JTextField PartsNameTxt;
	private JTextField PartsQuantityTxt;
	private JTextField RepairNumberTxt;
	private JTextField RepairWhenTxt;
	private JTextField RepairCostTxt;

	private JDBCUtil jdbc = new JDBCUtil();
	private CarMaintainDao carMaintainDao = new CarMaintainDao();
	

	public static void main(String[] args) {
		/**
		 * Launch the application.
		 */

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarMaintainImpl frame = new CarMaintainImpl();
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
	public CarMaintainImpl() {
		setResizable(false);
		setTitle("\u6C7D\u8F66\u7EF4\u4FEE\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 907, 624);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("\u8F66\u8F86\u7EF4\u4FEE\u4FE1\u606F\u7BA1\u7406");
		label.setIcon(new ImageIcon(CarMaintainImpl.class.getResource("/icon/\u4FE1\u606F.png")));
		label.setForeground(new Color(0, 191, 255));
		label.setFont(new Font("华文彩云", Font.BOLD, 40));
		label.setBounds(279, 15, 383, 60);
		contentPane.add(label);

		JLabel label_1 = new JLabel("\u8F66\u724C\u53F7\uFF1A");
		label_1.setForeground(Color.GREEN);
		label_1.setFont(new Font("宋体", Font.BOLD, 20));
		label_1.setBounds(169, 99, 84, 30);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("\u96F6\u4EF6\u540D\uFF1A");
		label_2.setForeground(Color.GREEN);
		label_2.setFont(new Font("宋体", Font.BOLD, 20));
		label_2.setBounds(169, 167, 84, 30);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("\u8981\u4F7F\u7528\u96F6\u4EF6\u6570\u91CF\uFF1A");
		label_3.setForeground(Color.GREEN);
		label_3.setFont(new Font("宋体", Font.BOLD, 20));
		label_3.setBounds(169, 233, 175, 30);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("\u4FEE\u7406\u5DE5\u53F7\uFF1A");
		label_4.setForeground(Color.GREEN);
		label_4.setFont(new Font("宋体", Font.BOLD, 20));
		label_4.setBounds(169, 304, 105, 30);
		contentPane.add(label_4);

		JLabel label_5 = new JLabel("\u4FEE\u7406\u7528\u65F6\uFF1A");
		label_5.setForeground(Color.GREEN);
		label_5.setFont(new Font("宋体", Font.BOLD, 20));
		label_5.setBounds(169, 370, 105, 30);
		contentPane.add(label_5);

		JLabel label_6 = new JLabel("\u4FEE\u7406\u8D39\u7528\uFF1A");
		label_6.setForeground(Color.GREEN);
		label_6.setFont(new Font("宋体", Font.BOLD, 20));
		label_6.setBounds(169, 430, 105, 30);
		contentPane.add(label_6);

		CarNumberTxt = new JTextField();
		CarNumberTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		CarNumberTxt.setBounds(363, 98, 367, 30);
		contentPane.add(CarNumberTxt);
		CarNumberTxt.setColumns(20);

		PartsNameTxt = new JTextField();
		PartsNameTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		PartsNameTxt.setBounds(363, 167, 367, 29);
		contentPane.add(PartsNameTxt);
		PartsNameTxt.setColumns(10);

		PartsQuantityTxt = new JTextField();
		PartsQuantityTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		PartsQuantityTxt.setBounds(363, 233, 367, 29);
		contentPane.add(PartsQuantityTxt);
		PartsQuantityTxt.setColumns(10);

		RepairNumberTxt = new JTextField();
		RepairNumberTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		RepairNumberTxt.setBounds(363, 304, 367, 29);
		contentPane.add(RepairNumberTxt);
		RepairNumberTxt.setColumns(30);

		RepairWhenTxt = new JTextField();
		RepairWhenTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		RepairWhenTxt.setBounds(363, 370, 367, 29);
		contentPane.add(RepairWhenTxt);
		RepairWhenTxt.setColumns(10);

		

		RepairCostTxt = new JTextField();
		RepairCostTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		RepairCostTxt.setColumns(10);
		RepairCostTxt.setBounds(363, 430, 367, 29);
		contentPane.add(RepairCostTxt);
		
		/**
		 * 返回上一层
		 */
		JButton btnNewButton = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u5C42");
		btnNewButton.setIcon(new ImageIcon(CarMaintainImpl.class.getResource("/icon/\u8FD4\u56DE2.png")));
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		btnNewButton.setBounds(14, 527, 195, 38);
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
		 * 确认录入
		 */
		JButton btnNewButton_1 = new JButton("\u786E\u8BA4\u5F55\u5165");
		btnNewButton_1.setIcon(
				new ImageIcon(CarMaintainImpl.class.getResource("/icon/confirm_24px_1232396_easyicon.net.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carMaintainAddActionPerformed(e);
			}
		});
		btnNewButton_1.setForeground(SystemColor.textHighlight);
		btnNewButton_1.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		btnNewButton_1.setBounds(473, 527, 189, 38);
		contentPane.add(btnNewButton_1);

		/**
		 * 信息重置
		 */
		JButton button = new JButton("\u4FE1\u606F\u91CD\u7F6E");
		button.setIcon(
				new ImageIcon(CarMaintainImpl.class.getResource("/icon/Circulation_24px_1099171_easyicon.net.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		button.setForeground(SystemColor.textHighlight);
		button.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		button.setBounds(247, 526, 189, 41);
		contentPane.add(button);
		
		/**
		 * 信息查询事件处理
		 */
		JButton button_1 = new JButton("\u4FE1\u606F\u67E5\u8BE2");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckCaMaintainrInformation frame = new CheckCaMaintainrInformation();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});
		button_1.setIcon(new ImageIcon(CarMaintainImpl.class.getResource("/icon/\u67E5\u8BE22.png")));
		button_1.setForeground(SystemColor.textHighlight);
		button_1.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		button_1.setBounds(698, 527, 189, 38);
		contentPane.add(button_1);
		
		/**
		 * 插入背景
		 */
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/icon/34.jpg"));
        JLabel jl = new JLabel(icon);
        jl.setForeground(new Color(0, 255, 255));
        jl.setText("");
        jl.setBounds(0, 0, 901, 589);	        
        contentPane.add(jl, new Integer(Integer.MIN_VALUE));
	}

	/**
	 * 信息录入事件处理
	 * 
	 * @param e
	 */
	protected void carMaintainAddActionPerformed(ActionEvent evt) {
		String carNumber = this.CarNumberTxt.getText();
		String partsName = this.PartsNameTxt.getText();
		String partsQuantity = this.PartsQuantityTxt.getText();
		String repairNumber = this.RepairNumberTxt.getText();
		String repairWhen = this.RepairWhenTxt.getText();
		String repairCost = this.RepairCostTxt.getText();

		/**
		 * 判断文本框内容是否为空
		 */
		if (StringUtil.isEmpty(carNumber)) {
			JOptionPane.showMessageDialog(null, "车牌号不能为空！");
			return;
		}
		if (StringUtil.isEmpty(partsName)) {
			JOptionPane.showMessageDialog(null, "零件名不能为空！");
			return;
		}
		if (StringUtil.isEmpty(partsQuantity)) {
			JOptionPane.showMessageDialog(null, "零件数量不能为空！");
			return;
		}
		if (StringUtil.isEmpty(repairNumber)) {
			JOptionPane.showMessageDialog(null, "维修工号不能为空！");
			return;
		}
		if (StringUtil.isEmpty(repairWhen)) {
			JOptionPane.showMessageDialog(null, "维修时间不能为空！");
			return;
		}
		if (StringUtil.isEmpty(repairCost)) {
			JOptionPane.showMessageDialog(null, "维修费用不能为空！");
			return;
		}
		CarMaintain carMaintain = new CarMaintain(carNumber, partsName, partsQuantity, repairNumber, repairWhen,
				repairCost);
		Connection conn = null;
		try {
			conn = jdbc.getConnection();
			int n = carMaintainDao.add(conn, carMaintain);
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
	 * 信息重置事件处理
	 * 
	 * @param e
	 */
	protected void resetValueActionPerformed(ActionEvent e) {

		this.resetValue();
	}

	/**
	 * 信息重置
	 */

	private void resetValue() {
		this.CarNumberTxt.setText("");
		this.PartsNameTxt.setText("");
		this.PartsQuantityTxt.setText("");
		this.RepairNumberTxt.setText("");
		this.RepairWhenTxt.setText("");
		this.RepairCostTxt.setText("");
	}
}
