package zygh.yfb.wxy.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import zygh.yfb.wxy.mapper.CarBodyCMapper;
import zygh.yfb.wxy.mapper.DataSourceMapper;
import zygh.yfb.wxy.service.CarBodyCService;
import zygh.yfb.wxy.service.DataSourceService;
import zygh.yfb.wxy.vo.CarBodyC;
import zygh.yfb.wxy.vo.DataSource;

public class CarBodyCServiceimpl implements CarBodyCService {
	
	@Autowired
	private CarBodyCMapper carBodyCMapper;

	public List<CarBodyC> findCarBodyC(CarBodyC carBodyC) throws Exception {
		// TODO Auto-generated method stub
		return carBodyCMapper.findCarBodyC(carBodyC);
	}

	public void addCarBodyC(CarBodyC carBodyC) throws Exception {
		// TODO Auto-generated method stub
		carBodyCMapper.addCarBodyC(carBodyC);
	}

	public void deleteCarBodyC(Integer[] sysIds) throws Exception {
		// TODO Auto-generated method stub
		carBodyCMapper.deleteCarBodyC(sysIds);
	}

	public void updateCarBodyC(CarBodyC carBodyC) throws Exception {
		// TODO Auto-generated method stub
		carBodyCMapper.updateCarBodyC(carBodyC);
	}
	
	
	
}
