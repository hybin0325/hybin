package com.edas.edasusers.utils;

import java.security.Key;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class DESCoder {
	public static final String KEY_ALGORTHM = "DES";

	private Key toKey(byte[] key) throws Exception {
		DESKeySpec dks = new DESKeySpec(key);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALGORTHM);
		SecretKey secretKey = keyFactory.generateSecret(dks);
		return secretKey;
	}

	/**
	 * 
	 * @param key key(Base64编码）
	 * @return
	 * @throws Exception
	 */
	public Key toKey(String key) throws Exception {
		//byte[] keyBytes = (new BASE64Decoder()).decodeBuffer(key);
		//Key keyObj = toKey(keyBytes);
		//return keyObj;
		return null;
	}
}
