package com.mize.domain.common;

import java.util.HashMap;
import java.util.Map;

import com.mize.domain.common.Entity;

public class LongUrl extends Entity implements Comparable<LongUrl>{

	private static final long serialVersionUID = -5226291820868027579L;
	private String errorCode;
	private String errorMessage;
	private String statusCode;
	private String url;
	private Map<String,LongUrlResults> results = new HashMap<String,LongUrlResults>();

	public static class LongUrlResults{
		private String longUrl;


		public String getLongUrl() {
			return longUrl;
		}
		public void setLongUrl(String longUrl) {
			this.longUrl = longUrl;
		}
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public Map<String, LongUrlResults> getResults() {
		return results;
	}

	public void setResults(Map<String, LongUrlResults> results) {
		this.results = results;
	}	


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "ShortURL [errorCode=" + errorCode + ", errorMessage="
				+ errorMessage + ", statusCode=" + statusCode + ", results="
				+ results + "]";
	}

	@Override
	public int compareTo(LongUrl arg0) {
		return 0;
	}
	
}
