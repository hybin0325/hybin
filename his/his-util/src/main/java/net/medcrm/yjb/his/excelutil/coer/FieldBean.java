package net.medcrm.yjb.his.excelutil.coer;

import java.io.Serializable;

import net.medcrm.yjb.his.excelutil.persistence.FieldNote;

public class FieldBean implements Serializable {
	private static final long serialVersionUID = -2580446648369809947L;
	private String name;
	private FieldNote note;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FieldNote getNote() {
		return this.note;
	}

	public void setNote(FieldNote note) {
		this.note = note;
	}
}
