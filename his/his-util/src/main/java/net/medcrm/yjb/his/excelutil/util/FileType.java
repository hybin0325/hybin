package net.medcrm.yjb.his.excelutil.util;

public enum FileType {
	doc("application/msword",".doc" ),    
	docx("application/vnd.openxmlformats-officedocument.wordprocessingml.document",".docx"),   
	xls("application/vnd.ms-excel",".xls"),
	xls2("application/x-excel",".xls"),
	ppt("application/vnd.ms-powerpoint",".ppt"),
	xlsx("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",".xlsx "),
	pptx("application/vnd.openxmlformats-officedocument.presentationml.presentation",".pptx"),   	
	gif("image/gif",".gif "),   
	png("image/png",".png"),   
	jpeg("image/jpeg",".jpeg");
	
	private String index;
	private String value;
	
	private FileType(String index, String value) {
		this.index = index;
		this.value = value;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
