package com.muj_unity_fest_2025.globalexception;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public class ErrorResponse {

	private int status;
	private long timestamp;
	private String message;
	
	public ErrorResponse(String message) {
		super();
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ErrorResponse(int status, long timestamp, String message) {
		super();
		this.status = status;
		this.timestamp = timestamp;
		this.message = message;
	}

	@Override
	public String toString() {
		return "ErrorResponse [status=" + status + ", timestamp=" + timestamp + ", message=" + message + "]";
	}
	
	
	
	
}
