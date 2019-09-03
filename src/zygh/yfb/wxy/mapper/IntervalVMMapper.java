package zygh.yfb.wxy.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import util.Page;
import zygh.yfb.wxy.vo.IntervalVM;
import zygh.yfb.wxy.vo.IntervalVMExample;
import zygh.yfb.wxy.vo.ScreenTotel;
import zygh.yfb.wxy.vo.TjVO;

/**
 * 区间测速
 * @author 王喜亚
 *
 */
public interface IntervalVMMapper {
	
    //查询信息
    List<IntervalVMExample> findIntervalVM(IntervalVM intervalVM)throws Exception;
    
    //按主键查询
    public IntervalVM findById(Integer sysid)throws Exception;
    
	//添加
	public void addIntervalVM(IntervalVM intervalVM)throws Exception;
	
	//删除
	public void deleteIntervalVM(Integer[] sysids) throws Exception;
	
	//修改信息
	public void updateIntervalVM(IntervalVM intervalVM)throws Exception;
	
	//只修改车牌号
	public void updatehphm(IntervalVM intervalVM)throws Exception;
	
	//只修改号牌号码
	public void updatehpzl(IntervalVM intervalVM)throws Exception;
	
	public long getCount(IntervalVM intervalVM);
	
	List<IntervalVM> findPage(Page page);
	
	List<IntervalVMExample> findPageBy(IntervalVMExample intervalVMExample);
	
	//上一页
//	public IntervalVMExample findUpOne(int nowId)throws Exception;
	public IntervalVMExample findUpOne(IntervalVM intervalVM)throws Exception;
	//违法数据查询上一条
	public IntervalVMExample findUpOnewhb(IntervalVM intervalVM)throws Exception;
	//民警筛选上一条
	public IntervalVMExample findUpOnemj(IntervalVM intervalVM)throws Exception;
	//民警查看误筛上一条
	public IntervalVMExample findmjws(IntervalVM intervalVM)throws Exception;
	
	//下一页
//	public IntervalVMExample findDownOne(int nowId)throws Exception;
	public IntervalVMExample findDownOne(IntervalVM intervalVM)throws Exception;
	//违法数据查询下一条
	public IntervalVMExample findDownOnewhb(IntervalVM intervalVM)throws Exception;
	//民警筛选下一条
	public IntervalVMExample findDownOnemj(IntervalVM intervalVM)throws Exception;
	
	//筛选状态
	public int updateStatue(IntervalVM intervalVM)throws Exception;
	//筛选状态 初筛误筛
	public int updateStatuecsws(IntervalVM intervalVM)throws Exception;

	
	//民警筛选状态
	public int updateStatuemj(IntervalVM intervalVM)throws Exception;
	//民警误筛用
	public int updatews(IntervalVM intervalVM)throws Exception;
	
	//查询所有不同的采集地址
	public List<IntervalVM> findAddress(IntervalVM intervalVM)throws Exception;
	//查询所有不同的采集地址--民警   地址可以模糊查询 
	public List<IntervalVM> findAddressmj(IntervalVM intervalVM)throws Exception;
	//查询所有不同的采集地址--初筛   地址可以模糊查询
	public List<IntervalVM> findAddresscs(IntervalVM intervalVM)throws Exception;
	
	//查询未分配的数据 -userName=''的是未分配的    发送任务，分配任务 
	public long getCountfpName(IntervalVM intervalVM)throws Exception;
	public void updateStatuefpName(IntervalVMExample intervalVMExample)throws Exception;
	public List<IntervalVMExample> findPageByfpName(IntervalVMExample intervalVMExample)throws Exception;
	
	//查询未分配的数据 -mjuserName=''的是未分配的    发送任务，分配任务 ---民警
	public long getCountfpNamemj(IntervalVM intervalVM)throws Exception;
	public void updateStatuefpNamemj(IntervalVMExample intervalVMExample)throws Exception;
	public List<IntervalVMExample> findPageByfpNamemj(IntervalVMExample intervalVMExample)throws Exception;
	
	// 归还未审核和未作废的数据 
	public void updateghdata(String userName)throws Exception;
	
	// 归还未审核和未作废的数据  ---民警
	public void updateghdatamj(String mjuserName)throws Exception;
	
	//筛选统计
	public List<ScreenTotel> finduserandcount(IntervalVM intervalVM)throws Exception;
	public ScreenTotel finduserandcount2(IntervalVM intervalVM)throws Exception;
	public ScreenTotel finduserandcount3(IntervalVM intervalVM)throws Exception;
	//初筛筛选统计4  所有人提取的还没筛选的
	public ScreenTotel finduserandcount4(IntervalVM intervalVM)throws Exception;

	//民警筛选统计
	public ScreenTotel finduserandcountmj(IntervalVM intervalVM)throws Exception;
	public ScreenTotel finduserandcountmj2(IntervalVM intervalVM)throws Exception;
	public List<ScreenTotel> finduserandcountmj3(IntervalVM intervalVM)throws Exception;
	//民警筛选统计4  所有人提取的还没筛选的
	public ScreenTotel finduserandcountmj4(IntervalVM intervalVM)throws Exception;
	
	//下载图片
	public List<IntervalVM> downimage(IntervalVM intervalVM)throws Exception;
	
	//查询民警名字
	public List<String> findmjuserName()throws Exception;
	
	// 查询这个车牌除了本次违法外的其他违法记录   民警复核的
	public List<IntervalVM> findqtwf(IntervalVM intervalVM)throws Exception;
	
	// 查询这个车牌除了本次违法外的其他违法记录  违法初筛的
	public List<IntervalVM> findqtwfcs(IntervalVM intervalVM)throws Exception;

	//初筛查询这个车牌有无同时间同地点的重复数据
	public long findcfcs(IntervalVM intervalVM)throws Exception;
	//民警查询这个车牌有无同时间同地点的重复数据
	public long findcfmj(IntervalVM intervalVM)throws Exception;
	
	//删除重复数据
	public List<String> findhp()throws Exception;
	public List<IntervalVM> findhp1(String hphm)throws Exception;
	public void deletebyid(Integer sysid)throws Exception;

	//路口数据统计，每个路口，抓取总数，初筛通过数，复核通过数
	public List<TjVO> findlukouBytemp(TjVO tjVO)throws Exception;
	public TjVO findByCJDZ(TjVO tjVO)throws Exception;
	public List<TjVO> findByCJDZ1(TjVO tjVO)throws Exception;
	public List<String> findAlllukou()throws Exception;

	//早上五六点释放复核所有未释放的数据
	public void shifangall()throws Exception;


}
