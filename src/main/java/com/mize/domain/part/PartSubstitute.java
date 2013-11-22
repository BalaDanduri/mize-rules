package com.mize.domain.part;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;
@Entity
@Table(name = "part_substitute")
public class PartSubstitute extends MizeEntity {

	private static final long serialVersionUID = 7541499457840335691L;
	
	private Part originalPart;
	private Part substitutedPart;
	private String code;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime date;
	private String comments;
    private String familyCode;
	
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


	@Column(name = "substitute_date", nullable = true)
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@Type(type = "com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using = JsonDateTimeSerializer.class, include = Inclusion.NON_NULL)
	public DateTime getDate() {
		return date;
	}

	@Column(name = "substitute_comments")
	public String getComments() {
		return comments;
	}

	
	@Override	
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@Column(name = "created_date")
	public DateTime getCreatedDate() {
		return createdDate;
	}

	@Override	
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@Column(name = "updated_date")
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

	public void setComments(String comments) {
		this.comments = comments;
	}


	@Override
	@DateTimeFormat (pattern="MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore
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

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result
				+ ((comments == null) ? 0 : comments.hashCode());
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
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
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
		StringBuilder builder = new StringBuilder();
		builder.append("PartSubstitute [originalPart=");
		builder.append(originalPart);
		builder.append(", substitutedPart=");
		builder.append(substitutedPart);
		builder.append(", code=");
		builder.append(code);
		builder.append(", date=");
		builder.append(date);
		builder.append(", comments=");
		builder.append(comments);
		builder.append(", familyCode=");
		builder.append(familyCode);
		builder.append("]");
		return builder.toString();
	}

	
	
}
