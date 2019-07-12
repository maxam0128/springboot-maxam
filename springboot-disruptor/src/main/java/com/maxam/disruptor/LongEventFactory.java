package com.maxam.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @author fanjinlong
 * @date 2019-07-12 16:58
 **/
public class LongEventFactory implements EventFactory<LongEvent> {
	@Override
	public LongEvent newInstance() {
		return new LongEvent();
	}
}
