package com.mize.domain.common.response;

import java.util.List;


public class ResponseMeta {
	
	private String statusCode;
	private List<String> statusMessage;
	private Integer resultSize;
	private Long totalRecords;
	private Integer pageNumber;
	private Long totalPages;
	private Long responseTime;
	private String version;
	private String request;

	public ResponseMeta() {
		
	}
	
	public ResponseMeta(String statusCode, List<String> statusMessage, Integer resultSize, Long totalRecords,
			Integer pageNumber, Long totalPages, Long responseTime, String version, String request) {
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
		this.resultSize = resultSize;
		this.totalRecords = totalRecords;
		this.pageNumber = pageNumber;
		this.totalPages = totalPages;
		this.responseTime = responseTime;
		this.version = version;
		this.request = request;
	}

	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public List<String> getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(List<String> statusMessage) {
		this.statusMessage = statusMessage;
	}
	public Integer getResultSize() {
		return resultSize;
	}
	public void setResultSize(Integer resultSize) {
		this.resultSize = resultSize;
	}
	public Long getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(Long totalRecords) {
		this.totalRecords = totalRecords;
	}
	public Integer getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	public Long getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Long totalPages) {
		this.totalPages = totalPages;
	}
	public Long getResponseTime() {
		return responseTime;
	}
	public void setResponseTime(Long responseTime) {
		this.responseTime = responseTime;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}	
}
