package zygh.yfb.wxy.service;

import java.util.List;

import zygh.yfb.wxy.vo.RoadInfo;
import zygh.yfb.wxy.vo.SbBh;

public interface RoadInfoService {

    //查询信息
    public List<RoadInfo> findRoadInfo(RoadInfo roadInfo)throws Exception;
    
    public String findsbbhbylukou(String lukouname)throws Exception;
    
	//添加
	public void addRoadInfo(RoadInfo roadInfo)throws Exception;
	
	//删除
	public void deleteRoadInfo(Integer[] ids) throws Exception;
	
	//修改信息
	public void updateRoadInfo(Integer id)throws Exception;
	
	/*public List<SbBh> selecthxsbbh(String area)throws Exception;
	
	public List<SbBh> selectparea(String hxsbbh)throws Exception;*/
	
}
