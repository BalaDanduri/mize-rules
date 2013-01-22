package com.mize.domain.product;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.auth.User;
import com.mize.domain.common.Entity;
import com.mize.domain.util.JodaDateDeserializer;
import com.mize.domain.util.JsonDateSerializer;

public class ProductRegister extends Entity{

	private static final long serialVersionUID = -6338652951554117142L;
	
	private Long productRegistrationId;
	private Product product;
	private User user = new User();;
	private String serialNumber;
	
	@DateTimeFormat (pattern="dd-MM-yyyy")
	private DateTime purchaseDate;
	private Double purchasePrice;
	private String purchaseStore;
	@DateTimeFormat (pattern="dd-MM-yyyy")
	private DateTime warrentyExpiryDate;
	private String additionalInfo;
	public Long getProductRegistrationId() {
		return productRegistrationId;
	}
	public void setProductRegistrationId(Long productRegistrationId) {
		this.productRegistrationId = productRegistrationId;
	}
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
	public DateTime getWarrentyExpiryDate() {
		return warrentyExpiryDate;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy")
	@JsonDeserialize(using=JodaDateDeserializer.class)
	public void setWarrentyExpiryDate(DateTime warrentyExpiryDate) {
		this.warrentyExpiryDate = warrentyExpiryDate;
	}
	public String getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((additionalInfo == null) ? 0 : additionalInfo.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((productRegistrationId == null) ? 0 : productRegistrationId.hashCode());
		result = prime * result + ((purchaseDate == null) ? 0 : purchaseDate.hashCode());
		result = prime * result + ((purchasePrice == null) ? 0 : purchasePrice.hashCode());
		result = prime * result + ((purchaseStore == null) ? 0 : purchaseStore.hashCode());
		result = prime * result + ((serialNumber == null) ? 0 : serialNumber.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((warrentyExpiryDate == null) ? 0 : warrentyExpiryDate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductRegister other = (ProductRegister) obj;
		if (additionalInfo == null) {
			if (other.additionalInfo != null)
				return false;
		} else if (!additionalInfo.equals(other.additionalInfo))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (productRegistrationId == null) {
			if (other.productRegistrationId != null)
				return false;
		} else if (!productRegistrationId.equals(other.productRegistrationId))
			return false;
		if (purchaseDate == null) {
			if (other.purchaseDate != null)
				return false;
		} else if (!purchaseDate.equals(other.purchaseDate))
			return false;
		if (purchasePrice == null) {
			if (other.purchasePrice != null)
				return false;
		} else if (!purchasePrice.equals(other.purchasePrice))
			return false;
		if (purchaseStore == null) {
			if (other.purchaseStore != null)
				return false;
		} else if (!purchaseStore.equals(other.purchaseStore))
			return false;
		if (serialNumber == null) {
			if (other.serialNumber != null)
				return false;
		} else if (!serialNumber.equals(other.serialNumber))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (warrentyExpiryDate == null) {
			if (other.warrentyExpiryDate != null)
				return false;
		} else if (!warrentyExpiryDate.equals(other.warrentyExpiryDate))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ProductRegister [productRegistrationId=" + productRegistrationId + ", product=" + product + ", user="
				+ user + ", serialNumber=" + serialNumber + ", purchaseDate=" + purchaseDate + ", purchasePrice="
				+ purchasePrice + ", purchaseStore=" + purchaseStore + ", warrentyExpiryDate=" + warrentyExpiryDate
				+ ", additionalInfo=" + additionalInfo + "]";
	}
	
	
}
