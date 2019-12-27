package org.szh.stream;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.szh.beans.Hello;

import com.google.common.collect.Lists;

@Service
public class SenderServer {
	
	@Autowired
	private StreamClient streamClient;
	
	@Autowired
	@Qualifier("sendChannel")
	private MessageChannel messageChannel;
	
	public boolean sendMsg(String msg) {
		Message<String> message = MessageBuilder.withPayload(msg).build();
		 System.out.println("获取成功:" + message);
		return streamClient.sendGreets().send(message);
	}
	
	public boolean sendChennelMsg(String msg) {
		  Message<String> message = MessageBuilder.withPayload(msg).build();
		  System.out.println("获取成功:" + message);
	        return messageChannel.send(message);
	}
	
	public boolean sendMsg(String msg,String version) {
		  Message<String> message = MessageBuilder.withPayload(msg).setHeader("version", version).build();
		  System.out.println("获取成功:" + message);
	        return messageChannel.send(message);
	}
	
	public boolean sendMsgList(String msg) {
		 List<String> m = Lists.newArrayList(msg+1, msg+2, msg+3);
	        Message<List<String>> message = MessageBuilder.withPayload(m).build();
	        System.out.println("获取成功:" + message);
	        return streamClient.sendGreets().send(message);
	}
	
	public boolean sendMsgObject(Hello hello,String version) {
		 Message<Hello> message = MessageBuilder.withPayload(hello).setHeader("version", version).build();
		  System.out.println("获取成功:" + message);
		return messageChannel.send(message);
	}

}
