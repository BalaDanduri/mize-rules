package com.mize.domain.product;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.brand.Brand;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.EmptyOrAlpha;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;
import com.mize.domain.util.NonEmpty;
import com.mize.domain.util.ValidateOnDependentFeild;

@Entity
@Table(name="engagement_options")
@ValidateOnDependentFeild.List({
	@ValidateOnDependentFeild(
        fieldName = "code",
        dependFieldName = "type",
        dependedFieldValue ="coupon",
        regex = true,
        regexValue ="^[0-9a-zA-Z-:.,_ ]+$",
        message ="code.notempty")})
public class Engagement extends MizeEntity  {
	
	private static final long serialVersionUID = 6140543699715462721L;
	@Transient
	private String storeNumber;
	private String type;
	private String code;
	private Brand brand;
	private String title;
	private String description;
	private String imagePath;
	private String imageTitle;
	private String url;
	private String urlTitle;
	private String redeemInstructions;
	private String termsConditions;
	private String discountType;
	private Double discountValue;
	private Integer maxRedemptions;
	private Integer redemptions;
	private Integer useLimit;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime startDate;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime endDate;
	private List<EngagementLink> engagementLinks = new ArrayList<EngagementLink>();
	@Transient
	private Integer pageIndex;
	private String status;
	private String level;
	
	public Engagement(){
		
	}
	
	
	public Engagement(String type, String code, Brand brand, String title, String description, String imagePath,
			String imageTitle, String url, String urlTitle, String redeemInstructions, String termsConditions,
			String discountType, Double discountValue, Integer maxRedemptions, Integer redemptions, Integer useLimit,
			DateTime startDate, DateTime endDate, List<EngagementLink> engagementLinks, Integer pageIndex, String status) {
		super();
		this.type = type;
		this.code = code;
		this.brand = brand;
		this.title = title;
		this.description = description;
		this.imagePath = imagePath;
		this.imageTitle = imageTitle;
		this.url = url;
		this.urlTitle = urlTitle;
		this.redeemInstructions = redeemInstructions;
		this.termsConditions = termsConditions;
		this.discountType = discountType;
		this.discountValue = discountValue;
		this.maxRedemptions = maxRedemptions;
		this.redemptions = redemptions;
		this.useLimit = useLimit;
		this.startDate = startDate;
		this.endDate = endDate;
		this.engagementLinks = engagementLinks;
		this.pageIndex = pageIndex;
		this.status = status;
	}

	
	@Id
	@GenericGenerator(name="id" , strategy="increment")
	@GeneratedValue(generator="id")
	@Column(name="id",unique=true,nullable=false,length=20)
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "type",nullable = true, length = 50)
	@NonEmpty(message="type.notempty")
	@Size(max = 50)
	@Pattern(regexp = "^[a-zA-Z]+$", message="type.alphabets")
	public String getType() {
		return type;
	}

	@Transient
	public String getStoreNumber() {
		return storeNumber;
	}

	@Transient
	public void setStoreNumber(String storeNumber) {
		this.storeNumber = storeNumber;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "code",nullable = true, length = 100)
	@Size(max = 100)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "brand_id", nullable = true)
	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@Column(name = "title",nullable = true, length = 100)
	@NonEmpty(message="title.notempty")
	@Size(max = 100)
	@Pattern(regexp = "^[0-9a-zA-Z-:.,_ ]+$", message="title.alphanumeric")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "description",nullable = true, length = 500)
	@NonEmpty(message="description.notempty")
	@Size(max = 500)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "image_title",nullable = true, length = 100)
	@NonEmpty(message="image_title.notempty")
	@Size(max = 100)
	@Pattern(regexp = "^[a-zA-Z]+$", message="image_title.alphabets")
	public String getImageTitle() {
		return imageTitle;
	}

	public void setImageTitle(String imageTitle) {
		this.imageTitle = imageTitle;
	}

	@Column(name = "url",nullable = true, length = 100)
	@Size(max = 100)
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "url_title",nullable = true, length = 100)
	@Size(max = 100)
	public String getUrlTitle() {
		return urlTitle;
	}

	public void setUrlTitle(String urlTitle) {
		this.urlTitle = urlTitle;
	}

	@Column(name = "redeem_instructions",nullable = false, length = 500)
	@Size(max = 500)
	@EmptyOrAlpha(message="redeem_instructions.alphanumeric")
	public String getRedeemInstructions() {
		return redeemInstructions;
	}

	public void setRedeemInstructions(String redeemInstructions) {
		this.redeemInstructions = redeemInstructions;
	}
	
	
	@Column(name = "terms_conditions",nullable = true, length = 1000)
	@Size(max = 1000)
	public String getTermsConditions() {
		return termsConditions;
	}

	public void setTermsConditions(String termsConditions) {
		this.termsConditions = termsConditions;
	}

	@Column(name = "discount_type",nullable = true, length = 100)
	@NonEmpty(message="discount_type.notempty")
	@Size(max = 100)
	public String getDiscountType() {
		return discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	@Column(name = "discount_value",nullable = true)
	@NonEmpty(message="discount_value.notempty")
	public Double getDiscountValue() {
		return discountValue;
	}

	public void setDiscountValue(Double discountValue) {
		this.discountValue = discountValue;
	}

	@Column(name = "max_redemptions",nullable = true, length = 11)
	@NonEmpty(message="max_redemptions.notempty")
	//@Pattern(regexp = "[0-9]", message="max_redemptions.numeric")
	public Integer getMaxRedemptions() {
		return maxRedemptions;
	}

	public void setMaxRedemptions(Integer maxRedemptions) {
		this.maxRedemptions = maxRedemptions;
	}

	@Column(name = "redemptions",nullable = true, length = 11)
	@NonEmpty(message="redemptions.notempty")
	//@Pattern(regexp = ".*[^0-9].*", message="redemptions.numeric")
	public Integer getRedemptions() {
		return redemptions;
	}

	public void setRedemptions(Integer redemptions) {
		this.redemptions = redemptions;
	}

	@Column(name = "use_limit",nullable = true, length = 11)
	public Integer getUseLimit() {
		return useLimit;
	}

	public void setUseLimit(Integer useLimit) {
		this.useLimit = useLimit;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@Column(name = "start_date",  nullable = true)
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	@NonEmpty(message="start_date.notempty")
	public DateTime getStartDate() {
		return startDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)
	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@Column(name = "end_date",  nullable = true)
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	@NonEmpty(message="end_date.notempty")
	public DateTime getEndDate() {
		return endDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setEndDate(DateTime endDate) {
		this.endDate = endDate;
	}

	@Column(name = "image",nullable = true, length = 100)
	@NonEmpty(message="image.notempty")
	@Size(max = 50)
	public String getImagePath() { 
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade =CascadeType.ALL)
	@JoinColumn(name="engagement_options_id") 
	public List<EngagementLink> getEngagementLinks() {
		return engagementLinks;
	}

	public void setEngagementLinks(List<EngagementLink> engagementLinks) {
		this.engagementLinks = engagementLinks;
	}

	@Transient
	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	
	@Column(name = "created_by",nullable = true, length = 20)
	@JsonIgnore(value=false)
	public Long getCreatedBy() {
		return createdBy;
	}
	@JsonIgnore(value=false)
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	
	
	@Column(name = "updated_by",nullable = true, length = 20)
	@JsonIgnore(value=false)
	public Long getUpdatedBy() {
		return updatedBy;
	}
	@JsonIgnore(value=false)
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	@Column(name = "eo_status",nullable = true)
	@NonEmpty(message="eo_status.notempty")
	@Size(max = 30)
	public String getStatus() {
		return status;
	}

	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}


	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((discountType == null) ? 0 : discountType.hashCode());
		result = prime * result
				+ ((discountValue == null) ? 0 : discountValue.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result
				+ ((engagementLinks == null) ? 0 : engagementLinks.hashCode());
		result = prime * result
				+ ((imagePath == null) ? 0 : imagePath.hashCode());
		result = prime * result
				+ ((imageTitle == null) ? 0 : imageTitle.hashCode());
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result
				+ ((maxRedemptions == null) ? 0 : maxRedemptions.hashCode());
		result = prime * result
				+ ((pageIndex == null) ? 0 : pageIndex.hashCode());
		result = prime
				* result
				+ ((redeemInstructions == null) ? 0 : redeemInstructions
						.hashCode());
		result = prime * result
				+ ((redemptions == null) ? 0 : redemptions.hashCode());
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((storeNumber == null) ? 0 : storeNumber.hashCode());
		result = prime * result
				+ ((termsConditions == null) ? 0 : termsConditions.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		result = prime * result
				+ ((urlTitle == null) ? 0 : urlTitle.hashCode());
		result = prime * result
				+ ((useLimit == null) ? 0 : useLimit.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Engagement other = (Engagement) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (discountType == null) {
			if (other.discountType != null)
				return false;
		} else if (!discountType.equals(other.discountType))
			return false;
		if (discountValue == null) {
			if (other.discountValue != null)
				return false;
		} else if (!discountValue.equals(other.discountValue))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (engagementLinks == null) {
			if (other.engagementLinks != null)
				return false;
		} else if (!engagementLinks.equals(other.engagementLinks))
			return false;
		if (imagePath == null) {
			if (other.imagePath != null)
				return false;
		} else if (!imagePath.equals(other.imagePath))
			return false;
		if (imageTitle == null) {
			if (other.imageTitle != null)
				return false;
		} else if (!imageTitle.equals(other.imageTitle))
			return false;
		if (level == null) {
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		if (maxRedemptions == null) {
			if (other.maxRedemptions != null)
				return false;
		} else if (!maxRedemptions.equals(other.maxRedemptions))
			return false;
		if (pageIndex == null) {
			if (other.pageIndex != null)
				return false;
		} else if (!pageIndex.equals(other.pageIndex))
			return false;
		if (redeemInstructions == null) {
			if (other.redeemInstructions != null)
				return false;
		} else if (!redeemInstructions.equals(other.redeemInstructions))
			return false;
		if (redemptions == null) {
			if (other.redemptions != null)
				return false;
		} else if (!redemptions.equals(other.redemptions))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (storeNumber == null) {
			if (other.storeNumber != null)
				return false;
		} else if (!storeNumber.equals(other.storeNumber))
			return false;
		if (termsConditions == null) {
			if (other.termsConditions != null)
				return false;
		} else if (!termsConditions.equals(other.termsConditions))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		if (urlTitle == null) {
			if (other.urlTitle != null)
				return false;
		} else if (!urlTitle.equals(other.urlTitle))
			return false;
		if (useLimit == null) {
			if (other.useLimit != null)
				return false;
		} else if (!useLimit.equals(other.useLimit))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Engagement [storeNumber=" + storeNumber + ", type=" + type
				+ ", code=" + code + ", brand=" + brand + ", title=" + title
				+ ", description=" + description + ", imagePath=" + imagePath
				+ ", imageTitle=" + imageTitle + ", url=" + url + ", urlTitle="
				+ urlTitle + ", redeemInstructions=" + redeemInstructions
				+ ", termsConditions=" + termsConditions + ", discountType="
				+ discountType + ", discountValue=" + discountValue
				+ ", maxRedemptions=" + maxRedemptions + ", redemptions="
				+ redemptions + ", useLimit=" + useLimit + ", startDate="
				+ startDate + ", endDate=" + endDate + ", engagementLinks="
				+ engagementLinks + ", pageIndex=" + pageIndex + ", status="
				+ status + ", level=" + level + "]";
	}
}
