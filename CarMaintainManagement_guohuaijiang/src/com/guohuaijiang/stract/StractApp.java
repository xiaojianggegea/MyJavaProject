package com.guohuaijiang.stract;

import com.guohuaijiang.window1.InterfaceImpl;

/**
 * 启动方法
 * 
 * @author 小江
 *
 */
public class StractApp {
	public static void main(String[] args) {
		/**
		 * 启动欢迎界面
		 */
		InterfaceImpl frame = new InterfaceImpl();
		frame.setTitle("\u6C7D\u8F66\u7EF4\u4FEE\u7BA1\u7406\u7CFB\u7EDF");
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
