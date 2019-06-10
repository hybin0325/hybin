package com.edas.edascommon.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.edas.edascommon.model.TemplateObj;

/**
 * 模版替换类
 * 
 * @author hybin
 *
 */
public class StringTemplateUtils {

	public static final String DEF_REGEX = "\\{(.+?)\\}";

	public static String render(String template, Map<String, Object> data) {
		return render(template, data, DEF_REGEX);
	}

	public static String render(String template, Map<String, Object> data, String regex) {
		if (StringUtils.isBlank(template)) {
			return "";
		}
		if (StringUtils.isBlank(regex)) {
			return template;
		}
		if (data == null || data.size() == 0) {
			return template;
		}
		try {
			StringBuffer sb = new StringBuffer();
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(template);
			while (matcher.find()) {
				String name = matcher.group(1);// 键名
				Object value = data.get(name);// 键值
				if (value == null) {
					value = "";
				}
				matcher.appendReplacement(sb, value.toString());
			}
			matcher.appendTail(sb);
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return template;

	}

	public static Map<String, Object> objectToMap(Object obj) throws Exception {
		if (obj == null)
			return null;

		Map<String, Object> map = new HashMap<String, Object>();

		BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor property : propertyDescriptors) {
			String key = property.getName();
			if (key.compareToIgnoreCase("class") == 0) {
				continue;
			}
			Method getter = property.getReadMethod();
			Object value = getter != null ? getter.invoke(obj) : null;
			map.put(key, value);
		}

		return map;
	}

	public static String processTemplate(String template, Object obj) {
		try {
			return render(template, objectToMap(obj));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String args[]) throws ParseException {
		String template = "您提现{borrowAmount}元至尾号{tailNo}的请求失败，您可以重新提交提款申请。";
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("borrowAmount", "1000.00");
		data.put("tailNo", "1234");
		System.out.println(render(template, data));

		String str = "{cus_name} 车主,您好! 您的爱车{license} 将在 {insur_day}天后,保险到期";

		TemplateObj user = new TemplateObj();
		user.setCus_name("李明");
		user.setLicense("yuehhh");
		user.setInsur_day("20天");

		System.out.println(processTemplate(str, user));
	}
}
