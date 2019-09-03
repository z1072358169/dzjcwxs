package zygh.yfb.wxy.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import zygh.yfb.wxy.mapper.SbBhMapper;
import zygh.yfb.wxy.service.SbBhService;
import zygh.yfb.wxy.vo.SbBh;

public class SbBhServiceimpl implements SbBhService {
	
	@Autowired
	private SbBhMapper sbbhMapper;

	public List<SbBh> findSbBh(SbBh sbbh) throws Exception {
		// TODO Auto-generated method stub
		return sbbhMapper.findSbBh(sbbh);
	}

	public void addSbBh(SbBh sbbh) throws Exception {
		// TODO Auto-generated method stub
		sbbhMapper.addSbBh(sbbh);
	}

	public void deleteSbBh(Integer[] sysids) throws Exception {
		// TODO Auto-generated method stub
		sbbhMapper.deleteSbBh(sysids);
	}

	public void updateSbBh(SbBh sbbh) throws Exception {
		// TODO Auto-generated method stub
		sbbhMapper.updateSbBh(sbbh);
	}

	public List<SbBh> selecthxsbbh(String area) throws Exception {
		// TODO Auto-generated method stub
		return sbbhMapper.selecthxsbbh(area);
	}

	public List<SbBh> selectparea(String hxsbbh) throws Exception {
		// TODO Auto-generated method stub
		return sbbhMapper.selectparea(hxsbbh);
	}

	public List<SbBh> findarea() throws Exception {
		// TODO Auto-generated method stub
		return sbbhMapper.findarea();
	}



}
