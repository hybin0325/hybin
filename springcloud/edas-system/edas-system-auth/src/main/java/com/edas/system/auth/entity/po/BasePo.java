package com.edas.system.auth.entity.po;

import lombok.Data;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class BasePo<ID extends Serializable> implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4024215146187785027L;
	public final static String DEFAULT_USERNAME = "system";
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private ID id;
    private String createdBy = DEFAULT_USERNAME;
    private String updatedBy = DEFAULT_USERNAME;
    private Date createdTime = Date.from(ZonedDateTime.now().toInstant());
    private Date updatedTime = Date.from(ZonedDateTime.now().toInstant());
}
