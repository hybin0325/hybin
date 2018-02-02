package net.medcrm.yjb.his.excelutil.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import net.medcrm.yjb.his.excelutil.coer.FieldBean;
import net.medcrm.yjb.his.excelutil.persistence.FieldNote;
import net.medcrm.yjb.his.excelutil.persistence.TableNote;

public class PersistenceUtil {
	public TableNote getClassAnnotation(Class<?> clazz) {
		boolean flag_table = clazz.isAnnotationPresent(TableNote.class);
		TableNote table = null;
		if (flag_table) {
			table = (TableNote) clazz.getAnnotation(TableNote.class);
		}
		return table;
	}

	public List<FieldBean> getFieldsAnnotation(Class<?> clazz) {
		List<FieldBean> fieldList = new ArrayList();
		Field[] fields = clazz.getDeclaredFields();
		if (fields.length == 0) {
			return null;
		}
		FieldNote note = null;
		FieldBean field = null;
		for (int i = 0; i < fields.length; i++) {
			boolean flag = fields[i].isAnnotationPresent(FieldNote.class);
			if (flag) {
				field = new FieldBean();
				field.setName(fields[i].getName());
				note = (FieldNote) fields[i].getAnnotation(FieldNote.class);
				field.setNote(note);
				fieldList.add(field);
			}
		}
		return fieldList;
	}
}