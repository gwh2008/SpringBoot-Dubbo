package cn.coinque.consumer.system.utils;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class ResponseData {
	public static final String ERRORS_KEY = "errors";
	private   String code;
	private   String message;
	private   Map<String, Object> content = new ConcurrentHashMap();

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setContent(Map<String, Object> content) {
		this.content = content;
	}

	public Map<String, Object> getContent() {
		return content;
	}


	public ResponseData putDataValue(String key, Object value) {
		content.put(key, value);
		return this;
	}
	public ResponseData() {
	}
	private ResponseData(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public  ResponseData success() {
		this.code = "0000";
		this.message = "Success";
		return this;
	}
	public  ResponseData isEmpty() {
		this.code = "5555";
		this.message = "查询数据为空";
		return this;
	}
	public static ResponseData ok() {
		return new ResponseData("200", "Ok");
	}
	
	public static ResponseData notFound() {
		return new ResponseData("404", "Not Found");
	}
	
	public static ResponseData badRequest() {
		return new ResponseData("400", "Bad Request");
	}
	
	public static ResponseData forbidden() {
		return new ResponseData("403", "Forbidden");
	}
	
	public static ResponseData unauthorized() {
		return new ResponseData("401", "unauthorized");
	}
	
	public static ResponseData serverInternalError() {
		return new ResponseData("500", "Server Internal Error");
	}
	
	public static ResponseData customerError() {
		return new ResponseData("1001", "Customer Error");
	}

	public static void main(String[] args) {
		ResponseData responseData = new ResponseData();
		System.err.println(responseData.success());
	}
}
