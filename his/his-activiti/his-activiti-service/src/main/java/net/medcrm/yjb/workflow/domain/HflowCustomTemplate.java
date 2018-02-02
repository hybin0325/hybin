package net.medcrm.yjb.workflow.domain;

import io.swagger.models.auth.In;
import net.medcrm.yjb.his.common.model.PersistentObject;
import net.medcrm.yjb.his.excelutil.excel.annotation.ExcelField;
import net.medcrm.yjb.his.tool.NumberConvert;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;


/**
 * 自定义表单模板实体
 * Created by linsheng on 2017/12/26.
 */
public class HflowCustomTemplate extends PersistentObject {

    public static final int PUBLIC_STATUS = 1; //发布状态
    public static final int INIT_STATUS = 0;   //未发布状态
    public static final int HISTORY_STATUS = -1;//历史状态
    @NotNull
    @Length(min=1, max=100)
    @ExcelField(title="编号", align=2, sort=10)
    private String code;
    @NotNull
    @Length(min=1, max=200, message="登录名长度必须介于 1 和 200 之间")
    @ExcelField(title="表单名称", align=2, sort=10)
    private String name;
    @ExcelField(title="描述", align=2, sort=20)
    private String description;
    @NotNull
    @ExcelField(title="表单模板", align=2, sort=30)
    private String tpl;
    private String type;
    private String version;
    private String pid;
    private Integer sort;
    private Integer status = INIT_STATUS;
    private Date publicDate;
    private List<HflowCustomField> hflowCustomFieldList;

    public List<HflowCustomField> getHflowCustomFieldList() {
        return hflowCustomFieldList;
    }

    public void setHflowCustomFieldList(List<HflowCustomField> hflowCustomFieldList) {
        this.hflowCustomFieldList = hflowCustomFieldList;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(Date publicDate) {
        this.publicDate = publicDate;
    }

    @Override
    public Integer getStatus() {
        return status;
    }

    @Override
    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getVersion() {
        return NumberConvert.stringToOneBigDecimalPlace(version);
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTpl() {
        return tpl;
    }

    public void setTpl(String tpl) {
        this.tpl = tpl;
    }

}
