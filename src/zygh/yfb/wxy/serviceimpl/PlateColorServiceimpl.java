package zygh.yfb.wxy.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import zygh.yfb.wxy.mapper.PlateColorMapper;
import zygh.yfb.wxy.service.PlateColorService;
import zygh.yfb.wxy.vo.PlateColor;

public class PlateColorServiceimpl implements PlateColorService {
	
	@Autowired
	private PlateColorMapper plateColorMapper;

	public List<PlateColor> findPlateColor(PlateColor plateColor)
			throws Exception {
		// TODO Auto-generated method stub
		return plateColorMapper.findPlateColor(plateColor);
	}

	public void addPlateColor(PlateColor plateColor) throws Exception {
		// TODO Auto-generated method stub
		plateColorMapper.addPlateColor(plateColor);
	}

	public void deletePlateColor(Integer[] sysIds) throws Exception {
		// TODO Auto-generated method stub
		plateColorMapper.deletePlateColor(sysIds);
	}

	public void updatePlateColor(PlateColor plateColor) throws Exception {
		// TODO Auto-generated method stub
		plateColorMapper.updatePlateColor(plateColor);
	}

}
