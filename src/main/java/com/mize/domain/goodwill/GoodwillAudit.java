package com.mize.domain.goodwill;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mize.domain.common.MizeAuditEntity;
import com.mize.domain.util.MizeDateTime;
/**
 * @author Raghavendra Serikar
 * @version 1.0
 */
@Entity
@Table(name="goodwill_audit")
public class GoodwillAudit extends MizeAuditEntity implements Comparable<GoodwillAudit>{
	private static final long serialVersionUID = -4806940799417432658L;
	private Goodwill goodwill;
	private String status;
	
	
	public GoodwillAudit(){
		goodwill = new Goodwill();
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",unique=true,nullable=false)
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "goodwill_id")
	@JsonBackReference(value="audits")
	public Goodwill getGoodwill() {
		return goodwill;
	}

	@Column(name = "status_code", length = 50)
	public String getStatus() {
		return status;
	}

	
	@Column(name = "status_date", nullable = true)
	@Type(type = "com.mize.domain.util.MizeDateTimeJPA")
	public MizeDateTime getStatusDate() {
		return statusDate;
	}

	@Column(name = "status_by")
	public Long getStatusBy() {
		return statusBy;
	}
	
	@Column(name = "status_by_user", nullable = true, length = 250)
	@Override
	public String getStatusByUser() {
		return statusByUser;
	}

	public void setGoodwill(Goodwill goodwill) {
		this.goodwill = goodwill;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setStatusDate(MizeDateTime statusDate) {
		this.statusDate = statusDate;
	}

	public void setStatusBy(Long statusBy) {
		this.statusBy = statusBy;
	}
	
	public void setStatusByUser(String statusByUser) {
		this.statusByUser = statusByUser;
	}
	

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((goodwill == null) ? 0 : goodwill.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((statusBy == null) ? 0 : statusBy.hashCode());
		result = prime * result
				+ ((statusDate == null) ? 0 : statusDate.hashCode());
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
		GoodwillAudit other = (GoodwillAudit) obj;
		if (goodwill == null) {
			if (other.goodwill != null)
				return false;
		} else if (!goodwill.equals(other.goodwill))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (statusBy == null) {
			if (other.statusBy != null)
				return false;
		} else if (!statusBy.equals(other.statusBy))
			return false;
		if (statusDate == null) {
			if (other.statusDate != null)
				return false;
		} else if (!statusDate.equals(other.statusDate))
			return false;
		return true;
	}

	@Override
	public int compareTo(GoodwillAudit o) {
		return 0;
	}

}
