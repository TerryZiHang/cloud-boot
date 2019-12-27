package org.szh.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * 消息通道接口
 * 
 * @author Terry Zi
 *
 */
public interface StreamClient {
	
	/** 消息输入通道名称 */
	String INPUT = "receiveChannel";
	
	@Input(StreamClient.INPUT)
	SubscribableChannel receivedGreets();
	
}
