package com.dd.frame;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class InfoPanel
{
    
    private static InfoPanel infoPanel;
    
    public final static int TRACE_LOG  = 0;
    public final static int DEBUG_LOG  = 1;
    public final static int WARING_LOG  = 2;
    public final static int ERROR_LOG  = 3;
    public final static int STATUS_INFO  = 4;
    
    public final static int LOG_MAX_LINE = 500;

//    private JTextArea traceLogTextArea;   //跟踪日志显示
    private TraceLogTextArea traceLogTextArea;
    private JTextArea debugLogTextArea;   //调试日志显示
    private JTextArea waringLogTextArea;  //警告日志显示
    private JTextArea errorLogTextArea;   //异常日志显示
//    private JTextArea statusInfoTextArea;   //系统状态显示
    private StatusInfoTextArea statusInfoTextArea;
    
    
    
    public static String TraceAppender = "TraceShow";
    public static String DebugAppender = "DebugShow";
    public static String WarnAppender  = "WarnShow";
    public static String ErrorAppender = "ErrorShow";
    
    private InfoPanel()
    {
        infoPanel = null;
        
        traceLogTextArea = null;
        debugLogTextArea = null;
        waringLogTextArea = null;
        errorLogTextArea = null;
        statusInfoTextArea = null;
    }
    
    public static InfoPanel getInstance()
    {
        if(infoPanel == null)
        {
            infoPanel = new InfoPanel();
        }
        
        return infoPanel;
    }
    
    //添加主信息面板
    public JPanel getMainInfoPanel()
    {
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BorderLayout());
        
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("运行日志", null, createTraceLogPanel(), "程序运行日志");
//
//        tabbedPane.addTab("调试日志", null, createDebugLogPanel(), "调试日志");
//        tabbedPane.addTab("警告日志", null, createWaringLogPanel(), "警告日志");
//        tabbedPane.addTab("错误日志", null, createErrorLogPanel(), "错误日志");
        tabbedPane.addTab("系统状态", null, createStatusInfoPanel(), "系统状态");
        
        tabbedPane.setBounds(3, 3, 650-14, 460);
        //tabbedPane.setPreferredSize(new Dimension(400,300));
        infoPanel.add(tabbedPane);
        infoPanel.setPreferredSize(new Dimension(700,300));
        
        return infoPanel;
       
    }
    
    //运行日志信息面板
    public JPanel createTraceLogPanel()
    {
        JPanel traceLogPanel = new JPanel();
        traceLogPanel.setLayout(new BorderLayout());   
        JScrollPane traceLogPane = new JScrollPane();   
//        traceLogTextArea = new JTextArea();
        traceLogTextArea = new TraceLogTextArea();
        
        traceLogTextArea.setEditable(false);
        traceLogTextArea.setLineWrap(true);
        traceLogTextArea.setFocusable(false);
        
        traceLogPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        traceLogPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        traceLogPane.getViewport().add(traceLogTextArea);
        traceLogPanel.add(traceLogPane, BorderLayout.CENTER);
  
        return traceLogPanel;
    }
    
    //调试日志信息面板
    public JPanel createDebugLogPanel()
    {
        JPanel debugLogPanel = new JPanel();
        debugLogPanel.setLayout(new BorderLayout());   
        JScrollPane debugLogPane = new JScrollPane();   
        debugLogTextArea = new JTextArea();
        
        debugLogTextArea.setEditable(false);
        debugLogTextArea.setLineWrap(true);
        debugLogTextArea.setFocusable(false);
        
        debugLogPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        debugLogPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        debugLogPane.getViewport().add(debugLogTextArea);
        debugLogPanel.add(debugLogPane, BorderLayout.CENTER);
  
        return debugLogPanel;
    }
    
    // 警告日志信息面板
    public JPanel createWaringLogPanel()
    {
        JPanel waringLogPanel = new JPanel();
        waringLogPanel.setLayout(new BorderLayout());
        JScrollPane waringLogPane = new JScrollPane();
        waringLogTextArea = new JTextArea();
        
        waringLogTextArea.setEditable(false);
        waringLogTextArea.setLineWrap(true);
        waringLogTextArea.setFocusable(false);
        
        waringLogPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        waringLogPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        waringLogPane.getViewport().add(waringLogTextArea);
        waringLogPanel.add(waringLogPane, BorderLayout.CENTER);
        
        return waringLogPanel;
    }
    
    // 异常日志信息面板
    public JPanel createErrorLogPanel()
    {
        JPanel errorLogPanel = new JPanel();
        errorLogPanel.setLayout(new BorderLayout());
        JScrollPane errorLogPane = new JScrollPane();
        errorLogTextArea = new JTextArea();
        
        errorLogTextArea.setEditable(false);
        errorLogTextArea.setLineWrap(true);
        errorLogTextArea.setFocusable(false);
        
        errorLogPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        errorLogPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        errorLogPane.getViewport().add(errorLogTextArea);
        errorLogPanel.add(errorLogPane, BorderLayout.CENTER);
        
        return errorLogPanel;
    }
    
    // 系统信息信息面板
    public JPanel createStatusInfoPanel()
    {
        JPanel statusInfoPanel = new JPanel();
        statusInfoPanel.setLayout(new BorderLayout());
        JScrollPane statusInfoPane = new JScrollPane();
//        statusInfoTextArea = new JTextArea();
        statusInfoTextArea = new StatusInfoTextArea();
        
        statusInfoTextArea.setEditable(false);
        statusInfoTextArea.setLineWrap(true);
        statusInfoTextArea.setFocusable(false);
        
        statusInfoPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        statusInfoPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        statusInfoPane.getViewport().add(statusInfoTextArea);
        statusInfoPanel.add(statusInfoPane, BorderLayout.CENTER);
        
        return statusInfoPanel;
    }
    
    public int calcStringWidth(String s)
    {
    	int len = 0;
    	for( int i = 0; i < s.length(); i++ )
    	{
     	    char c = s.charAt(i);
     	    if (  c  > 128 ) 
     	    	len = len + 2;
     	    else
     	    	len = len + 1;
    	}
    	return len;
    }

}

