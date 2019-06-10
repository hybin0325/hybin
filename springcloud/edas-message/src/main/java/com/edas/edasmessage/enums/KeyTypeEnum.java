package com.edas.edasmessage.enums;

public enum KeyTypeEnum {
	DLD("001", "门店"), DING("001", "钉钉"),WECHAT("003","微信");
    // 成员变量
    private String name;
    private String index;
    // 构造方法
    private KeyTypeEnum(String index,String name) {
        this.name = name;
        this.index = index;
    }
    // 普通方法
    public static String getName(String index) {
        for (KeyTypeEnum c : KeyTypeEnum.values()) {
            if (c.getIndex().equals(index)) {
                return c.name;
            }
        }
        return null;
    }
    // get set 方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getIndex() {
        return index;
    }
    public void setIndex(String index) {
        this.index = index;
    }
}
