package com.mize.domain.assets;

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
import com.mize.domain.common.MizeSceEntity;

@Entity
@Table(name="asset_model")
public class AssetModel extends MizeSceEntity implements Comparable<AssetModel>{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7732365706866028863L;
	private MizeAsset asset;
	private String series;
	private String model;	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mize_asset_id")
	@JsonBackReference(value ="assetModel")
	public MizeAsset getAsset() {
		return asset;
	}

	public void setAsset(MizeAsset asset) {
		this.asset = asset;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	@Override
	public int compareTo(AssetModel asset) {
		if ( this == asset ) 
			return EQUAL;
		else if (this.id < asset.id) 
			return BEFORE;
		else if (asset.id == this.id) 
			return EQUAL;
		else if (this.id > asset.id)
			return AFTER;
		return EQUAL;
	}

}
