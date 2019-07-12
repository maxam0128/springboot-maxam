package com.maxam.disruptor;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

public interface Producer<T> {

	void produce(RingBuffer<T> ringBuffer, ByteBuffer byteBuffer);
}
