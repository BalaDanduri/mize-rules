package com.mize.domain.extract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

public class ExportDataCriteria extends MizeEntity implements Comparable<ExportDataCriteria>{
	
	private static final long serialVersionUID = -6647895629560783568L;
	private String entityName;
	private Long entityID;
	private Long fromEntityID;
	private Long toEntityID;
	private String inCluseIDs;
	private DateTime startDate;
	private DateTime endDate;
	private String criteria;
	private List<Long> entityIDList;
	private List<Long> inCluseIDsList = new ArrayList<Long>();
	private Map<String,List<Long>> entityIDsMap;  
	private User user;
	
	public enum Criteria {
		Between,InClause,Equals,DateRange,UpdatedDate,CreatedDate;
	}
	public String getCriteria() {
		return criteria;
	}
	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	public DateTime getStartDate() {
		return startDate;
	}
	
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	@JsonDeserialize(using = JodaDateTimeDeserializer.class)
	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}
	
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	public DateTime getEndDate() {
		return endDate;
	}
	
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	@JsonDeserialize(using = JodaDateTimeDeserializer.class)
	public void setEndDate(DateTime endDate) {
		this.endDate = endDate;
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
	public static ExportDataCriteria createCopyObject(List<Long> entityIDList,String entityName,String aliasName) {
		ExportDataCriteria copy = new ExportDataCriteria();
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
	public int compareTo(ExportDataCriteria arg0) {
		return 0;
	}
	
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "SolrEntityCriteria [entityName=" + entityName
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", fromEntityID="
				+ fromEntityID + ", toEntityID=" + toEntityID + ", inCluseIDs="
				+ inCluseIDs + ", entityID=" + entityID + "]";
	}
	
}
