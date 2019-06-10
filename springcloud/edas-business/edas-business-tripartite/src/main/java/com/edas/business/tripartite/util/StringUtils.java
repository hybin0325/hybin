package com.edas.business.tripartite.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class StringUtils {

	public static <T> String beanToString(T value) {
		if (value == null) {
			return null;
		}
		Class<?> clazz = value.getClass();
		if (clazz == int.class || clazz == Integer.class) {
			return "" + value;
		} else if (clazz == String.class) {
			return (String) value;
		} else if (clazz == long.class || clazz == Long.class) {
			return "" + value;
		} else {
			return JSON.toJSONString(value);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T stringToBean(String str, Class<T> clazz) {
		if (str == null || str.length() <= 0 || clazz == null) {
			return null;
		}
		if (clazz == int.class || clazz == Integer.class) {
			return (T) Integer.valueOf(str);
		} else if (clazz == String.class) {
			return (T) str;
		} else if (clazz == long.class || clazz == Long.class) {
			return (T) Long.valueOf(str);
		} else {
			return JSON.toJavaObject(JSON.parseObject(str), clazz);
		}
	}

	public static <T> T mapToObject(Map<String, Object> map, Class<T> t)
			throws InstantiationException, IllegalAccessException, InvocationTargetException {
		T instance = t.newInstance();
		org.apache.commons.beanutils.BeanUtils.populate(instance, map);
		return instance;
	}

	public static Map<?, ?> objectToMap(Object obj) {
		if (obj == null)
			return null;

		return new org.apache.commons.beanutils.BeanMap(obj);
	}

	public static Map<String, Object> beanToMap(Object obj) throws Exception {
		if (obj == null) {
			return null;
		}

		Map<String, Object> map = new HashMap<String, Object>();

		Field[] declaredFields = obj.getClass().getDeclaredFields();
		for (Field field : declaredFields) {
			field.setAccessible(true);
			map.put(field.getName(), field.get(obj));
		}

		return map;
	}

}
