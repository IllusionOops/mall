package com.wyj.auth.mq;

import com.wyj.auth.entity.po.MallCommodity;
import com.wyj.auth.utils.UUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author wuyijie
 * @project mall
 * @className CommodityMessageConsumer
 * @description TODO
 * @date 2020/10/17 16:07
 */
@Component
@Slf4j
public class CommodityMessageProducer {
    @Value("${commodity.seckill.exchange}")
    private String commoditySeckillExchange;
    @Value("${commodity.seckill.binding.one}")
    private String commoditySeckillBingdingOne;
    @Value("${commodity.seckill.binding.two}")
    private String commoditySeckillBingdingTwo;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessageOne(MallCommodity mallCommodity){
        CorrelationData correlationData=new CorrelationData(UUIDUtil.getUUIDCode());
        log.info("sendMessageOne send message {}",mallCommodity.toString());
        rabbitTemplate.convertAndSend(commoditySeckillExchange, commoditySeckillBingdingOne,mallCommodity,correlationData);
    }

    public void sendMessageTwo(MallCommodity mallCommodity){
        CorrelationData correlationData=new CorrelationData(UUIDUtil.getUUIDCode());
        log.info("sendMessageTwo send message {}",mallCommodity.toString());
        rabbitTemplate.convertAndSend(commoditySeckillExchange, commoditySeckillBingdingTwo,mallCommodity,correlationData);
    }
}
