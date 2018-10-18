package com.dd.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.dd.file.util.FileUtils;
import com.dd.ftp.util.FtpUtils;
import com.dd.util.CONFIG;

public class ServiceThread implements Runnable {

	public void run() {
		while (true) {

			Map<String, Long> localTempMap = new HashMap<String, Long>();
			FileUtils fileUtils = new FileUtils();
			localTempMap = fileUtils.getLocalFilePro(CONFIG.LOCAL_PARENT_PATH);

			Map<String, Long> remoteTempMap = new HashMap<String, Long>();
			FtpUtils ftp = new FtpUtils();
			remoteTempMap = ftp.getFtpFilePro(CONFIG.FTP_PARENT_PATH);

			Set<Map.Entry<String, Long>> localEntrySet = localTempMap.entrySet();
			for (Map.Entry<String, Long> local : localEntrySet) {
				boolean isUp = false;
				String key_l = local.getKey();
				Long val_l = local.getValue();

				Set<Map.Entry<String, Long>> remoteEntrySet = remoteTempMap.entrySet();
				for (Map.Entry<String, Long> remote : remoteEntrySet) {
					String key_r = remote.getKey();
					Long val_r = remote.getValue();

					if (key_l.equals(key_r) && val_l == val_r) {
						isUp = true;
					}
				}
				
				if (!isUp) {
					new UpLoadThread(CONFIG.FTP_PARENT_PATH, key_l, CONFIG.LOCAL_PARENT_PATH + key_l).start();
				}
			}
			
			try {
				Thread.sleep(CONFIG.QUERY_FILEPRE_RATE_TIME * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
