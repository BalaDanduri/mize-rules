package com.mize.domain.sce.serviceentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.MizeDate;

/**
 * @author HarishBurra
 * @version 1.0
 */
@Entity
@Table(name = "srvc_enty_rqst_cvrg")
public class ServiceEntityRequestCoverage extends MizeSceEntity implements Comparable<ServiceEntityRequestCoverage> {
	
	private static final long serialVersionUID = 4345200969206488758L;
	
	private ServiceEntityRequest serviceEntityRequest;
	private Long coverageId;
	private String coverageName;
	private MizeDate coverageEndDate;

	public ServiceEntityRequestCoverage() {
		
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {		
		this.id = id;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "service_request_id")
	@JsonBackReference(value="service_request_coverage")
	@JsonSerialize(using=JPASerializer.class)
	public ServiceEntityRequest getServiceEntityRequest() {
		return serviceEntityRequest;
	}

	public void setServiceEntityRequest(ServiceEntityRequest serviceEntityRequest) {
		this.serviceEntityRequest = serviceEntityRequest;
	}
	
	@Column(name = "coverage_id")
	public Long getCoverageId() {
		return coverageId;
	}

	public void setCoverageId(Long coverageId) {
		this.coverageId = coverageId;
	}
	
	@Column(name = "coverage_name")
	public String getCoverageName() {
		return coverageName;
	}

	public void setCoverageName(String coverageName) {
		this.coverageName = coverageName;
	}
	
	
	@Column(name = "coverage_end_date")
	@Type(type = "com.mize.domain.util.MizeDateJPA")
	public MizeDate getCoverageEndDate() {
		return coverageEndDate;
	}
	
	public void setCoverageEndDate(MizeDate coverageEndDate) {
		this.coverageEndDate = coverageEndDate;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((coverageEndDate == null) ? 0 : coverageEndDate.hashCode());
		result = prime * result
				+ ((coverageId == null) ? 0 : coverageId.hashCode());
		result = prime * result
				+ ((coverageName == null) ? 0 : coverageName.hashCode());
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
		ServiceEntityRequestCoverage other = (ServiceEntityRequestCoverage) obj;
		if (coverageEndDate == null) {
			if (other.coverageEndDate != null)
				return false;
		} else if (!coverageEndDate.equals(other.coverageEndDate))
			return false;
		if (coverageId == null) {
			if (other.coverageId != null)
				return false;
		} else if (!coverageId.equals(other.coverageId))
			return false;
		if (coverageName == null) {
			if (other.coverageName != null)
				return false;
		} else if (!coverageName.equals(other.coverageName))
			return false;
		return true;
	}

	@Override
	public int compareTo(ServiceEntityRequestCoverage o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "ServiceEntityRequestCoverage [coverageId=" + coverageId
				+ ", coverageName=" + coverageName + ", coverageEndDate="
				+ coverageEndDate + "]";
	}
	

}
