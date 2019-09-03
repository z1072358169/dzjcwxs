package zygh.yfb.wxy.service;

import java.util.List;

import zygh.yfb.wxy.vo.Sectors;
/**
 * 
 * @author 王喜亚
 *
 */
public interface SectorsService {

	//查询所有部门信息
	public List<Sectors> findSectors(Sectors sectors)throws Exception;
	//添加部门信息
	public void addSectors(Sectors sectors)throws Exception;
	//批量删除部门信息
	public void deleteSectors(Integer[] sectorsNums) throws Exception;
	//通过主键查找部门信息
	public Sectors findSectorsByNum(Integer sectorsNum)throws Exception;
	//修改部门信息
	public void updateSectors(Sectors sectors)throws Exception;	
}
