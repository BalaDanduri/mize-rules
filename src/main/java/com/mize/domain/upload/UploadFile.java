package com.mize.domain.upload;

import com.mize.domain.common.Entity;

public class UploadFile extends Entity{

	private static final long serialVersionUID = -4764734738730804430L;
	private String fileFormat;
	private String fileName;
	private String fileType;
	private String generatedFileName;
	private String s3Bucket;
	private String folder;
	
	public String getFileFormat() {
		return fileFormat;
	}
	public void setFileFormat(String fileFormat) {
		this.fileFormat = fileFormat;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getGeneratedFileName() {
		return generatedFileName;
	}
	public void setGeneratedFileName(String generatedFileName) {
		this.generatedFileName = generatedFileName;
	}
	public String getS3Bucket() {
		return s3Bucket;
	}
	public void setS3Bucket(String s3Bucket) {
		this.s3Bucket = s3Bucket;
	}
	public String getFolder() {
		return folder;
	}
	public void setFolder(String folder) {
		this.folder = folder;
	}
	
	
}
