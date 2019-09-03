package zygh.yfb.wxy.mapper;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import util.Page;
import zygh.yfb.wxy.vo.ManufacturerNumber;

/**
 * 号牌种类
 * @author 王喜亚
 *
 */
public interface ManufacturerNumberMapper {
	
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
