package com.mize.domain.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.mize.domain.brand.Brand;
import com.mize.domain.common.MizeEntity;


@Entity
@Table(name = "device_list")
public class DeviceList extends MizeEntity implements Comparable<DeviceList>{

	private static final long serialVersionUID = -3440812506217447673L;
	private Brand brand;
	private String device;
	private String name;
	private String model;
	private Integer memory;
	private String color;
	private String carrier;
	private Long prodSourceId;
	private String prodToSourceId;
	private Long prodId;
	private String prodImage;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "brand_id", nullable = true)
	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@Column(name = "device",  nullable = true, length = 100)
	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	@Column(name = "name",  nullable = true, length = 200)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "model",  nullable = true, length = 50)
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	@Column(name = "memory",  nullable = true, length = 11)
	public Integer getMemory() {
		return memory;
	}

	public void setMemory(Integer memory) {
		this.memory = memory;
	}

	@Column(name = "color",  nullable = true, length = 20)
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Column(name = "carrier",  nullable = true, length = 50)
	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	@Column(name = "prod_source_id",  nullable = true, length = 11)
	public Long getProdSourceId() {
		return prodSourceId;
	}

	public void setProdSourceId(Long prodSourceId) {
		this.prodSourceId = prodSourceId;
	}

	@Column(name = "prod_to_source_id",  nullable = true, length = 50)
	public String getProdToSourceId() {
		return prodToSourceId;
	}

	public void setProdToSourceId(String prodToSourceId) {
		this.prodToSourceId = prodToSourceId;
	}

	@Column(name = "prod_id",  nullable = true, length = 20)
	public Long getProdId() {
		return prodId;
	}

	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}

	@Column(name = "prod_image",  nullable = true, length = 500)
	public String getProdImage() {
		return prodImage;
	}

	public void setProdImage(String prodImage) {
		this.prodImage = prodImage;
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
		super.id = id;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((carrier == null) ? 0 : carrier.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((device == null) ? 0 : device.hashCode());
		result = prime * result + ((memory == null) ? 0 : memory.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((prodId == null) ? 0 : prodId.hashCode());
		result = prime * result + ((prodImage == null) ? 0 : prodImage.hashCode());
		result = prime * result + ((prodSourceId == null) ? 0 : prodSourceId.hashCode());
		result = prime * result + ((prodToSourceId == null) ? 0 : prodToSourceId.hashCode());
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
		DeviceList other = (DeviceList) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (carrier == null) {
			if (other.carrier != null)
				return false;
		} else if (!carrier.equals(other.carrier))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (device == null) {
			if (other.device != null)
				return false;
		} else if (!device.equals(other.device))
			return false;
		if (memory == null) {
			if (other.memory != null)
				return false;
		} else if (!memory.equals(other.memory))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (prodId == null) {
			if (other.prodId != null)
				return false;
		} else if (!prodId.equals(other.prodId))
			return false;
		if (prodImage == null) {
			if (other.prodImage != null)
				return false;
		} else if (!prodImage.equals(other.prodImage))
			return false;
		if (prodSourceId == null) {
			if (other.prodSourceId != null)
				return false;
		} else if (!prodSourceId.equals(other.prodSourceId))
			return false;
		if (prodToSourceId == null) {
			if (other.prodToSourceId != null)
				return false;
		} else if (!prodToSourceId.equals(other.prodToSourceId))
			return false;
		return true;
	}
	
	

	@Override
	public String toString() {
		return "DeviceList [brand=" + brand + ", device=" + device + ", name=" + name + ", model=" + model
				+ ", memory=" + memory + ", color=" + color + ", carrier=" + carrier + ", prodSourceId=" + prodSourceId
				+ ", prodToSourceId=" + prodToSourceId + ", prodId=" + prodId + ", prodImage=" + prodImage + "]";
	}

	@Override
	public int compareTo(DeviceList arg0) {
		return 0;
	}
	

}
