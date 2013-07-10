package com.mize.domain.common.response;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;


public class ResponseMeta {
	
	private String status;
	private List<ResponseStatus> errors;
	private Integer resultSize;
	private Long totalRecords;
	private Integer pageNumber;
	private Long totalPages;
	private String version;
	private String request;
	@JsonIgnore
	private final Long startTime = System.currentTimeMillis();

	public static final String STATUS_SUCCESS = "success";
	public static final String STATUS_FAILURE = "failure";
	
	public ResponseMeta() {
		
	}
	
	public ResponseMeta(String status, List<ResponseStatus> errors, Integer resultSize, Long totalRecords,
			Integer pageNumber, Long totalPages, String version, String request) {
		this.status = status;
		this.errors = errors;
		this.resultSize = resultSize;
		this.totalRecords = totalRecords;
		this.pageNumber = pageNumber;
		this.totalPages = totalPages;
		this.version = version;
		this.request = request;
	}

	public String getStatus() {
		if (status == null || !status.equalsIgnoreCase(STATUS_FAILURE)) {
			status = STATUS_SUCCESS;
		}
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ResponseStatus> getErrors() {
		return errors;
	}

	public void setErrors(List<ResponseStatus> errors) {
		this.errors = errors;
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
	
	public Long getResponseTime() {
		return System.currentTimeMillis() - startTime;
	}

}
