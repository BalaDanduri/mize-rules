package com.mize.domain.purchaseorder;

/*@Entity
@DiscriminatorValue("SalesOrder")
@Table(name = "purchase_order", uniqueConstraints = {@UniqueConstraint (columnNames = {"order_number","tenant_id"})})*/
public class SalesOrder extends PurchaseOrder {	
	private static final long serialVersionUID = 6676650598420396291L;
	
	//@Column(name = "prod_model")
	public String getSalesPerson() {
		return super.getSalesPerson();
	}

	public void setSalesPerson(String salesPerson) {
		super.setSalesPerson(salesPerson);
	}
}
