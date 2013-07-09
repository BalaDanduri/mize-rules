package com.mize.domain.product;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.auth.User;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

public class UserProduct extends MizeEntity{

	private static final long serialVersionUID = -5270305444916049503L;
	protected Long id;
	protected User User = new User();
	protected Product product;
	protected String listName;
	protected String active;
	protected UserProductFeedback productFeedback;
	protected int pageIndex;
	
	public enum Wownit{
		own,want,gift;
	}
	
	public static Wownit getWownit(String val){
		for(Wownit wownit : Wownit.values()){
			if(wownit.toString().equals(val)){
				return wownit;
			}			
		}
		return null;
	}
	
	public enum Status{
		Success("PRD_WOWN_001"),Failure("PRD_WOWN_002"),Already_Tagged("PRD_ALREADY_TAGGED_001");
		String val;
		Status(String v){
			val = v;
		}
		public String getValue(){
			return val;
		}
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public User getUser() {
		return User;
	}

	public void setUser(User user) {
		User = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public UserProductFeedback getProductFeedback() {
		return productFeedback;
	}

	public void setProductFeedback(UserProductFeedback productFeedback) {
		this.productFeedback = productFeedback;
	}
	public int getPageIndex() {
		if (pageIndex == 0) {
			pageIndex = 1;
		}
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	@Override
	public String toString() {
		return "Wownit [id=" + id + ", prodId=" + product
				+ ", productList=" + listName + "]";
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)	
	@JsonIgnore(value=false)
	public DateTime getCreatedDate() {
		return createdDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(value=false)
	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)	
	@JsonIgnore(value=false)
	public DateTime getUpdatedDate() {
		return updatedDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(value=false)
	public void setUpdatedDate(DateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
}
