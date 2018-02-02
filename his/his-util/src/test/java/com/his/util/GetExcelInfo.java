package com.his.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class GetExcelInfo {
	public static byte[] readStream(InputStream inStream) throws Exception {
		ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = -1;
		while ((len = inStream.read(buffer)) != -1) {
			outSteam.write(buffer, 0, len);
		}
		outSteam.close();
		inStream.close();
		return outSteam.toByteArray();
	}

	public static void main(String[] args) {
		try {
			File file = new File("C:\\Users\\Administrator\\Desktop\\activiti-web\\yy.xlsx");
			FileInputStream fin = new FileInputStream(file);
			byte[] filebt = readStream(fin);
			System.out.println(filebt.length);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
