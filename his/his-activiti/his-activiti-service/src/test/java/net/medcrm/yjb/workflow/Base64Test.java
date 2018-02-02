package net.medcrm.yjb.workflow;

import net.medcrm.yjb.his.fileutil.Base64Util;


public class Base64Test {
	
	
	public static void main(String[] args) {
		String basr = "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQEASABIAAD/2wBDAAwICQoJBwwKCQoNDAwOER0TERA";
		Base64Util.generateFile(basr, null);
	}

}
