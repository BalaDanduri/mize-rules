package com.mize.domain.upload;

import java.io.File;

import com.mize.domain.auth.User;
import com.mize.domain.batch.BatchJobMapper;
import com.mize.domain.common.MizeSceEntity;

public class UploadFile extends MizeSceEntity implements Comparable<UploadFile>{

	private static final long serialVersionUID = -4764734738730804430L;
	
	private String fileFormat;
	private String fileName;
	private String category;
	private String generatedFileName;
	private String s3Bucket;
	private String folder;
	private String inputType;
	private User user;
	private String url;
	private File file;
	private String fileType;
	private BatchJobMapper batchJobMapper;

	public static final String INPUT_TYPE_S3 = "S3";
	public static final String INPUT_TYPE_FILE = "file";

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
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public File getFile() {
		return file;
	}
	
	public void setFile(File file) {
		this.file = file;
	}
	
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	
	public BatchJobMapper getBatchJobMapper() {
		return batchJobMapper;
	}
	public void setBatchJobMapper(BatchJobMapper batchJobMapper) {
		this.batchJobMapper = batchJobMapper;
	}
	
	public String getInputType() {
		return inputType;
	}
	public void setInputType(String inputType) {
		this.inputType = inputType;
	}
	@Override
	public String toString() {
		return "UploadFile [fileFormat=" + fileFormat + ", fileName="
				+ fileName + ", category=" + category + ", generatedFileName="
				+ generatedFileName + ", s3Bucket=" + s3Bucket + ", folder="
				+ folder + ", inputType=" + inputType + ", user=" + user
				+ ", url=" + url + ", file=" + file + ", fileType=" + fileType
				+ ", batchJobMapper=" + batchJobMapper + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((batchJobMapper == null) ? 0 : batchJobMapper.hashCode());
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((file == null) ? 0 : file.hashCode());
		result = prime * result
				+ ((fileFormat == null) ? 0 : fileFormat.hashCode());
		result = prime * result
				+ ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result
				+ ((fileType == null) ? 0 : fileType.hashCode());
		result = prime * result + ((folder == null) ? 0 : folder.hashCode());
		result = prime
				* result
				+ ((generatedFileName == null) ? 0 : generatedFileName
						.hashCode());
		result = prime * result
				+ ((inputType == null) ? 0 : inputType.hashCode());
		result = prime * result
				+ ((s3Bucket == null) ? 0 : s3Bucket.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof UploadFile)) {
			return false;
		}
		UploadFile other = (UploadFile) obj;
		if (batchJobMapper == null) {
			if (other.batchJobMapper != null) {
				return false;
			}
		} else if (!batchJobMapper.equals(other.batchJobMapper)) {
			return false;
		}
		if (category == null) {
			if (other.category != null) {
				return false;
			}
		} else if (!category.equals(other.category)) {
			return false;
		}
		if (file == null) {
			if (other.file != null) {
				return false;
			}
		} else if (!file.equals(other.file)) {
			return false;
		}
		if (fileFormat == null) {
			if (other.fileFormat != null) {
				return false;
			}
		} else if (!fileFormat.equals(other.fileFormat)) {
			return false;
		}
		if (fileName == null) {
			if (other.fileName != null) {
				return false;
			}
		} else if (!fileName.equals(other.fileName)) {
			return false;
		}
		if (fileType == null) {
			if (other.fileType != null) {
				return false;
			}
		} else if (!fileType.equals(other.fileType)) {
			return false;
		}
		if (folder == null) {
			if (other.folder != null) {
				return false;
			}
		} else if (!folder.equals(other.folder)) {
			return false;
		}
		if (generatedFileName == null) {
			if (other.generatedFileName != null) {
				return false;
			}
		} else if (!generatedFileName.equals(other.generatedFileName)) {
			return false;
		}
		if (inputType == null) {
			if (other.inputType != null) {
				return false;
			}
		} else if (!inputType.equals(other.inputType)) {
			return false;
		}
		if (s3Bucket == null) {
			if (other.s3Bucket != null) {
				return false;
			}
		} else if (!s3Bucket.equals(other.s3Bucket)) {
			return false;
		}
		if (url == null) {
			if (other.url != null) {
				return false;
			}
		} else if (!url.equals(other.url)) {
			return false;
		}
		if (user == null) {
			if (other.user != null) {
				return false;
			}
		} else if (!user.equals(other.user)) {
			return false;
		}
		return true;
	}
	@Override
	public int compareTo(UploadFile arg0) {
		return 0;
	}
	
	
}
