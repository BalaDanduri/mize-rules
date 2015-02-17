package com.mize.domain.assets;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.JPASerializer;

@Entity
@Table(name="mize_asset")
public class MizeAsset extends MizeSceEntity implements Comparable<MizeAsset>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7021114271237812539L;
	
	private BusinessEntity tenant;
	private String name;
	@Transient
	private String brand;
	@Transient
	private String model;
	@Transient
	private String category;
	private String type;
	private String contentType;
	private String storageType;
	private String filePath;

	public static final String DYNAMIC_FIELD_PREFIX = "s_";
	public static final String STORAGE_TYPE_S3 = "S3";
	public static final String STORAGE_TYPE_FILE = "FILE";
	
	private Long id;
	
	@Transient
	private User user;

	@Transient
	private String baseAccessURL;

	@Transient
	private String downloadURL;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	@Override
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tenant_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	public BusinessEntity getTenant() {
		return tenant;
	}

	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}

	@Column (name = "type")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column (name = "content_type")
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	@Column (name = "storage_type")
	public String getStorageType() {
		return storageType;
	}
	public void setStorageType(String storageType) {
		this.storageType = storageType;
	}
	
	@Column (name = "file_path")
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	@Transient
	public User getUser() {
		return user;
	}
	
	@Transient
	public void setUser(User user) {
		this.user = user;
	}
	@Transient
	public String getBrand() {
		return brand;
	}
	@Transient
	public void setBrand(String brand) {
		this.brand = brand;
	}
	@Transient
	public String getModel() {
		return model;
	}
	@Transient
	public void setModel(String model) {
		this.model = model;
	}
	@Transient
	public String getCategory() {
		return category;
	}
	@Transient
	public void setCategory(String category) {
		this.category = category;
	}
		
	@Transient
	public String getBaseAccessURL() {
		return baseAccessURL;
	}
	
	@Transient
	public void setBaseAccessURL(String baseAccessURL) {
		this.baseAccessURL = baseAccessURL;
	}
	
	@Transient
	public String getDownloadURL() {
		return downloadURL;
	}
	
	@Transient
	public void setDownloadURL(String downloadURL) {
		this.downloadURL = downloadURL;
	}
	
	@Override
	public int compareTo(MizeAsset asset) {
		if ( this == asset ) 
			return EQUAL;
		else if (this.id < asset.id) 
			return BEFORE;
		else if (asset.id == this.id) 
			return EQUAL;
		else if (this.id > asset.id)
			return AFTER;
		return EQUAL;
	}

}
