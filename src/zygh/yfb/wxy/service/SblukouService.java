package zygh.yfb.wxy.service;

import zygh.yfb.wxy.vo.Sblukou;

import java.util.List;

public interface SblukouService {

    //查询所有部门信息
    public List<Sblukou> findSblukou(Sblukou sblukou)throws Exception;
    //添加部门信息
    public void addSblukou(Sblukou sblukou)throws Exception;
    //批量删除部门信息
    public void deleteSblukou(Integer[] SBBHs) throws Exception;
    //通过主键查找部门信息
    public Sblukou findSblukouByNum(Integer SBBH)throws Exception;
    //修改部门信息
    public void updateSblukou(Sblukou sblukou)throws Exception;
}
