package org.szh.stream;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;
import org.szh.beans.Hello;

/**
 * 绑定自定义的消息通道接口，监听处理消息
 * 
 * @author Terry Zi
 *
 */
@Component
@EnableBinding({StreamClient.class})
public class StreamReceiver {
	
    /**
     * @StreamListener：该注解主要定义在方法上，作用是将被修饰的方法注册为消息中间件上数据流的事件监听器，
     * 注解中的属性值对应了监听的消息通道名。
     * 
     * @param message
     */
    @StreamListener(StreamClient.INPUT)
    public void recevieMessage(Object message){
        System.out.println("接收成功:" + message);
    }
    
    @StreamListener(value = StreamClient.INPUT,condition="headers['version']=='1.0'")
    public void recevieMessage1(Object message){
        System.out.println("1.0接收成功:" + message);
    }
    
    @StreamListener(value = StreamClient.INPUT,condition = "headers['version'] == '2.0'")
    public void recevieMessage2(Object message){
        System.out.println("2.0接收成功:" + message);
    }
    
    @StreamListener(value = StreamClient.INPUT,condition = "headers['version'] == '3.0'")
    public void recevieMessageObject(Hello message){
        System.out.println("3.0接收成功:" + message.getName());
    }
}
