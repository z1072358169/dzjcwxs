package zygh.yfb.wxy.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import zygh.yfb.wxy.mapper.WffhMapper;
import zygh.yfb.wxy.service.WffhService;
import zygh.yfb.wxy.vo.ScreenTotel;
import zygh.yfb.wxy.vo.Wffh;

import java.util.List;

public class WffhServiceimpl implements WffhService {

    @Autowired
    private WffhMapper wffhMapper;

    @Override
    public List<Wffh> findWffh(Wffh wffh) throws Exception {
        return wffhMapper.findWffh(wffh);
    }

    @Override
    public void updatehphmzlnew(Wffh wffh) throws Exception {
        wffhMapper.updatehphmzlnew(wffh);
    }

    @Override
    public long getCountnew(Wffh wffh) {
        return wffhMapper.getCountnew(wffh);
    }

    @Override
    public List<Wffh> findPageBynew(Wffh wffh) {
        return wffhMapper.findPageBynew(wffh);
    }

    @Override
    public int updateStatuemjnew(Wffh wffh) throws Exception {
        return wffhMapper.updateStatuemjnew(wffh);
    }

    @Override
    public int updatewsnew(Wffh wffh) throws Exception {
        return wffhMapper.updatewsnew(wffh);
    }

    @Override
    public List<Wffh> findAddressmjnew(Wffh wffh) throws Exception {
        return wffhMapper.findAddressmjnew(wffh);
    }

    @Override
    public long getCountfpNamemjnew(Wffh wffh) throws Exception {
        return wffhMapper.getCountfpNamemjnew(wffh);
    }

    @Override
    public void updateStatuefpNamemjnew(Wffh wffh) throws Exception {
        wffhMapper.updateStatuefpNamemjnew(wffh);
    }

    @Override
    public void updateghdatamjnew(String mjuserName) throws Exception {
        wffhMapper.updateghdatamjnew(mjuserName);
    }

    @Override
    public ScreenTotel finduserandcountmjnew(Wffh wffh) throws Exception {
        return wffhMapper.finduserandcountmjnew(wffh);
    }

    @Override
    public ScreenTotel finduserandcountmj2new(Wffh wffh) throws Exception {
        return wffhMapper.finduserandcountmj2new(wffh);
    }

    @Override
    public List<ScreenTotel> finduserandcountmj3new(Wffh wffh) throws Exception {
        return wffhMapper.finduserandcountmj3new(wffh);
    }

    @Override
    public ScreenTotel finduserandcountmj4new(Wffh wffh) throws Exception {
        return wffhMapper.finduserandcountmj4new(wffh);
    }

    @Override
    public List<String> findmjuserNamenew() throws Exception {
        return wffhMapper.findmjuserNamenew();
    }

    @Override
    public List<Wffh> findqtwfnew(Wffh wffh) throws Exception {
        return wffhMapper.findqtwfnew(wffh);
    }

    @Override
    public long findcfmjnew(Wffh wffh) throws Exception {
        return wffhMapper.findcfmjnew(wffh);
    }

    @Override
    public void shifangallnew() throws Exception {
        wffhMapper.shifangallnew();
    }

    @Override
    public List<ScreenTotel> finduserandcountmj5new(Wffh wffh) throws Exception {
        return wffhMapper.finduserandcountmj5new(wffh);
    }
}
