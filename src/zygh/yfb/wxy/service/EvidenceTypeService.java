package zygh.yfb.wxy.service;

import java.util.List;

import zygh.yfb.wxy.vo.EvidenceType;

public interface EvidenceTypeService {
	
    //查询信息
    public List<EvidenceType> findEvidenceType(EvidenceType evidenceType)throws Exception;
    
	//添加
	public void addEvidenceType(EvidenceType evidenceType)throws Exception;
	
	//删除
	public void deleteEvidenceType(Integer[] sysIds) throws Exception;
	
	//修改信息
	public void updateEvidenceType(EvidenceType evidenceType)throws Exception;
}
