package com.mize.domain.brand;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.MizeDateTime;

@Entity
@Table(name = "brand_feed")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, include="all")
public class BrandFeed extends MizeSceEntity implements Comparable<BrandFeed>{
	
	private static final long serialVersionUID = -8006941720446513027L;
	private Brand brand;
	private String feedType;
	private String feedDesc;
	private String feedTitle;
	private MizeDateTime startTime;
	private MizeDateTime endTime;
	@Transient
	private Integer pageIndex;
	
	public BrandFeed(){
		
	}
	
	public BrandFeed(Brand brand) {
		super();
		this.brand = brand;
	}

	public BrandFeed(Brand brand, String feedType, String feedDesc, MizeDateTime startTime, MizeDateTime endTime,Integer pageIndex) {
		super();
		this.brand = brand;
		this.feedType = feedType;
		this.feedDesc = feedDesc;
		this.startTime = startTime;
		this.endTime = endTime;
		this.pageIndex = pageIndex;
	}

	public BrandFeed(Long id,Brand brand, String feedType, String feedDesc, MizeDateTime startTime, MizeDateTime endTime,Integer pageIndex) {
		this.id = id;
		this.brand = brand;
		this.feedType = feedType;
		this.feedDesc = feedDesc;
		this.startTime = startTime;
		this.endTime = endTime;
		this.pageIndex = pageIndex;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id",unique=true,nullable=false)
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "BRAND_ID", nullable = true)
	@JsonBackReference(value="brand_feed")
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
	@Column(name = "FEED_TYPE",nullable = true, length = 20)
	public String getFeedType() {
		return feedType;
	}
	public void setFeedType(String feedType) {
		this.feedType = feedType;
	}
	
	@Column(name = "FEED_DESC",  nullable = true, length = 2000)
	public String getFeedDesc() {
		return feedDesc;
	}
	public void setFeedDesc(String feedDesc) {
		this.feedDesc = feedDesc;
	}
	
	
	@Column(name = "start_time",  nullable = true)
	@Type(type="com.mize.domain.util.MizeDateTimeJPA")
	public MizeDateTime getStartTime() {
		return startTime;
	}
	
	public void setStartTime(MizeDateTime startTime) {
		this.startTime = startTime;
	}
	
	
	@Column(name = "end_time",  nullable = true)
	@Type(type="com.mize.domain.util.MizeDateTimeJPA")
	public MizeDateTime getEndTime() {
		return endTime;
	}
	
	
	public void setEndTime(MizeDateTime endTime) {
		this.endTime = endTime;
	}
	
	@Column(name = "created_by",  nullable = true, length = 20)
	@JsonIgnore(value=false)
	public Long getCreatedBy() {
		return createdBy;
	}
	@JsonIgnore(value=false)
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "updated_by",  nullable = true, length = 20)
	@JsonIgnore(value=false)
	public Long getUpdatedBy() {
		return updatedBy;
	}
	@JsonIgnore(value=false)
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public int compareTo(BrandFeed arg0) {
		return 0;
	}

	@Transient
	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	@Column(name = "FEED_TITLE",nullable = true, length = 50)
	public String getFeedTitle() {
		return feedTitle;
	}

	public void setFeedTitle(String feedTitle) {
		this.feedTitle = feedTitle;
	}
	
}
