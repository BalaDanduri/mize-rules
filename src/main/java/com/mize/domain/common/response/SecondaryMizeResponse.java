package com.mize.domain.common.response;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"meta","rel","items"})
public class SecondaryMizeResponse {
	private ResponseMeta meta = new ResponseMeta();
	private List<ResponseLink>  rels = new ArrayList<ResponseLink>();
	private List<Object> items;
	
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
	public List<Object> getItems() {
		return items;
	}
	public void setItems(List<Object> items) {
		this.items = items;
	}

	public SecondaryMizeResponse(ResponseMeta meta, List<ResponseLink> rels, List<Object> items) {
		this.meta = meta;
		this.rels = rels;
		this.items = items;
	}
	
	public SecondaryMizeResponse() {
	}

	public SecondaryMizeResponse(String request) {
		meta.setRequest(request);
	}
}
