package com.lan.lottery.service;


import com.lan.lottery.model.LotteryAwards;
import com.lan.lottery.model.LotteryUser;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LotteryAwardsService extends BaseService<LotteryAwards> {

    List<LotteryAwards> findAll();

    @Transactional
    List<LotteryUser> doLottery(Integer awardsId);
}