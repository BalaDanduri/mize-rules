package com.mize.domain.shipping;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mize.domain.common.Country;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.common.State;

@Entity
@Table(name="shipment_item")
public class ShipmentItem extends MizeEntity implements Comparable<ShipmentItem> {
	private static final long serialVersionUID = -7073856017006485033L;
	private ShipmentTracking shipmentTracking;
	private String itemDescription;
	private String itemNumber;
	private Country country;
	private State state;
	private BigDecimal weight;
	private String weightUOM;	
	private BigDecimal quantity;
	private String quantityUOM;
	private BigDecimal unitPrice;
	private String tariffCode;	

	public ShipmentItem(){
		super();
	}	
	
	public ShipmentItem(String itemDescription, String itemNumber,
			Country country, State state, BigDecimal weight, String weightUOM,
			BigDecimal quantity, String quantityUOM, BigDecimal unitPrice,
			String tariffCode) {
		super();
		this.itemDescription = itemDescription;
		this.itemNumber = itemNumber;
		this.country = country;
		this.state = state;
		this.weight = weight;
		this.weightUOM = weightUOM;
		this.quantity = quantity;
		this.quantityUOM = quantityUOM;
		this.unitPrice = unitPrice;
		this.tariffCode = tariffCode;
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",unique=true,nullable=false)
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="shipment_tracking_id")
	@JsonBackReference(value="shipment_item")
	public ShipmentTracking getShipmentTracking() {
		return shipmentTracking;
	}

	public void setShipmentTracking(ShipmentTracking shipmentTracking) {
		this.shipmentTracking = shipmentTracking;
	}
	
	@Column(name="item_description")
	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	@Column(name="item_number")
	public String getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "country_id")
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "state_id")
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Column(name="item_weight")
	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	@Column(name="item_quantity")
	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	@Column(name="item_quantity_uom")
	public String getQuantityUOM() {
		return quantityUOM;
	}

	public void setQuantityUOM(String quantityUOM) {
		this.quantityUOM = quantityUOM;
	}

	@Column(name="item_unit_price")
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Column(name="tariff_code")
	public String getTariffCode() {
		return tariffCode;
	}

	public void setTariffCode(String tariffCode) {
		this.tariffCode = tariffCode;
	}

	@Column(name="item_weight_uom")
	public String getWeightUOM() {
		return weightUOM;
	}

	public void setWeightUOM(String weightUOM) {
		this.weightUOM = weightUOM;
	}

	@Override
	public int compareTo(ShipmentItem o) {
		return 0;
	}

	@Override
	public String toString() {
		return "ShipmentItem [itemDescription=" + itemDescription
				+ ", itemNumber=" + itemNumber + ", country=" + country
				+ ", state=" + state + ", weight=" + weight + ", weightUOM="
				+ weightUOM + ", quantity=" + quantity + ", quantityUOM="
				+ quantityUOM + ", unitPrice=" + unitPrice + ", tariffCode="
				+ tariffCode + "]";
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result
				+ ((itemDescription == null) ? 0 : itemDescription.hashCode());
		result = prime * result
				+ ((itemNumber == null) ? 0 : itemNumber.hashCode());
		result = prime * result
				+ ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result
				+ ((quantityUOM == null) ? 0 : quantityUOM.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result
				+ ((tariffCode == null) ? 0 : tariffCode.hashCode());
		result = prime * result
				+ ((unitPrice == null) ? 0 : unitPrice.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
		result = prime * result
				+ ((weightUOM == null) ? 0 : weightUOM.hashCode());
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
		ShipmentItem other = (ShipmentItem) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (itemDescription == null) {
			if (other.itemDescription != null)
				return false;
		} else if (!itemDescription.equals(other.itemDescription))
			return false;
		if (itemNumber == null) {
			if (other.itemNumber != null)
				return false;
		} else if (!itemNumber.equals(other.itemNumber))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (quantityUOM == null) {
			if (other.quantityUOM != null)
				return false;
		} else if (!quantityUOM.equals(other.quantityUOM))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (tariffCode == null) {
			if (other.tariffCode != null)
				return false;
		} else if (!tariffCode.equals(other.tariffCode))
			return false;
		if (unitPrice == null) {
			if (other.unitPrice != null)
				return false;
		} else if (!unitPrice.equals(other.unitPrice))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		if (weightUOM == null) {
			if (other.weightUOM != null)
				return false;
		} else if (!weightUOM.equals(other.weightUOM))
			return false;
		return true;
	}
	
}
