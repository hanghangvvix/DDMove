package com.dd.util;

public class CONFIG {
	
	//
	public static String TITLE = Util.getProperty("TITLE");
	
	//
	public static final String FTP_HOST = Util.getProperty("FTP_HOST");
	public static final int FTP_PORT = Integer.parseInt(Util.getProperty("FTP_PORT"));
	public static final String FTP_USERNAME = Util.getProperty("FTP_USERNAME");
	public static final String FTP_PASSWORD = Util.getProperty("FTP_PASSWORD");
	public static final String FTP_PARENT_PATH = Util.getProperty("FTP_PARENT_PATH");
	//
	public static final String LOCAL_PARENT_PATH = Util.getProperty("LOCAL_PARENT_PATH");
	//
	public static final int QUERY_FILEPRE_RATE_TIME = Integer.parseInt(Util.getProperty("QUERY_FILEPRE_RATE_TIME"));
	public static final int CLEAR_TRACELOG_RATE_TIME = Integer.parseInt(Util.getProperty("CLEAR_TRACELOG_RATE_TIME"));
	// 
	public static String LOCAL_CHARSET = Util.getProperty("LOCAL_CHARSET");
	public static String SERVER_CHARSET = Util.getProperty("SERVER_CHARSET");
	
	public static int FTP_LINK_SUCC = 0;
	public static int FTP_LINK_FAIL = 0;
	public static int FTP_FILE_SUCC = 0;
	public static int FTP_FILE_FAIL = 0;
	
	public static final int FRAME_WIDTH = Integer.parseInt(Util.getProperty("FRAME_WIDTH"));
	public static final int FRAME_HEIGH = Integer.parseInt(Util.getProperty("FRAME_HEIGH"));
	
}
