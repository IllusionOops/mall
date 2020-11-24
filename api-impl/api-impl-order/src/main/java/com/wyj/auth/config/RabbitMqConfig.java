package com.wyj.auth.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wuyijie
 * @project mall
 * @className RabbitMqConfiguration
 * @description TODO
 * @date 2020/10/17 14:45
 */
@Configuration
@Slf4j
public class RabbitMqConfig {
    @Value("${commodity.seckill.exchange}")
    private String commoditySeckillExchange;
    @Value("${commodity.seckill.queue.one}")
    private String commoditySeckillQueueOne;
    @Value("${commodity.seckill.queue.two}")
    private String commoditySeckillQueueTwo;
    @Value("${commodity.seckill.binding.one}")
    private String commoditySeckillBingdingOne;
    @Value("${commodity.seckill.binding.two}")
    private String commoditySeckillBingdingTwo;

    @Autowired
    private CachingConnectionFactory cachingConnectionFactory;


    @Bean(name = "commoditySeckillExchange")
    public TopicExchange commoditySeckillExchange()
    {
        return new TopicExchange(commoditySeckillExchange, true, true);
    }

    @Bean(name = "commoditySeckillQueueOne")
    public Queue commoditySeckillQueueOne() {
        return new Queue(commoditySeckillQueueOne,true);
    }
    @Bean(name = "commoditySeckillQueueTwo")
    public Queue commoditySeckillQueueTwo() {
        return new Queue(commoditySeckillQueueTwo,true);
    }

    @Bean(name = "commoditySeckillBingdingOne")
    public Binding commoditySeckillBingdingOne() {
        return BindingBuilder.bind(commoditySeckillQueueOne()).to(commoditySeckillExchange()).with(commoditySeckillBingdingOne);
    }
    @Bean(name = "commoditySeckillBingdingTwo")
    public Binding commoditySeckillBingdingTwo() {
        return BindingBuilder.bind(commoditySeckillQueueTwo()).to(commoditySeckillExchange()).with(commoditySeckillBingdingTwo);
    }


    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(cachingConnectionFactory);
//        mandatory：如果生产者的消息没有被正确路由，消息将会被退回给生产者，生产者需要添加相应的监听。
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());


        /**
         * @author wuyijie
         * @description TODO  消息退回监听。
         * @methodName rabbitTemplate
         * @param
         * @return * @return: org.springframework.amqp.rabbit.core.RabbitTemplate
         * @date 2020/10/17 16:01
         */
        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                log.warn("消息丢失:exchange({}),route({}),replyCode({}),replyText({}),message:{}", exchange, routingKey, replyCode, replyText, message);
            }
        });

        /**
         * @MethodName: rabbitTemplate
         * @Description: TODO 消息确认监听
         * @Param:  * @param
         * @Return: {@link RabbitTemplate}
         * @Author: yjwu
         * @Date: 2020/4/9 11:21
         **/
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                if (ack) {
                    log.info("消息发送成功，消息唯一标识：correlationData({}),确认状态：ack({}),原因：cause({})", correlationData, ack, cause);
                }
            }
        });
        return rabbitTemplate;
    }

}
