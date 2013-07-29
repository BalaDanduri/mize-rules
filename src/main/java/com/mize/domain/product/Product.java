package com.mize.domain.product;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hibernate.annotations.GenericGenerator;

import com.mize.domain.brand.Brand;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.DecimalValueDeserializer;
import com.mize.domain.util.Formatter;
import com.mize.domain.util.NumberValueSerializer;

@javax.persistence.Entity
@Table(name = "prod")
public class Product  extends MizeEntity implements Comparable<Product>{
	
	private static final long serialVersionUID = 5379538452565383073L;
	protected String name;
	@Transient
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
	
	
	public enum Source{
		MIZE(1),AMAZON(2),ETILIZE(3),BestBuy(4);
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
		productSource = new ProductSource();
		productDetails = new ProductDetails();
	}

/*	@OneToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="")*/
	public ProductSource getProductSource() {
		return productSource;
	}


	public void setProductSource(ProductSource productSource) {
		this.productSource = productSource;
	}

	@Id
	@GenericGenerator(name="prod_id",strategy="increment")
	@GeneratedValue
	@Column(name="prod_id",unique=true,nullable=false,length=20)
	@Override
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	@Column(name="prod_name",nullable=true,length=200)
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	@Transient
	public Brand getBrand() {
		return brand;
	}


	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	
	@Transient
	@JsonSerialize(using=NumberValueSerializer.class)
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


	@Transient
	public List<String> getListNames() {
		return listNames;
	}


	public void setListNames(List<String> listNames) {
		this.listNames = listNames;
	}


	@Transient
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
	
	
	@OneToMany(fetch = FetchType.EAGER, cascade =CascadeType.ALL)
	@JoinColumn(name="prod_regn_id") 
	public List<ProductRegister> getProductRegisters() {
		return productRegisters;
	}

	public void setProductRegisters(List<ProductRegister> productRegisters) {
		this.productRegisters = productRegisters;
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
	
	@Transient
	@JsonIgnore
	public boolean isMizeSource(){
		return (!isAmazonSource());
	}

	@Override
	public int compareTo(Product o) {	
		return 0;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", brand=" + brand + ", price="
				+ price + ", category=" + category + ", shortDescription="
				+ shortDescription + ", upc=" + upc + ", qrCode=" + qrCode
				+ ", productSource=" + productSource + ", mizeRating="
				+ mizeRating + ", imageLink=" + imageLink + ", listNames="
				+ listNames + ", productDetails=" + productDetails + ", model="
				+ model + ", productLink=" + productLink + "]";
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result
				+ ((imageLink == null) ? 0 : imageLink.hashCode());
		result = prime * result
				+ ((listNames == null) ? 0 : listNames.hashCode());
		result = prime * result
				+ ((mizeRating == null) ? 0 : mizeRating.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result
				+ ((productDetails == null) ? 0 : productDetails.hashCode());
		result = prime * result
				+ ((productLink == null) ? 0 : productLink.hashCode());
		result = prime * result
				+ ((productSource == null) ? 0 : productSource.hashCode());
		result = prime * result + ((qrCode == null) ? 0 : qrCode.hashCode());
		result = prime
				* result
				+ ((shortDescription == null) ? 0 : shortDescription.hashCode());
		result = prime * result + ((upc == null) ? 0 : upc.hashCode());
		return result;
	}
	

}
