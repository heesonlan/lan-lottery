package com.lan.lottery.mapper;


import com.lan.lottery.model.LotteryRel;
import com.lan.lottery.vo.LotteryWinnerExportVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LotteryRelMapper extends BaseMapper{

    List<LotteryRel> findByAwards(@Param("awardsId") Integer awardsId);

    List<LotteryWinnerExportVo> findWinnerForExport(@Param("awardsId") Integer awardsId);
}