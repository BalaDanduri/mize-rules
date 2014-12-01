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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.common.EntityComment;
import com.mize.domain.common.MizeSceEntityAudit;
import com.mize.domain.product.PartSubstituteComment;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.MizeDate;
@Entity
@Table(name = "part_substitute")
public class PartSubstitute extends MizeSceEntityAudit implements Comparable<PartSubstitute> {

	private static final long serialVersionUID = -8910398875058216907L;

	private Part originalPart;
	private Part substitutedPart;
	private String code;
	private MizeDate date;
	private MizeDate endDate;
	private EntityComment entityComment;
	private List<PartSubstituteComment> comments = new ArrayList<PartSubstituteComment>();
    private String familyCode;
    private Integer sequenceNo;
    @Transient
    private User user;
   
	
	public PartSubstitute(){
		super();
	}
		
	public PartSubstitute(Long id,String originalPartCode,String substitutePartCode,String fmailyCode,String code ,MizeDate date,MizeDate endDate,Integer sequenceNo){
		super();
		this.id = id;
		if(originalPartCode != null){
			this.originalPart = new Part();
			this.originalPart.setCode(originalPartCode);
		}
		if(substitutePartCode != null){
			this.substitutedPart = new Part();
			this.substitutedPart.setCode(substitutePartCode);
		}
		this.familyCode = fmailyCode;
		this.code = code;
		this.date = date;
		this.endDate = endDate;
		this.sequenceNo = sequenceNo;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	@Override
	public Long getId() {
		return id;
	}

	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="old_part_id")
	public Part getOriginalPart() {
		return originalPart;
	}

	@OneToOne(fetch=FetchType.EAGER)
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

	@Column(name = "sequence_no")
	public Integer getSequenceNo() {
		return sequenceNo;
	}

	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	@Transient
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Column(name = "substitute_date")
	@Type(type = "com.mize.domain.util.MizeDateJPA")
	public MizeDate getDate() {
		return date;
	}
	
	@Column(name = "end_date")
	@Type(type = "com.mize.domain.util.MizeDateJPA")
	public MizeDate getEndDate() {
		return endDate;
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

	public void setDate(MizeDate date) {
		this.date = date;
	}
	
	public void setEndDate(MizeDate endDate) {
		this.endDate = endDate;
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
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
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
		result = prime * result
				+ ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result
				+ ((entityComment == null) ? 0 : entityComment.hashCode());
		result = prime * result
				+ ((familyCode == null) ? 0 : familyCode.hashCode());
		result = prime * result
				+ ((originalPart == null) ? 0 : originalPart.hashCode());
		result = prime * result
				+ ((sequenceNo == null) ? 0 : sequenceNo.hashCode());
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
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (entityComment == null) {
			if (other.entityComment != null)
				return false;
		} else if (!entityComment.equals(other.entityComment))
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
		if (sequenceNo == null) {
			if (other.sequenceNo != null)
				return false;
		} else if (!sequenceNo.equals(other.sequenceNo))
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
				+ ", date=" + date + ", endDate=" + endDate + ",familyCode=" + familyCode
				+ ", sequenceNo=" + sequenceNo + "]";
	}

	@Override
	public int compareTo(PartSubstitute o) {
		return 0;
	}
	
}
