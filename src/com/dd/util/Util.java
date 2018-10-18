package com.dd.util;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;

public class Util {

	public static HashMap m = null;

	static {
		init();
	}

	// 加载参数配置文件
	private static void init() {
		m = new HashMap();
		try {
			Properties p = new Properties();

			InputStream in = Util.class.getResourceAsStream("/config.properties");
			p.load(in);
			Enumeration keys = p.keys();
			while (keys.hasMoreElements()) {
				String key = (String) keys.nextElement();
				String val = p.getProperty(key);
				m.put(key, val);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		String str = (String) m.get(key);
		if (str == null) {
			str = "";
		}else{
			str = str.trim();
		}
		return str;
	}

	public static void setProperty(String key, String value) {
		if (!m.containsKey(key))
			return;
		m.put(key, value);
	}

	// 生成随机码
	public static String getRancode() {
		Random random = new Random();

		StringBuffer backCode = new StringBuffer();
		for (int i = 0; i < 100; i++) {

			String rand = String.valueOf(random.nextInt(10));

			if (!(rand.equals("0"))) {

				backCode.append(rand);
				if (backCode.length() == 6) {
					break;
				}
			}
		}
		return backCode.toString();
	}

	public static String getsix() {
		Random rad = new Random();
		int sn = rad.nextInt(1000000);
		return String.format("%06d", sn);
	}

	// 文件解密
	public static byte[] deOrEncrypt2Bytes(String str, String flag) {
		byte key;
		byte[] result = new byte[str.length()];

		for (int i = 0; i < str.length(); i++) {
			key = (byte) str.charAt(i);
			if (flag.equals("-")) {
				key = (byte) (((key >> 4) & 0x0f) | ((key << 4) & 0xf0));
				key = (byte) (key ^ 0x9f);
			} else {
				key = (byte) (key ^ 0x9f);
				key = (byte) (((key >> 4) & 0x0f) | ((key << 4) & 0xf0));
			}
			result[i] = key;
		}
		return result;
	}

	/**
	 * 加，解密
	 * 
	 * @param b
	 * @param flag
	 * @return
	 */
	public static byte[] deOrEncrypt2Byte(byte b[], String flag) {
		byte key;
		byte returnByte[] = b;
		int num = 0;
		for (int i = 0; i < b.length; i++) {
			key = b[i];
			if (flag.equals("-")) {
				key = (byte) (((key >> 4) & 0x0f) | ((key << 4) & 0xf0));
				key = (byte) (key ^ 0x9f);
			} else {
				key = (byte) (key ^ 0x9f);
				key = (byte) (((key >> 4) & 0x0f) | ((key << 4) & 0xf0));
			}
			returnByte[i] = key;
			if (key != 0) {
				num++;
			}
		}
		byte reByte[] = new byte[num];
		for (int i = 0; i < reByte.length; i++) {
			reByte[i] = returnByte[i];
		}
		return reByte;
	}
}
