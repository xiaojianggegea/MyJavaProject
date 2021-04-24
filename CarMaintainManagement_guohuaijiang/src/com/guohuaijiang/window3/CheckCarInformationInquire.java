package com.guohuaijiang.window3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.table.DefaultTableModel;

import com.guohuaijiang.dao.CarDao;
import com.guohuaijiang.model.Car;
import com.guohuaijiang.model.Client;
import com.guohuaijiang.util.JDBCUtil;
import com.guohuaijiang.util.StringUtil;
import com.guohuaijiang.window1.CarInformationImpl;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

/**
 * 查询车辆维修信息的实现
 * @author 小江
 *
 */
public class CheckCarInformationInquire extends JFrame {

	private JPanel contentPane;
	private JTable carInformationTable;
	private JTextField CarNumberTxt;
	
	private JDBCUtil jdbc = new JDBCUtil();
	private CarDao carDao = new CarDao();
	private JTextField idTxt;
	private JTextField carClientNameTxt;
	private JTextField carBrandTxt;
	private JTextField carNumberTxt;
	private JTextField carPhoneNumberTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckCarInformationInquire frame = new CheckCarInformationInquire();
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
	public CheckCarInformationInquire() {
		setResizable(false);
		setTitle("\u6C7D\u8F66\u7EF4\u4FEE\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 719);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8F66\u8F86\u4FE1\u606F");
		label.setIcon(new ImageIcon(CheckCarInformationInquire.class.getResource("/icon/\u67E5\u8BE2.png")));
		label.setForeground(Color.GREEN);
		label.setFont(new Font("华文彩云", Font.BOLD, 40));
		label.setBounds(304, 15, 239, 47);
		contentPane.add(label);
		
		/**
		 * 返回上一层
		 */
		JButton btnNewButton = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u5C42");
		btnNewButton.setIcon(new ImageIcon(CheckCarInformationInquire.class.getResource("/icon/\u8FD4\u56DE2.png")));
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		btnNewButton.setBounds(39, 630, 186, 41);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				SynthesizeInquire frame=new SynthesizeInquire();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});
		
		/**
		 * 信息删除
		 */
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(76, 120, 649, 247);
		contentPane.add(scrollPane);
		
		carInformationTable = new JTable();
		carInformationTable.setFont(new Font("宋体", Font.PLAIN, 15));
		carInformationTable.setForeground(Color.BLACK);
		carInformationTable.setBackground(Color.WHITE);
		carInformationTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				carInformationTableMousePressed(e);
			}
		});
		carInformationTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u8F66\u4E3B\u59D3\u540D", "\u8F66\u8F86\u54C1\u724C", "\u8F66\u724C\u53F7\u7801", "\u8F66\u4E3B\u7535\u8BDD\u53F7\u7801"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(carInformationTable);
		this.fillTable(new Car());
		
		
		JLabel label_1 = new JLabel("\u8BF7\u8F93\u5165\u8981\u67E5\u8BE2\u7684\u8F66\u724C\u53F7\u7801\uFF1A");
		label_1.setForeground(Color.YELLOW);
		label_1.setFont(new Font("宋体", Font.BOLD, 20));
		label_1.setBounds(76, 83, 260, 24);
		contentPane.add(label_1);
		
		CarNumberTxt = new JTextField();
		CarNumberTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		CarNumberTxt.setBounds(346, 75, 225, 32);
		contentPane.add(CarNumberTxt);
		CarNumberTxt.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("\u67E5\u8BE2");
		btnNewButton_2.setIcon(new ImageIcon(CheckCarInformationInquire.class.getResource("/icon/\u67E5\u8BE22.png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carNumberSearchActionPerformed(e);
			}
		});
		btnNewButton_2.setForeground(SystemColor.textHighlight);
		btnNewButton_2.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		btnNewButton_2.setBounds(612, 75, 113, 32);
		contentPane.add(btnNewButton_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel.setBounds(79, 380, 646, 228);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label_2 = new JLabel("\u7F16\u53F7\uFF1A");
		label_2.setForeground(Color.GRAY);
		label_2.setFont(new Font("宋体", Font.BOLD, 20));
		label_2.setBounds(30, 24, 72, 24);
		panel.add(label_2);
		
		idTxt = new JTextField();
		idTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		idTxt.setEditable(false);
		idTxt.setBounds(86, 24, 62, 24);
		panel.add(idTxt);
		idTxt.setColumns(10);
		
		JLabel label_3 = new JLabel("\u8F66\u4E3B\u59D3\u540D\uFF1A");
		label_3.setForeground(Color.GRAY);
		label_3.setFont(new Font("宋体", Font.BOLD, 20));
		label_3.setBounds(30, 69, 113, 26);
		panel.add(label_3);
		
		carClientNameTxt = new JTextField();
		carClientNameTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		carClientNameTxt.setBounds(156, 68, 120, 24);
		panel.add(carClientNameTxt);
		carClientNameTxt.setColumns(10);
		
		JLabel label_4 = new JLabel("\u8F66\u8F86\u54C1\u724C\uFF1A");
		label_4.setForeground(Color.GRAY);
		label_4.setFont(new Font("宋体", Font.BOLD, 20));
		label_4.setBounds(318, 70, 128, 24);
		panel.add(label_4);
		
		carBrandTxt = new JTextField();
		carBrandTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		carBrandTxt.setBounds(466, 72, 148, 24);
		panel.add(carBrandTxt);
		carBrandTxt.setColumns(10);
		
		JLabel label_5 = new JLabel("\u8F66\u724C\u53F7\u7801\uFF1A");
		label_5.setForeground(Color.GRAY);
		label_5.setFont(new Font("宋体", Font.BOLD, 20));
		label_5.setBounds(29, 119, 115, 24);
		panel.add(label_5);
		
		carNumberTxt = new JTextField();
		carNumberTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		carNumberTxt.setBounds(156, 116, 120, 24);
		panel.add(carNumberTxt);
		carNumberTxt.setColumns(10);
		
		JLabel label_6 = new JLabel("\u8F66\u4E3B\u7535\u8BDD\u53F7\u7801\uFF1A");
		label_6.setForeground(Color.GRAY);
		label_6.setFont(new Font("宋体", Font.BOLD, 20));
		label_6.setBounds(320, 115, 149, 32);
		panel.add(label_6);
		
		carPhoneNumberTxt = new JTextField();
		carPhoneNumberTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		carPhoneNumberTxt.setBounds(469, 116, 146, 24);
		panel.add(carPhoneNumberTxt);
		carPhoneNumberTxt.setColumns(10);
		
		JButton button = new JButton("\u4FEE\u6539");
		button.setIcon(new ImageIcon(CheckCarInformationInquire.class.getResource("/icon/\u7EF4\u62A4\u83DC\u5355.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carInformationUpdateActionEvent(e);
			}
		});
		/**
		 * 删除
		 */
		button.setBounds(287, 174, 120, 41);
		panel.add(button);
		button.setForeground(SystemColor.textHighlight);
		button.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		JButton btnNewButton_1 = new JButton("\u5220\u9664");
		btnNewButton_1.setIcon(new ImageIcon(CheckCarInformationInquire.class.getResource("/icon/\u5220\u9664.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carInformationDeleteActionEvent(e);
			}
		});
		btnNewButton_1.setBounds(454, 174, 120, 41);
		panel.add(btnNewButton_1);
		btnNewButton_1.setForeground(SystemColor.textHighlight);
		btnNewButton_1.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		
		/**
		 * 车辆信息录入事件处理
		 */
		JButton button_1 = new JButton("\u4FE1\u606F\u5F55\u5165");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarInformationImpl frame = new CarInformationImpl();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});
		button_1.setIcon(new ImageIcon(CheckCarInformationInquire.class.getResource("/icon/\u4FE1\u606F.png")));
		button_1.setForeground(SystemColor.textHighlight);
		button_1.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		button_1.setBounds(594, 630, 186, 41);
		contentPane.add(button_1);
		
		/**
		 * 插入背景
		 */
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/icon/35.jpg"));
        JLabel jl = new JLabel(icon);
        jl.setText("");
        jl.setBounds(0, 0, 814, 684);	        
        contentPane.add(jl, new Integer(Integer.MIN_VALUE));
	}
	/**
	 * 车辆基本信息删除事件处理
	 * @param e
	 */
	private void carInformationDeleteActionEvent(ActionEvent evt) {
		String id = idTxt.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要删除的记录！");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "确定要删除该记录吗？");
		if (n == 0) {
			Connection conn = null;

			try {
				conn = jdbc.getConnection();
				int deleteNum = carDao.delete(conn, id);
				if (deleteNum == 1) {
					JOptionPane.showMessageDialog(null, "删除成功！");
					this.resetValue();
					this.fillTable(new Car());
				} else {
					JOptionPane.showMessageDialog(null, "删除失败！");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					jdbc.closeCon(conn);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "删除失败！");
					e.printStackTrace();
				}
			}
		}
		
	}

	/**
	 * 车辆基本信息修改事件处理
	 * @param evt
	 */
	private void carInformationUpdateActionEvent(ActionEvent evt) {
		
		String id = idTxt.getText();
		String carClientName = carClientNameTxt.getText();
		String carBrand = carBrandTxt.getText();
		String carNumber = carNumberTxt.getText();
		String carPhoneNumber = carPhoneNumberTxt.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录！");
			return;
		}
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
		
		Car car = new Car(Integer.parseInt(id), carClientName, carBrand, carNumber, carPhoneNumber);
		Connection conn = null;
		try {
			conn = jdbc.getConnection();
			int modifyNum = carDao.update(conn, car);
			if (modifyNum == 1) {
				JOptionPane.showMessageDialog(null, "修改成功！");
				this.resetValue();
				this.fillTable(new Car());
			} else {
				JOptionPane.showMessageDialog(null, "修改失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				jdbc.closeCon(conn);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "修改失败！");
				e.printStackTrace();
			}
		}
	}

	/**
	 * 重置表单
	 */
	private void resetValue() {
		
		this.idTxt.setText("");
		this.carClientNameTxt.setText("");
		this.carBrandTxt.setText("");
		this.carNumberTxt.setText("");
		this.carPhoneNumberTxt.setText("");
	}

	/**
	 * 表格行点击事件处理
	 * @param e
	 */
	private void carInformationTableMousePressed(MouseEvent evt) {
		int row = carInformationTable.getSelectedRow();
		idTxt.setText((String) carInformationTable.getValueAt(row, 0));
		carClientNameTxt.setText((String) carInformationTable.getValueAt(row, 1));
		carBrandTxt.setText((String) carInformationTable.getValueAt(row, 2));
		carNumberTxt.setText((String) carInformationTable.getValueAt(row, 3));
		carPhoneNumberTxt.setText((String) carInformationTable.getValueAt(row, 4));
		
	}

	/**
	 *  按车牌号码查询车辆基本信息事件处理
	 * @param evt
	 */
	private void carNumberSearchActionPerformed(ActionEvent evt) {
		String carNumber=this.CarNumberTxt.getText();
		Car car=new Car();
		car.setCarNumber(carNumber);
		this.fillTable(car);
	}

	/**
	 * 初始化表格
	 * @param car
	 */
	private void fillTable(Car car) {
		DefaultTableModel dtm=(DefaultTableModel) carInformationTable.getModel();
		dtm.setRowCount(0);
		Connection conn=null;
		try {
			conn=jdbc.getConnection();
			ResultSet rs=carDao.list(conn, car);
			while(rs.next()) {
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("CarClientName"));
				v.add(rs.getString("CarBrand"));
				v.add(rs.getString("CarNumber"));
				v.add(rs.getString("CarPhoneNumber"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				jdbc.closeCon(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
