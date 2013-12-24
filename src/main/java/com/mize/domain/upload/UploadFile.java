package com.mize.domain.upload;

import com.mize.domain.auth.User;
import com.mize.domain.common.MizeEntity;

public class UploadFile extends MizeEntity implements Comparable<UploadFile>{

	private static final long serialVersionUID = -4764734738730804430L;
	private String fileFormat;
	private String fileName;
	private String category;
	private String generatedFileName;
	private String s3Bucket;
	private String folder;
	private boolean local;
	private User user;
	
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	public boolean isLocal() {
		return local;
	}
	public void setLocal(boolean local) {
		this.local = local;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result
				+ ((fileFormat == null) ? 0 : fileFormat.hashCode());
		result = prime * result
				+ ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((folder == null) ? 0 : folder.hashCode());
		result = prime
				* result
				+ ((generatedFileName == null) ? 0 : generatedFileName
						.hashCode());
		result = prime * result + (local ? 1231 : 1237);
		result = prime * result
				+ ((s3Bucket == null) ? 0 : s3Bucket.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		UploadFile other = (UploadFile) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (fileFormat == null) {
			if (other.fileFormat != null)
				return false;
		} else if (!fileFormat.equals(other.fileFormat))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (folder == null) {
			if (other.folder != null)
				return false;
		} else if (!folder.equals(other.folder))
			return false;
		if (generatedFileName == null) {
			if (other.generatedFileName != null)
				return false;
		} else if (!generatedFileName.equals(other.generatedFileName))
			return false;
		if (local != other.local)
			return false;
		if (s3Bucket == null) {
			if (other.s3Bucket != null)
				return false;
		} else if (!s3Bucket.equals(other.s3Bucket))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "UploadFile [fileFormat=" + fileFormat + ", fileName="
				+ fileName + ", category=" + category + ", generatedFileName="
				+ generatedFileName + ", s3Bucket=" + s3Bucket + ", folder="
				+ folder + ", local=" + local + ", user=" + user + "]";
	}
	
	@Override
	public int compareTo(UploadFile arg0) {
		return 0;
	}
	
	
}
