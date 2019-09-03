package zygh.yfb.wxy.service;

import java.util.List;

import zygh.yfb.wxy.vo.ManufacturerNumber;


public interface ManufacturerNumberService {
	
    //查询信息
    public List<ManufacturerNumber> findManufacturerNumber(ManufacturerNumber manufacturerNumber)throws Exception;
    
    //按照厂商代码查询厂商名字
    public ManufacturerNumber findSM(String manufacturerId)throws Exception;
	
    //添加
	public void addManufacturerNumber(ManufacturerNumber manufacturerNumber)throws Exception;
	
	//删除
	public void deleteManufacturerNumber(Integer[] sysIds) throws Exception;
	
	//修改信息
	public void updateManufacturerNumber(ManufacturerNumber manufacturerNumber)throws Exception;
	
	
}
