package com.mize.domain.catalog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.MizeEntity;

public class CatalogEntity extends MizeEntity implements Serializable{
	
	private static final long serialVersionUID = -8481137770262609141L;	

	private List<CatalogEntryCache> catalogEntryCaches = new ArrayList<CatalogEntryCache>();
	private List<Catalog> catalogNames = new ArrayList<Catalog>();	
	private BusinessEntity tenant;
	private User user;
	
	public List<CatalogEntryCache> getCatalogEntryCaches() {
		return catalogEntryCaches;
	}
	public void setCatalogEntryCaches(List<CatalogEntryCache> catalogEntryCaches) {
		this.catalogEntryCaches = catalogEntryCaches;
	}
	@Override
	public Long getId() {
		return id;
	}
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	public List<Catalog> getCatalogNames() {
		return catalogNames;
	}
	public void setCatalogNames(List<Catalog> catalogNames) {
		this.catalogNames = catalogNames;
	}
	public BusinessEntity getTenant() {
		return tenant;
	}
	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
	

