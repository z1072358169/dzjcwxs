package zygh.yfb.wxy.mapper;


import zygh.yfb.wxy.vo.ScreenTotel;
import zygh.yfb.wxy.vo.Wfcs;

import java.util.List;

public interface WfcsMapper {

    //查询信息
    List<Wfcs> findWfcsold(Wfcs wfcs)throws Exception;

    //查询所有不同的采集地址
    public List<Wfcs> findAddressold(Wfcs wfcs)throws Exception;
    //查询所有不同的采集地址--初筛   地址可以模糊查询
    public List<Wfcs> findAddresscsold(Wfcs wfcs)throws Exception;

    // 查询这个车牌除了本次违法外的其他违法记录  违法初筛的
    public List<Wfcs> findqtwfcsold(Wfcs wfcs)throws Exception;
    //初筛查询这个车牌有无同时间同地点的重复数据
    public long findcfcsold(Wfcs wfcs)throws Exception;

    //只修改车牌号或号牌种类
    public void updatehphmzlold(Wfcs wfcs)throws Exception;//

    // 归还未审核和未作废的数据
    public void updateghdataold(String userName)throws Exception;

    public long getCountold(Wfcs wfcs);

    List<Wfcs> findPageByold(Wfcs wfcs);

    //筛选状态
    public int updateStatueold(Wfcs wfcs)throws Exception;
    //筛选状态 初筛误筛
    public int updateStatuecswsold(Wfcs wfcs)throws Exception;

    //筛选统计
    public List<ScreenTotel> finduserandcountold(Wfcs wfcs)throws Exception;
    public ScreenTotel finduserandcount2old(Wfcs wfcs)throws Exception;
    public ScreenTotel finduserandcount3old(Wfcs wfcs)throws Exception;
    //初筛筛选统计4  所有人提取的还没筛选的
    public ScreenTotel finduserandcount4old(Wfcs wfcs)throws Exception;

    //查询未分配的数据 -userName=''的是未分配的    发送任务，分配任务
    public long getCountfpNameold(Wfcs wfcs)throws Exception;
    public void updateStatuefpNameold(Wfcs wfcs)throws Exception;

    public void deletebyidold(Integer sysid)throws Exception;
}

