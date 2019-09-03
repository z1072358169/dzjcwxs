package zygh.yfb.wxy.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import zygh.yfb.wxy.mapper.IntervalVMMapper;
import zygh.yfb.wxy.mapper.WfcsMapper;
import zygh.yfb.wxy.service.WfcsService;
import zygh.yfb.wxy.vo.ScreenTotel;
import zygh.yfb.wxy.vo.Wfcs;

import java.util.List;

public class WfcsServiceimpl implements WfcsService {

    @Autowired
    private WfcsMapper wfcsMapper;


    @Autowired
    private IntervalVMMapper intervalVMMapper;

    @Override
    public List<Wfcs> findWfcsold(Wfcs wfcs) throws Exception {
        return wfcsMapper.findWfcsold(wfcs);
    }

    @Override
    public List<Wfcs> findAddressold(Wfcs wfcs) throws Exception {
        return wfcsMapper.findAddressold(wfcs);
    }

    @Override
    public List<Wfcs> findAddresscsold(Wfcs wfcs) throws Exception {
        return wfcsMapper.findAddresscsold(wfcs);
    }

    @Override
    public List<Wfcs> findqtwfcsold(Wfcs wfcs) throws Exception {
        return wfcsMapper.findqtwfcsold(wfcs);
    }

    @Override
    public long findcfcsold(Wfcs wfcs) throws Exception {
        return wfcsMapper.findcfcsold(wfcs);
    }

    @Override
    public void updatehphmzlold(Wfcs wfcs) throws Exception {
        wfcsMapper.updatehphmzlold(wfcs);
    }

    @Override
    public void updateghdataold(String userName) throws Exception {
        wfcsMapper.updateghdataold(userName);
    }

    @Override
    public long getCountold(Wfcs wfcs) {
        return wfcsMapper.getCountold(wfcs);
    }

    @Override
    public List<Wfcs> findPageByold(Wfcs wfcs) {
        return wfcsMapper.findPageByold(wfcs);
    }

    @Override
    public int updateStatueold(Wfcs wfcs) throws Exception {
        return wfcsMapper.updateStatueold(wfcs);
    }

    @Override
    public int updateStatuecswsold(Wfcs wfcs) throws Exception {
        return wfcsMapper.updateStatuecswsold(wfcs);
    }

    @Override
    public List<ScreenTotel> finduserandcountold(Wfcs wfcs) throws Exception {
        return wfcsMapper.finduserandcountold(wfcs);
    }

    @Override
    public ScreenTotel finduserandcount2old(Wfcs wfcs) throws Exception {
        return wfcsMapper.finduserandcount2old(wfcs);
    }

    @Override
    public ScreenTotel finduserandcount3old(Wfcs wfcs) throws Exception {
        return wfcsMapper.finduserandcount3old(wfcs);
    }

    @Override
    public ScreenTotel finduserandcount4old(Wfcs wfcs) throws Exception {
        return wfcsMapper.finduserandcount4old(wfcs);
    }

    @Override
    public long getCountfpNameold(Wfcs wfcs) throws Exception {
        return wfcsMapper.getCountfpNameold(wfcs);
    }

    @Override
    public void updateStatuefpNameold(Wfcs wfcs) throws Exception {
        wfcsMapper.updateStatuefpNameold(wfcs);
    }

    @Override
    public void deletebyidold(Integer sysid) throws Exception {
        wfcsMapper.deletebyidold(sysid);
    }
}
