package com.lan.lottery.service.impl;

import com.lan.lottery.mapper.BaseMapper;
import com.lan.lottery.mapper.LotteryAwardsMapper;
import com.lan.lottery.model.LotteryAwards;
import com.lan.lottery.model.LotteryRel;
import com.lan.lottery.model.LotteryUser;
import com.lan.lottery.service.LotteryAwardsService;
import com.lan.lottery.service.LotteryRelService;
import com.lan.lottery.service.LotteryUserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("lotteryAwardsService")
public class LotteryAwardsServiceImpl extends BaseServiceImpl<LotteryAwards> implements LotteryAwardsService {

    @Resource
    private LotteryAwardsMapper mapper;

    @Autowired
    private LotteryUserService lotteryUserService;
    @Autowired
    private LotteryRelService lotteryRelService;

    @Override
    protected BaseMapper getMapper() {
        return mapper;
    }

    @Override
    public List<LotteryAwards> findAll() {
        return mapper.findAll();
    }

    @Override
    public List<LotteryUser> doLottery(Integer awardsId) {
        List<LotteryUser> allUserList = lotteryUserService.findUserForLottery();
        LotteryAwards awards = this.getById(awardsId);
        Integer quantity = awards.getQuantity();
        Set<Integer> idxSet = randomIndex(quantity, allUserList.size());
        List<LotteryUser> winners = new ArrayList<>();
        String msg = "同心致远，聚力腾飞。恭喜您在2023研发体系年终会抽中了"+awards.getAwards()+"，奖品："+awards.getPrize()+"。";
        StringBuilder sendUsers = new StringBuilder();
        for(Integer i:idxSet){
            LotteryUser user = allUserList.get(i);
            LotteryRel rel = new LotteryRel();
            rel.setAwardsId(awards.getId());
            rel.setAwards(awards.getAwards());
            rel.setUserId(user.getId());
            rel.setUserName(user.getUserName());
            lotteryRelService.save(rel);
            winners.add(user);
            sendUsers.append(user.getUserName()).append(";");
        }
        // 暂不发送中奖通知
        return winners;
    }

    //实际抽奖随机下标
    public Set<Integer> randomIndex(int n, int maxSize) {
        SecureRandom rand = new SecureRandom();
        Set<Integer> idxSet = new HashSet<>();
        if(maxSize<n){// 奖比人还多，那么人人中奖
            for(int i=0;i<maxSize; i++){
                idxSet.add(i);
            }
            return idxSet;
        }

        while (idxSet.size()<n){
            Integer r = rand.nextInt(maxSize);
            idxSet.add(r);
        }
        return idxSet;
    }
}
