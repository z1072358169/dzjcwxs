package zygh.yfb.wxy.mapper;

import java.util.List;
import zygh.yfb.wxy.vo.DataSource;

/**
 * 数据来源
 * @author 王喜亚
 *
 */
public interface DataSourceMapper {
	
    //查询信息
    public List<DataSource> findDataSource(DataSource dataSource)throws Exception;
    
	//添加
	public void addDataSource(DataSource dataSource)throws Exception;
	
	//删除
	public void deleteDataSource(Integer[] sysIds) throws Exception;
	
	//修改信息
	public void updateDataSource(DataSource dataSource)throws Exception;
	
	
}
