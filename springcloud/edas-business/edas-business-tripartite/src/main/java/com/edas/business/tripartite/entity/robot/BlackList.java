package com.edas.business.tripartite.entity.robot;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;

import com.edas.business.tripartite.annotation.Phone;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * <p>
 * Description: 黑名单实体
 * </p>
 * <p>
 * Date：2019年4月29日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@SuppressWarnings("serial")
@Table(name = "shopwwi_zt_ai_baiying_blacklist")
@Data
@ToString
@ApiModel(description = "黑名单实体")
public class BlackList implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@ApiModelProperty(hidden = true)
    private Integer id;
	
	@NotNull(message = "companyId不允许为空")
	@ApiModelProperty(notes = "公司id", example = "2019", required = true, dataType="Integer")
    private Integer companyId;
    
	@NotBlank(message = "name不允许为空")
	@ApiModelProperty(notes = "姓名", example = "刘德华", required = true, dataType="String")
    private String name;
    
	@Phone
	@ApiModelProperty(notes = "手机", example = "18688886666", required = true, dataType="String")
    private String mobile;
    
	@ApiModelProperty(notes = "说明", example = "说明", dataType="String")
    private String remark;
	
	@ApiModelProperty(hidden = true)
    private Integer blackListId;
           
}