package com.dd.frame;

import javax.swing.JTextArea;

import com.dd.core.SYSDATE;

public class StatusInfoTextArea extends JTextArea {
	//
	public StatusInfoTextArea() {
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					// run方法具体重写
					append(SYSDATE.GetSysStatusInfo());
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
					setText("");
				}
			}
		}).start();
	}
}
