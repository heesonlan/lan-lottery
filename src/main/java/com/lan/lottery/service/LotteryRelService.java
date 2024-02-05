package com.lan.lottery.service;


import com.lan.lottery.model.LotteryRel;
import com.lan.lottery.vo.LotteryWinnerExportVo;

import java.util.List;

public interface LotteryRelService extends BaseService<LotteryRel>{

    List<LotteryRel> findByAwards(Integer awardsId);

    Boolean isFinish(Integer awardsId);

    List<LotteryWinnerExportVo> findWinnerForExport(Integer awardsId);
}