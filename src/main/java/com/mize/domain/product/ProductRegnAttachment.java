package com.mize.domain.product;

import java.net.URL;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.mize.domain.common.MizeEntity;

@Entity
@Table(name = "prod_regn_attach")
public class ProductRegnAttachment extends MizeEntity{
	private static final long serialVersionUID = -6722341511569003526L;	
	
	private String name;
	@Transient
	private URL url;
	private String type;
	
	@Transient
	private Long prodRegnId;
	
	private ProductRegister productRegister;
	
	@ManyToOne(targetEntity = ProductRegister.class,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "prod_regn_id", nullable = true)
	public ProductRegister getProductRegister() {
		return productRegister;
	}
	public void setProductRegister(ProductRegister productRegister) {
		this.productRegister = productRegister;
	}
	
	@Transient
	public Long getProdRegnId() {
		return prodRegnId;
	}
	public void setProdRegnId(Long prodId) {
		this.prodRegnId = prodId;
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
	
	@Transient
	public URL getUrl() {
		return url;
	}
	public void setUrl(URL url) {
		this.url = url;
	}
	
	@Column(name="type",nullable=false,length=50)
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Column(name="name",nullable=false,length=250)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "ProductAttachment [id=" + id + ", name=" + name + ", url=" + url + ", type=" + type + ", prodRegnId="
				+ prodRegnId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ProductRegnAttachment other = (ProductRegnAttachment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
