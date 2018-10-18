package com.dd.frame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.text.Document;

import com.dd.frame.util.LoopedStreams;
import com.dd.util.CONFIG;

public class TraceLogTextArea extends JTextArea {
	public TraceLogTextArea(InputStream[] inStreams) {
		for (int i = 0; i < inStreams.length; ++i)
			startRunReaderThread(inStreams[i]);
	}

	public TraceLogTextArea() {
		LoopedStreams ls;
		try {
			ls = new LoopedStreams();

			// 重定向System.out和System.err
			PrintStream ps = new PrintStream(ls.getOutputStream());
			System.setOut(ps);
			System.setErr(ps);
			startRunReaderThread(ls.getInputStream());
			startRunClearThread();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void startRunReaderThread(InputStream inStream) {
		final BufferedReader br = new BufferedReader(new InputStreamReader(inStream));
		new Thread(new Runnable() {
			@Override
			public void run() {
				StringBuffer sb = new StringBuffer();
				try {
					String s;
					Document doc = getDocument();
					while ((s = br.readLine()) != null) {
						boolean caretAtEnd = false;
						caretAtEnd = getCaretPosition() == doc.getLength() ? true : false;
						sb.setLength(0);
						append(" 系 统 ： " + sb.append(s).append('\n').toString());
						if (caretAtEnd)
							setCaretPosition(doc.getLength());
					}
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "从BufferedReader读取错误：" + e);
					System.exit(1);
				}
			}
		}).start();
	}

	private void startRunClearThread() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(CONFIG.CLEAR_TRACELOG_RATE_TIME * 1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
					setText("");
				}
			}
		}).start();
	}
}
