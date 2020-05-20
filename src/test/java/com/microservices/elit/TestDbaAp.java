package com.microservices.elit;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;


import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;



@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestDbaAp {
	
	 private MockMvc mockMvc;
	
	 
	 
	 @Autowired
	 private WebApplicationContext wac;
	 
	 @Autowired
	 private FilterChainProxy springSecurityFilterChain;
	 
	/* @Test
	 public void doTest() throws Exception {
		when(correctionrepo.findAll()).thenReturn(Collections.emptyList());
		MvcResult mvcresult = mvc.perform(MockMvcRequestBuilders.get("/Corr/").accept(MediaType.APPLICATION_JSON)).andReturn();
		System.out.println(mvcresult.getResponse());
		
		verify(correctionrepo);
	 }*/
	 /*
	 @Test
	 public void toDoTest() throws Exception {
	 this.mvc
	 .perform(get("/Correction"))
	 .andExpect(status().isOk())
	 .andExpect(content()
	 .contentType(MediaType.APPLICATION_JSON));
	 
	 }
	 */
	 
	 @Before
	    public void setup() {
	        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac)
	          .addFilter(springSecurityFilterChain).build();
	    }
	 
	 @Test
	 public void givenNoToken_whenGetSecureRequest_thenUnauthorized() throws Exception {
	     mockMvc.perform(get("/DbaAp"))
	       .andExpect(status().isUnauthorized());
	 }
	 
	 
	 @Test
	 public void givenToken_whenPostGetSecureRequest_thenOk() throws Exception {
	     String accessToken = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1ODc1NDAxNDUsInVzZXJfbmFtZSI6IjM2MGd1bm5lciIsImF1dGhvcml0aWVzIjpbIlJPTEVfQURNSU4iLCJST0xFX1VTRVIiXSwianRpIjoiMDlhMzViYzgtNTQ4NS00MDhlLWIyMTYtMTg0ZmQzNGIwM2ZhIiwiY2xpZW50X2lkIjoiS2VudGFjaGUiLCJzY29wZSI6WyJvcGVuaWQiXX0.CGXDeSkXj-jJoBmBj3RaVMjfiIOgdYXj2Fteh1R4rAz1t88-OUIdeBthxh4TYiXS5cnfNSbyTAoshX5GBxCQDQ7QbgI-lDpnhONgEHAz6Tf8KQWhTgfgCsgnirqDjCSliOw52bSTepay0hihP-zt2BUhkXQL6-yNIJj1c4mBQOMCOj7brDVjbMARUAJo4ZuzhpFq9jvn6NxeRSYCLO77c1SDnSfFYMVcf_D40XIaHtCgebd-Ph0LxTlvuAQPzUbyq7kV6AWgagQLlWRR7_J6M7HKs5OUvuTQc3b32X1zhfopbI0DcN7WaD7s412GMtE288cZDap0axixIiT8wVyv5Q";
	  
	           
	     mockMvc.perform(get("/DbaAp")
	       .header("Authorization", "Bearer " + accessToken))
	       
	      // .accept(application/json;charset=UTF-8))
	       .andExpect(status().isOk());
	  
	 }
	 
}


