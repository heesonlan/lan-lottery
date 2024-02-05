package com.lan.lottery.mapper;


import com.lan.lottery.model.LotteryAwards;

import java.util.List;

public interface LotteryAwardsMapper extends BaseMapper{

    List<LotteryAwards> findAll();
}