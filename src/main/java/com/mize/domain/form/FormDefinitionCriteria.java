package com.mize.domain.form;

import com.mize.domain.auth.User;
import com.mize.domain.common.Locale;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.datetime.Date;
import com.mize.domain.product.Product;

public class FormDefinitionCriteria extends MizeSceEntity implements Comparable<FormDefinitionCriteria> {

	
	private static final long serialVersionUID = 478530840631021065L;
	
	private String inspectionType;
	private Product product;
	private Date inspectionDate;
	private User user;
	private Locale locale;
	
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

	public Date getInspectionDate() {
		return inspectionDate;
	}

	public void setInspectionDate(Date inspectionDate) {
		this.inspectionDate = inspectionDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	
	

	@Override
	public String toString() {
		return "FormDefinitionCriteria [inspectionType=" + inspectionType
				+ ", product=" + product + ", inspectionDate=" + inspectionDate + "]";
	}

	@Override
	public int compareTo(FormDefinitionCriteria o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	

}
