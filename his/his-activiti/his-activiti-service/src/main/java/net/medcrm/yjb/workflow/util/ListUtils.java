package net.medcrm.yjb.workflow.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.beanutils.BeanUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;

public class ListUtils {
	public static List<Integer> getIntersection(List<Integer> list1, List<Integer> list2) {
		List<Integer> result = new ArrayList<Integer>();
		for (Integer integer : list2) {// 遍历list1
			if (list1.contains(integer)) {// 如果存在这个数
				result.add(integer);// 放进一个list里面，这个list就是交集
			}
		}
		return result;
	}

	public static List<String> getStringsection(List<String> list1, List<String> list2) {
		List<String> result = new ArrayList<String>();
		for (String string : list2) {// 遍历list1
			if (list1.contains(string)) {// 如果存在这个数
				result.add(string);// 放进一个list里面，这个list就是交集
			}
		}
		return result;
	}

	public static Map<String, String> json2Map(String strJson) {
		Map<String, String> map = new HashMap<String, String>();
		ObjectMapper mapper = new ObjectMapper();
		try {
			map = mapper.readValue(strJson, new TypeReference<HashMap<String, String>>() {
			});
			System.out.println(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public static Map<String, String> map2Map(Map<String, Object> objMap) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			Iterator<Map.Entry<String, Object>> entries = objMap.entrySet().iterator();
			while (entries.hasNext()) {
				Entry<String, Object> entry = entries.next();
				System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
				map.put(entry.getKey(), entry.getValue()+"");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public static <K, V> Map<K, V> list2Map1(List<V> list, String fieldName4Key) {
		Map<K, V> map = new HashMap<K, V>();
		if (list != null) {
			try {
				for (int i = 0; i < list.size(); i++) {
					V value = list.get(i);
					@SuppressWarnings("unchecked")
					K k = (K) BeanUtils.getProperty(value, fieldName4Key);
					map.put(k, value);
				}
			} catch (Exception e) {
				throw new IllegalArgumentException("field can't match the key!");
			}
		}
		return map;
	}

	public static void main(String[] args) {

		// String json = "{\"name\":\"zitong\", \"age\":\"26\"}";
		// ListUtils.json2Map(json);
		// Map<String, String> map = new HashMap<String, String>();
		// map.put("sfs", "2222");
		// map.put("name", "asfasf");
		// System.out.println(map);

		List<String> a = Lists.newArrayList();
		a.add("sdgdsf");
		a.add("afsasfa");
		Map<String, String> map = new HashMap<String, String>();
		Map<String, String> maps = ListUtils.list2Map1(a, "dfdfd");
		System.out.println(maps);
	}
}
