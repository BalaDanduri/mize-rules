package com.mize.domain.upload;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.BadSqlGrammarException;

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
	@JsonIgnore
	private Map<Integer,ProcessLog> logMap = new  HashMap<Integer,ProcessLog>();
	@JsonIgnore
	private boolean isSolrUpdateReq = true;
	private List<Long> prodIds = new ArrayList<Long>();
	public enum Status{
		IN_PROGRESS,COMPLETED;
	}
	
	public static String DATA_INTEGRITY_EXCEPTION = "DATA_INTEGRITY_EXCEPTION";
	public static String DULPLICATE_RECORD_EXCEPTION = "DULPLICATE_RECORD_EXCEPTION";
	public static String SQL_EXCEPTION = "SQL_EXCEPTION";
	public static String NULL_POINTER_EXCEPTION = "NULL_POINTER_EXCEPTION";
	public static String BAD_SQL_GRAMMER_EXCEPTION = "BAD_SQL_GRAMMER_EXCEPTION";
	
	public enum EntityType{
		BrandService("Brand"),BrandSupprtService("Brand Supprt"),ProductService("Product"),ProductDesriptionService("Product Desription"),
		ProductKeywordsService("Product Keywords"),ProductLocaleService("Product Locale"),ProductAccessoriesService("Product Accessories"),
		ProductSearchAttributeService("Product Search Attribute"),ProductUpsellService("Product Upsell"),ProductSkuService("Product Sku"),
		ProductImagesService("Product Images"),ProductAttributeService("Product Attribute"),ServiceLocatorService("Service Locator"),
		ProductSimilarService("Similar Product"),EtilizeProductRegistrationJob("Product Registration");
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
		return PRIME;
	}

	@Override
	public boolean equals(Object obj) {		
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
	public void addToFailureRecord(UploadEntity uploadEntity ,int recordNumber,String entityCode,String field,String msgCode) {
		ProcessLog processLog = logMap.get(recordNumber);
		if(processLog == null){
			processLog = new ProcessLog();
			MizeEntity entity = (MizeEntity)((List)uploadEntity.getEntity()).get(recordNumber);
			processLog.setInputRecord(entity);
			processLog.setEntityId(entity.getId());
			processLog.setEntityCode(entityCode);
			processLog.setRecordNumber(recordNumber);
			logMap.put(recordNumber, processLog);
			uploadEntity.getProcessLogs().add(processLog);
		}			
		ErrorLog errorLog = new ErrorLog(field,msgCode);
		processLog.getErrorLogs().add(errorLog);		
	}

	public void addToFailureRecord(UploadEntity uploadEntity ,int recordNumber,String entityCode,String field,Exception exp){
		String messageCode = SQL_EXCEPTION;
		if(exp instanceof NullPointerException){
			messageCode = NULL_POINTER_EXCEPTION;
		}
		if(exp instanceof DataIntegrityViolationException){
			messageCode = DATA_INTEGRITY_EXCEPTION;
		}
		if(exp instanceof DataIntegrityViolationException){
			messageCode = DATA_INTEGRITY_EXCEPTION;
		}
		if(exp instanceof BadSqlGrammarException){
			messageCode = BAD_SQL_GRAMMER_EXCEPTION;
		}		
		uploadEntity.addToFailureRecord(uploadEntity, recordNumber, entityCode, field, messageCode);
	}
	
	public void addToFailureRecord(UploadEntity uploadEntity ,int recordNumber,String entityCode,Exception exp){
		addToFailureRecord(uploadEntity ,recordNumber,entityCode,null,exp);
	}
	
	public void addToFailureRecord(UploadEntity uploadEntity ,int recordNumber,String entityCode,String messageCode){
		uploadEntity.addToFailureRecord(uploadEntity, recordNumber, entityCode, null, messageCode);
	}
	
	public void addToFailureRecord(UploadEntity uploadEntity ,int recordNumber,Long entityCode,String messageCode){
		uploadEntity.addToFailureRecord(uploadEntity, recordNumber, String.valueOf(entityCode), null, messageCode);
	}
	
	public void addToFailureRecord(UploadEntity uploadEntity ,int recordNumber,Long entityCode,String field,String messageCode){
		uploadEntity.addToFailureRecord(uploadEntity, recordNumber, String.valueOf(entityCode), field, messageCode);
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

	@JsonIgnore
	public boolean isSolrUpdateReq() {
		return isSolrUpdateReq;
	}

	@JsonIgnore
	public void setSolrUpdateReq(boolean isSolrUpdateReq) {
		this.isSolrUpdateReq = isSolrUpdateReq;
	}

	public List<Long> getProdIds() {
		return prodIds;
	}

	public void setProdIds(List<Long> prodIds) {
		this.prodIds = prodIds;
	}	
	
}
