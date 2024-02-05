package com.lan.lottery.service;


import com.lan.lottery.model.LotteryUser;

import java.util.List;

public interface LotteryUserService extends BaseService<LotteryUser>{

    List<LotteryUser> findAll();

    List<LotteryUser> findUserByAwards(Integer awardsId);

    List<LotteryUser> findUserForLottery();
}