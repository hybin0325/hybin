package net.medcrm.yjb.workflow.vo;

import java.util.List;

import net.medcrm.yjb.his.excelutil.model.BaseModel;
import net.medcrm.yjb.his.excelutil.persistence.FieldNote;


public class TvTypeBean extends BaseModel implements java.io.Serializable{
    

    private static final long serialVersionUID = -5217032731630006972L;
    
    @FieldNote(logicalName = "终端类型",physicalName = "terminalType",notNull = true)
    private String terminalType;
    
    @FieldNote(logicalName = "分类编码",physicalName = "tvTypeCode",notNull = true)
    private String tvTypeCode;
    
    @FieldNote(logicalName = "分类名称",physicalName = "tvTypeName",notNull = true)
    private String tvTypeName;
    
    @FieldNote(logicalName = "分类缩写名称",physicalName = "tvTypeAbridgeName",notNull = true)
    private String tvTypeAbridgeName;
    
    @FieldNote(logicalName = "排序字段",physicalName = "orderBy")
    private String orderBy;

    @Override
    public List<Object> check(BaseModel model, List<Object> valueList){
       // valueList = super.check(model,valueList);
       //TODO:实现非空时的数据检验
       return valueList;
    }
    /**
     * @return the terminalType
     */
    public String getTerminalType() {
        return terminalType;
    }

    /**
     * @param terminalType the terminalType to set
     */
    public void setTerminalType(String terminalType) {
        this.terminalType = terminalType;
    }

    /**
     * @return the tvTypeCode
     */
    public String getTvTypeCode() {
        return tvTypeCode;
    }

    /**
     * @param tvTypeCode the tvTypeCode to set
     */
    public void setTvTypeCode(String tvTypeCode) {
        this.tvTypeCode = tvTypeCode;
    }

    /**
     * @return the tvTypeName
     */
    public String getTvTypeName() {
        return tvTypeName;
    }

    /**
     * @param tvTypeName the tvTypeName to set
     */
    public void setTvTypeName(String tvTypeName) {
        this.tvTypeName = tvTypeName;
    }

    /**
     * @return the tvTypeAbridgeName
     */
    public String getTvTypeAbridgeName() {
        return tvTypeAbridgeName;
    }

    /**
     * @param tvTypeAbridgeName the tvTypeAbridgeName to set
     */
    public void setTvTypeAbridgeName(String tvTypeAbridgeName) {
        this.tvTypeAbridgeName = tvTypeAbridgeName;
    }

    /**
     * @return the orderBy
     */
    public String getOrderBy() {
        return orderBy;
    }

    /**
     * @param orderBy the orderBy to set
     */
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}