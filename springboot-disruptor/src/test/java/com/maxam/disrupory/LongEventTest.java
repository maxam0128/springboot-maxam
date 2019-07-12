package com.maxam.disrupory;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.maxam.disruptor.*;

import java.nio.ByteBuffer;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author fanjinlong
 * @date 2019-07-12 17:18
 **/
public class LongEventTest {

	public static void main(String[] args) throws InterruptedException {

		LongEventFactory eventFactory = new LongEventFactory();

		int bufferSize = 8;

		Disruptor<LongEvent> disruptor = new Disruptor<>(eventFactory, bufferSize, r -> {
			return new Thread(r, "disruptor-");
		});

		disruptor.handleEventsWith(new LongEventHandler(),new LongEventHandler2());

		disruptor.start();

		RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

		LongEventProducer producer = new LongEventProducer(ringBuffer);

		ByteBuffer bb = ByteBuffer.allocate(8);
		for (int i = 0; i < 10000; i++) {
			bb.putLong(0, i);
			producer.onData(bb);
//			Thread.sleep(ThreadLocalRandom.current().nextInt(50,200));
		}

	}
}
