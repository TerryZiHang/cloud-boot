package org.szh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.szh.beans.Hello;
import org.szh.client.HandsClient;
import org.szh.stream.SenderServer;

@RestController
public class HelloControler {
	@Autowired
	private HandsClient handsClient;

	@Autowired
	private SenderServer senderServer;

	@RequestMapping(value = "/start", method = RequestMethod.GET)
	public Object manage(HttpServletRequest request, HttpServletResponse response) {
		senderServer.sendChennelMsg("开始测试");
		return "success";

	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public Object hello(HttpServletRequest request, HttpServletResponse response, @RequestParam("data") String data) {
		senderServer.sendMsg(data);
		return handsClient.hello(data);

	}

	@RequestMapping(value = "/mark", method = RequestMethod.GET)
    public Object mark(HttpServletRequest request, HttpServletResponse response,
            @RequestParam("markId") String data) {
    	senderServer.sendMsg(data, "1.0");
    	senderServer.sendMsg(data, "2.0");
        return handsClient.info(data);

    }

	@RequestMapping(value = "/test", method = RequestMethod.POST,consumes = "application/json")
    public Object getData(@RequestBody Hello data) {
		senderServer.sendMsgObject(data,"3.0");
        return "ok";
    }

}
