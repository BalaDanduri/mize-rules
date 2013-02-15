package com.mize.domain.prod;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

public class ProductUpsell extends Entity{

	private static final long serialVersionUID = 6738887069779058581L;
	private Long Id;
	private String mfgPartNo;
	private Long manufacturerId;
	private String isActive;
	private Long catId;
	private String isAccesory;
	private String equivalency;
	private Long familyId;
	private Long userId;
	private String name;
	private String lowPic;
	private String highPic;
	private String thumbPic;
	private Integer lowPicSize;
	private Integer highPicSize;
	private Integer thumbPicSize;
	private DateTime releaseDate;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getMfgPartNo() {
		return mfgPartNo;
	}
	public void setMfgPartNo(String mfgPartNo) {
		this.mfgPartNo = mfgPartNo;
	}
	public Long getManufacturerId() {
		return manufacturerId;
	}
	public void setManufacturerId(Long manufacturerId) {
		this.manufacturerId = manufacturerId;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public Long getCatId() {
		return catId;
	}
	public void setCatId(Long catId) {
		this.catId = catId;
	}
	public String getIsAccesory() {
		return isAccesory;
	}
	public void setIsAccesory(String isAccesory) {
		this.isAccesory = isAccesory;
	}
	public String getEquivalency() {
		return equivalency;
	}
	public void setEquivalency(String equivalency) {
		this.equivalency = equivalency;
	}
	
	public Long getFamilyId() {
		return familyId;
	}
	public void setFamilyId(Long familyId) {
		this.familyId = familyId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLowPic() {
		return lowPic;
	}
	public void setLowPic(String lowPic) {
		this.lowPic = lowPic;
	}
	public String getHighPic() {
		return highPic;
	}
	public void setHighPic(String highPic) {
		this.highPic = highPic;
	}
	public String getThumbPic() {
		return thumbPic;
	}
	public void setThumbPic(String thumbPic) {
		this.thumbPic = thumbPic;
	}
	public Integer getLowPicSize() {
		return lowPicSize;
	}
	public void setLowPicSize(Integer lowPicSize) {
		this.lowPicSize = lowPicSize;
	}
	public Integer getHighPicSize() {
		return highPicSize;
	}
	public void setHighPicSize(Integer highPicSize) {
		this.highPicSize = highPicSize;
	}
	public Integer getThumbPicSize() {
		return thumbPicSize;
	}
	public void setThumbPicSize(Integer thumbPicSize) {
		this.thumbPicSize = thumbPicSize;
	}
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)	
	public DateTime getReleaseDate() {
		return releaseDate;
	}
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)
	public void setReleaseDate(DateTime releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	
	

}
