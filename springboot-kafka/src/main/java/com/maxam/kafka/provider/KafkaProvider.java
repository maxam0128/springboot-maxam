package com.maxam.kafka.provider;

import com.alibaba.fastjson.JSONObject;
import com.maxam.kafka.MessageDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author fanjinlong
 * @date 2019-07-11 20:22
 **/
@Component
@Log4j2
public class KafkaProvider {

	@Resource
	private KafkaTemplate<String,String> kafkaTemplate;


	@PostConstruct
	public void init(){
		new Thread(() -> {
			log.info("start to send message to topic [tom] !");
			for (int i = 0; i < 1000; i++) {
				try {
					Thread.sleep(ThreadLocalRandom.current().nextInt(500,3000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				sendMsg("tom");
			}
		}).start();

		new Thread(() -> {

			log.info("start to send message to topic [jack] !");
			for (int i = 0; i < 1000; i++) {
				try {
					Thread.sleep(ThreadLocalRandom.current().nextInt(500,3000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				sendMsg("jack");
			}
		}).start();

		new Thread(() -> {
			log.info("start to send message to topic [rick] !");
			for (int i = 0; i < 1000; i++) {
				try {
					Thread.sleep(ThreadLocalRandom.current().nextInt(500,3000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				sendMsg("rick");
			}
		}).start();

	}


	private void sendMsg(String topic){
		MessageDTO messageDTO = new MessageDTO();
		messageDTO.setId(System.nanoTime());
		messageDTO.setData(UUID.randomUUID());
		messageDTO.setCreateTime(new Date());
		kafkaTemplate.send(topic, JSONObject.toJSONString(messageDTO));
	}

}
