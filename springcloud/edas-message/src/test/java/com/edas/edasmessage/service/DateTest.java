package com.edas.edasmessage.service;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.JSONObject;
import com.edas.edasmessage.constant.DateAdapter;
import com.edas.edasmessage.utils.StringUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class DateTest implements Serializable {

	private Date date;

	private int id;

	public DateTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DateTest(Date date, int id) {
		super();
		this.date = date;
		this.id = id;
	}

	@Override
	public String toString() {
		return "DateTest [date=" + date + ", id=" + id + "]";
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static void main(String[] args) {
		Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateAdapter())
                .create();
        DateTest dateTest = new DateTest(new Date(),1);
        System.out.println("dateTest " + gson.toJson(dateTest));
        //String dateTestStr = "{\"date\":\"2018-08-31 16:56:18\",\"id\":1}";
        String dateTestStr = "{\"date\":\"\",\"id\":1}";
        //DateTest dateTest1 = gson.fromJson(dateTestStr,new TypeToken<DateTest>(){}.getType());
        //DateTest dateTest1 = gson.fromJson(dateTestStr,DateTest.class);
        //System.out.println("time object " + dateTest1.getDate().toString());
        
        
        System.out.println(StringUtils.stringToBean(dateTestStr, DateTest.class));
	}
}
