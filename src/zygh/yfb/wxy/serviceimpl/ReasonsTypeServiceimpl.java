package zygh.yfb.wxy.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import zygh.yfb.wxy.mapper.ReasonsTypeMapper;
import zygh.yfb.wxy.service.ReasonsTypeService;
import zygh.yfb.wxy.vo.Reasons;
import zygh.yfb.wxy.vo.ReasonsType;

import java.util.List;

public class ReasonsTypeServiceimpl implements ReasonsTypeService {

    @Autowired
    private ReasonsTypeMapper reasonsTypeMapper;

    @Override
    public List<ReasonsType> findReasonsType(ReasonsType reasonsType) throws Exception {
        return reasonsTypeMapper.findReasonsType(reasonsType);
    }

    @Override
    public List<Reasons> findReasonsAndType(Reasons reasons) throws Exception {
        return reasonsTypeMapper.findReasonsAndType(reasons);
    }

    @Override
    public void insertReasonsType(ReasonsType reasonsType) throws Exception {
        reasonsTypeMapper.insertReasonsType(reasonsType);
    }

    @Override
    public void deleteReasonsType(Integer[] ReasonsTypeIds) throws Exception {
        reasonsTypeMapper.deleteReasonsType(ReasonsTypeIds);
    }

    @Override
    public void updateReasonsType(ReasonsType reasonsType) throws Exception {
        reasonsTypeMapper.updateReasonsType(reasonsType);
    }
}
