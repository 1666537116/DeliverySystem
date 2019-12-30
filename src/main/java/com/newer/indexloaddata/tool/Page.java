package com.newer.indexloaddata.tool;

import com.newer.indexloaddata.domian.Merchants;

import java.io.Serializable;
import java.util.List;

public class Page implements Serializable{
	

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private int currentPage;//当前页
		private int pageSize;//每页显示记录数
		private int totalRecord;//总记录数
		private int totalPage;//总页数
		private List<?> data;//当前页的数据
	     private Merchants merchants;

	public Merchants getMerchants() {
		return merchants;
	}

	public void setMerchants(Merchants merchants) {
		this.merchants = merchants;
	}

	public int getCurrentPage() {
			return currentPage;
		}
		public void setCurrentPage(int currentPage) {

			this.currentPage = currentPage;
		}
		public int getPageSize() {

			return pageSize;
		}
		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}
		public int getTotalRecord() {
			return totalRecord;
		}
		public void setTotalRecord(int totalRecord) {
			this.totalRecord = totalRecord;
		}
		public int getTotalPage() {
			return totalPage;
		}
		public void setTotalPage(int totalPage) {
			this.totalPage = totalPage;
		}
		public List<?> getData() {
			return data;
		}
		public void setData(List<?> data) {
			this.data = data;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		@Override
		public String toString() {
			return "Page [currentPage=" + currentPage + ", pageSize=" + pageSize + ", totalRecord=" + totalRecord
					+ ", totalPage=" + totalPage + ", data=" + data + "]";
		}
		
		
		
	}


