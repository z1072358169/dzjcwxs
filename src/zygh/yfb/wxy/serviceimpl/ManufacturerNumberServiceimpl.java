package zygh.yfb.wxy.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import zygh.yfb.wxy.mapper.ManufacturerNumberMapper;
import zygh.yfb.wxy.service.ManufacturerNumberService;
import zygh.yfb.wxy.vo.ManufacturerNumber;

public class ManufacturerNumberServiceimpl implements ManufacturerNumberService {
	
	@Autowired
	private ManufacturerNumberMapper manufacturerNumberServiceMapper;

	public List<ManufacturerNumber> findManufacturerNumber(
			ManufacturerNumber manufacturerNumber) throws Exception {
		// TODO Auto-generated method stub
		return manufacturerNumberServiceMapper.findManufacturerNumber(manufacturerNumber);
	}

	public void addManufacturerNumber(ManufacturerNumber manufacturerNumber)
			throws Exception {
		// TODO Auto-generated method stub
		manufacturerNumberServiceMapper.addManufacturerNumber(manufacturerNumber);
	}

	public void deleteManufacturerNumber(Integer[] sysIds) throws Exception {
		// TODO Auto-generated method stub
		manufacturerNumberServiceMapper.deleteManufacturerNumber(sysIds);
	}

	public void updateManufacturerNumber(ManufacturerNumber manufacturerNumber)
			throws Exception {
		// TODO Auto-generated method stub
		manufacturerNumberServiceMapper.updateManufacturerNumber(manufacturerNumber);
	}

	public ManufacturerNumber findSM(String manufacturerId) throws Exception {
		// TODO Auto-generated method stub
		return manufacturerNumberServiceMapper.findSM(manufacturerId);
	}

}
