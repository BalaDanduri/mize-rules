package com.mize.domain.appmsg;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.Locale;
import com.mize.domain.common.MizeSceEntityAudit;
import com.mize.domain.util.JPASerializer;

@Entity
@Table(name="application_messages_intl")
public class AppMessageIntl extends MizeSceEntityAudit implements Comparable<AppMessageIntl> {

	private static final long serialVersionUID = 3605561224344122428L;
	private AppMessage appMessage;
	private String shortDesc;
	private String longDesc;
	private Locale locale = new Locale();
	
	public AppMessageIntl(){
		super();
	}
	
	
	public AppMessageIntl(AppMessage appMessage, String shortDesc,
			String longDesc, Locale locale) {
		super();
		this.appMessage = appMessage;
		this.shortDesc = shortDesc;
		this.longDesc = longDesc;
		this.locale = locale;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		super.id = id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "message_id")
	@JsonBackReference(value="intl")
	public AppMessage getAppMessage() {
		return appMessage;
	}

	public void setAppMessage(AppMessage appMessage) {
		this.appMessage = appMessage;
	}

	@Column(name = "short_description")
	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	
	@Column(name = "long_description")
	public String getLongDesc() {
		return longDesc;
	}

	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "locale_id")
	@JsonSerialize(using=JPASerializer.class)
//	@JsonInclude(Include.NON_NULL)
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((locale == null) ? 0 : locale.hashCode());
		result = prime * result
				+ ((longDesc == null) ? 0 : longDesc.hashCode());
		result = prime * result
				+ ((shortDesc == null) ? 0 : shortDesc.hashCode());
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
		AppMessageIntl other = (AppMessageIntl) obj;		
		if (locale == null) {
			if (other.locale != null)
				return false;
		} else if (!locale.equals(other.locale))
			return false;
		if (longDesc == null) {
			if (other.longDesc != null)
				return false;
		} else if (!longDesc.equals(other.longDesc))
			return false;
		if (shortDesc == null) {
			if (other.shortDesc != null)
				return false;
		} else if (!shortDesc.equals(other.shortDesc))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "AppMessageIntl [shortDesc=" + shortDesc + ", longDesc="
				+ longDesc + ", locale=" + locale + "]";
	}


	@Override
	public int compareTo(AppMessageIntl o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
