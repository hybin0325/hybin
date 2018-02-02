package net.medcrm.yjb.his.fileutil;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class Base64Util {
	@SuppressWarnings("restriction")
	/**
	 * base64解密
	 * @param baseStr Base64位字符串
	 * @param temp 生成地址
	 * @return
	 */
	public static boolean generateFile(String baseStr,String temp) {
		if (baseStr == null) // 数据为空
			return false;
		sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
		try {
			// Base64解码
			byte[] b = decoder.decodeBuffer(baseStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			// 生成地址
			OutputStream out = new FileOutputStream(temp);
			out.write(b);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
