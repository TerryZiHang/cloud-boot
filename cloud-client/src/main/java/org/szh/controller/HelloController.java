package org.szh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.szh.beans.Hello;

@RestController
public class HelloController {

    @RequestMapping(value = "/hello/zuul", method = RequestMethod.GET)
    public String hello(HttpServletRequest request, HttpServletResponse response,
            @RequestParam("data") String data) {
        return "hello," + data;
    }

    @RequestMapping(value = "/infos/zuul", method = RequestMethod.GET)
    public String info(HttpServletRequest request, HttpServletResponse response,
            @RequestParam("markId") String data) {
        return "ID为:"+data;

    }
    
    @RequestMapping(value = "/getHello/zuul", method = RequestMethod.POST)
    public Object getHello(@RequestBody Hello data) {
        return data;
    }
}
