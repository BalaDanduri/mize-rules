package com.mize.domain.common.response;

import java.util.ArrayList;
import java.util.List;

import com.mize.domain.common.MizeEntity;

public class MizeResponse {
	private ResponseMeta meta;
	private List<ResponseLink>  rels;
	private List<? extends MizeEntity> items;
	
	public ResponseMeta getMeta() {
		return meta;
	}
	public void setMeta(ResponseMeta meta) {
		this.meta = meta;
	}
	public List<ResponseLink> getRels() {
		return rels;
	}
	public void setRels(List<ResponseLink> rels) {
		this.rels = rels;
	}
	public List<? extends MizeEntity> getItems() {
		return items;
	}
	public void setItems(List<? extends MizeEntity> items) {
		this.items = items;
	}

	public MizeResponse(ResponseMeta meta, List<ResponseLink> rels, List<? extends MizeEntity>items) {
		this.meta = meta;
		this.rels = rels;
		this.items = items;
	}
	
	public MizeResponse() {
		meta = new ResponseMeta();
		rels = new ArrayList<ResponseLink>();
	}

}
