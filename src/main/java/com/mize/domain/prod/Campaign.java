package com.mize.domain.prod;

import org.joda.time.DateTime;

public class Campaign extends Entity{

	private static final long serialVersionUID = -6127526446685342722L;
	private Long id;
	private String name;
	private String shortDesc;
	private String longDesc;
	private String link;
	private DateTime startDate;
	private DateTime endDate;
	private Long userId;
	private Long countryIdSet;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortDesc() {
		return shortDesc;
	}
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	public String getLongDesc() {
		return longDesc;
	}
	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public DateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}
	public DateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(DateTime endDate) {
		this.endDate = endDate;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getCountryIdSet() {
		return countryIdSet;
	}
	public void setCountryIdSet(Long countryIdSet) {
		this.countryIdSet = countryIdSet;
	}
		
}