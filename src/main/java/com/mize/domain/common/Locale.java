package com.mize.domain.common;



public class Locale extends MizeEntity implements Comparable<Locale>{
	
	private static final long serialVersionUID = -3914800360286751871L;
	private String isActive;
    private String languageCode;
    private String countryCode;
    private String name;
   

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public String getLanguageCode() {
		return languageCode;
	}
	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Locale [isActive=" + isActive + ", languageCode=" + languageCode + ", countryCode=" + countryCode + ", name=" + name + ", id=" + id + "]";
	}
	
	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = PRIME * result + ((countryCode == null) ? 0 : countryCode.hashCode());
		result = PRIME * result + ((isActive == null) ? 0 : isActive.hashCode());
		result = PRIME * result + ((languageCode == null) ? 0 : languageCode.hashCode());
		result = PRIME * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	public int compareTo(Locale locale) {
		if ( this == locale ) 
			return EQUAL;
		else if (this.id < locale.id) 
			return BEFORE;
		else if (locale.id == this.id) 
			return EQUAL;
		else if (this.id > locale.id)
			return AFTER;
		return EQUAL;		
	}
}
