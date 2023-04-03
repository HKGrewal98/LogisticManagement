package com.harkanwal.DTO;

public class Response {

	private boolean isSuccess;
	private String message;
	private Object data;
	
	public Response(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	
	public Response(boolean isSuccess, String message) {
		this.isSuccess = isSuccess;
		this.message = message;
	}
	
	public Response(boolean isSuccess, String message, Object data) {
		this.isSuccess = isSuccess;
		this.message = message;
		this.data = data;
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
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
	@Override
	public String toString() {
		return "Response [isSuccess=" + isSuccess + ", message=" + message + ", data=" + data + "]";
	}
	
	
	
}
