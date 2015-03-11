package com.mize.domain.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.collection.internal.PersistentBag;
import org.hibernate.collection.internal.PersistentMap;
import org.hibernate.collection.internal.PersistentSet;
import org.hibernate.collection.spi.PersistentCollection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mize.domain.datetime.DateTime;
import com.mize.domain.exception.UploadError;

public abstract class MizeSceEntity implements IEntity {
	
	private static final long serialVersionUID = 4810418252575043078L;	
	public static final int EQUAL = 0;
	public static final int BEFORE = -1;
	public static final int AFTER = 1;
	public static final int PRIME = 31;	
	public static final int HASH_CODE_START = 17;
	protected UploadError uploadError;
	protected int uploadRecordNumber;
	@JsonIgnore
	protected Boolean isValid = Boolean.TRUE;
			
	protected Long createdBy;
	protected DateTime createdDate;	
	protected Long updatedBy;
	protected DateTime updatedDate;	
	protected Long id;
	
	protected String createdByUser;
	
	protected String updatedByUser;

	@JsonIgnore
	public static String STATUS = "status";
	
	public enum Result{
		TRUE,FALSE;
	}
	
	public abstract Long getId();

	public abstract void setId(Long id);

	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public DateTime getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	@JsonInclude(Include.NON_DEFAULT)
	public DateTime getUpdatedDate() {
		return updatedDate;
	}
	
	public void setUpdatedDate(DateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	@JsonIgnore
	public UploadError getUploadError() {
		return uploadError;
	}
	
	@JsonIgnore
	public void setUploadError(UploadError uploadError) {
		this.isValid = Boolean.FALSE;
		this.uploadError = uploadError;
	}
	
	@JsonIgnore
	public int getUploadRecordNumber() {
		return uploadRecordNumber;
	}

	@JsonIgnore
	public void setUploadRecordNumber(int uploadRecordNumber) {
		this.uploadRecordNumber = uploadRecordNumber;
	}

	public String getCreatedByUser() {
		return createdByUser;
	}

	public void setCreatedByUser(String createdByUser) {
		this.createdByUser = createdByUser;
	}

	
	public String getUpdatedByUser() {
		return updatedByUser;
	}

	public void setUpdatedByUser(String updatedByUser) {
		this.updatedByUser = updatedByUser;
	}

	
	@JsonIgnore
	public boolean isValid() {
		if(this.isValid == null){
			return true;
		}
		return this.isValid.booleanValue();
	}
	
	@Override
	public int hashCode() {
		int result = HASH_CODE_START;
		result = PRIME * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MizeSceEntity other = (MizeSceEntity) obj;		
		if (!isLongFieldsEquals(this.id, other.id)) {
			return false;
		}		
		return true;
	}
	
	public boolean isLongFieldsEquals(Long tHis, Long tHat) {
		if (tHis == null) {
			if (tHat != null) {
				return false;
			}
		} else if (!tHis.equals(tHat)) {
			return false;
		}
		return true;
	}
	
	@SuppressWarnings("rawtypes")
	public boolean isProxiesEquals(Object proxy1, Object proxy2){
		if(proxy1 == null && proxy2 == null){
			return true;
		}
		if(proxy1 != null && proxy2 == null){
			return false;
		}
		if(proxy1 == null && proxy2 != null){
			return false;
		}
		List list1 = toEntityList(proxy1);
		List list2 = toEntityList(proxy2);
		return list1.equals(list2);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List toEntityList(Object proxy){
		List list = new ArrayList();
		if(PersistentCollection.class.isAssignableFrom(proxy.getClass())) {
			PersistentCollection pcollection = (PersistentCollection) proxy;
			if (pcollection.wasInitialized()) {				
				if(PersistentMap.class.isAssignableFrom(proxy.getClass()))  {
					//need to handle Map data type ... ignoring for now
				}
				if(PersistentBag.class.isAssignableFrom(proxy.getClass()))  {
					Iterator iterator = ((PersistentBag)proxy).iterator();
					while(iterator.hasNext()){
						list.add(iterator.next());
					}
				}
				if(PersistentSet.class.isAssignableFrom(proxy.getClass()))  {
					Iterator iterator = ((PersistentSet)proxy).iterator();
					while(iterator.hasNext()){
						list.add(iterator.next());
					}
				}
			}
		}
		return list;
	}
	
	
}