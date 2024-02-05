package com.lan.lottery.mapper;


import com.lan.lottery.model.LotteryUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LotteryUserMapper extends BaseMapper{

    List<LotteryUser> findAll();

    List<LotteryUser> findUserByAwards(@Param("awardsId") Integer awardsId);

    List<LotteryUser> findUserForLottery();
}