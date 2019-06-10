package com.edas.job.admin.core.util;


import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Jackson util
 * 
 * 1、obj need private and set/get；
 * 2、do not support inner class；
 * 
 * @author xuxueli 2015-9-25 18:02:56
 */
public class JacksonUtil {
	private static Logger logger = LoggerFactory.getLogger(JacksonUtil.class);

    private final static ObjectMapper objectMapper = new ObjectMapper();
    public static ObjectMapper getInstance() {
        return objectMapper;
    }

    /**
     * bean、array、List、Map --> json
     * 
     * @param obj
     * @return json string
     * @throws Exception
     */
    public static String writeValueAsString(Object obj) {
    	try {
			return getInstance().writeValueAsString(obj);
		} catch (JsonGenerationException e) {
			logger.error(e.getMessage(), e);
		} catch (JsonMappingException e) {
			logger.error(e.getMessage(), e);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
        return null;
    }

    /**
     * string --> bean、Map、List(array)
     * 
     * @param jsonStr
     * @param clazz
     * @return obj
     * @throws Exception
     */
    public static <T> T readValue(String jsonStr, Class<T> clazz) {
    	try {
			return getInstance().readValue(jsonStr, clazz);
		} catch (JsonParseException e) {
			logger.error(e.getMessage(), e);
		} catch (JsonMappingException e) {
			logger.error(e.getMessage(), e);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
    	return null;
    }

	/**
	 * string --> List<Bean>...
	 *
	 * @param jsonStr
	 * @param parametrized
	 * @param parameterClasses
	 * @param <T>
	 * @return
	 */
	public static <T> T readValue(String jsonStr, Class<?> parametrized, Class<?>... parameterClasses) {
		try {
			JavaType javaType = getInstance().getTypeFactory().constructParametricType(parametrized, parameterClasses);
			return getInstance().readValue(jsonStr, javaType);
		} catch (JsonParseException e) {
			logger.error(e.getMessage(), e);
		} catch (JsonMappingException e) {
			logger.error(e.getMessage(), e);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

    /*public static <T> T readValueRefer(String jsonStr, Class<T> clazz) {
    	try {
			return getInstance().readValue(jsonStr, new TypeReference<T>() { });
		} catch (JsonParseException e) {
			logger.error(e.getMessage(), e);
		} catch (JsonMappingException e) {
			logger.error(e.getMessage(), e);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
    	return null;
    }*/
	
	public static List jsonToList(String json, Class beanClass) {
		if (!StringUtils.isBlank(json)) {
			//这里的JSONObject引入的是 com.alibaba.fastjson.JSONObject;
			return JSONObject.parseArray(json, beanClass);
		} else {
			return null;
		}
	}
	
	public static List<Long> stringToLongList(String strArr) {
		return Arrays.stream(strArr.split(",")).map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
	}
	
	public static List<String> stringToStrigList(String strArr) {
		return Arrays.stream(strArr.split(",")).map(s -> s.trim()).collect(Collectors.toList());
	}

    public static void main(String[] args) {
//		try {
//			Map<String, String> map = new HashMap<String, String>();
//			map.put("aaa", "111");
//			map.put("bbb", "222");
//			String json = writeValueAsString(map);
//			System.out.println(json);
//			System.out.println(readValue(json, Map.class));
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//		}
    	
    	String str="2,3,8";
    	List<Long> ss= stringToLongList(str);
    	for (Long long1 : ss) {
			System.out.println(long1);
		}
	}
}
