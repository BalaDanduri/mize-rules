package com.mize.domain.common;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mize.domain.util.Formatter;

public class PaginationPage<T> implements Serializable {

	private static final long serialVersionUID = -3877742914755125667L;
	public static final Integer DEFAULT_PAGE_SIZE = 10;
	private int pageNumber;
	private int pagesAvailable;
	private List<T> pageItems = new ArrayList<T>();
	private long rowsAvailable;
	private Integer pageSize;
	private String orderBy;
	private String sortBy;
	
	public enum OrderBy{
		DESC,ASC;
	}

	public PaginationPage() {

	}

	public PaginationPage(int pageNumber, int pagesAvailable,
			List<T> pageItems, long rowsAvailable, Integer pageSize) {
		super();
		this.pageNumber = pageNumber;
		this.pagesAvailable = pagesAvailable;
		this.pageItems = pageItems;
		this.rowsAvailable = rowsAvailable;
		this.pageSize = pageSize;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public void setPagesAvailable(int pagesAvailable) {
		this.pagesAvailable = pagesAvailable;
	}

	public void setPageItems(List<T> pageItems) {
		this.pageItems = pageItems;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public int getPagesAvailable() {
		return pagesAvailable;
	}

	public List<T> getPageItems() {
		return pageItems;
	}

	public long getRowsAvailable() {
		return rowsAvailable;
	}

	public void setRowsAvailable(long rowsAvailable) {
		this.rowsAvailable = rowsAvailable;
	}

	public Integer getPageSize() {
		if (pageSize == null || pageSize == 0) {
			pageSize = DEFAULT_PAGE_SIZE;
		}
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@JsonIgnore
	public T getPage() {
		if (pageItems != null && pageItems.size() > 0) {
			return pageItems.get(0);
		}
		return null;
	}

	@JsonIgnore
	public void setPage(T page) {
		pageItems.add(page);
	}	
	@JsonIgnore
	public static int getDefaultPageSize(Integer pageSize){
		if(Formatter.intValue(pageSize) > 0){
			return pageSize;
		}else{
			return DEFAULT_PAGE_SIZE;
		}
	}

	@Override
	public String toString() {
		return "PaginationPage [pageNumber=" + pageNumber + ", pagesAvailable="
				+ pagesAvailable + ", rowsAvailable=" + rowsAvailable
				+ ", pageSize=" + pageSize + "]";
	}

	public String getOrderBy() {
		return orderBy;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}	
	
	
}