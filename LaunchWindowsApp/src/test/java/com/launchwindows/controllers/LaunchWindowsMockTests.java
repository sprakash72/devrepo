package com.launchwindows.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.launchwindows.AbstractTest;
import com.launchwindows.resources.LaunchWindowsResource;
import com.launchwindows.service.WeatherInfoService;


public class LaunchWindowsMockTests extends AbstractTest
{
	@Mock
	private WeatherInfoService weatherInfoService;
	
	@InjectMocks
	private LaunchWindowsResource launchWindowsResource; 
	@Before
	public void setUp() {
		// Initialize Mockito annotated components
		MockitoAnnotations.initMocks(this);
		// Prepare the Spring MVC Mock components for standalone testing
		setUp(launchWindowsResource);
	}
	
	
	@Test
	public void testGetLaunchWindowsWithNoPrams() throws Exception {
		
	}
	


}
