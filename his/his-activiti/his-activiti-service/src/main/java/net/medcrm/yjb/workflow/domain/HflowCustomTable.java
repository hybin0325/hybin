package net.medcrm.yjb.workflow.domain;

import net.medcrm.yjb.his.common.model.PersistentObject;

/**
 * 流程表单字段表
 * Created by linsheng on 2017/12/26.
 */
public class HflowCustomTable extends PersistentObject {

    private String fieldId;
    private String title;
    private String content;
    private String componentKey;
    private long maxlen;
    private String tplId;
    private String flowId;
    private String flowNodeId;
    private boolean isDefault;
    private String version;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

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

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public String getFlowNodeId() {
        return flowNodeId;
    }

    public void setFlowNodeId(String flowNodeId) {
        this.flowNodeId = flowNodeId;
    }
}
