package com.algaworks.algafood.client.api;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class Problema {
	
	private Integer status;
	private OffsetDateTime timeStamp;
	private String userMessage;
	private String detail;
	private List<ProblemaObjects> objects = new ArrayList<>();
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public OffsetDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(OffsetDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getUserMessage() {
		return userMessage;
	}
	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public List<ProblemaObjects> getObjects() {
		return objects;
	}
	public void setObjects(List<ProblemaObjects> objects) {
		this.objects = objects;
	}
	
	public static class ProblemaObjects {
		
		private String fieldName;
		private String fieldUserMessage;
		
		public String getFieldName() {
			return fieldName;
		}
		public void setFieldName(String fieldName) {
			this.fieldName = fieldName;
		}
		public String getFieldUserMessage() {
			return fieldUserMessage;
		}
		public void setFieldUserMessage(String fieldUserMessage) {
			this.fieldUserMessage = fieldUserMessage;
		}
		
	}
}
