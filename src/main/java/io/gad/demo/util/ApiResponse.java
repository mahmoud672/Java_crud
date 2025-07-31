package io.gad.demo.util;

public class ApiResponse<T> {

	private String message;
	private String status;
	private Integer code;
	private T data;
	
	
	public ApiResponse(String message,String status,Integer code,T data)
	{
		this.setMessage(message);
		this.setStatus(status);
		this.setCode(code);
		this.setData(data);
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Integer getCode() {
		return code;
	}


	public void setCode(Integer code) {
		this.code = code;
	}


	public T getData() {
		return data;
	}


	public void setData(T data) {
		this.data = data;
	}
	
	
	
}
