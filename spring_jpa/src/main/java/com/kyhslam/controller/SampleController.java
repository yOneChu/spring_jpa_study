package com.kyhslam.controller;

import java.net.URI;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kyhslam.domain.ResponseMessage;
import com.kyhslam.domain.SampleVO;

@RestController
public class SampleController {

	Logger logger = LoggerFactory.getLogger(SampleController.class);

	@GetMapping("/hello")
	public String sayHello() {
		
		return "Hello World";
	}
	
	
	@GetMapping("/sample")
	public SampleVO makeSample() {
		
		SampleVO vo = new SampleVO();
		
		vo.setVal1("v1");
		vo.setVal2("v2");

		logger.info("vo --- " + vo);
		
		
		
		return vo;
	}
	
	@RequestMapping(value= "/rest", method = RequestMethod.GET)
	public ResponseMessage restTest() {
		
		SampleVO vo = new SampleVO();
		
		vo.setVal1("v1");
		vo.setVal2("v2");

		logger.info("vo --- " + vo);
		
		HashMap<String, SampleVO> map = new HashMap<>();
		map.put("GOOD", vo);
		
		ResponseMessage message = new ResponseMessage(HttpStatus.OK);
		logger.info("HttpStatus.OK --- " + HttpStatus.OK);
		message.setSample(vo);
		
		return message;
	}
	
	
	@RequestMapping(value="test3")
	public ResponseEntity test3() {
		SampleVO vo = new SampleVO();
		
		vo.setVal1("v1");
		vo.setVal2("v2");

		
		URI createdURI = ControllerLinkBuilder.linkTo(SampleController.class).slash(vo).toUri();
		// ResponseEntity.created(createdURI).body(newEvent);

		return ResponseEntity.created(createdURI).body(vo);
	}
	
}
