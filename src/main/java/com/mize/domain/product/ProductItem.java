package com.mize.domain.product;

import com.mize.domain.common.Entity;

public class ProductItem extends Entity{
	private static final long serialVersionUID = -7554073627351568158L;
	protected String title;
	protected String description;
	protected String listingType;
	protected String currency;
	protected Double startPrice;
	protected String listingDuration;
	protected String location;
	protected String country;
	protected Integer quantity;
	protected Integer conditionID;
	protected Integer dispatchTimeMax;
	protected String payPalEmailAddress;
	protected String postalCode;
	protected String site;
	protected String returnsAcceptedOption;
	protected String refundOption;
	protected String returnsWithinOption;
	protected String returnsDescription;
	protected String paymentMethods;
	protected String categoryId;
	protected Double shippingServiceCost;
	protected Double shippingServiceAdditionalCost;
	protected Integer shippingServicePriority;

	protected ProductDefaultOptions productDefaultOptions;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getListingType() {
		return listingType;
	}

	public void setListingType(String listingType) {
		this.listingType = listingType;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getStartPrice() {
		return startPrice;
	}

	public void setStartPrice(Double startPrice) {
		this.startPrice = startPrice;
	}

	public String getListingDuration() {
		return listingDuration;
	}

	public void setListingDuration(String listingDuration) {
		this.listingDuration = listingDuration;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getConditionID() {
		return conditionID;
	}

	public void setConditionID(Integer conditionID) {
		this.conditionID = conditionID;
	}

	public Integer getDispatchTimeMax() {
		return dispatchTimeMax;
	}

	public void setDispatchTimeMax(Integer dispatchTimeMax) {
		this.dispatchTimeMax = dispatchTimeMax;
	}

	public String getPayPalEmailAddress() {
		return payPalEmailAddress;
	}

	public void setPayPalEmailAddress(String payPalEmailAddress) {
		this.payPalEmailAddress = payPalEmailAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getReturnsAcceptedOption() {
		return returnsAcceptedOption;
	}

	public void setReturnsAcceptedOption(String returnsAcceptedOption) {
		this.returnsAcceptedOption = returnsAcceptedOption;
	}

	public String getRefundOption() {
		return refundOption;
	}

	public void setRefundOption(String refundOption) {
		this.refundOption = refundOption;
	}

	public String getReturnsWithinOption() {
		return returnsWithinOption;
	}

	public void setReturnsWithinOption(String returnsWithinOption) {
		this.returnsWithinOption = returnsWithinOption;
	}

	public String getReturnsDescription() {
		return returnsDescription;
	}

	public void setReturnsDescription(String returnsDescription) {
		this.returnsDescription = returnsDescription;
	}

	public String getPaymentMethods() {
		return paymentMethods;
	}

	public void setPaymentMethods(String paymentMethods) {
		this.paymentMethods = paymentMethods;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public Double getShippingServiceCost() {
		return shippingServiceCost;
	}

	public void setShippingServiceCost(Double shippingServiceCost) {
		this.shippingServiceCost = shippingServiceCost;
	}

	public Double getShippingServiceAdditionalCost() {
		return shippingServiceAdditionalCost;
	}

	public void setShippingServiceAdditionalCost(Double shippingServiceAdditionalCost) {
		this.shippingServiceAdditionalCost = shippingServiceAdditionalCost;
	}

	public Integer getShippingServicePriority() {
		return shippingServicePriority;
	}

	public void setShippingServicePriority(Integer shippingServicePriority) {
		this.shippingServicePriority = shippingServicePriority;
	}

	public ProductDefaultOptions getProductDefaultOptions() {
		return productDefaultOptions;
	}

	public void setProductDefaultOptions(ProductDefaultOptions productDefaultOptions) {
		this.productDefaultOptions = productDefaultOptions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryId == null) ? 0 : categoryId.hashCode());
		result = prime * result + ((conditionID == null) ? 0 : conditionID.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((dispatchTimeMax == null) ? 0 : dispatchTimeMax.hashCode());
		result = prime * result + ((listingDuration == null) ? 0 : listingDuration.hashCode());
		result = prime * result + ((listingType == null) ? 0 : listingType.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((payPalEmailAddress == null) ? 0 : payPalEmailAddress.hashCode());
		result = prime * result + ((paymentMethods == null) ? 0 : paymentMethods.hashCode());
		result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
		result = prime * result + ((productDefaultOptions == null) ? 0 : productDefaultOptions.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((refundOption == null) ? 0 : refundOption.hashCode());
		result = prime * result + ((returnsAcceptedOption == null) ? 0 : returnsAcceptedOption.hashCode());
		result = prime * result + ((returnsDescription == null) ? 0 : returnsDescription.hashCode());
		result = prime * result + ((returnsWithinOption == null) ? 0 : returnsWithinOption.hashCode());
		result = prime * result
				+ ((shippingServiceAdditionalCost == null) ? 0 : shippingServiceAdditionalCost.hashCode());
		result = prime * result + ((shippingServiceCost == null) ? 0 : shippingServiceCost.hashCode());
		result = prime * result + ((shippingServicePriority == null) ? 0 : shippingServicePriority.hashCode());
		result = prime * result + ((site == null) ? 0 : site.hashCode());
		result = prime * result + ((startPrice == null) ? 0 : startPrice.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		ProductItem other = (ProductItem) obj;
		if (categoryId == null) {
			if (other.categoryId != null)
				return false;
		} else if (!categoryId.equals(other.categoryId))
			return false;
		if (conditionID == null) {
			if (other.conditionID != null)
				return false;
		} else if (!conditionID.equals(other.conditionID))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (dispatchTimeMax == null) {
			if (other.dispatchTimeMax != null)
				return false;
		} else if (!dispatchTimeMax.equals(other.dispatchTimeMax))
			return false;
		if (listingDuration == null) {
			if (other.listingDuration != null)
				return false;
		} else if (!listingDuration.equals(other.listingDuration))
			return false;
		if (listingType == null) {
			if (other.listingType != null)
				return false;
		} else if (!listingType.equals(other.listingType))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (payPalEmailAddress == null) {
			if (other.payPalEmailAddress != null)
				return false;
		} else if (!payPalEmailAddress.equals(other.payPalEmailAddress))
			return false;
		if (paymentMethods == null) {
			if (other.paymentMethods != null)
				return false;
		} else if (!paymentMethods.equals(other.paymentMethods))
			return false;
		if (postalCode == null) {
			if (other.postalCode != null)
				return false;
		} else if (!postalCode.equals(other.postalCode))
			return false;
		if (productDefaultOptions == null) {
			if (other.productDefaultOptions != null)
				return false;
		} else if (!productDefaultOptions.equals(other.productDefaultOptions))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (refundOption == null) {
			if (other.refundOption != null)
				return false;
		} else if (!refundOption.equals(other.refundOption))
			return false;
		if (returnsAcceptedOption == null) {
			if (other.returnsAcceptedOption != null)
				return false;
		} else if (!returnsAcceptedOption.equals(other.returnsAcceptedOption))
			return false;
		if (returnsDescription == null) {
			if (other.returnsDescription != null)
				return false;
		} else if (!returnsDescription.equals(other.returnsDescription))
			return false;
		if (returnsWithinOption == null) {
			if (other.returnsWithinOption != null)
				return false;
		} else if (!returnsWithinOption.equals(other.returnsWithinOption))
			return false;
		if (shippingServiceAdditionalCost == null) {
			if (other.shippingServiceAdditionalCost != null)
				return false;
		} else if (!shippingServiceAdditionalCost.equals(other.shippingServiceAdditionalCost))
			return false;
		if (shippingServiceCost == null) {
			if (other.shippingServiceCost != null)
				return false;
		} else if (!shippingServiceCost.equals(other.shippingServiceCost))
			return false;
		if (shippingServicePriority == null) {
			if (other.shippingServicePriority != null)
				return false;
		} else if (!shippingServicePriority.equals(other.shippingServicePriority))
			return false;
		if (site == null) {
			if (other.site != null)
				return false;
		} else if (!site.equals(other.site))
			return false;
		if (startPrice == null) {
			if (other.startPrice != null)
				return false;
		} else if (!startPrice.equals(other.startPrice))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductItem [title=" + title + ", description=" + description + ", listingType=" + listingType
				+ ", currency=" + currency + ", startPrice=" + startPrice + ", listingDuration=" + listingDuration
				+ ", location=" + location + ", country=" + country + ", quantity=" + quantity + ", conditionID="
				+ conditionID + ", dispatchTimeMax=" + dispatchTimeMax + ", payPalEmailAddress=" + payPalEmailAddress
				+ ", postalCode=" + postalCode + ", site=" + site + ", returnsAcceptedOption=" + returnsAcceptedOption
				+ ", refundOption=" + refundOption + ", returnsWithinOption=" + returnsWithinOption
				+ ", returnsDescription=" + returnsDescription + ", paymentMethods=" + paymentMethods + ", categoryId="
				+ categoryId + ", shippingServiceCost=" + shippingServiceCost + ", shippingServiceAdditionalCost="
				+ shippingServiceAdditionalCost + ", shippingServicePriority=" + shippingServicePriority
				+ ", productDefaultOptions=" + productDefaultOptions + "]";
	}

}
