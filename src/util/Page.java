package util;

import zygh.yfb.wxy.vo.PlateType;

public class Page extends PlateType{
	
	  
    private int pageNow = 1; // 当前页数  
  
    private int pageSize = 10; // 每页显示记录的条数  
  
    private long totalCount; // 总的记录条数  
  
    private int totalPageCount; // 总的页数  
    
    private int start;
    
    //页数
	public void cp(){
		if(this.totalCount%this.pageSize>0){
			this.totalPageCount = (int) (this.totalCount/this.pageSize+1);
		}else if(this.totalCount%this.pageSize==0){
			this.totalPageCount = (int) (this.totalCount/this.pageSize);
		}else{
			this.totalPageCount=1;
		}
	}
  	
  	//每页第一条数据
  	public int Start(){
  		return (this.pageNow-1)*this.pageSize;
  	}
  	//每页最后一条数据
  	public int End(){
  		return this.pageNow*this.pageSize;
  	}
    

	public Page() {
		super();
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	@Override
	public String toString() {
		return "Page [pageNow=" + pageNow + ", pageSize=" + pageSize
				+ ", totalCount=" + totalCount + ", totalPageCount="
				+ totalPageCount + ", start=" + start + "]";
	}


	
  
}
