package zygh.yfb.wxy.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import zygh.yfb.wxy.mapper.RoadInfoMapper;
import zygh.yfb.wxy.service.RoadInfoService;
import zygh.yfb.wxy.vo.RoadInfo;

public class RoadInfoServiceimpl implements RoadInfoService {
	
	@Autowired
	private RoadInfoMapper roadInfoMapper;

	public List<RoadInfo> findRoadInfo(RoadInfo roadInfo) throws Exception {
		// TODO Auto-generated method stub
		return roadInfoMapper.findRoadInfo(roadInfo);
	}

	public void addRoadInfo(RoadInfo roadInfo) throws Exception {
		// TODO Auto-generated method stub
		roadInfoMapper.addRoadInfo(roadInfo);
	}

	public void deleteRoadInfo(Integer[] ids) throws Exception {
		// TODO Auto-generated method stub
		roadInfoMapper.deleteRoadInfo(ids);
	}

	public void updateRoadInfo(Integer id) throws Exception {
		// TODO Auto-generated method stub
		roadInfoMapper.updateRoadInfo(id);
	}

	public String findsbbhbylukou(String lukouname) throws Exception {
		// TODO Auto-generated method stub
		return roadInfoMapper.findsbbhbylukou(lukouname);
	}

}
