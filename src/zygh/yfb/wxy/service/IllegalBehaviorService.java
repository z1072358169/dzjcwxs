package zygh.yfb.wxy.service;

import java.util.List;

import zygh.yfb.wxy.vo.IllegalBehavior;

public interface IllegalBehaviorService {
	
    //查询信息
    public List<IllegalBehavior> findIllegalBehavior(IllegalBehavior illegalBehavior)throws Exception;
    
	//添加
	public void addIllegalBehavior(IllegalBehavior illegalBehavior)throws Exception;
	
	//删除
	public void deleteIllegalBehavior(Integer[] sysIds) throws Exception;
	
	//修改信息
	public void updateIllegalBehavior(IllegalBehavior illegalBehavior)throws Exception;
	
/*	public List<IllegalBehavior> selectlicenseIllegalBehaviorCount(String illegal_number)throws Exception;
	
	public List<IllegalBehavior> selectpExplainCount(String illegal_explanation)throws Exception;*/
	
}
