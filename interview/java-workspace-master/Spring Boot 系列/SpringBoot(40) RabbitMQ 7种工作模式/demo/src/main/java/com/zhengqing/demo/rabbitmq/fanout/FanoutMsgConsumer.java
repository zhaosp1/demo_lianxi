package com.zhengqing.demo.rabbitmq.fanout;

import com.zhengqing.demo.constant.MqConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FanoutMsgConsumer {

    @RabbitListener(queues = MqConstant.FANOUT_QUEUE_1)
    public void listener1(String msg) {
        log.info("[消费者1] 接收消息: {}", msg);
    }

    @RabbitListener(queues = MqConstant.FANOUT_QUEUE_2)
    public void listener2(String msg) {
        log.info("[消费者2] 接收消息: {}", msg);
    }

}
