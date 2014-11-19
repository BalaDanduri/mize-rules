package com.mize.domain.product;

import java.util.ArrayList;
import java.util.List;

import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.EntityComment;
import com.mize.domain.common.MizeSceEntity;

public class BulkProductRegistrationTransfer extends MizeSceEntity implements Comparable<BulkProductRegistrationTransfer> {
	
	private static final long serialVersionUID = -6823485629435457415L;
	
	private BusinessEntity fromInvoiceBE;
	private BusinessEntity toInvoiceBE;
	private EntityComment entityComment;
	private List<ProductRegistration> productRegistrations = new ArrayList<ProductRegistration>();
	private User user;
	private Long recordCount;
	
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public BulkProductRegistrationTransfer() {
	}

	public BusinessEntity getFromInvoiceBE() {
		return fromInvoiceBE;
	}

	public BusinessEntity getToInvoiceBE() {
		return toInvoiceBE;
	}

	public EntityComment getEntityComment() {
		return entityComment;
	}

	public List<ProductRegistration> getProductRegistrations() {
		return productRegistrations;
	}

	public User getUser() {
		return user;
	}

	public void setFromInvoiceBE(BusinessEntity fromInvoiceBE) {
		this.fromInvoiceBE = fromInvoiceBE;
	}

	public void setToInvoiceBE(BusinessEntity toInvoiceBE) {
		this.toInvoiceBE = toInvoiceBE;
	}

	public void setEntityComment(EntityComment entityComment) {
		this.entityComment = entityComment;
	}

	public void setProductRegistrations(List<ProductRegistration> productRegistrations) {
		this.productRegistrations = productRegistrations;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

	public Long getRecordCount() {
		return recordCount;
	}


	public void setRecordCount(Long recordCount) {
		this.recordCount = recordCount;
	}


	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((fromInvoiceBE == null) ? 0 : fromInvoiceBE.hashCode());
		result = prime
				* result
				+ ((productRegistrations == null) ? 0 : productRegistrations
						.hashCode());
		result = prime * result
				+ ((toInvoiceBE == null) ? 0 : toInvoiceBE.hashCode());
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
		if (!(obj instanceof BulkProductRegistrationTransfer)) {
			return false;
		}
		BulkProductRegistrationTransfer other = (BulkProductRegistrationTransfer) obj;
		if (fromInvoiceBE == null) {
			if (other.fromInvoiceBE != null) {
				return false;
			}
		} else if (!fromInvoiceBE.equals(other.fromInvoiceBE)) {
			return false;
		}
		if (productRegistrations == null) {
			if (other.productRegistrations != null) {
				return false;
			}
		} else if (!productRegistrations.containsAll(other.productRegistrations)) {
			return false;
		}
		if (toInvoiceBE == null) {
			if (other.toInvoiceBE != null) {
				return false;
			}
		} else if (!toInvoiceBE.equals(other.toInvoiceBE)) {
			return false;
		}
		return true;
	}

	
	@Override
	public String toString() {
		return "BulkProductRegistrationTransfer [fromInvoiceBE="
				+ fromInvoiceBE + ", toInvoiceBE=" + toInvoiceBE
				+ ", entityComment=" + entityComment
				+ ", productRegistrations=" + productRegistrations + ", user="
				+ user + "]";
	}

	@Override
	public int compareTo(BulkProductRegistrationTransfer o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

	

	

}
