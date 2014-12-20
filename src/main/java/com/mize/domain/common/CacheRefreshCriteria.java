package com.mize.domain.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

public class CacheRefreshCriteria extends MizeEntity implements Comparable<CacheRefreshCriteria>{
	
	private static final long serialVersionUID = -6647895629560783567L;
	private String entityName;
	private String entityAliasName;
	private DateTime startDate;
	private DateTime endDate;
	private Long fromEntityID;
	private Long toEntityID;
	private String inCluseIDs;
	private List<Long> entityIDList;
	private Long entityID;
	private String criteria;
	private Integer recordsCount;
	private List<Long> inCluseIDsList = new ArrayList<Long>();
	private Map<String,List<Long>> entityIDsMap;  
	private User user;
	private BusinessEntity tenant;
	private Integer commitCount;
	private String jpqlQuery;
	private String nativeQuery;	
	private Boolean nestedDocument;	
	private Map<String,Object> defaultCriteriaMap;
	private boolean reload;
	private String domainUIdField;
	private String fieldNames;
	private List<String> fieldNamesList = new ArrayList<String>();
	
	public String getCriteria() {
		return criteria;
	}
	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}
	public enum Criteria {
		Between,InClause,Equals,DateRange,UpdatedDate,CreatedDate,JpqlQuery,NativeQuery,ByName,InitialLoad;
	}
	
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	
	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	public DateTime getStartDate() {
		return startDate;
	}
	
	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using = JodaDateTimeDeserializer.class)
	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}
	
	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	public DateTime getEndDate() {
		return endDate;
	}
	
	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using = JodaDateTimeDeserializer.class)
	public void setEndDate(DateTime endDate) {
		this.endDate = endDate;
	}
	public String getEntityAliasName() {
		return entityAliasName;
	}
	public void setEntityAliasName(String entityAliasName) {
		this.entityAliasName = entityAliasName;
	}
	public Long getFromEntityID() {
		return fromEntityID;
	}
	public void setFromEntityID(Long fromEntityID) {
		this.fromEntityID = fromEntityID;
	}
	public Long getToEntityID() {
		return toEntityID;
	}
	public void setToEntityID(Long toEntityID) {
		this.toEntityID = toEntityID;
	}
	public String getInCluseIDs() {
		return inCluseIDs;
	}
	public void setInCluseIDs(String inCluseIDs) {
		this.inCluseIDs = inCluseIDs;
	}
	public List<Long> getEntityIDList() {
		if (entityIDList == null) {
			entityIDList = new ArrayList<Long>();
		}
		
		if (entityIDList.isEmpty() && entityID != null) {
			entityIDList.add(entityID);
		}
		return entityIDList;
	}
	public void setEntityIDList(List<Long> entityIDList) {
		this.entityIDList = entityIDList;
	}

	public Long getEntityID() {
		return entityID;
	}
	public void setEntityID(Long entityID) {
		this.entityID = entityID;
	}

	public Integer getRecordsCount() {
		return recordsCount;
	}
	public void setRecordsCount(Integer recordsCount) {
		this.recordsCount = recordsCount;
	}
	public List<Long> getInCluseIDsList() {
		return inCluseIDsList;
	}
	public void setInCluseIDsList(List<Long> inCluseIDsList) {
		this.inCluseIDsList = inCluseIDsList;
	}	
	public Map<String, List<Long>> getEntityIDsMap() {
		if(entityIDsMap == null){
			entityIDsMap = new HashMap<String,List<Long>>();
		}
		return entityIDsMap;
	}
	public void setEntityIDsMap(Map<String, List<Long>> entityIDsMap) {
		this.entityIDsMap = entityIDsMap;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@JsonIgnore
	public Map<String, Object> getDefaultCriteriaMap() {
		return defaultCriteriaMap;
	}
	
	public void setDefaultCriteriaMap(Map<String, Object> defaultCriteriaMap) {
		this.defaultCriteriaMap = defaultCriteriaMap;
	}
	
	public String getJpqlQuery() {
		return jpqlQuery;
	}
	public void setJpqlQuery(String jpqlQuery) {
		this.jpqlQuery = jpqlQuery;
	}
	public String getNativeQuery() {
		return nativeQuery;
	}
	public void setNativeQuery(String nativeQuery) {
		this.nativeQuery = nativeQuery;
	}
	
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getCommitCount() {
		return commitCount;
	}
	public void setCommitCount(Integer commitCount) {
		this.commitCount = commitCount;
	}
	
	public Boolean getNestedDocument() {
		return nestedDocument;
	}
	public void setNestedDocument(Boolean nestedDocument) {
		this.nestedDocument = nestedDocument;
	}
	
	public BusinessEntity getTenant() {
		return tenant;
	}
	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}
	public static CacheRefreshCriteria createCopyObject(List<Long> entityIDList,String entityName) {
		CacheRefreshCriteria copy = new CacheRefreshCriteria();
		List<Long> copyList = new ArrayList<Long>();
		for (Long id: entityIDList) {
			copyList.add(id);
		}
		try {
			copy.setEntityIDList(copyList);
			copy.setEntityName(entityName);
		} catch(Exception e) {	
		}
		return copy;
	}
	
	@Override
	public int compareTo(CacheRefreshCriteria arg0) {
		return 0;
	}
	@Override
	public String toString() {
		return "CacheRefreshCriteria [entityName=" + entityName
				+ ", entityAliasName=" + entityAliasName + ", startDate="
				+ startDate + ", endDate=" + endDate + ", fromEntityID="
				+ fromEntityID + ", toEntityID=" + toEntityID + ", inCluseIDs="
				+ inCluseIDs + ", entityIDList=" + entityIDList + ", entityID="
				+ entityID + ", criteria=" + criteria + ", recordsCount="
				+ recordsCount + ", inCluseIDsList=" + inCluseIDsList
				+ ", entityIDsMap=" + entityIDsMap + ", commitCount="
				+ commitCount + ", jpqlQuery=" + jpqlQuery + ", nativeQuery="
				+ nativeQuery + ", nestedDocument=" + nestedDocument
				+ ", defaultCriteriaMap=" + defaultCriteriaMap + "]";
	}
	
	public boolean getReload() {
		return reload;
	}
	public void setReload(boolean reload) {
		this.reload = reload;
	}
	@JsonIgnore
	public String getDomainUIdField() {
		return domainUIdField;
	}
	public void setDomainUIdField(String domainUIdField) {
		this.domainUIdField = domainUIdField;
	}
	public String getFieldNames() {
		return fieldNames;
	}
	public void setFieldNames(String fieldNames) {
		this.fieldNames = fieldNames;
	}
	public List<String> getFieldNamesList() {
		return fieldNamesList;
	}
	public void setFieldNamesList(List<String> fieldNamesList) {
		this.fieldNamesList = fieldNamesList;
	}
	
	
}
