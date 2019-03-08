package com.launchwindows.controllers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.launchwindows.AbstractTest;

@RunWith(SpringRunner.class)

public class LaunchWindowsResourceTest extends AbstractTest{
	@Before
	public void setUp() {
		super.setUp();
	}
	
	@Test
	public void testGetLaunchWindowWithLocationParam() throws Exception{
		System.out.println("Running Test - 1");
		String uri = "/launchwindows?location=Melbourne";
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON))
				.andReturn();
		
		String content = result.getResponse().getContentAsString();
		System.out.println("testGetLaunchWindowWithNoParams(): content=" + content);
		
		int status = result.getResponse().getStatus();
		Assert.assertEquals("failure - expected HTTP status", 200, status);
		Assert.assertTrue("failure - expected HTTP response body to have a value", content.trim().length() > 0);

		
	}
	
	@Test
	public void testGetLaunchWindowWithNoParams() throws Exception{ //throws is required by MockMvcRequestBuilders
		System.out.println("Running Test - 2");

		String uri = "/launchwindows";
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON))
				.andReturn();
		
		String content = result.getResponse().getContentAsString();
		System.out.println("testGetLaunchWindowWithNoParams(): content=" + content);
		
		int status = result.getResponse().getStatus();
		Assert.assertEquals("failure - expected HTTP status", 200, status);
		Assert.assertTrue("failure - expected HTTP response body to have a value", content.trim().length() > 0);
		
	}
	
	@Test
	public void testGetLaunchWindowWithLocationParamInvalid() throws Exception{
		System.out.println("Running Test - 3");
		String uri = "/launchwindows?location=Sydney";
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON))
				.andReturn();
		
		String content = result.getResponse().getContentAsString();
		System.out.println("testGetLaunchWindowWithNoParams(): content=" + content);
		
		int status = result.getResponse().getStatus();
		Assert.assertEquals("failure - expected HTTP status", 404, status);
		Assert.assertTrue("failure - expected HTTP response body to have a value", content.trim().length() > 0);
		
	}


}
