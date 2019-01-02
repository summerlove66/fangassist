package com.huido.fangassist.controller;


import com.huido.fangassist.model.House;
import com.huido.fangassist.model.Result;
import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FangController {

    @RequestMapping("/fang")
    public Result getHouseList(HttpSession session , HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        System.out.println(session +"-----");
//        if (!"1".equals(session.getAttribute("verified") + "")) {
//            return new Result(0, "请先登陆", "");
//        }
        House house = new House();
        house.setCity("重庆");
        house.setCommunity("盘龙一号");
        house.setDistrict("观音桥");
        house.setHouseId(12);
        house.setPhoneNumber("10086");
        house.setImg("https://pic3.58cdn.com.cn/mobile/small/n_v2a62ce24bb88b403183b1188a11abfdd4.jpg");
        house.setInfo("2室1厅|60.97㎡|天瑞国际");
        house.setPrice(102);
        house.setTitle("随便一家房子，准备卖个100wf");
        List<House> houseList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {

            houseList.add(house);

        }
        return new Result(1, "success", houseList);
    }


}
