package com.mize.domain.common;
import java.util.ArrayList;
import java.util.List;

public class PaginationPage<E> {

		private final Integer DEFAULT_PAGE_SIZE = 10;
        private int pageNumber;
        private int pagesAvailable;
        private List<E> pageItems = new ArrayList<E>();
        private long rowsAvailable;
        private Integer pageSize;
        
        public PaginationPage() {
        	
        }
        
        public PaginationPage(int pageNumber, int pagesAvailable,
    			List<E> pageItems, long rowsAvailable, Integer pageSize) {
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

        public void setPageItems(List<E> pageItems) {
            this.pageItems = pageItems;
        }

        public int getPageNumber() {
            return pageNumber;
        }

        public int getPagesAvailable() {
            return pagesAvailable;
        }

        public List<E> getPageItems() {
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
    }