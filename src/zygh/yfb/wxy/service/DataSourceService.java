package zygh.yfb.wxy.service;

import java.util.List;

import zygh.yfb.wxy.vo.DataSource;


public interface DataSourceService {
	
    //查询信息
    public List<DataSource> findDataSource(DataSource dataSource)throws Exception;
    
	//添加
	public void addDataSource(DataSource dataSource)throws Exception;
	
	//删除
	public void deleteDataSource(Integer[] sysIds) throws Exception;
	
	//修改信息
	public void updateDataSource(DataSource dataSource)throws Exception;
	
	
}
