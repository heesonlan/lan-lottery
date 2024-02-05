package com.lan.lottery.model;


import java.io.Serializable;

/**
 *
 */
public class MSG implements Serializable {
	
	private boolean success;
	
	private String code;
	
	private String message;
	
	private Object data;

	public String getI18nCode() {
		return i18nCode;
	}

	public void setI18nCode(String i18nCode) {
		this.i18nCode = i18nCode;
	}

	private String i18nCode;

	public MSG() {
		super();
	}
	
	public MSG(boolean success) {
		super();
		this.success = success;
	}
	
	public MSG(boolean success, Object data) {
		super();
		this.success = success;
		this.data = data;
	}
	
	public MSG(boolean success, Object data, String message) {
		super();
		this.success = success;
		this.data = data;
		this.message = message;
	}
	
	public MSG(boolean success, Object data, String message, String code) {
		super();
		this.success = success;
		this.data = data;
		this.message = message;
		this.code = code;
	}

	public MSG i18n(String i18nCode){
		this.i18nCode=i18nCode;
		return this;
	}
	
	public static MSG success(){
		return new MSG(true);
	}
	
	public static MSG success(Object data){
		return new MSG(true, data);
	}
	
	public static MSG success(Object data, String message){
		return new MSG(true, data, message);
	}
	
	public static MSG error(){
		return new MSG(false);
	}
	
	public static MSG error(String message){
		return new MSG(false, null, message);
	}
	
	public static MSG error(String code, String message){
		return new MSG(false, null, message, code);
	}

	public static MSG error(String code, String message, Object data){
		return new MSG(false, data, message, code);
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
