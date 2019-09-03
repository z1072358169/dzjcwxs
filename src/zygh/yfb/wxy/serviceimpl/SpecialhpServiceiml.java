package zygh.yfb.wxy.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import zygh.yfb.wxy.mapper.SpecialhpMapper;
import zygh.yfb.wxy.service.SpecialhpService;
import zygh.yfb.wxy.vo.Specialhp;

public class SpecialhpServiceiml implements SpecialhpService {
	
	@Autowired
	private SpecialhpMapper specialhpMapper;

	public List<Specialhp> findSpecialhp() throws Exception {
		// TODO Auto-generated method stub
		return specialhpMapper.findSpecialhp();
	}

	public int findSpecialhpByHp(String HPHM) throws Exception {
		// TODO Auto-generated method stub
		return specialhpMapper.findSpecialhpByHp(HPHM);
	}

	public void addHp(Specialhp specialhp) throws Exception {
		// TODO Auto-generated method stub
		specialhpMapper.addHp(specialhp);
	}

	public List<Specialhp> findAll(Specialhp specialhp) throws Exception {
		// TODO Auto-generated method stub
		return specialhpMapper.findAll(specialhp);
	}

	public void deleteSpecialhp(Integer[] ids) throws Exception {
		// TODO Auto-generated method stub
		specialhpMapper.deleteSpecialhp(ids);
	}

	public void updateSpecialhp(Specialhp specialhp) throws Exception {
		// TODO Auto-generated method stub
		specialhpMapper.updateSpecialhp(specialhp);
	}

}
