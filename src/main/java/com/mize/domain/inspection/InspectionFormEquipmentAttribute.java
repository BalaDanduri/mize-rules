package com.mize.domain.inspection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.JPASerializer;
@Entity
@Table(name="insp_form_eqpmnt_attribute")
public class InspectionFormEquipmentAttribute extends MizeSceEntity implements Comparable<InspectionFormEquipmentAttribute> {


	private static final long serialVersionUID = 4209438685260898918L;

	private InspectionFormEquipment inspectionFormEquipment;
	private String attributeCode;
	private String attributeUom;
	private String attributeValue;
	private String attributeDataType;
	
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id=id;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "insp_eqpmnt_id")
	@JsonBackReference(value="insp_eqpmnt_attr")
	@JsonSerialize(using=JPASerializer.class)
	public InspectionFormEquipment getInspectionFormEquipment() {
		return inspectionFormEquipment;
	}

	public void setInspectionFormEquipment(InspectionFormEquipment inspectionFormEquipment) {
		this.inspectionFormEquipment = inspectionFormEquipment;
	}

	@Column(name="attribute_code")
	public String getAttributeCode() {
		return attributeCode;
	}

	public void setAttributeCode(String attributeCode) {
		this.attributeCode = attributeCode;
	}

	@Column(name="attribute_uom")
	public String getAttributeUom() {
		return attributeUom;
	}

	public void setAttributeUom(String attributeUom) {
		this.attributeUom = attributeUom;
	}

	@Column(name="attribute_value")
	public String getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

	@Column(name="attribute_data_type")
	public String getAttributeDataType() {
		return attributeDataType;
	}
	
	public void setAttributeDataType(String attributeDataType) {
		this.attributeDataType = attributeDataType;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((attributeCode == null) ? 0 : attributeCode.hashCode());
		result = prime * result + ((attributeDataType == null) ? 0 : attributeDataType.hashCode());
		result = prime * result + ((attributeUom == null) ? 0 : attributeUom.hashCode());
		result = prime * result + ((attributeValue == null) ? 0 : attributeValue.hashCode());
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
		if (!(obj instanceof InspectionFormEquipmentAttribute)) {
			return false;
		}
		InspectionFormEquipmentAttribute other = (InspectionFormEquipmentAttribute) obj;
		if (attributeCode == null) {
			if (other.attributeCode != null) {
				return false;
			}
		} else if (!attributeCode.equals(other.attributeCode)) {
			return false;
		}
		if (attributeDataType == null) {
			if (other.attributeDataType != null) {
				return false;
			}
		} else if (!attributeDataType.equals(other.attributeDataType)) {
			return false;
		}
		if (attributeUom == null) {
			if (other.attributeUom != null) {
				return false;
			}
		} else if (!attributeUom.equals(other.attributeUom)) {
			return false;
		}
		if (attributeValue == null) {
			if (other.attributeValue != null) {
				return false;
			}
		} else if (!attributeValue.equals(other.attributeValue)) {
			return false;
		}
		
		return true;
	}

	@Override
	public String toString() {
		return "InspectionFormItemAttribute [id="
				+ id + ", attributeCode=" + attributeCode
				+ ", attributeUom=" + attributeUom + ", attributeValue="
				+ attributeValue + ", attributeDataType=" + attributeDataType
				+ "]";
	}

	@Override
	public int compareTo(InspectionFormEquipmentAttribute o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	
	
	
	
}
