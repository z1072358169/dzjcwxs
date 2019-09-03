package zygh.yfb.wxy.service;

import java.util.List;

import zygh.yfb.wxy.vo.CarBodyC;

public interface CarBodyCService {

    //查询信息
    public List<CarBodyC> findCarBodyC(CarBodyC carBodyC)throws Exception;
    
	//添加
	public void addCarBodyC(CarBodyC carBodyC)throws Exception;
	
	//删除
	public void deleteCarBodyC(Integer[] sysIds) throws Exception;
	
	//修改信息
	public void updateCarBodyC(CarBodyC carBodyC)throws Exception;
}
