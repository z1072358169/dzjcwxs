package zygh.yfb.wxy.mapper;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import util.Page;
import zygh.yfb.wxy.vo.PlateType;

/**
 * 号牌种类
 * @author 王喜亚
 *
 */
public interface PlateTypeMapper {
	
    //查询信息
    public List<PlateType> findPlateType(PlateType plateType)throws Exception;
    
	//添加
	public void addPlateType(PlateType plateType)throws Exception;
	
	//删除
	public void deletePlateType(Integer[] sysIds) throws Exception;
	
	//修改信息
	public void updatePlateType(PlateType plateType)throws Exception;
	
	public List<PlateType> selectlicensePlateTypeCount(String licensePlateType)throws Exception;
	
	public List<PlateType> selectpExplainCount(String pExplain)throws Exception;
	
}
