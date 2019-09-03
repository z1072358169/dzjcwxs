package zygh.yfb.wxy.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import zygh.yfb.wxy.mapper.CarLogoMapper;
import zygh.yfb.wxy.service.CarLogoService;
import zygh.yfb.wxy.vo.CarLogo;

public class CarLogoServiceimpl implements CarLogoService {
	
	@Autowired
	private CarLogoMapper carLogoMapper;

	public List<CarLogo> findCarLogo(CarLogo carLogo) throws Exception {
		// TODO Auto-generated method stub
		return carLogoMapper.findCarLogo(carLogo);
	}

	public void addCarLogo(CarLogo carLogo) throws Exception {
		// TODO Auto-generated method stub
		carLogoMapper.addCarLogo(carLogo);
	}

	public void deleteCarLogo(Integer[] sysIds) throws Exception {
		// TODO Auto-generated method stub
		carLogoMapper.deleteCarLogo(sysIds);
	}

	public void updateCarLogo(CarLogo carLogo) throws Exception {
		// TODO Auto-generated method stub
		carLogoMapper.updateCarLogo(carLogo);
	}

}
