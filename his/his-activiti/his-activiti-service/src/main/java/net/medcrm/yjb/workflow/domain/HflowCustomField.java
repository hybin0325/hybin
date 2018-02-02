package net.medcrm.yjb.workflow.domain;

import net.medcrm.yjb.his.common.model.PersistentObject;

/**
 * 自定义表单字段表实体
 * Created by linsheng on 2017/12/26.
 */
public class HflowCustomField extends PersistentObject {

    private String fieldId;
    private String title;
    private String content;
    private String componentKey;
    private long maxlen;
    private boolean isDefault;
    private String tplId;

    public boolean isDefault() {
        return isDefault;
    }
    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getComponentKey() {
        return componentKey;
    }

    public void setComponentKey(String componentKey) {
        this.componentKey = componentKey;
    }

    public long getMaxlen() {
        return maxlen;
    }

    public void setMaxlen(long maxlen) {
        this.maxlen = maxlen;
    }

    public String getTplId() {
        return tplId;
    }

    public void setTplId(String tplId) {
        this.tplId = tplId;
    }


}
