package com.mize.domain.brand;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

@Entity
@Table(name = "brand_feed")
public class BrandFeed extends MizeEntity implements Comparable<BrandFeed>{
	
	private static final long serialVersionUID = -8006941720446513027L;
	private Brand brand;
	private String feedType;
	private String feedDesc;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime startTime;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime endTime;
	private Long userId;
	protected Long createdBy;
	protected Long updatedBy;
	
	public BrandFeed(){
		
	}
	
	public BrandFeed(Brand brand) {
		super();
		this.brand = brand;
	}

	public BrandFeed(Brand brand, String feedType, String feedDesc, DateTime startTime, DateTime endTime) {
		super();
		this.brand = brand;
		this.feedType = feedType;
		this.feedDesc = feedDesc;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public BrandFeed(Long id,Brand brand, String feedType, String feedDesc, DateTime startTime, DateTime endTime) {
		this.id = id;
		this.brand = brand;
		this.feedType = feedType;
		this.feedDesc = feedDesc;
		this.startTime = startTime;
		this.endTime = endTime;
	}


	@Id
	@GenericGenerator(name="id" , strategy="increment")
	@GeneratedValue(generator="id")
	@Column(name="id",unique=true,nullable=false,length=11)
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "BRAND_ID", nullable = true)
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
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@Column(name = "start_time",  nullable = true)
	@Type(type="com.mize.domain.brand.DateTimeJPA")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	public DateTime getStartTime() {
		return startTime;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)
	public void setStartTime(DateTime startTime) {
		this.startTime = startTime;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@Column(name = "end_time",  nullable = true)
	@Type(type="com.mize.domain.brand.DateTimeJPA")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	public DateTime getEndTime() {
		return endTime;
	}
	
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setEndTime(DateTime endTime) {
		this.endTime = endTime;
	}
	
	@Transient
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	@Column(name = "created_by",  nullable = true, length = 20)
	public Long getCreatedBy() {
		return userId;
	}

	public void setCreatedBy(Long userId) {
		this.userId = userId;
	}

	@Column(name = "updated_by",  nullable = true, length = 20)
	public Long getUpdatedBy() {
		return userId;
	}

	public void setUpdatedBy(Long userId) {
		this.userId = userId;
	}

	@Override
	public int compareTo(BrandFeed arg0) {
		return 0;
	}
	
}
