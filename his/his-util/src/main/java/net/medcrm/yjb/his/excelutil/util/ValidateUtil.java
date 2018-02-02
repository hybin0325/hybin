package net.medcrm.yjb.his.excelutil.util;

import java.io.File;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import net.medcrm.yjb.his.excelutil.coer.FieldBean;
import net.medcrm.yjb.his.excelutil.coer.HandleResult;
import net.medcrm.yjb.his.excelutil.model.BaseModel;

public class ValidateUtil {
	public static boolean validateTitle(Map<Integer, String> sheetTitleMap, List<FieldBean> fieldList, BaseModel obj) {
		String title = "";
		for (FieldBean field : fieldList) {
			title = field.getNote().logicalName();
			if ("".equals(field.getNote().logicalName())) {
				title = field.getNote().physicalName();
			} else {
				title = field.getNote().logicalName();
			}
			if (("".equals(title.trim())) || (!sheetTitleMap.containsValue(title))) {
				List<HandleResult> resultList = obj.getResultList();
				HandleResult error = new HandleResult();
				error.setCode("401");
				error.setMessage("Excel中不存在的标题:" + title);
				resultList.add(error);
				obj.setResultList(resultList);
				return false;
			}
		}
		return true;
	}

	public static boolean isExists(String fileFullPath, BaseModel obj) {
		if ((fileFullPath == null) || ("".equals(fileFullPath.trim()))) {
			List<HandleResult> resultList = obj.getResultList();
			HandleResult error = new HandleResult();
			error.setCode("302");
			error.setMessage("文件不存在!");
			resultList.add(error);
			obj.setResultList(resultList);
			return false;
		}
		File file = new File(fileFullPath);
		if (!file.exists()) {
			List<HandleResult> resultList = obj.getResultList();
			HandleResult error = new HandleResult();
			error.setCode("302");
			error.setMessage("文件不存在!");
			resultList.add(error);
			obj.setResultList(resultList);
			return false;
		}
		return true;
	}

	public static boolean isExcelFile(String fileFullPath, BaseModel obj) {
		if ((fileFullPath != null) && ((fileFullPath.endsWith(".xls")) || (fileFullPath.endsWith(".xlsx")))) {
			return true;
		}
		List<HandleResult> resultList = obj.getResultList();
		HandleResult error = new HandleResult();
		error.setCode("303");
		error.setMessage("非Excel文件!");
		resultList.add(error);
		obj.setResultList(resultList);
		return false;
	}

	public static boolean isNull(BaseModel model, Object obj, int rowNum) {
		Class<?> clazz = model.getClass();
		PersistenceUtil persistence = new PersistenceUtil();
		List<FieldBean> fieldList = persistence.getFieldsAnnotation(clazz);
		boolean flag = true;
		for (FieldBean fieldBean : fieldList) {
			if (fieldBean.getNote().notNull()) {
				try {
					Field field = clazz.getDeclaredField(fieldBean.getName());
					field.setAccessible(true);
					if ((field.get(obj) == null) || ("".equals(field.get(obj)))) {
						List<HandleResult> resultList = model.getResultList();
						HandleResult error = new HandleResult();
						error.setCode("405");
						error.setMessage("第" + rowNum + "行" + fieldBean.getName() + "不能为空!");
						resultList.add(error);
						model.setResultList(resultList);
						flag = false;
					}
				} catch (Exception localException) {
				}
			}
		}
		return flag;
	}
}
