package zygh.yfb.wxy.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import zygh.yfb.wxy.mapper.SblukouMapper;
import zygh.yfb.wxy.service.SblukouService;
import zygh.yfb.wxy.vo.Sblukou;

import java.util.List;

public class SblukouServiceimpl implements SblukouService {

    @Autowired
    private SblukouMapper sblukouMapper;

    @Override
    public List<Sblukou> findSblukou(Sblukou sblukou) throws Exception {
        return sblukouMapper.findSblukou(sblukou);
    }

    @Override
    public void addSblukou(Sblukou sblukou) throws Exception {
        sblukouMapper.addSblukou(sblukou);
    }

    @Override
    public void deleteSblukou(Integer[] SBBHs) throws Exception {
        sblukouMapper.deleteSblukou(SBBHs);
    }

    @Override
    public Sblukou findSblukouByNum(Integer SBBH) throws Exception {
        return sblukouMapper.findSblukouByNum(SBBH);
    }

    @Override
    public void updateSblukou(Sblukou sblukou) throws Exception {
        sblukouMapper.updateSblukou(sblukou);
    }
}
