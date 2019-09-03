package zygh.yfb.wxy.service;

import java.util.List;

import zygh.yfb.wxy.vo.SbBh;

public interface SbBhService {

    //查询信息
    public List<SbBh> findSbBh(SbBh sbbh)throws Exception;
    //查询area去重
    public List<SbBh> findarea()throws Exception;
    
	//添加
	public void addSbBh(SbBh sbbh)throws Exception;
	
	//删除
	public void deleteSbBh(Integer[] sysids) throws Exception;
	
	//修改信息
	public void updateSbBh(SbBh sbbh)throws Exception;
	
	public List<SbBh> selecthxsbbh(String area)throws Exception;
	
	public List<SbBh> selectparea(String hxsbbh)throws Exception;
}
