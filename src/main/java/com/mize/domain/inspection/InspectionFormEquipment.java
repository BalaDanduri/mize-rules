package com.mize.domain.inspection;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.product.ProductRegistration;
import com.mize.domain.util.CachedEntity;
import com.mize.domain.util.JPASerializer;

@Entity
@Inheritance
@DiscriminatorColumn(name = "discriminator")
@DiscriminatorValue("InspectionFormEquipment")
@Table(name="insp_form_eqpmnt")
public class InspectionFormEquipment extends MizeSceEntity implements Comparable<InspectionFormEquipment> {

	
	private static final long serialVersionUID = -5051962833279097787L;

	private InspectionForm inspectionForm;
	private ProductRegistration productRegistration;
	private Long   equipmentId;
	private String equipmentType;
	private String equipmentCode;
	private Long equipmentBrandId;
	private String equipmentBrand;
	private String equipmentBrandName;
	private Long equipmentCategoryId;
	private String equipmentCategory;
	private String equipmentCategoryName;
	private Long equipmentSerialId;
	private String equipmentSerial;
	private String equipmentModel;
	private String equipmentName;
	private String equipmentDescription;
	private String equipmentReference;
	private Long productRegistrationId;
	private List<InspectionFormEquipmentAttribute> equipmentAttributes = new ArrayList<InspectionFormEquipmentAttribute>();
	@CachedEntity
	private InspectionFormEquipmentOwner equipmentOwner;
	
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "insp_form_id")
	@JsonBackReference(value="insp_form_eqpmnt")
	@JsonSerialize(using=JPASerializer.class)
	public InspectionForm getInspectionForm() {
		return inspectionForm;
	}

	public void setInspectionForm(InspectionForm inspectionForm) {
		this.inspectionForm = inspectionForm;
	}

	@Column(name = "eqpmnt_id")
	public Long getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(Long equipmentId) {
		this.equipmentId = equipmentId;
	}

	@Column(name = "eqpmnt_type")
	public String getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}

	@Column(name = "eqpmnt_code")
	public String getEquipmentCode() {
		return equipmentCode;
	}
	
	public void setEquipmentCode(String equipmentCode) {
		this.equipmentCode = equipmentCode;
	}

	@Column(name = "eqpmnt_brand")
	public String getEquipmentBrand() {
		return equipmentBrand;
	}

	public void setEquipmentBrand(String equipmentBrand) {
		this.equipmentBrand = equipmentBrand;
	}

	@Column(name = "eqpmnt_category")
	public String getEquipmentCategory() {
		return equipmentCategory;
	}

	public void setEquipmentCategory(String equipmentCategory) {
		this.equipmentCategory = equipmentCategory;
	}

	@Column(name = "eqpmnt_serial")
	public String getEquipmentSerial() {
		return equipmentSerial;
	}

	public void setEquipmentSerial(String equipmentSerial) {
		this.equipmentSerial = equipmentSerial;
	}

	@Column(name = "eqpmnt_model")
	public String getEquipmentModel() {
		return equipmentModel;
	}

	public void setEquipmentModel(String equipmentModel) {
		this.equipmentModel = equipmentModel;
	}

	@Column(name = "eqpmnt_name")
	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	@Column(name = "eqpmnt_description")
	public String getEquipmentDescription() {
		return equipmentDescription;
	}

	public void setEquipmentDescription(String equipmentDescription) {
		this.equipmentDescription = equipmentDescription;
	}

	@Column(name = "eqpmnt_reference")
	public String getEquipmentReference() {
		return equipmentReference;
	}

	public void setEquipmentReference(String equipmentReference) {
		this.equipmentReference = equipmentReference;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "inspectionFormEquipment" , orphanRemoval = true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonManagedReference(value="insp_eqpmnt_attr")
	@JsonInclude(Include.NON_EMPTY)
	public List<InspectionFormEquipmentAttribute> getEquipmentAttributes() {
		return equipmentAttributes;
	}

	public void setEquipmentAttributes(List<InspectionFormEquipmentAttribute> equipmentAttributes) {
		this.equipmentAttributes = equipmentAttributes;
	}

	@OneToOne(mappedBy = "inspectionFormEquipment",cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference(value = "insp_eqpmnt_owner")
	@JsonSerialize(using=JPASerializer.class)
	public InspectionFormEquipmentOwner getEquipmentOwner() {
		return equipmentOwner;
	}

	public void setEquipmentOwner(InspectionFormEquipmentOwner equipmentOwner) {
		this.equipmentOwner = equipmentOwner;
	}

	@Column(name="eqpmnt_brand_id")
	public Long getEquipmentBrandId() {
		return equipmentBrandId;
	}

	public void setEquipmentBrandId(Long equipmentBrandId) {
		this.equipmentBrandId = equipmentBrandId;
	}

	@Column(name="eqpmnt_brand_name")
	public String getEquipmentBrandName() {
		return equipmentBrandName;
	}

	public void setEquipmentBrandName(String equipmentBrandName) {
		this.equipmentBrandName = equipmentBrandName;
	}

	@Column(name="eqpmnt_category_id")
	public Long getEquipmentCategoryId() {
		return equipmentCategoryId;
	}

	public void setEquipmentCategoryId(Long equipmentCategoryId) {
		this.equipmentCategoryId = equipmentCategoryId;
	}

	@Column(name="eqpmnt_category_name")
	public String getEquipmentCategoryName() {
		return equipmentCategoryName;
	}

	public void setEquipmentCategoryName(String equipmentCategoryName) {
		this.equipmentCategoryName = equipmentCategoryName;
	}

	@Column(name="eqpmnt_serial_id")
	public Long getEquipmentSerialId() {
		return equipmentSerialId;
	}

	public void setEquipmentSerialId(Long equipmentSerialId) {
		this.equipmentSerialId = equipmentSerialId;
	}

	@Column(name="eqpmnt_regn_id")
	public Long getProductRegistrationId() {
		return productRegistrationId;
	}

	public void setProductRegistrationId(Long productRegistrationId) {
		this.productRegistrationId = productRegistrationId;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((equipmentAttributes == null) ? 0 : equipmentAttributes.hashCode());
		result = prime * result + ((equipmentBrand == null) ? 0 : equipmentBrand.hashCode());
		result = prime * result + ((equipmentBrandId == null) ? 0 : equipmentBrandId.hashCode());
		result = prime * result + ((equipmentBrandName == null) ? 0 : equipmentBrandName.hashCode());
		result = prime * result + ((equipmentCategory == null) ? 0 : equipmentCategory.hashCode());
		result = prime * result + ((equipmentCategoryId == null) ? 0 : equipmentCategoryId.hashCode());
		result = prime * result + ((equipmentCategoryName == null) ? 0 : equipmentCategoryName.hashCode());
		result = prime * result + ((equipmentCode == null) ? 0 : equipmentCode.hashCode());
		result = prime * result + ((equipmentDescription == null) ? 0 : equipmentDescription.hashCode());
		result = prime * result + ((equipmentId == null) ? 0 : equipmentId.hashCode());
		result = prime * result + ((equipmentModel == null) ? 0 : equipmentModel.hashCode());
		result = prime * result + ((equipmentName == null) ? 0 : equipmentName.hashCode());
		result = prime * result + ((equipmentOwner == null) ? 0 : equipmentOwner.hashCode());
		result = prime * result + ((equipmentReference == null) ? 0 : equipmentReference.hashCode());
		result = prime * result + ((equipmentSerial == null) ? 0 : equipmentSerial.hashCode());
		result = prime * result + ((equipmentSerialId == null) ? 0 : equipmentSerialId.hashCode());
		result = prime * result + ((equipmentType == null) ? 0 : equipmentType.hashCode());
		result = prime * result + ((productRegistrationId == null) ? 0 : productRegistrationId.hashCode());
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
		InspectionFormEquipment other = (InspectionFormEquipment) obj;
		if (equipmentAttributes == null) {
			if (other.equipmentAttributes != null)
				return false;
		} else if (!equipmentAttributes.equals(other.equipmentAttributes))
			return false;
		if (equipmentBrand == null) {
			if (other.equipmentBrand != null)
				return false;
		} else if (!equipmentBrand.equals(other.equipmentBrand))
			return false;
		if (equipmentBrandId == null) {
			if (other.equipmentBrandId != null)
				return false;
		} else if (!equipmentBrandId.equals(other.equipmentBrandId))
			return false;
		if (equipmentBrandName == null) {
			if (other.equipmentBrandName != null)
				return false;
		} else if (!equipmentBrandName.equals(other.equipmentBrandName))
			return false;
		if (equipmentCategory == null) {
			if (other.equipmentCategory != null)
				return false;
		} else if (!equipmentCategory.equals(other.equipmentCategory))
			return false;
		if (equipmentCategoryId == null) {
			if (other.equipmentCategoryId != null)
				return false;
		} else if (!equipmentCategoryId.equals(other.equipmentCategoryId))
			return false;
		if (equipmentCategoryName == null) {
			if (other.equipmentCategoryName != null)
				return false;
		} else if (!equipmentCategoryName.equals(other.equipmentCategoryName))
			return false;
		if (equipmentCode == null) {
			if (other.equipmentCode != null)
				return false;
		} else if (!equipmentCode.equals(other.equipmentCode))
			return false;
		if (equipmentDescription == null) {
			if (other.equipmentDescription != null)
				return false;
		} else if (!equipmentDescription.equals(other.equipmentDescription))
			return false;
		if (equipmentId == null) {
			if (other.equipmentId != null)
				return false;
		} else if (!equipmentId.equals(other.equipmentId))
			return false;
		if (equipmentModel == null) {
			if (other.equipmentModel != null)
				return false;
		} else if (!equipmentModel.equals(other.equipmentModel))
			return false;
		if (equipmentName == null) {
			if (other.equipmentName != null)
				return false;
		} else if (!equipmentName.equals(other.equipmentName))
			return false;
		if (equipmentOwner == null) {
			if (other.equipmentOwner != null)
				return false;
		} else if (!equipmentOwner.equals(other.equipmentOwner))
			return false;
		if (equipmentReference == null) {
			if (other.equipmentReference != null)
				return false;
		} else if (!equipmentReference.equals(other.equipmentReference))
			return false;
		if (equipmentSerial == null) {
			if (other.equipmentSerial != null)
				return false;
		} else if (!equipmentSerial.equals(other.equipmentSerial))
			return false;
		if (equipmentSerialId == null) {
			if (other.equipmentSerialId != null)
				return false;
		} else if (!equipmentSerialId.equals(other.equipmentSerialId))
			return false;
		if (equipmentType == null) {
			if (other.equipmentType != null)
				return false;
		} else if (!equipmentType.equals(other.equipmentType))
			return false;
		if (productRegistrationId == null) {
			if (other.productRegistrationId != null)
				return false;
		} else if (!productRegistrationId.equals(other.productRegistrationId))
			return false;
		return true;
	}

	@JsonIgnore
	@Transient
	public ProductRegistration getProductRegistration() {
		return productRegistration;
	}

	public void setProductRegistration(ProductRegistration productRegistration) {
		this.productRegistration = productRegistration;
	}

	@Override
	public String toString() {
		return "InspectionFormEquipment [equipmentId=" + equipmentId + ", equipmentType=" + equipmentType + ", equipmentCode=" + equipmentCode 
				+ ", equipmentBrandId=" + equipmentBrandId + ", equipmentBrand=" + equipmentBrand + ", equipmentBrandName=" + equipmentBrandName 
				+ ", equipmentCategoryId=" + equipmentCategoryId + ", equipmentCategory=" + equipmentCategory 
				+ ", equipmentCategoryName=" + equipmentCategoryName + ", equipmentSerialId=" + equipmentSerialId 
				+ ", equipmentSerial=" + equipmentSerial + ", equipmentModel=" + equipmentModel + ", equipmentName=" + equipmentName 
				+ ", equipmentDescription=" + equipmentDescription + ", equipmentReference=" + equipmentReference 
				+ ", productRegistrationId=" + productRegistrationId + ", equipmentAttributes=" + equipmentAttributes 
				+ ", equipmentOwner=" + equipmentOwner + "]";
	}

	@Override
	public int compareTo(InspectionFormEquipment arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
