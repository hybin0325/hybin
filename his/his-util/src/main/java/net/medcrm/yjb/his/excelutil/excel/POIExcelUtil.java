package net.medcrm.yjb.his.excelutil.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.medcrm.yjb.his.excelutil.coer.FieldBean;
import net.medcrm.yjb.his.excelutil.model.BaseModel;
import net.medcrm.yjb.his.excelutil.util.PersistenceUtil;
import net.medcrm.yjb.his.excelutil.util.ValidateUtil;

public class POIExcelUtil {
	private static final Logger logger = LoggerFactory.getLogger(POIExcelUtil.class);
	private Map<Integer, String> sheetTitleMap;
	private List<Object> valueList;

	public void impExcelFile(String fileFullPath, BaseModel model) {
		if (!ValidateUtil.isExists(fileFullPath, model)) {
			return;
		}
		if (!ValidateUtil.isExcelFile(fileFullPath, model)) {
			return;
		}
		try {
			Class<?> clazz = model.getClass();
			PersistenceUtil persistence = new PersistenceUtil();
			List<FieldBean> fieldList = persistence.getFieldsAnnotation(clazz);
			getDataByExcel(fileFullPath, decideExcel2003(fileFullPath), model, fieldList);
			setValueList(model.check(model, getValueList()));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	public void impExcelFile(String fileName, BaseModel model, InputStream input) {
		try {
			if (!ValidateUtil.isExcelFile(fileName, model)) {
				return;
			}
			Class<?> clazz = model.getClass();
			PersistenceUtil persistence = new PersistenceUtil();
			List<FieldBean> fieldList = persistence.getFieldsAnnotation(clazz);
			getDataByInputStream(input, decideExcel2003(fileName), model, fieldList);
			setValueList(model.check(model, getValueList()));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	private void getDataByExcel(String fileFullPath, boolean isExcel2003, BaseModel model, List<FieldBean> fieldList) {
		InputStream input = null;
		try {
			input = new FileInputStream(fileFullPath);
			getDataByInputStream(input, isExcel2003, model, fieldList);
		} catch (IOException ie) {
			logger.error(ie.getMessage());
			if (input != null) {
				try {
					input.close();
				} catch (IOException localIOException1) {
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			if (input != null) {
				try {
					input.close();
				} catch (IOException localIOException2) {
				}
			}
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException localIOException3) {
				}
			}
		}
	}

	private void getDataByInputStream(InputStream input, boolean isExcel2003, BaseModel model,
			List<FieldBean> fieldList) throws FileNotFoundException, IOException {
		Workbook workbook = null;
		try {
			if (isExcel2003) {
				workbook = new HSSFWorkbook(input);
			} else {
				workbook = new XSSFWorkbook(input);
			}
			Sheet xsheet = workbook.getSheetAt(0);

			int cells = xsheet.getRow(0).getPhysicalNumberOfCells();
			handleTitleBySheet(xsheet, cells, 0);
			if (!ValidateUtil.validateTitle(getSheetTitleMap(), fieldList, model)) {
				return;
			}
			int rows = xsheet.getLastRowNum() + 1;
			handleValueBySheet(xsheet, cells, rows, model, fieldList);
		} catch (IOException ie) {
			logger.error(ie.getMessage());
			if (input != null) {
				try {
					input.close();
				} catch (IOException localIOException2) {
				}
			}
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException localIOException3) {
				}
			}
		}
	}

	private void handleValueBySheet(Sheet xsheet, int cells, int rows, BaseModel model, List<FieldBean> fieldList) {
		Map<Integer, Map<Integer, String>> valueMap = new HashMap();
		List<Object> list = new ArrayList();
		for (int i = 1; i < rows; i++) {
			if (xsheet.getRow(i) != null) {
				valueMap.put(Integer.valueOf(i), handleValueByRow(xsheet.getRow(i), cells));
				try {
					list.add(handleValueByRow(xsheet.getRow(i), cells, model, getSheetTitleMap(), fieldList));
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		setValueList(list);
	}

	private Object handleValueByRow(Row row, int cells, BaseModel model, Map<Integer, String> map,
			List<FieldBean> fieldList) throws InstantiationException, IllegalAccessException {
		Class<?> clazz = model.getClass();
		Object obj = clazz.newInstance();
		for (int j = 0; j < cells; j++) {
			String temStr = "";
			try {
				String fieldName = getNameByCond((String) map.get(Integer.valueOf(j)), fieldList);
				Field field = clazz.getDeclaredField(fieldName);
				if (row.getCell(j) != null) {
					temStr = getValueByType(row.getCell(j));
					if (!"".equals(temStr.trim())) {
						field.setAccessible(true);
						field.set(obj, temStr);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return obj;
	}

	private String getNameByCond(String title, List<FieldBean> fieldList) {
		if ((title == null) || (fieldList == null)) {
			return null;
		}
		for (FieldBean fieldBean : fieldList) {
			if ((title.equals(fieldBean.getNote().physicalName()))
					|| (title.equals(fieldBean.getNote().logicalName()))) {
				return fieldBean.getName();
			}
		}
		return null;
	}

	private Map<Integer, String> handleValueByRow(Row row, int cells) {
		Map<Integer, String> valueRowMap = new HashMap();
		for (int j = 0; j < cells; j++) {
			String temStr = "";
			if (row.getCell(j) != null) {
				temStr = getValueByType(row.getCell(j));
				if (!"".equals(temStr.trim())) {
					valueRowMap.put(Integer.valueOf(j), temStr);
				}
			}
		}
		return valueRowMap;
	}

	private void handleTitleBySheet(Sheet xsheet, int cells, int i) {
		if (cells == 0) {
			return;
		}
		Map<Integer, String> titleMap = new HashMap();
		for (int j = 0; j < cells; j++) {
			String temStr = "";
			if (xsheet.getRow(i).getCell(j) != null) {
				temStr = getValueByType(xsheet.getRow(i).getCell(j));
				if (!"".equals(temStr)) {
					titleMap.put(Integer.valueOf(j), temStr);
				}
			}
		}
		setSheetTitleMap(titleMap);
	}

	private static String getValueByType(Cell xcell) {
		String valueStr = null;
		switch (xcell.getCellType()) {
		case 1:
			valueStr = xcell.getRichStringCellValue().toString();
			break;
		case 0:
			if (!DateUtil.isCellDateFormatted(xcell)) {
				valueStr = String.valueOf((int) xcell.getNumericCellValue());
			} else {
				valueStr = xcell.getDateCellValue().toString();
			}
			break;
		case 4:
			if (xcell.getBooleanCellValue()) {
				valueStr = "1";
			} else {
				valueStr = "0";
			}
			break;
		case 3:
			valueStr = "";
			break;
		case 2:
		default:
			valueStr = "";
		}
		return valueStr;
	}

	private static boolean decideExcel2003(String fileFullPath) {
		if (fileFullPath.toLowerCase().endsWith(".xlsx")) {
			return false;
		}
		return true;
	}

	public Map<Integer, String> getSheetTitleMap() {
		return this.sheetTitleMap;
	}

	public void setSheetTitleMap(Map<Integer, String> sheetTitleMap) {
		this.sheetTitleMap = sheetTitleMap;
	}

	public List<Object> getValueList() {
		return this.valueList;
	}

	public void setValueList(List<Object> valueList) {
		this.valueList = valueList;
	}
}
