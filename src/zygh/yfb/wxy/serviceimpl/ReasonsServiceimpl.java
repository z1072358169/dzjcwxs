package zygh.yfb.wxy.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import zygh.yfb.wxy.mapper.ReasonsMapper;
import zygh.yfb.wxy.service.ReasonsService;
import zygh.yfb.wxy.vo.Reasons;

import java.util.List;

public class ReasonsServiceimpl implements ReasonsService {

    @Autowired
    private ReasonsMapper reasonsMapper;

    @Override
    public List<Reasons> findReasons(Reasons reasons) throws Exception {
        return reasonsMapper.findReasons(reasons);
    }

    @Override
    public void insertReasons(Reasons reasons) throws Exception {
        reasonsMapper.insertReasons(reasons);
    }

    @Override
    public void deleteReasons(Integer[] ReasonsIds) throws Exception {
        reasonsMapper.deleteReasons(ReasonsIds);
    }

    @Override
    public void updateReasons(Reasons reasons) throws Exception {
        reasonsMapper.updateReasons(reasons);
    }
}
