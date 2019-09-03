package zygh.yfb.wxy.mapper;

import java.util.List;
import zygh.yfb.wxy.vo.CarLogo;

/**
 * 车标表
 * @author 王喜亚
 *
 */
public interface CarLogoMapper {
	
    //查询信息
    public List<CarLogo> findCarLogo(CarLogo carLogo)throws Exception;
    
	//添加
	public void addCarLogo(CarLogo carLogo)throws Exception;
	
	//删除
	public void deleteCarLogo(Integer[] sysIds) throws Exception;
	
	//修改信息
	public void updateCarLogo(CarLogo carLogo)throws Exception;
	
	
}
