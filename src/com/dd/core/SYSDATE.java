package com.dd.core;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.dd.util.CONFIG;

public class SYSDATE
{
	static final String FORMAT = "yyyy年MM月dd日 HH:mm:ss";  
	static final Format DF= new SimpleDateFormat(FORMAT); 
	static final Date date = new Date();
	static final String startTime = DF.format(date);
	
	public static String Get_Sys_Start_Time()
	{
		return startTime;
	}
	
	public static String Get_Run_Time()
	{
		Date now = new Date();
		long l = now.getTime() - date.getTime();
		
		long day=l/(24*60*60*1000);
		long hour=(l/(60*60*1000)-day*24);
		long min=((l/(60*1000))-day*24*60-hour*60);
		long s=(l/1000-day*24*60*60-hour*60*60-min*60);
		
		return day+"天"+hour+"小时"+min+"分"+s+"秒";
	}
	
	public static String GetSysStatusInfo()
	{
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("- 系统开始时间:" + startTime + " \n");
		buffer.append("- 系统运行时间:" + Get_Run_Time() + " \n\n");
		
		buffer.append("- FTP连接 成功:" + CONFIG.FTP_LINK_SUCC + "次 \n");
		buffer.append("- FTP连接 失败:" + CONFIG.FTP_LINK_FAIL + "次 \n\n");
		
		buffer.append("- FTP上传文件 成功:" + CONFIG.FTP_LINK_SUCC + "个 \n");
		buffer.append("- FTP上传文件 失败:" + CONFIG.FTP_LINK_FAIL + "个 \n\n");

		buffer.append("\n");
		
		return buffer.toString();
	}
}
