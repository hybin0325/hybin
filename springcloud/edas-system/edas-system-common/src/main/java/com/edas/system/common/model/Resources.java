package com.edas.system.common.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class Resources implements Serializable {
	private static final long serialVersionUID = 2095842409729872221L;
    private Long id;
	private String code;
    private String name;
    private String type;
    private String url;
    private String method;
    private String description;
    private Long parentId;
    private Integer level;
    
}
