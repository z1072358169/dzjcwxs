package zygh.yfb.wxy.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import zygh.yfb.wxy.mapper.IllegalBehaviorMapper;
import zygh.yfb.wxy.service.IllegalBehaviorService;
import zygh.yfb.wxy.vo.IllegalBehavior;

public class IllegalBehaviorServiceimpl implements IllegalBehaviorService {
	
	@Autowired
	private IllegalBehaviorMapper illegalBehaviorMapper;

	public List<IllegalBehavior> findIllegalBehavior(
			IllegalBehavior illegalBehavior) throws Exception {
		// TODO Auto-generated method stub
		return illegalBehaviorMapper.findIllegalBehavior(illegalBehavior);
	}

	public void addIllegalBehavior(IllegalBehavior illegalBehavior)
			throws Exception {
		// TODO Auto-generated method stub
		illegalBehaviorMapper.addIllegalBehavior(illegalBehavior);
	}

	public void deleteIllegalBehavior(Integer[] sysIds) throws Exception {
		// TODO Auto-generated method stub
		illegalBehaviorMapper.deleteIllegalBehavior(sysIds);
	}

	public void updateIllegalBehavior(IllegalBehavior illegalBehavior)
			throws Exception {
		// TODO Auto-generated method stub
		illegalBehaviorMapper.updateIllegalBehavior(illegalBehavior);
	}

}
