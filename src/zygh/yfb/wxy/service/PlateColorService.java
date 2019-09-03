package zygh.yfb.wxy.service;

import java.util.List;

import zygh.yfb.wxy.vo.PlateColor;


public interface PlateColorService {
	
    //查询信息
    public List<PlateColor> findPlateColor(PlateColor plateColor)throws Exception;
    
	//添加
	public void addPlateColor(PlateColor plateColor)throws Exception;
	
	//删除
	public void deletePlateColor(Integer[] sysIds) throws Exception;
	
	//修改信息
	public void updatePlateColor(PlateColor plateColor)throws Exception;
	
	
}
