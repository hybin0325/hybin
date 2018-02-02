package net.medcrm.yjb.his.excelutil.model;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.medcrm.yjb.his.excelutil.coer.HandleResult;
import net.medcrm.yjb.his.excelutil.persistence.TableNote;
import net.medcrm.yjb.his.excelutil.util.PersistenceUtil;
import net.medcrm.yjb.his.excelutil.util.ValidateUtil;

public class BaseModel {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private List<HandleResult> resultList;

	public void saveData(BaseModel model, List<Object> valueList) {
		PersistenceUtil persistence = new PersistenceUtil();
		Class<?> clazz = model.getClass();
		TableNote table = persistence.getClassAnnotation(clazz);
		this.logger.info("super-->>saveData -->>tableName:" + table.tableName());
	}

	public List<Object> check(BaseModel model, List<Object> valueList) {
		List<Object> realValueList = new ArrayList();
		int rowNum = 1;
		for (Object obj : valueList) {
			if (ValidateUtil.isNull(model, obj, rowNum)) {
				realValueList.add(obj);
			}
			rowNum++;
		}
		this.logger.info("super-->>check:");
		return realValueList;
	}

	public List<HandleResult> getResultList() {
		if (this.resultList == null) {
			this.resultList = new ArrayList();
		}
		return this.resultList;
	}

	public void setResultList(List<HandleResult> resultList) {
		this.resultList = resultList;
	}
}
