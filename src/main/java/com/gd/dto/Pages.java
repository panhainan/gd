/**
 * 
 */
package com.gd.dto;



/**
 * @author phn
 * 
 */
public class Pages {

	private int currentPage; // 当前页数
	private int pageSize; // 每页显示的记录数
	private int totalPages; // 总页数
	private int allRecords; // 总记录数

	private boolean isFirstPage; // 是否是第一页
	private boolean isFinalPage; // 是否是最后一页
	private boolean hasPreviousPage; // 是否有上一页
	private boolean hasNextPage; // 是否有下一页

	/**
	 * @param allRecords2
	 * @param judgedCurrentPage
	 * @param pageSize2
	 * @param totalPages2
	 */
	public Pages(int allRecords2, int currentPage2, int pageSize2,
			int totalPages2) {
		this.allRecords= allRecords2;
		this.currentPage=currentPage2;
		this.pageSize=pageSize2;
		this.totalPages=totalPages2;
		init();
	}


	/**
	 * TODO 初始化分页信息
	 * @param isFirstPage 
	 * @param hasPreviousPage 
	 * @param isFinalPage 
	 * @param hasNextPage 
	 */
	public void init() {
		if(this.currentPage==1){
			this.isFirstPage = true;
		}
		if(this.currentPage==this.totalPages){
			this.isFinalPage = true;
		}
		if(this.currentPage>1){
			this.hasPreviousPage= true;
		}
		if(this.currentPage<this.totalPages){
			this.hasNextPage= true;
		}
	}

	/**
	 * TODO 计算总页数
	 * @param pageSize:每页的记录数
	 * @param allRecords:总记录数
	 * @return 总页数
	 */
	public static int calculateTotalPage(final int pageSize,
			final int allRecords) {
		int total = (allRecords % pageSize == 0) ? allRecords / pageSize
				: allRecords / pageSize + 1;
		if (total == 0) {
			total = 1;
		}
		return total;
	}

	/**
	 * TODO 计算当前页的开始记录数
	 * @param pageSize:每页记录数
	 * @param currentPage:当前第几页
	 * @return 当前页开始记录数
	 */
	public static int currentPage_startRecord(final int pageSize,
			final int currentPage) {
		final int startRecord = pageSize * (currentPage - 1);
		return startRecord;
	}

	/**
	 * TODO 判断当前页是否为0
	 * @param page:当前页
	 * @return 判断当前页的结果
	 */
	public static int judgeCurrentPage(int page,int totalPages) {
		final int judgeCurrent = (page <= 0 || page > totalPages ) ? 0 : page;
		return judgeCurrent;
	}
	@Override
	public String toString() {
		return this.getClass().getName()+"[\n" +
				"\tcurrentPage:"+currentPage+"\n" +
				"\tpageSize:"+pageSize+"\n" +
				"\ttotalPages:"+totalPages+"\n" +
				"\tallRecords:"+allRecords+"\n" +
				"\tisFirstPage:"+isFirstPage+"\n" +
				"\tisFinalPage:"+isFinalPage+"\n" +
				"\thasPreviousPage:"+hasPreviousPage+"\n" +
				"\thasNextPage:"+hasNextPage+"\n" +
						"]";
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public int getPageSize() {
		return pageSize;
	}


	public int getTotalPages() {
		return totalPages;
	}


	public int getAllRecords() {
		return allRecords;
	}


	public boolean isFirstPage() {
		return isFirstPage;
	}


	public boolean isFinalPage() {
		return isFinalPage;
	}


	public boolean isHasPreviousPage() {
		return hasPreviousPage;
	}


	public boolean isHasNextPage() {
		return hasNextPage;
	}
	
	
}
