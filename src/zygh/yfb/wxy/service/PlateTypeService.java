package zygh.yfb.wxy.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import zygh.yfb.wxy.vo.PlateType;


public interface PlateTypeService {
	
    //查询信息
    List<PlateType> findPlateType(PlateType plateType)throws Exception;
    
	//添加
	public void addPlateType(PlateType plateType)throws Exception;
	
	//删除
	public void deletePlateType(Integer[] sysIds) throws Exception;
	
	//修改信息
	public void updatePlateType(PlateType plateType)throws Exception;
	
	public List<PlateType> selectlicensePlateTypeCount(String licensePlateType)throws Exception;
	
	public List<PlateType> selectpExplainCount(String pExplain)throws Exception;
	
}
