package com.mize.domain.product;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.auth.User;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JodaDateDeserializer;
import com.mize.domain.util.JsonDateSerializer;

public class ProductRegister extends MizeEntity{

	private static final long serialVersionUID = -6338652951554117142L;
	
	private Product product;
	private User user = new User();;
	private String serialNumber;
	
	@DateTimeFormat (pattern="dd-MM-yyyy")
	private DateTime purchaseDate;
	private Double purchasePrice;
	private String purchaseStore;
	@DateTimeFormat (pattern="dd-MM-yyyy")
	private DateTime warrantyExpiryDate;
	private String additionalInfo;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy")
	@JsonSerialize(using=JsonDateSerializer.class)
	public DateTime getPurchaseDate() {
		return purchaseDate;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy")
	@JsonDeserialize(using=JodaDateDeserializer.class)
	public void setPurchaseDate(DateTime purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public Double getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public String getPurchaseStore() {
		return purchaseStore;
	}
	public void setPurchaseStore(String purchaseStore) {
		this.purchaseStore = purchaseStore;
	}
	@DateTimeFormat (pattern="MM-dd-yyyy")
	@JsonSerialize(using=JsonDateSerializer.class)
	public DateTime getWarrantyExpiryDate() {
		return warrantyExpiryDate;
	}
	@DateTimeFormat (pattern="MM-dd-yyyy")
	@JsonDeserialize(using=JodaDateDeserializer.class)
	public void setWarrantyExpiryDate(DateTime warrantyExpiryDate) {
		this.warrantyExpiryDate = warrantyExpiryDate;
	}
	public String getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	
	@Override
	public String toString() {
		return "ProductRegister [product=" + product + ", user=" + user + ", serialNumber=" + serialNumber + ", purchaseDate=" + purchaseDate
				+ ", purchasePrice=" + purchasePrice + ", purchaseStore=" + purchaseStore + ", warrantyExpiryDate=" + warrantyExpiryDate + ", additionalInfo="
				+ additionalInfo + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate
				+ ", id=" + id + "]";
	}
	
	@Override
	public Long getId() {
		return id;
	}
	@Override
	public void setId(Long id) {
		super.id = id;
		
	}
	
	
	
}
