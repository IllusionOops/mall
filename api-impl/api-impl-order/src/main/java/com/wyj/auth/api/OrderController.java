package com.wyj.auth.api;

import com.wyj.auth.entity.po.MallCommodity;
import com.wyj.auth.mq.CommodityMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author wuyijie
 * @project mall
 * @className OrderController
 * @description TODO
 * @date 2020/10/17 17:05
 */
@RestController
@RequestMapping("orderController")
public class OrderController {
    @Autowired
    private CommodityMessageProducer commodityMessageProducer;

    @RequestMapping(value = "send1",method = RequestMethod.GET)
    public void send1(@RequestParam("version") String version){
        MallCommodity mallCommodity=new MallCommodity();
        mallCommodity.setName("iphone "+version);
        mallCommodity.setStock(99999);
        mallCommodity.setPrice(new BigDecimal("9999"));
        commodityMessageProducer.sendMessageOne(mallCommodity);

    }

    @RequestMapping(value = "send2",method = RequestMethod.GET)
    public void send2(@RequestParam("version") String version){
        MallCommodity mallCommodity=new MallCommodity();
        mallCommodity.setName("iphone "+version);
        mallCommodity.setStock(88888);
        mallCommodity.setPrice(new BigDecimal("8888"));
        commodityMessageProducer.sendMessageTwo(mallCommodity);

    }
}
