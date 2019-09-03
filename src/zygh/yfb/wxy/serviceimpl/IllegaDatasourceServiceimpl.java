package zygh.yfb.wxy.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import zygh.yfb.wxy.mapper.IllegaDatasourceMapper;
import zygh.yfb.wxy.service.IllegaDatasourceService;
import zygh.yfb.wxy.vo.IllegaDatasource;

public class IllegaDatasourceServiceimpl implements IllegaDatasourceService {
	
	@Autowired
	private IllegaDatasourceMapper illegaDatasourceMapper;

	public List<IllegaDatasource> findIllegaDatasource(
			IllegaDatasource illegaDatasource) throws Exception {
		// TODO Auto-generated method stub
		return illegaDatasourceMapper.findIllegaDatasource(illegaDatasource);
	}

	public void addIllegaDatasource(IllegaDatasource illegaDatasource)
			throws Exception {
		// TODO Auto-generated method stub
		illegaDatasourceMapper.addIllegaDatasource(illegaDatasource);
	}

	public void deleteIllegaDatasource(Integer[] sysIds) throws Exception {
		// TODO Auto-generated method stub
		illegaDatasourceMapper.deleteIllegaDatasource(sysIds);
	}

	public void updateIllegaDatasource(IllegaDatasource illegaDatasource)
			throws Exception {
		// TODO Auto-generated method stub
		illegaDatasourceMapper.updateIllegaDatasource(illegaDatasource);
	}

}
