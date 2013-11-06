package com.mize.domain.sce.be;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mize.domain.common.Locale;
import com.mize.domain.common.MizeEntity;

@Entity
@Table(name="business_entity_intl")
public class BusinessEntityIntl extends MizeEntity {

	private static final long serialVersionUID = -1362236702129137109L;
	private BusinessEntity businessEntity;
	private String beName;
	private String beDescription;
	private Locale locale;	
	
	public BusinessEntityIntl() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "be_id")
	public BusinessEntity getBusinessEntity() {
		return businessEntity;
	}
	
	@Column(name = "be_name", nullable = true, length = 250)
	public String getBeName() {
		return beName;
	}

	@Column(name = "be_description", nullable = true, length = 500)
	public String getBeDescription() {
		return beDescription;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "locale_id")
	public Locale getLocale() {
		return locale;
	}

	public void setBusinessEntity(BusinessEntity businessEntity) {
		this.businessEntity = businessEntity;
	}

	public void setBeName(String beName) {
		this.beName = beName;
	}

	public void setBeDescription(String beDescription) {
		this.beDescription = beDescription;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	
}
