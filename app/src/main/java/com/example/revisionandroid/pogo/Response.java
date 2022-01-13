package com.example.revisionandroid.pogo;

import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("data")
	private Data data;

	@SerializedName("message")
	private Object message;

	@SerializedName("status")
	private boolean status;

	public Data getData(){
		return data;
	}

	public Object getMessage(){
		return message;
	}

	public boolean isStatus(){
		return status;
	}
}