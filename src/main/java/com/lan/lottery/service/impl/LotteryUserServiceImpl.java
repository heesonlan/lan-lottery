package com.lan.lottery.service.impl;


import com.lan.lottery.mapper.BaseMapper;
import com.lan.lottery.mapper.LotteryUserMapper;
import com.lan.lottery.model.LotteryUser;
import com.lan.lottery.service.LotteryUserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("lotteryUserService")
public class LotteryUserServiceImpl extends BaseServiceImpl<LotteryUser> implements LotteryUserService {
    @Resource
    private LotteryUserMapper mapper;

    @Override
    protected BaseMapper getMapper() {
        return mapper;
    }

    @Override
    public List<LotteryUser> findAll() {
        return mapper.findAll();
    }

    @Override
    public List<LotteryUser> findUserByAwards(Integer awardsId) {
        return mapper.findUserByAwards(awardsId);
    }

    @Override
    public List<LotteryUser> findUserForLottery() {
        return mapper.findUserForLottery();
    }
}
