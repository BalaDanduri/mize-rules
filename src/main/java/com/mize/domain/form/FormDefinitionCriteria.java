package com.mize.domain.form;

import org.joda.time.DateTime;

import com.mize.domain.auth.User;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.product.Product;

public class FormDefinitionCriteria extends MizeEntity {

	
	private static final long serialVersionUID = 478530840631021065L;
	
	private String inspectionType;
	private Product product;
	private DateTime inspectionDate;
	private User user;
	
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id =id;
	}

	public String getInspectionType() {
		return inspectionType;
	}

	public void setInspectionType(String inspectionType) {
		this.inspectionType = inspectionType;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public DateTime getInspectionDate() {
		return inspectionDate;
	}

	public void setInspectionDate(DateTime inspectionDate) {
		this.inspectionDate = inspectionDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "FormDefinitionCriteria [inspectionType=" + inspectionType
				+ ", product=" + product + ", inspectionDate=" + inspectionDate
				+ ", user=" + user + "]";
	}
	
	
	

}
