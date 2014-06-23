package com.mize.domain.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mize.domain.util.Formatter;

@Entity
@Table(name="locale")
public class Locale extends MizeEntity implements Comparable<Locale>{
	
	private static final long serialVersionUID = -3914800360286751871L;
	private String isActive;
    private String languageCode;
    private String countryCode;
    private String name;
   
    public Locale(){
    	super();
    }
    
    public Locale(Long id){
    	super();
    	this.id = id;
    }
    
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="locale_id",nullable=false)
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="is_active",nullable=true,length=1)
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	@Column(name="language_code",nullable=true,length=10)
	public String getLanguageCode() {
		return languageCode;
	}
	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}
	@Column(name="country_code",nullable=true,length=10)
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	@Column(name="locale_name",nullable=true,length=80)
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

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime * result
				+ ((languageCode == null) ? 0 : languageCode.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;		
		if (getClass() != obj.getClass())
			return false;
		Locale other = (Locale) obj;
		if (Formatter.isNull(countryCode)) {
			if (Formatter.isNotNull(other.countryCode))
				return false;
		} else if (!countryCode.equals(other.countryCode))
			return false;
		if (Formatter.isNull(languageCode)) {
			if (Formatter.isNotNull(other.languageCode))
				return false;
		} else if (!languageCode.equals(other.languageCode))
			return false;
		if (Formatter.isNull(name)) {
			if (Formatter.isNotNull(other.name))
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
