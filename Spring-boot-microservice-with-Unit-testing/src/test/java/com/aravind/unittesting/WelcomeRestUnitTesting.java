package com.aravind.unittesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.aravind.rest.WelcomeRest;
import com.aravind.service.WelcomeService;

@WebMvcTest(value = WelcomeRest.class)
public class WelcomeRestUnitTesting {
	
	@MockBean
	private WelcomeService service;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void test() throws Exception {
		when(service.welcomeMsg()).thenReturn("hi man...!");
		MockHttpServletRequestBuilder builder=MockMvcRequestBuilders.get("/welcome");
		 MvcResult mvc = mockMvc.perform(builder).andReturn();
		MockHttpServletResponse res = mvc.getResponse();
		int actual = res.getStatus();
		int expected = 200;
		assertEquals(expected, actual);
	}
	
	@Test
	public void greetTest() throws Exception {
		when(service.greetMsg()).thenReturn("from greeet");
		MockHttpServletRequestBuilder builder=MockMvcRequestBuilders.get("/greet");
		MvcResult msg = mockMvc.perform(builder).andReturn();
		MockHttpServletResponse resp = msg.getResponse();
		int status=resp.getStatus();
		assertEquals(200, status);
	}
}
