package com.mize.domain.applicationformat;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.Formatter;

public class ApplicationFormatCache extends MizeSceEntity implements Comparable<ApplicationFormatCache> {
	
	private static final long serialVersionUID = 848292818865493379L;
	private List<ApplicationFormat> formats = new ArrayList<ApplicationFormat>();
	
	public ApplicationFormatCache() {
		super();
	}
	
	public ApplicationFormatCache(List<ApplicationFormat> formats) {
		super();
		this.formats = formats;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public List<ApplicationFormat> getFormats() {
		return formats;
	}

	public void setFormats(List<ApplicationFormat> formats) {
		this.formats = formats;
	}

	@JsonIgnore
	public String getUserDateTimeFormat(){
		if(formats != null){
			for(ApplicationFormat format : formats){
				if(Formatter.equalIgnoreCase(format.getFormatType(), ApplicationFormatConstants.DATE_TIME_FORMAT)){
					return format.getFormatValue();
				}
			}
		}
		return null;
	}
	
	@JsonIgnore
	public ApplicationFormat getApplcationFormat(String formatType){
		if(formats != null){
			for(ApplicationFormat format : formats){
				if(Formatter.equalIgnoreCase(format.getFormatType(), formatType)){
					return format;
				}
			}
		}
		return null;
	}
	
	@JsonIgnore
	public String getUserDateFormat(){
		if(formats != null){
			for(ApplicationFormat format : formats){
				if(Formatter.equalIgnoreCase(format.getFormatType(), ApplicationFormatConstants.DATE_FORMAT)){
					return format.getFormatValue();
				}
			}
		}
		return null;
	}
	
	@JsonIgnore
	public String getUserDecimalFormat(){
		if(formats != null){
			for(ApplicationFormat format : formats){
				if(Formatter.equalIgnoreCase(format.getFormatType(), ApplicationFormatConstants.DECIMAL_FORMAT)){
					return format.getFormatValue();
				}
			}
		}
		return null;
	}

	@JsonIgnore
	public boolean addFormat(String formatType,ApplicationFormat inputFormat){
		boolean isExists = false;
		if(formats != null){
			for(ApplicationFormat format : formats){
				if(Formatter.equalIgnoreCase(format.getFormatType(), ApplicationFormatConstants.DECIMAL_FORMAT)){
					isExists = true;
					break;
				}
			}
			if(isExists == false){
				formats.add(inputFormat);
			}
		}else{
			formats = new ArrayList<ApplicationFormat>();
			formats.add(inputFormat);
		}
		return isExists;
	}
	
	@Override
	public int compareTo(ApplicationFormatCache o) {
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((formats == null) ? 0 : formats.hashCode());
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
		ApplicationFormatCache other = (ApplicationFormatCache) obj;
		if (formats == null) {
			if (other.formats != null)
				return false;
		} else if (!formats.equals(other.formats))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ApplicationFormatCache [formats=" + formats + "]";
	}

}
