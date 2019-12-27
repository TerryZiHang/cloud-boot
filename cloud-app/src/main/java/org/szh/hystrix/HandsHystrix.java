package org.szh.hystrix;

import org.springframework.stereotype.Component;
import org.szh.client.HandsClient;

/**
 * @author Terry
 * @date 2019年12月27日
 * @description
 * 熔断器，出现远程调用失败的时候 提供一种
 * 保证程序正常运行而不会卡死的情况
 */
@Component
public class HandsHystrix implements HandsClient{

    @Override
    public String hello(String data) {
        if(data  == null) {
            return "问候对象不存在";
        }
        return null;
    }

    @Override
    public String info(String markId) {
        return "不存在";
    }
}
