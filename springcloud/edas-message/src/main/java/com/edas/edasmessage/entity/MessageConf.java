package com.edas.edasmessage.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * shopwwi_message_conf
 * 
 * @author
 */
@Table(name = "shopwwi_message_conf")
public class MessageConf implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	/**
	 * 类型 001门店 002钉钉 003微信
	 */
	private String typeKey;

	/**
	 * 值
	 */
	private String commKey;

	/**
	 * 所属门店
	 */
	private String dld;

	/**
	 * 所属集团
	 */
	private String clique;

	private static final long serialVersionUID = 1L;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypeKey() {
		return typeKey;
	}

	public void setTypeKey(String typeKey) {
		this.typeKey = typeKey;
	}

	public String getCommKey() {
		return commKey;
	}

	public void setCommKey(String commKey) {
		this.commKey = commKey;
	}

	public String getDld() {
		return dld;
	}

	public void setDld(String dld) {
		this.dld = dld;
	}

	public String getClique() {
		return clique;
	}

	public void setClique(String clique) {
		this.clique = clique;
	}

	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		MessageConf other = (MessageConf) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getTypeKey() == null ? other.getTypeKey() == null
						: this.getTypeKey().equals(other.getTypeKey()))
				&& (this.getCommKey() == null ? other.getCommKey() == null
						: this.getCommKey().equals(other.getCommKey()))
				&& (this.getDld() == null ? other.getDld() == null : this.getDld().equals(other.getDld()))
				&& (this.getClique() == null ? other.getClique() == null : this.getClique().equals(other.getClique()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getTypeKey() == null) ? 0 : getTypeKey().hashCode());
		result = prime * result + ((getCommKey() == null) ? 0 : getCommKey().hashCode());
		result = prime * result + ((getDld() == null) ? 0 : getDld().hashCode());
		result = prime * result + ((getClique() == null) ? 0 : getClique().hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", typeKey=").append(typeKey);
		sb.append(", commKey=").append(commKey);
		sb.append(", dld=").append(dld);
		sb.append(", clique=").append(clique);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}