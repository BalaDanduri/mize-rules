package com.mize.domain.common;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnore;

public class ShortUrl extends MizeEntity implements Comparable<ShortUrl>{

	private static final long serialVersionUID = -5226291820868027579L;
	private String errorCode;
	private String errorMessage;
	private String statusCode;
	private String url;
	private Map<String,ShortUrlResults> results = new HashMap<String,ShortUrlResults>();

	public static class ShortUrlResults{
		private String longUrl;
		private String shortUrl;
		private String hash;


		public String getLongUrl() {
			return longUrl;
		}
		public void setLongUrl(String longUrl) {
			this.longUrl = longUrl;
		}
		public String getShortUrl() {
			return shortUrl;
		}
		public void setShortUrl(String shortUrl) {
			this.shortUrl = shortUrl;
		}
		public String getHash() {
			return hash;
		}
		public void setHash(String hash) {
			this.hash = hash;
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

	public Map<String, ShortUrlResults> getResults() {
		return results;
	}

	public void setResults(Map<String, ShortUrlResults> results) {
		this.results = results;
	}	

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@JsonIgnore
	public String getShortUrl(){
		try{
			return results.values().iterator().next().getShortUrl();
		}catch(Exception e){			
		}
		return null;
	}
	
	@Override
	public String toString() {
		return "ShortURL [errorCode=" + errorCode + ", errorMessage="
				+ errorMessage + ", statusCode=" + statusCode + ", results="
				+ results + "]";
	}

	@Override
	public int compareTo(ShortUrl arg0) {
		return 0;
	}
	
}
