package com.mize.domain.form.link;

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
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.annotate.JsonBackReference;

import com.mize.domain.common.MizeEntity;
import com.mize.domain.product.Product;

@Entity
@Table(name = "form_defn_link_data", uniqueConstraints = {@UniqueConstraint (columnNames = {"id"})})
public class FormDefinitionLinkData extends MizeEntity {
	
	private static final long serialVersionUID = -2232145881370573178L;
	
	private FormDefinitionLink formDefinitionLink;
	private Product product;
	private String linkType;
	private String linkDuration;
	
	public FormDefinitionLinkData() {
		super();
	}
	
	public FormDefinitionLinkData(FormDefinitionLink formDefinitionLink, String linkType, String linkDuration, Product product) {
		super();
		this.formDefinitionLink = formDefinitionLink;
		this.product = product;
		this.linkType = linkType;
		this.linkDuration = linkDuration;		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false, length = 20)
	@Override
	public Long getId() {
		return super.id;
	}

	@Override
	public void setId(Long id) {
		super.id=id;
	}
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "form_defn_link_id", nullable = false)
	@JsonBackReference(value="form_defn_link")
	public FormDefinitionLink getFormDefinitionLink() {
		return formDefinitionLink;
	}
	
	public void setFormDefinitionLink(FormDefinitionLink formDefinitionLink) {
		this.formDefinitionLink = formDefinitionLink;
	}
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="prod_id", nullable = true)
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	@Column( name = "link_type", nullable = true, length = 50)
	public String getLinkType() {
		return linkType;
	}

	public void setLinkType(String linkType) {
		this.linkType = linkType;
	}
	
	@Column( name = "link_duration", nullable = true, length = 50)
	public String getLinkDuration() {
		return linkDuration;
	}

	public void setLinkDuration(String linkDuration) {
		this.linkDuration = linkDuration;
	}	

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();		
		result = prime * result
				+ ((linkDuration == null) ? 0 : linkDuration.hashCode());
		result = prime * result
				+ ((linkType == null) ? 0 : linkType.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
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
		FormDefinitionLinkData other = (FormDefinitionLinkData) obj;
		if (linkDuration == null) {
			if (other.linkDuration != null)
				return false;
		} else if (!linkDuration.equals(other.linkDuration))
			return false;
		if (linkType == null) {
			if (other.linkType != null)
				return false;
		} else if (!linkType.equals(other.linkType))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FormDefinitionLinkData [product=" + product + ", linkType="
				+ linkType + ", linkDuration=" + linkDuration + "]";
	}	
	
}
