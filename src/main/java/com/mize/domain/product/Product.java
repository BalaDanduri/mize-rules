package com.mize.domain.product;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.brand.Brand;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.DecimalValueDeserializer;
import com.mize.domain.util.Formatter;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.MizeDateTime;
import com.mize.domain.util.NumberValueSerializer;

@javax.persistence.Entity
@Table(name = "prod")
public class Product  extends MizeSceEntity implements Comparable<Product>{
	
	private static final long serialVersionUID = 5379538452565383073L;
	protected String name;
	protected Brand brand = new Brand();
	protected Double price;
	protected Set<ProductCategory> category = new HashSet<ProductCategory>();
	private String shortDescription;
	protected String upc;
	protected String qrCode;
	protected ProductSource productSource = new ProductSource();
	protected Double mizeRating;
	protected String imageLink;
	private List<String> listNames ;
	private ProductDetails productDetails;
	private String model;
	private String productLink;
	private List<ProductRegister> productRegisters = new ArrayList<ProductRegister>();
	private String hasProdContent;
	private String isConsumable;
	private String isAccessory;
	private String mpn;
	private Long userId;
	private Integer prodScore;
	private String active;
	private BusinessEntity tenant;
	private BusinessEntity manufacturerBE;	
	private List<ProductIntl> productIntl = new ArrayList<ProductIntl>();	
	private MizeDateTime releaseDate;
	@Transient
	private User user;
	private List<ProductCategory> categories = new ArrayList<ProductCategory>();
	private ProductCategory productCategory;

	public enum Source{
		MIZE(1),AMAZON(2),ETILIZE(3),BestBuy(4),Sears(5),Ebay(6);
		int value;
		Source(int val){
			value = val;
		}
		public int getValue(){
			return value;
		}
	}	
	
	public Product() {
		category = new HashSet<ProductCategory>();
		categories = new ArrayList<ProductCategory>();
		productSource = new ProductSource();
		productDetails = new ProductDetails();
	}
	
	public Product(String model) {
		this.model = model;
	}
	
	public Product(Long id, String model) {
		this.id = id;
		this.model = model;
	}
	
	public Product(Long id, String model, Long brandId, String brandName, String name, String description ) {
		this.model = model;
		this.id = id;
		Brand brand = new Brand();
		brand.setId(brandId);
		brand.setName(brandName);
		this.brand = brand;
		ProductIntl intl = new ProductIntl();
		intl.setName(name);
		intl.setDescription(description);
		if(this.productIntl == null) {
			List<ProductIntl> intls = new ArrayList<ProductIntl>();
			this.setProductIntl(intls);
		}
		this.getProductIntl().add(intl);
	}
	
	@Id
	@GenericGenerator(name="prod_id",strategy="increment")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "prod_id", nullable = false, unique = true)
	@Override	
	public Long getId() {
		return id;
	}

	@Column(name = "prod_id")
	public void setId(Long id) {
		this.id = id;
	}
	
	
	@Column(name = "release_date")
	@Type(type = "com.mize.domain.util.MizeDateTimeJPA")
	public MizeDateTime getReleaseDate() {
		return releaseDate;
	}
	
	public void setReleaseDate(MizeDateTime releaseDate) {
		this.releaseDate = releaseDate;
	}	

	@Transient
	public ProductSource getProductSource() {
		return productSource;
	}


	public void setProductSource(ProductSource productSource) {
		this.productSource = productSource;
	}	

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.EAGER, mappedBy = "product",orphanRemoval= true)
	@Fetch(FetchMode.SUBSELECT)
	public List<ProductIntl> getProductIntl() {
		return productIntl;
	}

	public void setProductIntl(List<ProductIntl> productIntl) {
		this.productIntl = productIntl;
	}
	

	@Column(name="prod_name",nullable=true,length=200)
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="brand_id") 
	public Brand getBrand() {
		return brand;
	}


	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	
	@Transient
	@JsonSerialize(using=NumberValueSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	public Double getPrice() {
		return price;
	}

	@JsonDeserialize(using=DecimalValueDeserializer.class)	
	public void setPrice(Double price) {
		this.price = price;
	}

	@Transient
	public Set<ProductCategory> getCategory() {
		return category;
	}


	public void setCategory(Set<ProductCategory> category) {
		this.category = category;
	}

	@Column(name="upc",nullable=true,length=20)
	public String getUpc() {
		return upc;
	}


	public void setUpc(String upc) {
		this.upc = upc;
	}


	@Column(name="qr_code",nullable=true,length=100)
	public String getQrCode() {
		return qrCode;
	}


	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	
	@Transient
	public Double getMizeRating() {
		return mizeRating;
	}


	public void setMizeRating(Double mizeRating) {
		this.mizeRating = mizeRating;
	}


	@Transient
	public ProductDetails getProductDetails() {
		return productDetails;
	}


	public void setProductDetails(ProductDetails productDetails) {
		this.productDetails = productDetails;
	}

	@Column(name="prod_image",nullable=true,length=500)
	public String getImageLink() {
		return imageLink;
	}


	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	
	@Override
	public void setCreatedByUser(String createdByUser){
	      this.createdByUser=createdByUser;
	}
	
	@Override
	@Column(name = "created_by_user" , updatable=false)
	public String getCreatedByUser(){
		 return createdByUser;
		 
	}
	
	@Override
	@Column(name = "updated_by_user")
	public String getUpdatedByUser() {
		return updatedByUser;
	}
    

	@Override
	public void setUpdatedByUser(String updatedByUser) {
		this.updatedByUser = updatedByUser;
	}
	
	

	@Transient
	public List<String> getListNames() {
		return listNames;
	}


	public void setListNames(List<String> listNames) {
		this.listNames = listNames;
	}


	@Column(name="model",nullable=true,length=50)
	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}

	@Column(name="prod_desc",nullable=true,length=500)
	public String getShortDescription() {
		return shortDescription;
	}


	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}


	@Transient
	public String getProductLink() {
		return productLink;
	}


	public void setProductLink(String productLink) {
		this.productLink = productLink;
	}	
	
	
	@Transient
	public List<ProductRegister> getProductRegisters() {
		return productRegisters;
	}

	@Transient
	public void setProductRegisters(List<ProductRegister> productRegisters) {
		this.productRegisters = productRegisters;
	}
	
	@Column(name="is_active",nullable=true,length=1)
	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	@Transient
	@JsonIgnore
	public boolean isAmazonSource(){
		boolean flag = false;
		if(Formatter.longValue(getProductSource().getSourceId()) == Source.AMAZON.getValue()){
			flag = true;
		}
		return flag;
	}
	
	@Column(name="mfg_part_no",nullable=true,length=70)
	public String getMpn() {
		return mpn;
	}

	public void setMpn(String mpn) {
		this.mpn = mpn;
	}

	@Transient
	@JsonIgnore
	public boolean isMizeSource(){
		return (!isAmazonSource());
	}

	@Transient
	public String getHasProdContent() {
		return hasProdContent;
	}

	public void setHasProdContent(String hasProdContent) {
		this.hasProdContent = hasProdContent;
	}

	@Transient
	public String getIsConsumable() {
		return isConsumable;
	}

	public void setIsConsumable(String isConsumable) {
		this.isConsumable = isConsumable;
	}

	@Transient
	public String getIsAccessory() {
		return isAccessory;
	}

	public void setIsAccessory(String isAccessory) {
		this.isAccessory = isAccessory;
	}
	
	@JsonIgnore
	@Transient
	public static Long getValidSourceId(Long sourceId){
		for(Source source : Source.values()){
			if(Formatter.longValue(sourceId) == source.getValue()){
				return sourceId;
			}
		}
		return Long.valueOf(Source.ETILIZE.getValue());
	}
	
	@Transient
	public List<ProductCategory> getCategories() {
		return categories;
	}
	
	public void setCategories(List<ProductCategory> categories) {
		this.categories = categories;
	}
	
	@Transient
	@JsonIgnore
	public ProductCategory getProductCategory() {
		return productCategory;
	}
	
	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (hasProdContent == null) {
			if (other.hasProdContent != null)
				return false;
		} else if (!hasProdContent.equals(other.hasProdContent))
			return false;
		if (imageLink == null) {
			if (other.imageLink != null)
				return false;
		} else if (!imageLink.equals(other.imageLink))
			return false;
		if (isAccessory == null) {
			if (other.isAccessory != null)
				return false;
		} else if (!isAccessory.equals(other.isAccessory))
			return false;
		if (isConsumable == null) {
			if (other.isConsumable != null)
				return false;
		} else if (!isConsumable.equals(other.isConsumable))
			return false;
		if (mizeRating == null) {
			if (other.mizeRating != null)
				return false;
		} else if (!mizeRating.equals(other.mizeRating))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (mpn == null) {
			if (other.mpn != null)
				return false;
		} else if (!mpn.equals(other.mpn))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (prodScore == null) {
			if (other.prodScore != null)
				return false;
		} else if (!prodScore.equals(other.prodScore))
			return false;
		if (productLink == null) {
			if (other.productLink != null)
				return false;
		} else if (!productLink.equals(other.productLink))
			return false;
		if (qrCode == null) {
			if (other.qrCode != null)
				return false;
		} else if (!qrCode.equals(other.qrCode))
			return false;
		if (releaseDate == null) {
			if (other.releaseDate != null)
				return false;
		} else if (!releaseDate.equals(other.releaseDate))
			return false;
		if (shortDescription == null) {
			if (other.shortDescription != null)
				return false;
		} else if (!shortDescription.equals(other.shortDescription))
			return false;
		if (upc == null) {
			if (other.upc != null)
				return false;
		} else if (!upc.equals(other.upc))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Column(name="user_id",nullable=true,length=20)
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Transient
	public Integer getProdScore() {
		return prodScore;
	}

	public void setProdScore(Integer prodScore) {
		this.prodScore = prodScore;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="tenant_id") 
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public BusinessEntity getTenant() {
		return tenant;
	}

	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="manufacturer_be_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public BusinessEntity getManufacturerBE() {
		return manufacturerBE;
	}

	public void setManufacturerBE(BusinessEntity manufacturerBE) {
		this.manufacturerBE = manufacturerBE;
	}
	
	@Transient
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int compareTo(Product o) {	
		return 0;
	}
	
	@Override	
	@Type(type="com.mize.domain.util.MizeDateTimeJPA")
	@Column(name = "created_date",updatable=false)
	@JsonIgnore(false)
	public MizeDateTime getCreatedDate() {
		return createdDate;
	}

	@Override	
	@Type(type="com.mize.domain.util.MizeDateTimeJPA")
	@Column(name = "updated_date")
	@JsonIgnore(false)
	public MizeDateTime getUpdatedDate() {
		return updatedDate;
	}

	@Override
	@JsonIgnore
	@Column(name = "created_by",updatable=false)
	public Long getCreatedBy() {		
		return super.getCreatedBy();
	}

	@Override
	@JsonIgnore
	@Column(name = "updated_by")
	public Long getUpdatedBy() {		
		return super.getUpdatedBy();
	}

	
	@Override
	@JsonIgnore(false)
	public void setCreatedDate(MizeDateTime createdDate) {
		super.createdDate = createdDate;
	}

	@Override
	@JsonIgnore(false)
	public void setUpdatedDate(MizeDateTime updatedDate) {
		super.updatedDate = updatedDate;
	}

	@Override
	@JsonIgnore
	public void setCreatedBy(Long createdBy) {		
		super.setCreatedBy(createdBy);
	}

	@Override
	@JsonIgnore
	public void setUpdatedBy(Long updatedBy) {		
		super.setUpdatedBy(updatedBy);
	}

	@PrePersist
	@PreUpdate
	public void auditFields(){
		if(createdDate==null && id==null){
			setCreatedDate(MizeDateTime.now());
		}
		setUpdatedDate(MizeDateTime.now());		
	}

	@Override
	public String toString() {
		return "Product [id" + id + ", name=" + name + ", brand=" + brand + ", price=" + price + ", category=" + category
				+ ", shortDescription=" + shortDescription + ", upc=" + upc + ", qrCode=" + qrCode + ", productSource="
				+ productSource + ", mizeRating=" + mizeRating + ", imageLink=" + imageLink + ", listNames="
				+ listNames + ", productDetails=" + productDetails + ", model=" + model + ", productLink="
				+ productLink + ", productRegisters=" + productRegisters + ", hasProdContent=" + hasProdContent
				+ ", isConsumable=" + isConsumable + ", isAccessory=" + isAccessory + ", mpn=" + mpn + ", releaseDate="
				+ releaseDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result
				+ ((hasProdContent == null) ? 0 : hasProdContent.hashCode());
		result = prime * result
				+ ((imageLink == null) ? 0 : imageLink.hashCode());
		result = prime * result
				+ ((isAccessory == null) ? 0 : isAccessory.hashCode());
		result = prime * result
				+ ((isConsumable == null) ? 0 : isConsumable.hashCode());
		result = prime * result
				+ ((mizeRating == null) ? 0 : mizeRating.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((mpn == null) ? 0 : mpn.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result
				+ ((prodScore == null) ? 0 : prodScore.hashCode());
		result = prime * result
				+ ((productLink == null) ? 0 : productLink.hashCode());
		result = prime * result + ((qrCode == null) ? 0 : qrCode.hashCode());
		result = prime * result
				+ ((releaseDate == null) ? 0 : releaseDate.hashCode());
		result = prime
				* result
				+ ((shortDescription == null) ? 0 : shortDescription.hashCode());
		result = prime * result + ((upc == null) ? 0 : upc.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}
	
}
