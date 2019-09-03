package zygh.yfb.wxy.service;

import zygh.yfb.wxy.vo.Reasons;
import zygh.yfb.wxy.vo.ReasonsType;

import java.util.List;

public interface ReasonsTypeService {

	//查询信息
	public List<ReasonsType> findReasonsType(ReasonsType reasonsType)throws Exception;

	//关联原因表查询信息
	public List<Reasons> findReasonsAndType(Reasons reasons)throws Exception;

	public void insertReasonsType(ReasonsType reasonsType)throws Exception;

	//删除
	public void deleteReasonsType(Integer[] ReasonsTypeIds) throws Exception;

	//修改信息
	public void updateReasonsType(ReasonsType reasonsType)throws Exception;
}
