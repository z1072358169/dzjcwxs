package zygh.yfb.wxy.mapper;

import java.util.List;
import zygh.yfb.wxy.vo.CarBodyC;

/**
 * 车身颜色
 * @author 王喜亚
 *
 */
public interface CarBodyCMapper {
	
    //查询信息
    public List<CarBodyC> findCarBodyC(CarBodyC carBodyC)throws Exception;
    
	//添加
	public void addCarBodyC(CarBodyC carBodyC)throws Exception;
	
	//删除
	public void deleteCarBodyC(Integer[] sysIds) throws Exception;
	
	//修改信息
	public void updateCarBodyC(CarBodyC carBodyC)throws Exception;
	
	
}
