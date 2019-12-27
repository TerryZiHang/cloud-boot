package org.szh.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
/**
 * 自定义消息通道接口
 * 
 * @author Terry Zi
 *
 */
public interface StreamClient {
	
	
	/** 消息输出通道名 */
	String OUTPUT = "sendChannel";
	
	@Output(StreamClient.OUTPUT)
	MessageChannel  sendGreets();
}
