package zygh.yfb.wxy.service;

import zygh.yfb.wxy.vo.ScreenTotel;
import zygh.yfb.wxy.vo.Wffh;

import java.util.List;

public interface WffhService {

    //查询信息
    List<Wffh> findWffh(Wffh wffh)throws Exception;//

    //只修改车牌号或号牌种类
    public void updatehphmzlnew(Wffh wffh)throws Exception;//

    public long getCountnew(Wffh wffh);//

    List<Wffh> findPageBynew(Wffh wffh);//


    //民警筛选状态
    public int updateStatuemjnew(Wffh wffh)throws Exception;//
    //民警误筛用
    public int updatewsnew(Wffh wffh)throws Exception;//

    //查询所有不同的采集地址--民警   地址可以模糊查询
    public List<Wffh> findAddressmjnew(Wffh wffh)throws Exception;//

    //查询未分配的数据 -mjuserName=''的是未分配的    发送任务，分配任务 ---民警
    public long getCountfpNamemjnew(Wffh wffh)throws Exception;//
    public void updateStatuefpNamemjnew(Wffh wffh)throws Exception;//

    // 归还未审核和未作废的数据  ---民警
    public void updateghdatamjnew(String mjuserName)throws Exception;//

    //民警筛选统计
    public ScreenTotel finduserandcountmjnew(Wffh wffh)throws Exception; //
    public ScreenTotel finduserandcountmj2new(Wffh wffh)throws Exception;//
    public List<ScreenTotel> finduserandcountmj3new(Wffh wffh)throws Exception;//
    //民警筛选统计4  所有人提取的还没筛选的
    public ScreenTotel finduserandcountmj4new(Wffh wffh)throws Exception;//

    //查询民警名字
    public List<String> findmjuserNamenew()throws Exception;

    // 查询这个车牌除了本次违法外的其他违法记录   民警复核的
    public List<Wffh> findqtwfnew(Wffh wffh)throws Exception;//

    //民警查询这个车牌有无同时间同地点的重复数据
    public long findcfmjnew(Wffh wffh)throws Exception;//

    //早上五六点释放复核所有未释放的数据
    public void shifangallnew()throws Exception;

    //民警复核统计
    public List<ScreenTotel> finduserandcountmj5new(Wffh wffh)throws Exception;//

}
