package com.edas.business.dingtalk.enums;

public enum DingtalkEnum {
    TEXT("text", "text"), TEXTCARD("textcards", "action_card"),MARKDOWN("mess_con", "markdown"), OA("textcard", "oa"), TITLE("title", "title"), SINGLEURL("tz_url", "single_url"), SINGLETITLE("tz_btn", "single_title"), TEXTS("mess_con", "text"), CONTENT("content", "content");
    // 成员变量
    private String name;
    private String index;
    // 构造方法
    private DingtalkEnum(String index,String name) {
        this.name = name;
        this.index = index;
    }
    // 普通方法
    public static String getName(String index) {
        for (DingtalkEnum c : DingtalkEnum.values()) {
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
