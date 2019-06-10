package com.edas.system.auth.entity;

import java.util.List;

import javax.persistence.Table;

import com.edas.system.auth.entity.po.BasePo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false )
@NoArgsConstructor
@Table(name="shopwwi_sys_resources")
public class Resource extends BasePo<Long> {
    /**
	 * 
	 */
	private static final long serialVersionUID = 2095842409729872221L;
	private String code;
    private String name;
    private String type;
    private String url;
    private String method;
    private String description;
    private Long parentId;
    private Integer level;
    
    private List<Resource> child;
    
    
}
