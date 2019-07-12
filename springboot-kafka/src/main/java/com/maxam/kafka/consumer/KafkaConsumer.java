package com.maxam.kafka.consumer;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author fanjinlong
 * @date 2019-07-11 20:42
 **/
@Component
@Log4j2
public class KafkaConsumer {

	@KafkaListener(topics = {"tom","rick"})
	public void listen(ConsumerRecord<?,?> record){
		Object value = record.value();
		if(Objects.nonNull(value)){
			log.info(" the topic is: [{}], received message : [{}]",record.topic(), JSONObject.toJSONString(value));
		}
	}
}
