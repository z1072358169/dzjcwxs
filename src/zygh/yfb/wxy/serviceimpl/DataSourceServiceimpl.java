package zygh.yfb.wxy.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import zygh.yfb.wxy.mapper.DataSourceMapper;
import zygh.yfb.wxy.service.DataSourceService;
import zygh.yfb.wxy.vo.DataSource;

public class DataSourceServiceimpl implements DataSourceService {
	
	@Autowired
	private DataSourceMapper dataSourceMapper;

	public List<DataSource> findDataSource(DataSource dataSource)
			throws Exception {
		// TODO Auto-generated method stub
		return dataSourceMapper.findDataSource(dataSource);
	}

	public void addDataSource(DataSource dataSource) throws Exception {
		// TODO Auto-generated method stub
		dataSourceMapper.addDataSource(dataSource);
	}

	public void deleteDataSource(Integer[] sysIds) throws Exception {
		// TODO Auto-generated method stub
		dataSourceMapper.deleteDataSource(sysIds);
	}

	public void updateDataSource(DataSource dataSource) throws Exception {
		// TODO Auto-generated method stub
		dataSourceMapper.updateDataSource(dataSource);
	}

}
