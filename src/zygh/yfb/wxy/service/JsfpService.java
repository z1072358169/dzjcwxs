package zygh.yfb.wxy.service;

import zygh.yfb.wxy.vo.Jsfp;
import zygh.yfb.wxy.vo.ScreenTotel;

import java.util.List;

public interface JsfpService {

    //查询信息
    List<Jsfp> findJsfpfz(Jsfp jsfp)throws Exception;

    //查询所有不同的采集地址
    public List<Jsfp> findAddressfz(Jsfp jsfp)throws Exception;
    //查询所有不同的采集地址--初筛   地址可以模糊查询
    public List<Jsfp> findAddresscsfz(Jsfp jsfp)throws Exception;

    // 查询这个车牌除了本次违法外的其他违法记录  违法初筛的
    public List<Jsfp> findqtJsfpfz(Jsfp jsfp)throws Exception;
    //初筛查询这个车牌有无同时间同地点的重复数据
    public long findcfcsfz(Jsfp jsfp)throws Exception;

    //只修改车牌号或号牌种类
    public void updatehphmzlfz(Jsfp jsfp)throws Exception;//

    // 归还未审核和未作废的数据
    public void updateghdatafz(String userName)throws Exception;

    public long getCountfz(Jsfp jsfp);

    List<Jsfp> findPageByfz(Jsfp jsfp);

    //筛选状态
    public int updateStatuefz(Jsfp jsfp)throws Exception;
    //筛选状态 初筛误筛
    public int updateStatuecswsfz(Jsfp jsfp)throws Exception;

    //筛选统计
    public List<ScreenTotel> finduserandcountfz(Jsfp jsfp)throws Exception;
    public ScreenTotel finduserandcount2fz(Jsfp jsfp)throws Exception;
    public ScreenTotel finduserandcount3fz(Jsfp jsfp)throws Exception;
    //初筛筛选统计4  所有人提取的还没筛选的
    public ScreenTotel finduserandcount4fz(Jsfp jsfp)throws Exception;

    //查询未分配的数据 -userName=''的是未分配的    发送任务，分配任务
    public long getCountfpNamefz(Jsfp jsfp)throws Exception;
    public void updateStatuefpNamefz(Jsfp jsfp)throws Exception;

    public void deletebyidfz(Integer sysid)throws Exception;
}
