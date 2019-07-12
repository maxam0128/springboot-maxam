package com.maxam.disruptor;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * @author fanjinlong
 * @date 2019-07-12 17:13
 **/
public class LongEventProducerWithTranslator {

	private final RingBuffer<LongEvent> ringBuffer;

	public LongEventProducerWithTranslator(RingBuffer<LongEvent> ringBuffer) {
		this.ringBuffer = ringBuffer;
	}

	public void onData(ByteBuffer byteBuffer){
		ringBuffer.publishEvent(TRANSLATOR,byteBuffer);
	}

	private static final EventTranslatorOneArg<LongEvent, ByteBuffer> TRANSLATOR = (event, sequence, arg0) -> event.setValue(arg0.getLong(0));
}
