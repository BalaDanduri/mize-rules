package com.mize.domain.extract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mize.domain.auth.User;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.MizeDateTime;

public class ExportDataCriteria extends MizeSceEntity implements Comparable<ExportDataCriteria>{
	
	private static final long serialVersionUID = -6647895629560783568L;
	private String entityName;
	private Long entityID;
	private Long fromEntityID;
	private Long toEntityID;
	private String inCluseIDs;
	private MizeDateTime startDate;
	private MizeDateTime endDate;
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
	
	public MizeDateTime getStartDate() {
		return startDate;
	}
	
	public void setStartDate(MizeDateTime startDate) {
		this.startDate = startDate;
	}
	
	public MizeDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(MizeDateTime endDate) {
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
