package com.guohuaijiang.window1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.guohuaijiang.dao.CarDao;
import com.guohuaijiang.model.Car;
import com.guohuaijiang.util.JDBCUtil;
import com.guohuaijiang.util.StringUtil;
import com.guohuaijiang.window3.CheckCarInformationInquire;

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
 * 车辆基本信息登记的实现
 * @author 小江
 *
 */
public class CarInformationImpl extends JFrame {

	private JPanel contentPane;
	private JTextField CarClientNameTxt;
	private JTextField CarBrandTxt;
	private JTextField CarNumberTxt;
	private JTextField CarPhoneNumberTxt;

	private JDBCUtil jdbc = new JDBCUtil();
	private CarDao carDao = new CarDao();

	public static void main(String[] args) {
		/**
		 * Launch the application.
		 */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarInformationImpl frame = new CarInformationImpl();
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
	public CarInformationImpl() {
		setResizable(false);
		setTitle("\u6C7D\u8F66\u7EF4\u4FEE\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 907, 546);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u8F66\u8F86\u4FE1\u606F\u7BA1\u7406");
		lblNewLabel.setIcon(new ImageIcon(CarInformationImpl.class.getResource("/icon/\u4FE1\u606F.png")));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("华文彩云", Font.BOLD, 40));
		lblNewLabel.setBounds(283, 13, 328, 85);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u8F66\u4E3B\u59D3\u540D\uFF1A");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_1.setBounds(191, 111, 133, 31);
		contentPane.add(lblNewLabel_1);

		JLabel label = new JLabel("\u8F66\u8F86\u54C1\u724C\uFF1A");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("宋体", Font.BOLD, 20));
		label.setBounds(191, 184, 105, 31);
		contentPane.add(label);

		JLabel label_1 = new JLabel("\u8F66\u724C\u53F7\u7801\uFF1A");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("宋体", Font.BOLD, 20));
		label_1.setBounds(191, 252, 105, 31);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("\u8F66\u4E3B\u7535\u8BDD\u53F7\u7801\uFF1A");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("宋体", Font.BOLD, 20));
		label_2.setBounds(191, 333, 147, 31);
		contentPane.add(label_2);

		CarClientNameTxt = new JTextField();
		CarClientNameTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		CarClientNameTxt.setBounds(347, 111, 328, 31);
		contentPane.add(CarClientNameTxt);
		CarClientNameTxt.setColumns(10);

		CarBrandTxt = new JTextField();
		CarBrandTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		CarBrandTxt.setBounds(347, 182, 328, 31);
		contentPane.add(CarBrandTxt);
		CarBrandTxt.setColumns(10);

		CarNumberTxt = new JTextField();
		CarNumberTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		CarNumberTxt.setBounds(347, 252, 328, 31);
		contentPane.add(CarNumberTxt);
		CarNumberTxt.setColumns(10);

		CarPhoneNumberTxt = new JTextField();
		CarPhoneNumberTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		CarPhoneNumberTxt.setBounds(347, 331, 328, 31);
		contentPane.add(CarPhoneNumberTxt);
		CarPhoneNumberTxt.setColumns(10);

		/**
		 * 返回上一层
		 */
		JButton btnNewButton = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u5C42");
		btnNewButton.setIcon(new ImageIcon(CarInformationImpl.class.getResource("/icon/\u8FD4\u56DE2.png")));
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		btnNewButton.setBounds(38, 446, 171, 43);
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
				new ImageIcon(CarInformationImpl.class.getResource("/icon/confirm_24px_1232396_easyicon.net.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carinformationAddActionPerformed(e);
			}
		});
		btnNewButton_1.setForeground(SystemColor.textHighlight);
		btnNewButton_1.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		btnNewButton_1.setBounds(479, 446, 171, 43);
		contentPane.add(btnNewButton_1);

		/**
		 * 信息重置
		 */
		JButton button = new JButton("\u4FE1\u606F\u91CD\u7F6E");
		button.setIcon(
				new ImageIcon(CarInformationImpl.class.getResource("/icon/Circulation_24px_1099171_easyicon.net.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		button.setForeground(SystemColor.textHighlight);
		button.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		button.setBounds(263, 447, 175, 41);
		contentPane.add(button);
		
		/**
		 * 车辆信息查询事件处理
		 */
		JButton button_1 = new JButton("\u4FE1\u606F\u67E5\u8BE2");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckCarInformationInquire frame = new CheckCarInformationInquire();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});
		button_1.setIcon(new ImageIcon(CarInformationImpl.class.getResource("/icon/\u67E5\u8BE22.png")));
		button_1.setForeground(SystemColor.textHighlight);
		button_1.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		button_1.setBounds(690, 446, 171, 43);
		contentPane.add(button_1);
		
		/**
		 * 插入背景
		 */
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/icon/32.jpg"));
        JLabel jl = new JLabel(icon);
        jl.setText("");
        jl.setBounds(0, 0, 901, 511);	        
        contentPane.add(jl, new Integer(Integer.MIN_VALUE));
	}

	protected void carinformationAddActionPerformed(ActionEvent evt) {
		
		String carClientName = this.CarClientNameTxt.getText();
		String carBrand = this.CarBrandTxt.getText();
		String carNumber = this.CarNumberTxt.getText();
		String carPhoneNumber = this.CarPhoneNumberTxt.getText();
		/**
		 * 判断文本框内容是否为空
		 */
		if (StringUtil.isEmpty(carClientName)) {
			JOptionPane.showMessageDialog(null, "车主姓名不能为空！");
			return;
		}
		if (StringUtil.isEmpty(carBrand)) {
			JOptionPane.showMessageDialog(null, "车辆品牌不能为空！");
			return;
		}
		if (StringUtil.isEmpty(carNumber)) {
			JOptionPane.showMessageDialog(null, "车牌号码不能为空！");
			return;
		}
		if (StringUtil.isEmpty(carPhoneNumber)) {
			JOptionPane.showMessageDialog(null, "车主电话号码不能为空！");
			return;
		}

		Car car = new Car(carClientName, carBrand, carNumber, carPhoneNumber);
		Connection conn = null;
		try {
			conn = jdbc.getConnection();
			int n = carDao.add(conn, car);
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
	 * @param evt
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		this.resetValue();

	}

	/**
	 * 重置信息
	 */
	private void resetValue() {
		this.CarClientNameTxt.setText("");
		this.CarBrandTxt.setText("");
		this.CarNumberTxt.setText("");
		this.CarPhoneNumberTxt.setText("");
	}
}
