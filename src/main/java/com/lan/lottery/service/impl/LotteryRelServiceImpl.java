package com.lan.lottery.service.impl;

import com.lan.lottery.mapper.BaseMapper;
import com.lan.lottery.mapper.LotteryRelMapper;
import com.lan.lottery.model.LotteryRel;
import com.lan.lottery.service.LotteryRelService;
import com.lan.lottery.vo.LotteryWinnerExportVo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("lotteryRelService")
public class LotteryRelServiceImpl extends BaseServiceImpl<LotteryRel> implements LotteryRelService {

    @Resource
    private LotteryRelMapper mapper;

    @Override
    protected BaseMapper getMapper() {
        return mapper;
    }

    @Override
    public List<LotteryRel> findByAwards(Integer awardsId) {
        return mapper.findByAwards(awardsId);
    }

    @Override
    public Boolean isFinish(Integer awardsId) {
        List<LotteryRel> list = findByAwards(awardsId);
        return list.size()>0;
    }

    @Override
    public List<LotteryWinnerExportVo> findWinnerForExport(Integer awardsId) {
        return mapper.findWinnerForExport(awardsId);
    }
}
