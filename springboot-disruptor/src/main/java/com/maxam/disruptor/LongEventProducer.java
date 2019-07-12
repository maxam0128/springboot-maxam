package com.maxam.disruptor;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * @author fanjinlong
 * @date 2019-07-12 17:02
 **/
public class LongEventProducer {

	private final RingBuffer<LongEvent> ringBuffer;

	public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
		this.ringBuffer = ringBuffer;
	}

	public void onData(ByteBuffer byteBuffer){
		long seq = ringBuffer.next();
		try {
			LongEvent longEvent = ringBuffer.get(seq);
			longEvent.setValue(byteBuffer.getLong(0));
		} finally {
			ringBuffer.publish(seq);
		}
	}
}
