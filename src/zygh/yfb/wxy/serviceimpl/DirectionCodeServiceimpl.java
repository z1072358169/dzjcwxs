package zygh.yfb.wxy.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import zygh.yfb.wxy.mapper.DirectionCodeMapper;
import zygh.yfb.wxy.service.DirectionCodeService;
import zygh.yfb.wxy.vo.DirectionCode;

public class DirectionCodeServiceimpl implements DirectionCodeService{
	
	@Autowired
	private DirectionCodeMapper directionCodeMapper;

	public List<DirectionCode> findDirectionCode(DirectionCode directionCode)
			throws Exception {
		// TODO Auto-generated method stub
		return directionCodeMapper.findDirectionCode(directionCode);
	}

	public void addDirectionCode(DirectionCode directionCode) throws Exception {
		// TODO Auto-generated method stub
		directionCodeMapper.addDirectionCode(directionCode);
	}

	public void deleteDirectionCode(Integer[] sysIds) throws Exception {
		// TODO Auto-generated method stub
		directionCodeMapper.deleteDirectionCode(sysIds);
	}

	public void updateDirectionCode(DirectionCode directionCode)
			throws Exception {
		// TODO Auto-generated method stub
		directionCodeMapper.updateDirectionCode(directionCode);
	}

}
