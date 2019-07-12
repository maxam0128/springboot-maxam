package com.maxam.disruptor;

import com.lmax.disruptor.EventHandler;
import lombok.extern.log4j.Log4j2;

/**
 * @author fanjinlong
 * @date 2019-07-12 16:59
 **/
@Log4j2
public class LongEventHandler implements EventHandler<LongEvent> {
	@Override
	public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
		System.out.println("LongEventHandler ,sequence: [" + sequence+ "],event:["+event.getValue()+"], endOfBatch: ["+endOfBatch+"]");
//		log.info("LongEventHandler ,sequence: [{}],event:[{}], endOfBatch: [{}]",sequence,event.getValue(),endOfBatch);
	}
}
