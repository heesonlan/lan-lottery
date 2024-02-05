package com.lan.lottery.controller;


import com.lan.lottery.model.LotteryAwards;
import com.lan.lottery.model.LotteryUser;
import com.lan.lottery.model.MSG;
import com.lan.lottery.service.LotteryAwardsService;
import com.lan.lottery.service.LotteryRelService;
import com.lan.lottery.service.LotteryUserService;
import com.lan.lottery.util.ExcelUtil;
import com.lan.lottery.util.StringUtils;
import com.lan.lottery.vo.LotteryWinnerExportVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class LotteryController {

    @Autowired
    private LotteryUserService lotteryUserService;
    @Autowired
    private LotteryAwardsService lotteryAwardsService;
    @Autowired
    private LotteryRelService lotteryRelService;

    @PostMapping("api/lottery/findAllUsers")
    public MSG findAllUsers(){
        List<LotteryUser> list = lotteryUserService.findAll();
        return MSG.success(list);
    }

    @PostMapping("api/lottery/findUserForLottery")
    public MSG findUserForLottery(){
        List<LotteryUser> list = lotteryUserService.findUserForLottery();
        return MSG.success(list);
    }

    @PostMapping("api/lottery/findUserByAwards")
    public MSG findUserByAwards(Integer awardsId){
        List<LotteryUser> list = lotteryUserService.findUserByAwards(awardsId);
        LotteryAwards awards = lotteryAwardsService.getById(awardsId);
        Map m = new HashMap();
        m.put("awards", awards);
        m.put("winners", list);
        return MSG.success(m);
    }

    @PostMapping("api/lottery/doLottery")
    public synchronized MSG doLottery(Integer awardsId){
        try {
            Boolean f = lotteryRelService.isFinish(awardsId);
            if (f) {
                List<LotteryUser> users = lotteryUserService.findUserByAwards(awardsId);
                return MSG.success(users);
            }
            List<LotteryUser> users = lotteryAwardsService.doLottery(awardsId);
            return MSG.success(users);
        }catch (Exception e){
            log.error("抽奖失败", e);
            return MSG.error("系统故障，抽奖失败");
        }
    }


    @PostMapping("api/lottery/addAwards")
    public MSG findUserByAwards(LotteryAwards awards){
        if(StringUtils.isEmpty(awards.getAwards())){
            return MSG.error("奖项不能为空");
        }
        if(StringUtils.isEmpty(awards.getPrize())){
            return MSG.error("奖品不能为空");
        }
        if(StringUtils.isEmpty(awards.getQuantity())){
            return MSG.error("数量不能为空");
        }
        lotteryAwardsService.save(awards);
        return MSG.success();
    }

    @PostMapping("api/lottery/isFinish")
    public MSG isFinish(Integer awardsId){
        if(awardsId==null || awardsId==0){
            return MSG.error("请选择奖项后,再下载中奖名单");
        }
        Boolean finish = lotteryRelService.isFinish(awardsId);
        return MSG.success(finish);
    }

    @RequestMapping("api/lottery/downloadWinner")
    public void downloadWinner(HttpServletResponse response, HttpServletRequest request, Integer awardsId) throws IOException {
        if(awardsId==null || awardsId==0){
            return;
        }
        LotteryAwards awards = lotteryAwardsService.getById(awardsId);
        List<LotteryWinnerExportVo> list = lotteryRelService.findWinnerForExport(awardsId);
        String fileName = awards.getAwards()+"_"+awards.getPrize()+"中奖名单.xlsx";
        ExcelUtil.exportExcel(response,list, LotteryWinnerExportVo.class,fileName,"中奖名单");
    }

//    @RequestMapping("api/lottery/setNotify")
//    public MSG setNotify(String value){
//        if("true".equals(value)){
//            RedisUtil.setString("LotteryNotify", "true", 3600*12);
//            return MSG.success(value, "开启中奖通知成功！！！！！！！！！！！！！");
//        }else {
//            RedisUtil.setString("LotteryNotify", null, 3600*12);
//            return MSG.success(value, "已取消中奖通知");
//        }
//    }
}
