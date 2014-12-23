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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mize.domain.common.MizeAuditEntity;
/**
 * @author Raghavendra Serikar
 * @version 1.0
 */
@Entity
@Table(name="goodwill_audit")
public class GoodwillAudit extends MizeAuditEntity implements Comparable<GoodwillAudit>{
	private static final long serialVersionUID = -4806940799417432658L;
	private Goodwill goodwill;
	
	public GoodwillAudit(){
		goodwill = new Goodwill();
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
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

	public void setGoodwill(Goodwill goodwill) {
		this.goodwill = goodwill;
	}
	
	@Override
	public int compareTo(GoodwillAudit o) {
		return 0;
	}

}
