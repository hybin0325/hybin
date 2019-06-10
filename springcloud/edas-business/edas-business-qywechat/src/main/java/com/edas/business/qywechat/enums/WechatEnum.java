package com.edas.business.qywechat.enums;

public enum WechatEnum {
    TEXT("text", "text"), TEXTCARD("textcard", "textcard"), FILE("file", "file"), VOICE("voice", "voice"),VIDEO("video", "video"),MARKDOWN("markdown", "markdown"), TITLE("title", "title"), MARKURL("tz_url", "url"), SINGLETITLE("tz_btn", "btntxt"),TEXTS("mess_con", "description"),CONTENT("content", "content"),IMAGE("image", "image"),NEWS("news", "news");
    // 成员变量
    private String name;
    private String index;
    // 构造方法
    private WechatEnum(String index,String name) {
        this.name = name;
        this.index = index;
    }
    // 普通方法
    public static String getName(String index) {
        for (WechatEnum c : WechatEnum.values()) {
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
