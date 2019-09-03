package zygh.yfb.wxy.mapper;

import java.util.List;

import zygh.yfb.wxy.vo.Specialhp;

/**
 * 号牌种类
 * @author 王喜亚
 *
 */
public interface SpecialhpMapper {
	
    //查询信息
    public List<Specialhp> findSpecialhp()throws Exception;
    
	public int findSpecialhpByHp(String HPHM)throws Exception;
	
	public void addHp(Specialhp specialhp)throws Exception;
	
    //查询信息
    public List<Specialhp> findAll(Specialhp specialhp)throws Exception;
    
	//删除
	public void deleteSpecialhp(Integer[] ids) throws Exception;
	
	//修改信息
	public void updateSpecialhp(Specialhp specialhp)throws Exception;
	
}
