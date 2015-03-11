package com.mize.domain.product;

import java.util.ArrayList;
import java.util.List;

import com.mize.domain.auth.User;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.datetime.DateTime;

public class UserProduct extends MizeSceEntity implements Comparable<UserProduct>{

	private static final long serialVersionUID = -5270305444916049503L;
	protected Long id;
	protected User user = new User();
	protected Product product;
	protected String listName;
	protected String active;
	protected UserProductFeedback productFeedback;
	protected int pageIndex;
	private List<Long> prodRegnIds = new ArrayList<Long>(); 
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
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public DateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	public DateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(DateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public List<Long> getProdRegnIds() {
		return prodRegnIds;
	}

	public void setProdRegnIds(List<Long> prodRegnIds) {
		this.prodRegnIds = prodRegnIds;
	}

	@Override
	public int compareTo(UserProduct o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
