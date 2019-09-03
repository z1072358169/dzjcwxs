package zygh.yfb.wxy.service;

import java.util.List;

import zygh.yfb.wxy.vo.IllegaDatasource;


public interface IllegaDatasourceService {
	
    //查询信息
    public List<IllegaDatasource> findIllegaDatasource(IllegaDatasource illegaDatasource)throws Exception;
    
	//添加
	public void addIllegaDatasource(IllegaDatasource illegaDatasource)throws Exception;
	
	//删除
	public void deleteIllegaDatasource(Integer[] sysIds) throws Exception;
	
	//修改信息
	public void updateIllegaDatasource(IllegaDatasource illegaDatasource)throws Exception;
	
	
}
