package zygh.yfb.wxy.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import util.Page;
import zygh.yfb.wxy.mapper.IntervalVMMapper;
import zygh.yfb.wxy.service.IntervalVMService;
import zygh.yfb.wxy.vo.IntervalVM;
import zygh.yfb.wxy.vo.IntervalVMExample;
import zygh.yfb.wxy.vo.ScreenTotel;
import zygh.yfb.wxy.vo.TjVO;

public class IntervalVMServiceimpl implements IntervalVMService {

	@Autowired
	private IntervalVMMapper intervalVMMapper;

	public List<IntervalVMExample> findIntervalVM(IntervalVM intervalVM)
			throws Exception {
		// TODO Auto-generated method stub
		return intervalVMMapper.findIntervalVM(intervalVM);
	}

	public void addIntervalVM(IntervalVM intervalVM) throws Exception {
		// TODO Auto-generated method stub
		intervalVMMapper.addIntervalVM(intervalVM);
	}

	public void deleteIntervalVM(Integer[] sysids) throws Exception {
		// TODO Auto-generated method stub
		intervalVMMapper.deleteIntervalVM(sysids);
	}

	public void updateIntervalVM(IntervalVM intervalVM) throws Exception {
		// TODO Auto-generated method stub
		intervalVMMapper.updateIntervalVM(intervalVM);
	}

	public void updatehphm(IntervalVM intervalVM) throws Exception {
		// TODO Auto-generated method stub
		intervalVMMapper.updatehphm(intervalVM);
	}

	public void updatehpzl(IntervalVM intervalVM) throws Exception {
		// TODO Auto-generated method stub
		intervalVMMapper.updatehpzl(intervalVM);
	}

	public long getCount(IntervalVM intervalVM) {
		// TODO Auto-generated method stub
		return intervalVMMapper.getCount(intervalVM);
	}

	public List<IntervalVM> findPage(Page page) {
		// TODO Auto-generated method stub
		return intervalVMMapper.findPage(page);
	}

	public List<IntervalVMExample> findPageBy(IntervalVMExample intervalVMExample) {
		// TODO Auto-generated method stub
		return intervalVMMapper.findPageBy(intervalVMExample);
	}

//	public IntervalVMExample findUpOne(int nowId) throws Exception {
//		// TODO Auto-generated method stub
//		return intervalVMMapper.findUpOne(nowId);
//	}
//
//	public IntervalVMExample findDownOne(int nowId) throws Exception {
//		// TODO Auto-generated method stub
//		return intervalVMMapper.findDownOne(nowId);
//	}

	public int updateStatue(IntervalVM intervalVM) throws Exception {
		return intervalVMMapper.updateStatue(intervalVM);
	}

	@Override
	public int updateStatuecsws(IntervalVM intervalVM) throws Exception {
		return intervalVMMapper.updateStatuecsws(intervalVM);
	}

	public int updateStatuemj(IntervalVM intervalVM) throws Exception {
		// TODO Auto-generated method stub
		return intervalVMMapper.updateStatuemj(intervalVM);
	}

	public int updatews(IntervalVM intervalVM) throws Exception {
		// TODO Auto-generated method stub
		return intervalVMMapper.updatews(intervalVM);
	}

	public IntervalVM findById(Integer sysid) throws Exception {
		// TODO Auto-generated method stub
		return intervalVMMapper.findById(sysid);
	}

	public List<IntervalVM> findAddress(IntervalVM intervalVM) throws Exception {
		// TODO Auto-generated method stub
		return intervalVMMapper.findAddress(intervalVM);
	}

	public List<IntervalVM> findAddressmj(IntervalVM intervalVM)
			throws Exception {
		// TODO Auto-generated method stub
		return intervalVMMapper.findAddressmj(intervalVM);
	}

	@Override
	public List<IntervalVM> findAddresscs(IntervalVM intervalVM) throws Exception {
		return intervalVMMapper.findAddresscs(intervalVM);
	}

	public IntervalVMExample findUpOne(IntervalVM intervalVM) throws Exception {
		// TODO Auto-generated method stub
		return intervalVMMapper.findUpOne(intervalVM);
	}

	public IntervalVMExample findUpOnewhb(IntervalVM intervalVM)
			throws Exception {
		// TODO Auto-generated method stub
		return intervalVMMapper.findUpOnewhb(intervalVM);
	}

	public IntervalVMExample findUpOnemj(IntervalVM intervalVM)
			throws Exception {
		// TODO Auto-generated method stub
		return intervalVMMapper.findUpOnemj(intervalVM);
	}

	public IntervalVMExample findmjws(IntervalVM intervalVM) throws Exception {
		// TODO Auto-generated method stub
		return intervalVMMapper.findmjws(intervalVM);
	}

	public IntervalVMExample findDownOne(IntervalVM intervalVM)
			throws Exception {
		// TODO Auto-generated method stub
		return intervalVMMapper.findDownOne(intervalVM);
	}

	public IntervalVMExample findDownOnewhb(IntervalVM intervalVM)
			throws Exception {
		// TODO Auto-generated method stub
		return intervalVMMapper.findDownOnewhb(intervalVM);
	}

	public IntervalVMExample findDownOnemj(IntervalVM intervalVM)
			throws Exception {
		// TODO Auto-generated method stub
		return intervalVMMapper.findDownOnemj(intervalVM);
	}

	public long getCountfpName(IntervalVM intervalVM) throws Exception {
		// TODO Auto-generated method stub
		return intervalVMMapper.getCountfpName(intervalVM);
	}

	public long getCountfpNamemj(IntervalVM intervalVM) throws Exception {
		// TODO Auto-generated method stub
		return intervalVMMapper.getCountfpNamemj(intervalVM);
	}

	public void updateStatuefpName(IntervalVMExample intervalVMExample)
			throws Exception {
		// TODO Auto-generated method stub
		intervalVMMapper.updateStatuefpName(intervalVMExample);
	}

	public void updateStatuefpNamemj(IntervalVMExample intervalVMExample)
			throws Exception {
		// TODO Auto-generated method stub
		intervalVMMapper.updateStatuefpNamemj(intervalVMExample);
	}

	public List<IntervalVMExample> findPageByfpName(
			IntervalVMExample intervalVMExample) throws Exception {
		// TODO Auto-generated method stub
		return intervalVMMapper.findPageByfpName(intervalVMExample);
	}

	public List<IntervalVMExample> findPageByfpNamemj(
			IntervalVMExample intervalVMExample) throws Exception {
		// TODO Auto-generated method stub
		return intervalVMMapper.findPageByfpNamemj(intervalVMExample);
	}

	public void updateghdata(String userName) throws Exception {
		// TODO Auto-generated method stub
		intervalVMMapper.updateghdata(userName);
	}

	public void updateghdatamj(String mjuserName) throws Exception {
		// TODO Auto-generated method stub
		intervalVMMapper.updateghdatamj(mjuserName);
	}

	public List<ScreenTotel> finduserandcount(IntervalVM intervalVM) throws Exception {
		// TODO Auto-generated method stub
		return intervalVMMapper.finduserandcount(intervalVM);
	}

	public ScreenTotel finduserandcount2(IntervalVM intervalVM)
			throws Exception {
		// TODO Auto-generated method stub
		return intervalVMMapper.finduserandcount2(intervalVM);
	}

	public ScreenTotel finduserandcount3(IntervalVM intervalVM)
			throws Exception {
		// TODO Auto-generated method stub
		return intervalVMMapper.finduserandcount3(intervalVM);
	}

	@Override
	public ScreenTotel finduserandcount4(IntervalVM intervalVM) throws Exception {
		return intervalVMMapper.finduserandcount4(intervalVM);
	}


	public ScreenTotel finduserandcountmj(IntervalVM intervalVM)
			throws Exception {
		// TODO Auto-generated method stub
		return intervalVMMapper.finduserandcountmj(intervalVM);
	}

	public ScreenTotel finduserandcountmj2(IntervalVM intervalVM)
			throws Exception {
		// TODO Auto-generated method stub
		return intervalVMMapper.finduserandcountmj2(intervalVM);
	}

	public List<ScreenTotel> finduserandcountmj3(IntervalVM intervalVM)
			throws Exception {
		// TODO Auto-generated method stub
		return intervalVMMapper.finduserandcountmj3(intervalVM);
	}

	public ScreenTotel finduserandcountmj4(IntervalVM intervalVM)
			throws Exception {
		// TODO Auto-generated method stub
		return intervalVMMapper.finduserandcountmj4(intervalVM);
	}

	public List<IntervalVM> downimage(IntervalVM intervalVM) throws Exception {
		// TODO Auto-generated method stub
		return intervalVMMapper.downimage(intervalVM);
	}

	public List<String> findmjuserName() throws Exception {
		// TODO Auto-generated method stub
		return intervalVMMapper.findmjuserName();
	}

	public List<IntervalVM> findqtwf(IntervalVM intervalVM) throws Exception {
		// TODO Auto-generated method stub
		return intervalVMMapper.findqtwf(intervalVM);
	}

	public List<IntervalVM> findqtwfcs(IntervalVM intervalVM) throws Exception {
		// TODO Auto-generated method stub
		return intervalVMMapper.findqtwfcs(intervalVM);
	}

	public List<String> findhp() throws Exception {
		// TODO Auto-generated method stub
		return intervalVMMapper.findhp();
	}

	public List<IntervalVM> findhp1(String hphm) throws Exception {
		// TODO Auto-generated method stub
		return intervalVMMapper.findhp1(hphm);
	}

	public void deletebyid(Integer sysid) throws Exception {
		// TODO Auto-generated method stub
		intervalVMMapper.deletebyid(sysid);
	}

	@Override
	public long findcfcs(IntervalVM intervalVM) throws Exception {
		return intervalVMMapper.findcfcs(intervalVM);
	}

	public long findcfmj(IntervalVM intervalVM) throws Exception {
		// TODO Auto-generated method stub
		return intervalVMMapper.findcfmj(intervalVM);
	}

	@Override
	public List<TjVO> findlukouBytemp(TjVO tjVO) throws Exception {
		return intervalVMMapper.findlukouBytemp(tjVO);
	}

	@Override
	public TjVO findByCJDZ(TjVO tjVO) throws Exception {
		return intervalVMMapper.findByCJDZ(tjVO);
	}

	@Override
	public List<TjVO> findByCJDZ1(TjVO tjVO) throws Exception {
		return intervalVMMapper.findByCJDZ1(tjVO);
	}

	@Override
	public List<String> findAlllukou() throws Exception {
		return intervalVMMapper.findAlllukou();
	}

	@Override
	public void shifangall() throws Exception {
		intervalVMMapper.shifangall();
	}


}
