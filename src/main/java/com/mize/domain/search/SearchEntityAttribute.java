package com.mize.domain.search;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mize.domain.common.MizeEntity;

@Entity
@Table(name = "search_entity_attribute")
public class SearchEntityAttribute extends MizeEntity {

	private static final long serialVersionUID = -5771429113064408520L;
	private Long id;
	private Long searchEntityId;
	private String name;
	private String label;
	private String description;
	private boolean isSearchable;
	private String type;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", unique = true)
	@Override
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "search_entity_id")
	public Long getSearchEntityId() {
		return searchEntityId;
	}
	public void setSearchEntityId(Long searchEntityId) {
		this.searchEntityId = searchEntityId;
	}
	
	@Column(name = "name", length = 100)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "label", length = 100)
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	@Column(name = "description", length = 1000)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "searchable")
	public boolean isSearchable() {
		return isSearchable;
	}
	public void setSearchable(boolean isSearchable) {
		this.isSearchable = isSearchable;
	}
	@Column(name = "type", length = 20)
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "SearchEntityAttribute [id=" + id + ", searchEntityId="
				+ searchEntityId + ", name=" + name + ", label=" + label
				+ ", description=" + description + ", isSearchable="
				+ isSearchable + ", type=" + type + "]";
	}
}
