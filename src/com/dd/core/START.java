package com.dd.core;

import javax.swing.JOptionPane;

import com.dd.frame.MainFrame;
import com.dd.thread.ServiceThread;	

public class START {
	public static void main(String[] args) {
		try {
			MainFrame mainFrame = new MainFrame();
			mainFrame.setVisible(true);

			new Thread(new ServiceThread()).start();
		} catch (Exception e) {
			String excep_Str = "系统运行异常:" + e.toString() + "|" + e.getStackTrace();
			JOptionPane.showMessageDialog(null, excep_Str, "启动异常", JOptionPane.WARNING_MESSAGE);
		}
	}
}
