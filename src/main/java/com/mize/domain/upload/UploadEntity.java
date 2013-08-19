package com.mize.domain.upload;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.auth.User;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

public final class UploadEntity extends MizeEntity implements Comparable<UploadEntity> {

	private static final long serialVersionUID = 8241122531831985362L;
	private Long parentId;
	private String entityType;
	private String fileType;
	private Integer recordCount;
	private Integer successCount;
	private Integer failureCount;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime startTime;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime endTime;
	private String status;
	private String fileName;
	private Object entity;
	private List<ProcessLog> processLogs = new ArrayList<ProcessLog>();
	private String logFileURI;
	private User user;
	public enum Status{
		IN_PROGRESS,COMPLETED;
	}
	
	public enum EntityType{
		BrandService("Brand Service"),BrandSupprtService("Brand Supprt"),ProductService("Product"),ProductDesriptionService("Product Desription"),
		ProductKeywordsService("Product Keywords"),ProductLocaleService("Product Locale"),ProductAccessoriesService("Product Accessories"),
		ProductSearchAttributeService("Product Search Attribute"),ProductUpsellService("Product Upsell"),ProductSkuService("Product Sku"),
		ProductImagesService("Product Images"),ProductAttributeService("Product Attribute"),ServiceLocatorService("Service Locator");
		String name;
		EntityType(String name){
			this.name = name;
		}
		public String getName(){
			return name;
		}
	}
	
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	public DateTime getStartTime() {
		return startTime;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setStartTime(DateTime startTime) {
		this.startTime = startTime;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	public DateTime getEndTime() {
		return endTime;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setEndTime(DateTime endTime) {
		this.endTime = endTime;
	}
	
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public Integer getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(Integer recordCount) {
		this.recordCount = recordCount;
	}

	public Integer getFailureCount() {
		return failureCount;
	}

	public void setFailureCount(Integer failureCount) {
		this.failureCount = failureCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public Object getEntity() {
		return entity;
	}

	public void setEntity(Object entity) {
		this.entity = entity;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	
	public List<ProcessLog> getProcessLogs() {
		return processLogs;
	}

	public void setProcessLogs(List<ProcessLog> processLogs) {
		this.processLogs = processLogs;
	}

	
	public Integer getSuccessCount() {
		return successCount;
	}

	public void setSuccessCount(Integer successCount) {
		this.successCount = successCount;
	}

	public String getLogFileURI() {
		return logFileURI;
	}

	public void setLogFileURI(String logFileURI) {
		this.logFileURI = logFileURI;
	}

	@Override
	public int compareTo(UploadEntity o) {
		return 0;
	}	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((entity == null) ? 0 : entity.hashCode());
		result = prime * result
				+ ((entityType == null) ? 0 : entityType.hashCode());
		result = prime * result
				+ ((failureCount == null) ? 0 : failureCount.hashCode());
		result = prime * result
				+ ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result
				+ ((fileType == null) ? 0 : fileType.hashCode());
		result = prime * result
				+ ((parentId == null) ? 0 : parentId.hashCode());
		result = prime * result
				+ ((processLogs == null) ? 0 : processLogs.hashCode());
		result = prime * result
				+ ((recordCount == null) ? 0 : recordCount.hashCode());
		result = prime * result
				+ ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((successCount == null) ? 0 : successCount.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		UploadEntity other = (UploadEntity) obj;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (entity == null) {
			if (other.entity != null)
				return false;
		} else if (!entity.equals(other.entity))
			return false;
		if (entityType == null) {
			if (other.entityType != null)
				return false;
		} else if (!entityType.equals(other.entityType))
			return false;
		if (failureCount == null) {
			if (other.failureCount != null)
				return false;
		} else if (!failureCount.equals(other.failureCount))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (fileType == null) {
			if (other.fileType != null)
				return false;
		} else if (!fileType.equals(other.fileType))
			return false;
		if (parentId == null) {
			if (other.parentId != null)
				return false;
		} else if (!parentId.equals(other.parentId))
			return false;
		if (processLogs == null) {
			if (other.processLogs != null)
				return false;
		} else if (!processLogs.equals(other.processLogs))
			return false;
		if (recordCount == null) {
			if (other.recordCount != null)
				return false;
		} else if (!recordCount.equals(other.recordCount))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (successCount == null) {
			if (other.successCount != null)
				return false;
		} else if (!successCount.equals(other.successCount))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UploadEntity [parentId=" + parentId + ", entityType="
				+ entityType + ", fileType=" + fileType + ", recordCount="
				+ recordCount + ", successCount=" + successCount
				+ ", failureCount=" + failureCount + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", status=" + status + ", fileName="
				+ fileName + ", entity=" + entity + ", processLogs="
				+ processLogs + "]";
	}
	
	
	@JsonIgnore
	@SuppressWarnings("rawtypes")
	public static void addToFailureRecord(UploadEntity uploadEntity ,MizeEntity entity,String entityCode,String field,String msgCode) {		
		if(uploadEntity != null){
			ProcessLog processLog = new ProcessLog();			
			processLog.setInputRecord(entity);
			processLog.setEntityId(entity.getId());
			processLog.setEntityCode(entityCode);
			processLog.setRecordNumber(((List)uploadEntity.getEntity()).indexOf(entity)+1);
			ErrorLog errorLog = new ErrorLog(field,msgCode);
			processLog.getErrorLogs().add(errorLog);
			uploadEntity.getProcessLogs().add(processLog);
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@JsonIgnore
	public static String getEntityName(String entityCode){
		try{
			EntityType entityType = EntityType.valueOf(entityCode);
			return entityType.getName();
		}catch(Exception e){			
		}		
		return entityCode;
	}
	
}
