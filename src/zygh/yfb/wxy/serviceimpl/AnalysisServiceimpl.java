package zygh.yfb.wxy.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import zygh.yfb.wxy.mapper.AnalysisMapper;
import zygh.yfb.wxy.service.AnalysisService;
import zygh.yfb.wxy.vo.Analysis;
import zygh.yfb.wxy.vo.ReasonsTj;

import java.util.List;

public class AnalysisServiceimpl implements AnalysisService {

    @Autowired
    private AnalysisMapper analysisMapper;

    @Override
    public List<Analysis> findAnalysis() throws Exception {
        return analysisMapper.findAnalysis();
    }

    @Override
    public List<ReasonsTj> findtest(Analysis analysis) throws Exception {
        return analysisMapper.findtest(analysis);
    }

    @Override
    public List<ReasonsTj> findAnalysisAndType() throws Exception {
        return analysisMapper.findAnalysisAndType();
    }

    @Override
    public List<Analysis> findifadd(Analysis analysis) throws Exception {
        return analysisMapper.findifadd(analysis);
    }

    @Override
    public void insertAnalysis(Analysis analysis) throws Exception {
        analysisMapper.insertAnalysis(analysis);
    }

    @Override
    public void updateAnalysis(Analysis analysis) throws Exception {
        analysisMapper.updateAnalysis(analysis);
    }
}
