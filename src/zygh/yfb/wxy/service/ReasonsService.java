package zygh.yfb.wxy.service;

import zygh.yfb.wxy.vo.Reasons;
import java.util.List;

public interface ReasonsService {

	//查询信息
	public List<Reasons> findReasons(Reasons reasons)throws Exception;

	public void insertReasons(Reasons reasons)throws Exception;

	//删除
	public void deleteReasons(Integer[] ReasonsIds) throws Exception;

	//修改信息
	public void updateReasons(Reasons reasons)throws Exception;
}
