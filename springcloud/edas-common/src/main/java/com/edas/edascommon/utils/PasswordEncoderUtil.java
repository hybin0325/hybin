package com.edas.edascommon.utils;

import org.junit.Assert;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderUtil {
	public static void main(String[] args) {
		// System.out.println(new BCryptPasswordEncoder().encode("nacosQsf"));

		long star = System.currentTimeMillis();
		PasswordEncoderUtil bloomFilters = new PasswordEncoderUtil(10000000);
		for (int i = 12; i < 10000000; i++) {
			bloomFilters.add(i + "");
		}
		Assert.assertTrue(bloomFilters.check(0 + ""));
		Assert.assertTrue(bloomFilters.check(2 + ""));
		Assert.assertTrue(bloomFilters.check(3 + ""));
		Assert.assertTrue(bloomFilters.check(999999 + ""));
		Assert.assertFalse(bloomFilters.check(400230340 + ""));
		long end = System.currentTimeMillis();
		System.out.println("执行时间：" + (end - star));

	}

	private int arraySize;
	private int[] array;

	public PasswordEncoderUtil(int arraySize) {
		this.arraySize = arraySize;
		array = new int[arraySize];
	}

	public void add(String key) {
		int first = hashcode_1(key);
		int second = hashcode_2(key);
		int third = hashcode_3(key);
		array[first % arraySize] = 1;
		array[second % arraySize] = 1;
		array[third % arraySize] = 1;
	}

	public boolean check(String key) {
		int first = hashcode_1(key);
		int second = hashcode_2(key);
		int third = hashcode_3(key);
		int firstIndex = array[first % arraySize];
		if (firstIndex == 0) {
			return false;
		}
		int secondIndex = array[second % arraySize];
		if (secondIndex == 0) {
			return false;
		}
		int thirdIndex = array[third % arraySize];
		if (thirdIndex == 0) {
			return false;
		}
		return true;
	}

	private int hashcode_1(String key) {
		int hash = 0;
		int i;
		for (i = 0; i < key.length(); ++i) {
			hash = 33 * hash + key.charAt(i);
		}
		return Math.abs(hash);
	}

	private int hashcode_2(String data) {
		final int p = 16777619;
		int hash = (int) 2166136261L;
		for (int i = 0; i < data.length(); i++) {
			hash = (hash ^ data.charAt(i)) * p;
		}
		hash += hash << 13;
		hash ^= hash >> 7;
		hash += hash << 3;
		hash ^= hash >> 17;
		hash += hash << 5;
		return Math.abs(hash);
	}

	private int hashcode_3(String key) {
		int hash, i;
		for (hash = 0, i = 0; i < key.length(); ++i) {
			hash += key.charAt(i);
			hash += (hash << 10);
			hash ^= (hash >> 6);
		}
		hash += (hash << 3);
		hash ^= (hash >> 11);
		hash += (hash << 15);
		return Math.abs(hash);
	}
}
