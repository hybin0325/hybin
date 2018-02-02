package com.his.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import org.junit.Test;

import com.his.util.model.UserTypeBean;

import net.medcrm.yjb.his.excelutil.excel.POIExcelUtil;

public class TestUtil {

	@Test
	public void importExcel() throws FileNotFoundException {
		File f = new File("C:\\Users\\Administrator\\Desktop\\activiti-web\\yy.xlsx");
		InputStream inputStream = new FileInputStream(f);
		POIExcelUtil poi = new POIExcelUtil();
		poi.impExcelFile("yy.xlsx", new UserTypeBean(), inputStream);
		List<Object> valueList = poi.getValueList();
		if (valueList != null && valueList.size() > 0) {
			for (int i = 0; i < valueList.size(); i++) {
				UserTypeBean bean = (UserTypeBean) valueList.get(i);
				// 输出字段数据，并插入到相应的表中，省略
				System.out.println(bean.getFullName() + "asfasfasf");
			}
		}
	}
	
}
