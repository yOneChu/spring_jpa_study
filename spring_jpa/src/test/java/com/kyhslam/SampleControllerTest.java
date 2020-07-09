package com.kyhslam;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.kyhslam.controller.SampleController;



@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class)
public class SampleControllerTest {

	
	@Autowired
	MockMvc mock;
	
	@Test
	public void testHello() throws Exception {
		
		//mock.perform(get("/hello")).andExpect(content().string("Hello World"));
		
		mock.perform(get("/rest")).andDo(MockMvcResultHandlers.print());
	}
	
}
