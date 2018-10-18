package com.dd.frame;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.dd.util.CONFIG;

public class MainFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -714139139891646891L;

	public MainFrame() throws InterruptedException
	{

		UIManager.put("swing.boldMetal", Boolean.FALSE);
		this.setSize(CONFIG.FRAME_WIDTH, CONFIG.FRAME_HEIGH);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		InitFrame();
	}

	public void InitFrame()
	{
		//缺省标题
		this.setTitle(CONFIG.TITLE);

        //信息面板
        this.getContentPane().add(InfoPanel.getInstance().getMainInfoPanel());

		this.setLocationCenter();

		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				int confirm = JOptionPane.showConfirmDialog(null,
						"是否关闭当前系统?", "提示", JOptionPane.OK_CANCEL_OPTION);

				if (confirm == JOptionPane.OK_OPTION)
				{					
					System.exit(0);
				}
			}
		});
	}

	public void setLocationCenter()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		int x = (screenSize.width - this.getSize().width) / 2;
		int y = (screenSize.height - this.getSize().height) / 2;
		this.setLocation(x, y);

	}
}

