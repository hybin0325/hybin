package me.zhengjie.modules.system.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/**
 * 群组管理
 * 
 * @author Owner
 *
 */

@Entity
@Getter
@Setter
@Table(name = "sys_group")
public class Group implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@NotNull(groups = Update.class)
	private Long id;

	@Column(name = "group_name")
	private String groupName;

	@Column(name = "create_time")
	@CreationTimestamp
	private Timestamp createTime;

	@JsonIgnore
	@ManyToMany(mappedBy = "groups")
	private Set<Role> roles;

	private int status;

	public @interface Update {
	}
}
