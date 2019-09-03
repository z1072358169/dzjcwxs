package zygh.yfb.wxy.service;

import java.util.List;

import zygh.yfb.wxy.vo.DirectionCode;

public interface DirectionCodeService {
	
    //查询信息
    public List<DirectionCode> findDirectionCode(DirectionCode directionCode)throws Exception;
    
	//添加
	public void addDirectionCode(DirectionCode directionCode)throws Exception;
	
	//删除
	public void deleteDirectionCode(Integer[] sysIds) throws Exception;
	
	//修改信息
	public void updateDirectionCode(DirectionCode directionCode)throws Exception;

}
