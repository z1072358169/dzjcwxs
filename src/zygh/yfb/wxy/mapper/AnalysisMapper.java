package zygh.yfb.wxy.mapper;

import zygh.yfb.wxy.vo.Analysis;
import zygh.yfb.wxy.vo.ReasonsTj;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * 
 * @author 王喜亚
 *
 */
public interface AnalysisMapper {

	//查询所有部门信息
	public List<Analysis> findAnalysis()throws Exception;

	public List<ReasonsTj> findtest(Analysis analysis)throws Exception;

	public List<ReasonsTj> findAnalysisAndType()throws Exception;

	//查询该条数据是否已分析过
	public List<Analysis> findifadd(Analysis analysis)throws Exception;

	//添加
	public void insertAnalysis(Analysis analysis)throws Exception;

	//修改
	public void updateAnalysis(Analysis analysis)throws Exception;

}
