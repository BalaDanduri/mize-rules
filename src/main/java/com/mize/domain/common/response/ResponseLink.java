package com.mize.domain.common.response;

public class ResponseLink {

	private String name;
	private String href;
	private String[] type;
	
	public ResponseLink(String name, String href, String[] type) {
		this.name = name;
		this.href = href;
		this.type = type;
	}
	
	public ResponseLink() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String[] getType() {
		return type;
	}
	public void setType(String[] type) {
		this.type = type;
	} 
	
	
}
