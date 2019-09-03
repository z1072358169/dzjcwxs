package zygh.yfb.wxy.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zygh.yfb.wxy.mapper.SectorsMapper;
import zygh.yfb.wxy.service.SectorsService;
import zygh.yfb.wxy.vo.Sectors;


public class SectorsServiceimpl implements SectorsService {

	@Autowired
	private SectorsMapper sectorsMapper;
	
	public List<Sectors> findSectors(Sectors sectors) throws Exception {
		// TODO Auto-generated method stub
		return sectorsMapper.findSectors(sectors);
	}

	public void addSectors(Sectors sectors) throws Exception {
		// TODO Auto-generated method stub
		sectorsMapper.addSectors(sectors);
	}

	public void deleteSectors(Integer[] sectorsNums) throws Exception {
		// TODO Auto-generated method stub
		sectorsMapper.deleteSectors(sectorsNums);
	}

	public Sectors findSectorsByNum(Integer sectorsNum) throws Exception {
		// TODO Auto-generated method stub
		return sectorsMapper.findSectorsByNum(sectorsNum);
	}

	public void updateSectors(Sectors sectors) throws Exception {
		// TODO Auto-generated method stub
		sectorsMapper.updateSectors(sectors);
	}

}
