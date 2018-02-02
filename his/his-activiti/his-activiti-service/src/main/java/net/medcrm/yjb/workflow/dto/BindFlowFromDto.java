package net.medcrm.yjb.workflow.dto;

import java.util.List;

/**
 * Created by linsheng on 2017/12/26.
 */
public class BindFlowFromDto {

    private String flowId;
    private List<String> flowNodeIds;
    private String formId;

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public List<String> getFlowNodeIds() {
        return flowNodeIds;
    }

    public void setFlowNodeIds(List<String> flowNodeIds) {
        this.flowNodeIds = flowNodeIds;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }
}
