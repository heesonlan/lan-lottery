package com.lan.lottery.controller;

import com.lan.lottery.model.LotteryAwards;
import com.lan.lottery.model.LotteryRel;
import com.lan.lottery.service.LotteryAwardsService;
import com.lan.lottery.service.LotteryRelService;
import com.lan.lottery.service.LotteryUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Slf4j
@Controller
public class UrlController {

    @Autowired
    private LotteryAwardsService lotteryAwardsService;
    @Autowired
    private LotteryRelService lotteryRelService;
    @Autowired
    private LotteryUserService lotteryUserService;

    @RequestMapping("login")
    public String login(){
        return "login";
    }

    @RequestMapping("api/lottery/index")
    public String lottery(Model model){
        List<LotteryAwards> list = lotteryAwardsService.findAll();
        List resList = new ArrayList();
        String pre = null;
        List list1 = new ArrayList();
        for(LotteryAwards o:list){
            List<LotteryRel> rels = lotteryRelService.findByAwards(o.getId());
            if(rels.size()==0){
                o.setTopic("not-start");
            }else{
                o.setTopic("finish");
            }
            if(pre==null || pre.equals(o.getAwards())){//同项
                list1.add(o);
            } else {//异项
                Map<String,Object> m = new HashMap<>();
                m.put("name", pre);
                m.put("list", list1);
                resList.add(m);
                list1 = new ArrayList();
                list1.add(o);
            }
            pre=o.getAwards();
        }
        if(list1.size()>0){
            Map<String,Object> m = new HashMap<>();
            m.put("name", pre);
            m.put("list", list1);
            resList.add(m);
        }
        String nameOrder = "01特02盲11一12二13三14四15五16六17七18八19九20十";

        resList.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Map m1 = (Map)o1;
                Map m2 = (Map)o2;
                String name1 = (String)m1.get("name");
                String name2 = (String)m2.get("name");
                int i01 = nameOrder.indexOf(name1.substring(0, 1));
                int i02 = nameOrder.indexOf(name2.substring(0, 1));
                if(i01>=0){
                    name1 = nameOrder.substring(i01-2,i01);
                }
                if(i02>=0){
                    name2 = nameOrder.substring(i02-2,i02);
                }
                return name1.compareTo(name2);
            }
        });
    //    log.info(JSON.toJSONString(resList));
        model.addAttribute("awardsList", resList);
        return "lottery";
    }
}
