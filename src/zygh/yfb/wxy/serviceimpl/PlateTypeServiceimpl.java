package zygh.yfb.wxy.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import util.Page;
import zygh.yfb.wxy.mapper.PlateTypeMapper;
import zygh.yfb.wxy.service.PlateTypeService;
import zygh.yfb.wxy.vo.PlateType;


public class PlateTypeServiceimpl implements PlateTypeService {

	@Autowired
	private PlateTypeMapper plateTypeMapper;

	public List<PlateType> findPlateType(PlateType plateType) throws Exception {
		// TODO Auto-generated method stub
		return plateTypeMapper.findPlateType(plateType);
	}

	public void addPlateType(PlateType plateType) throws Exception {
		// TODO Auto-generated method stub
		plateTypeMapper.addPlateType(plateType);
	}

	public void deletePlateType(Integer[] sysIds) throws Exception {
		// TODO Auto-generated method stub
		plateTypeMapper.deletePlateType(sysIds);
	}

	public void updatePlateType(PlateType plateType) throws Exception {
		// TODO Auto-generated method stub
		plateTypeMapper.updatePlateType(plateType);
	}

	public List<PlateType> selectlicensePlateTypeCount(String licensePlateType)
			throws Exception {
		// TODO Auto-generated method stub
		return plateTypeMapper.selectlicensePlateTypeCount(licensePlateType);
	}

	public List<PlateType> selectpExplainCount(String pExplain) throws Exception {
		// TODO Auto-generated method stub
		return plateTypeMapper.selectpExplainCount(pExplain);
	}

}
