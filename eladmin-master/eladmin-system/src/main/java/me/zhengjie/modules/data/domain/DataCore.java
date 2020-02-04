package me.zhengjie.modules.data.domain;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "data_core")
public class DataCore implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * ID
	 */
	@Id
	private ObjectId id;
	
	/**
	 * 用户ID
	 */
	@Indexed(unique = true,background = true)
	@Field("pro_name")
	@NotBlank
	@Length(min = 5, max = 50)
	private String proName;
	
	@Indexed(background = true,expireAfterSeconds = 10*60)
	private Date createTime;
	
}
