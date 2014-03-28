package com.mize.domain.part;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.mize.domain.auth.User;
import com.mize.domain.common.EntityComment;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.product.PartSubstituteComment;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;
@Entity
@Table(name = "part_substitute")
public class PartSubstitute extends MizeEntity {

	private static final long serialVersionUID = -8910398875058216907L;

	private Part originalPart;
	private Part substitutedPart;
	private String code;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime date;
	//private String comments;
	private EntityComment entityComment;
	private List<PartSubstituteComment> comments = new ArrayList<PartSubstituteComment>();
    private String familyCode;
    @Transient
    private User user;
    
	
	public PartSubstitute(){
		super();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}

	
	@OneToOne(fetch=FetchType.EAGER ,cascade= CascadeType.ALL)
	@JoinColumn(name="old_part_id")
	public Part getOriginalPart() {
		return originalPart;
	}

	@OneToOne(fetch=FetchType.EAGER ,cascade= CascadeType.ALL)
	@JoinColumn(name="new_part_id")
	public Part getSubstitutedPart() {
		return substitutedPart;
	}

	@Column(name = "substitute_code")
	public String getCode() {
		return code;
	}

	@Column(name = "family_code")
	public String getFamilyCode() {
		return familyCode;
	}


	@Transient
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Column(name = "substitute_date", nullable = true)
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@Type(type = "com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using = JsonDateTimeSerializer.class, include = Inclusion.NON_NULL)
	public DateTime getDate() {
		return date;
	}

	@Override	
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@Column(name = "created_date")
	@JsonIgnore(value = false)
	public DateTime getCreatedDate() {
		return createdDate;
	}

	@Override	
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@Column(name = "updated_date")
	@JsonIgnore(value = false)
	public DateTime getUpdatedDate() {
		return updatedDate;
	}

	@Override
	@JsonIgnore
	@Column(name = "created_by")
	public Long getCreatedBy() {		
		return super.getCreatedBy();
	}

	@Override
	@JsonIgnore
	@Column(name = "updated_by")
	public Long getUpdatedBy() {		
		return super.getUpdatedBy();
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public void setOriginalPart(Part originalPart) {
		this.originalPart = originalPart;
	}

	public void setSubstitutedPart(Part substitutedPart) {
		this.substitutedPart = substitutedPart;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setDate(DateTime date) {
		this.date = date;
	}

	@Override
	@DateTimeFormat (pattern="MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(false)
	public void setCreatedDate(DateTime createdDate) {
		super.createdDate = createdDate;
	}

	@Override
	@DateTimeFormat (pattern="MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore
	public void setUpdatedDate(DateTime updatedDate) {
		super.updatedDate = updatedDate;
	}

	@Override
	@JsonIgnore
	public void setCreatedBy(Long createdBy) {		
		super.setCreatedBy(createdBy);
	}

	@Override
	@JsonIgnore
	public void setUpdatedBy(Long updatedBy) {		
		super.setUpdatedBy(updatedBy);
	}
 
	public void setFamilyCode(String familyCode) {
		this.familyCode = familyCode;
	}
	
	@Transient
	public EntityComment getEntityComment() {
		return entityComment;
	}

	public void setEntityComment(EntityComment entityComment) {
		this.entityComment = entityComment;
	}
	
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "partSubstitute",orphanRemoval= true)
	@JsonSerialize(using=JPASerializer.class,include=Inclusion.NON_NULL)
	public List<PartSubstituteComment> getComments() {
		return comments;
	}

	public void setComments(List<PartSubstituteComment> comments) {
		this.comments = comments;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result
				+ ((familyCode == null) ? 0 : familyCode.hashCode());
		result = prime * result
				+ ((originalPart == null) ? 0 : originalPart.hashCode());
		result = prime * result
				+ ((substitutedPart == null) ? 0 : substitutedPart.hashCode());
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
		PartSubstitute other = (PartSubstitute) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (familyCode == null) {
			if (other.familyCode != null)
				return false;
		} else if (!familyCode.equals(other.familyCode))
			return false;
		if (originalPart == null) {
			if (other.originalPart != null)
				return false;
		} else if (!originalPart.equals(other.originalPart))
			return false;
		if (substitutedPart == null) {
			if (other.substitutedPart != null)
				return false;
		} else if (!substitutedPart.equals(other.substitutedPart))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PartSubstitute [originalPart=" + originalPart
				+ ", substitutedPart=" + substitutedPart + ", code=" + code
				+ ", date=" + date + ", familyCode=" + familyCode + "]";
	}

	
}
