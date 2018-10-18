package com.dd.thread;

import com.dd.ftp.util.FtpUtils;

public class UpLoadThread extends Thread {
	
	private String pathName;
	private String fileName;
	private String originFileName;

	public UpLoadThread(String pathName,String fileName,String originFileName)
   {
		this.pathName = pathName;
		this.fileName = fileName;
		this.originFileName = originFileName;
   }

	public void run() {
		FtpUtils ftp = new FtpUtils();
		ftp.uploadFile(pathName, fileName, originFileName);
	}
	
	public static void main(String[] args)
    {
        Thread thread = new UpLoadThread("1","2","3");
        thread.start();        
    }
}
