package zygh.yfb.wxy.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import zygh.yfb.wxy.mapper.JsfpMapper;
import zygh.yfb.wxy.service.JsfpService;
import zygh.yfb.wxy.vo.Jsfp;
import zygh.yfb.wxy.vo.ScreenTotel;

import java.util.List;

public class JsfpServiceimpl implements JsfpService {

    @Autowired
    private JsfpMapper jsfpMapper;

    @Override
    public List<Jsfp> findJsfpfz(Jsfp jsfp) throws Exception {
        return jsfpMapper.findJsfpfz(jsfp);
    }

    @Override
    public List<Jsfp> findAddressfz(Jsfp jsfp) throws Exception {
        return jsfpMapper.findAddressfz(jsfp);
    }

    @Override
    public List<Jsfp> findAddresscsfz(Jsfp jsfp) throws Exception {
        return jsfpMapper.findAddresscsfz(jsfp);
    }

    @Override
    public List<Jsfp> findqtJsfpfz(Jsfp jsfp) throws Exception {
        return jsfpMapper.findqtJsfpfz(jsfp);
    }

    @Override
    public long findcfcsfz(Jsfp jsfp) throws Exception {
        return jsfpMapper.findcfcsfz(jsfp);
    }

    @Override
    public void updatehphmzlfz(Jsfp jsfp) throws Exception {
        jsfpMapper.updatehphmzlfz(jsfp);
    }

    @Override
    public void updateghdatafz(String userName) throws Exception {
        jsfpMapper.updateghdatafz(userName);
    }

    @Override
    public long getCountfz(Jsfp jsfp) {
        return jsfpMapper.getCountfz(jsfp);
    }

    @Override
    public List<Jsfp> findPageByfz(Jsfp jsfp) {
        return jsfpMapper.findPageByfz(jsfp);
    }

    @Override
    public int updateStatuefz(Jsfp jsfp) throws Exception {
        return jsfpMapper.updateStatuefz(jsfp);
    }

    @Override
    public int updateStatuecswsfz(Jsfp jsfp) throws Exception {
        return jsfpMapper.updateStatuecswsfz(jsfp);
    }

    @Override
    public List<ScreenTotel> finduserandcountfz(Jsfp jsfp) throws Exception {
        return jsfpMapper.finduserandcountfz(jsfp);
    }

    @Override
    public ScreenTotel finduserandcount2fz(Jsfp jsfp) throws Exception {
        return jsfpMapper.finduserandcount2fz(jsfp);
    }

    @Override
    public ScreenTotel finduserandcount3fz(Jsfp jsfp) throws Exception {
        return jsfpMapper.finduserandcount3fz(jsfp);
    }

    @Override
    public ScreenTotel finduserandcount4fz(Jsfp jsfp) throws Exception {
        return jsfpMapper.finduserandcount4fz(jsfp);
    }

    @Override
    public long getCountfpNamefz(Jsfp jsfp) throws Exception {
        return jsfpMapper.getCountfpNamefz(jsfp);
    }

    @Override
    public void updateStatuefpNamefz(Jsfp jsfp) throws Exception {
        jsfpMapper.updateStatuefpNamefz(jsfp);
    }

    @Override
    public void deletebyidfz(Integer sysid) throws Exception {
        jsfpMapper.deletebyidfz(sysid);
    }
}
