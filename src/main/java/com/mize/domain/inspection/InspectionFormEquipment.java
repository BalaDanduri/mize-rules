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
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.product.ProductRegistration;
import com.mize.domain.util.JPASerializer;

@Entity
@Inheritance
@DiscriminatorColumn(name = "discriminator")
@DiscriminatorValue("InspectionFormEquipment")
@Table(name="insp_form_eqpmnt")
public class InspectionFormEquipment extends MizeEntity {

	
	private static final long serialVersionUID = -5051962833279097787L;

	private InspectionForm inspectionForm;
	private ProductRegistration productRegistration;
	private Long   equipmentId;
	private String equipmentType;
	private String equipmentCode;
	private String equipmentBrand;
	private String equipmentCategory;
	private String equipmentSerial;
	private String equipmentModel;
	private String equipmentName;
	private String equipmentDescription;
	private String equipmentReference;
	private List<InspectionFormEquipmentAttribute> equipmentAttributes = new ArrayList<InspectionFormEquipmentAttribute>();
	private InspectionFormEquipmentOwner equipmentOwner;
	
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
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

	@Column(name = "eqpmnt_type",length=50)
	public String getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}

	@Column(name = "eqpmnt_code",length =100)
	public String getEquipmentCode() {
		return equipmentCode;
	}
	
	public void setEquipmentCode(String equipmentCode) {
		this.equipmentCode = equipmentCode;
	}

	@Column(name = "eqpmnt_brand",length =250)
	public String getEquipmentBrand() {
		return equipmentBrand;
	}

	public void setEquipmentBrand(String equipmentBrand) {
		this.equipmentBrand = equipmentBrand;
	}

	@Column(name = "eqpmnt_category" ,length =250)
	public String getEquipmentCategory() {
		return equipmentCategory;
	}

	public void setEquipmentCategory(String equipmentCategory) {
		this.equipmentCategory = equipmentCategory;
	}

	@Column(name = "eqpmnt_serial",length =200)
	public String getEquipmentSerial() {
		return equipmentSerial;
	}

	public void setEquipmentSerial(String equipmentSerial) {
		this.equipmentSerial = equipmentSerial;
	}

	@Column(name = "eqpmnt_model",length =50)
	public String getEquipmentModel() {
		return equipmentModel;
	}

	public void setEquipmentModel(String equipmentModel) {
		this.equipmentModel = equipmentModel;
	}

	@Column(name = "eqpmnt_name",length=250)
	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	@Column(name = "eqpmnt_description" ,length=500)
	public String getEquipmentDescription() {
		return equipmentDescription;
	}

	public void setEquipmentDescription(String equipmentDescription) {
		this.equipmentDescription = equipmentDescription;
	}

	@Column(name = "eqpmnt_reference",length=100)
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

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((equipmentAttributes == null) ? 0 : equipmentAttributes.hashCode());
		result = prime * result
				+ ((equipmentBrand == null) ? 0 : equipmentBrand.hashCode());
		result = prime * result
				+ ((equipmentCategory == null) ? 0 : equipmentCategory.hashCode());
		result = prime * result
				+ ((inspectionForm == null) ? 0 : inspectionForm.hashCode());
		result = prime * result
				+ ((equipmentDescription == null) ? 0 : equipmentDescription.hashCode());
		result = prime * result + ((equipmentId == null) ? 0 : equipmentId.hashCode());
		result = prime * result
				+ ((equipmentName == null) ? 0 : equipmentName.hashCode());
		result = prime * result
				+ ((equipmentCode == null) ? 0 : equipmentCode.hashCode());
		result = prime * result
				+ ((equipmentType == null) ? 0 : equipmentType.hashCode());
		result = prime * result + ((equipmentModel == null) ? 0 : equipmentModel.hashCode());
		result = prime * result + ((equipmentOwner == null) ? 0 : equipmentOwner.hashCode());
		result = prime * result
				+ ((equipmentReference == null) ? 0 : equipmentReference.hashCode());
		result = prime * result
				+ ((equipmentSerial == null) ? 0 : equipmentSerial.hashCode());
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
		if (!(obj instanceof InspectionFormEquipment)) {
			return false;
		}
		InspectionFormEquipment other = (InspectionFormEquipment) obj;
		if (equipmentAttributes == null) {
			if (other.equipmentAttributes != null) {
				return false;
			}
		} else if (!equipmentAttributes.equals(other.equipmentAttributes)) {
			return false;
		}
		if (equipmentBrand == null) {
			if (other.equipmentBrand != null) {
				return false;
			}
		} else if (!equipmentBrand.equals(other.equipmentBrand)) {
			return false;
		}
		if (equipmentCategory == null) {
			if (other.equipmentCategory != null) {
				return false;
			}
		} else if (!equipmentCategory.equals(other.equipmentCategory)) {
			return false;
		}
		if (inspectionForm == null) {
			if (other.inspectionForm != null) {
				return false;
			}
		} else {
			if(inspectionForm.getId() == null) {
				if(other.inspectionForm.getId() != null)
					return false;
			} else if(!inspectionForm.getId().equals(other.inspectionForm.getId()))
				return false;
		} 
		if (equipmentDescription == null) {
			if (other.equipmentDescription != null) {
				return false;
			}
		} else if (!equipmentDescription.equals(other.equipmentDescription)) {
			return false;
		}
		if (equipmentId == null) {
			if (other.equipmentId != null) {
				return false;
			}
		} else if (!equipmentId.equals(other.equipmentId)) {
			return false;
		}
		if (equipmentName == null) {
			if (other.equipmentName != null) {
				return false;
			}
		} else if (!equipmentName.equals(other.equipmentName)) {
			return false;
		}
		if (equipmentCode == null) {
			if (other.equipmentCode != null) {
				return false;
			}
		} else if (!equipmentCode.equals(other.equipmentCode)) {
			return false;
		}
		if (equipmentType == null) {
			if (other.equipmentType != null) {
				return false;
			}
		} else if (!equipmentType.equals(other.equipmentType)) {
			return false;
		}
		if (equipmentModel == null) {
			if (other.equipmentModel != null) {
				return false;
			}
		} else if (!equipmentModel.equals(other.equipmentModel)) {
			return false;
		}
		if (equipmentOwner == null) {
			if (other.equipmentOwner != null) {
				return false;
			}
		} else {
			if(equipmentOwner.getId() == null) {
				if(other.equipmentOwner.getId() != null)
					return false;
			} else if(!equipmentOwner.getId().equals(other.equipmentOwner.getId()))
				return false;
		} 
		if (equipmentReference == null) {
			if (other.equipmentReference != null) {
				return false;
			}
		} else if (!equipmentReference.equals(other.equipmentReference)) {
			return false;
		}
		if (equipmentSerial == null) {
			if (other.equipmentSerial != null) {
				return false;
			}
		} else if (!equipmentSerial.equals(other.equipmentSerial)) {
			return false;
		}
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

	
	
	
}
