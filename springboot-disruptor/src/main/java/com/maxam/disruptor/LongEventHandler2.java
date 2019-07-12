package com.maxam.disruptor;

import com.lmax.disruptor.EventHandler;
import lombok.extern.log4j.Log4j2;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author fanjinlong
 * @date 2019-07-12 17:53
 **/
@Log4j2
public class LongEventHandler2 implements EventHandler<LongEvent> {
	@Override
	public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
		Thread.sleep(ThreadLocalRandom.current().nextInt(200,500));
		System.out.println("LongEventHandler2 ,sequence: [" + sequence+ "],event:["+event.getValue()+"], endOfBatch: ["+endOfBatch+"]");
//		log.info("LongEventHandler2 ,sequence: [{}],event:[{}], endOfBatch: [{}]",sequence,event.getValue(),endOfBatch);
	}
}
