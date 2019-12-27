package org.szh.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.szh.hystrix.HandsHystrix;

@FeignClient(name = "hands-client" , fallback = HandsHystrix.class)
public interface HandsClient {
    
    @RequestMapping(value = "/hello/zuul",method=RequestMethod.GET)
    String hello(@RequestParam("data") String data);
    
    @RequestMapping(value = "/infos/zuul",method=RequestMethod.GET)
    String info(@RequestParam("markId") String data);
    
}
