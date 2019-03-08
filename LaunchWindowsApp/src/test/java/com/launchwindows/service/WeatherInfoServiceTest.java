package com.launchwindows.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.launchwindows.AbstractTest;
import com.launchwindows.model.LaunchWindows;
import com.launchwindows.model.weatherinfo.CloudSection;
import com.launchwindows.model.weatherinfo.MainSection;
import com.launchwindows.model.weatherinfo.WeatherInfo;
import com.launchwindows.model.weatherinfo.WeatherParameters;
import com.launchwindows.model.weatherinfo.WindSection;
import com.launchwindows.service.impl.WeatherInfoServiceImpl;

@RunWith(SpringRunner.class)
//@RunWith(MockitoJUnitRunner.class) 
public class WeatherInfoServiceTest extends AbstractTest{
	@Mock
	RestTemplate restTemplate;
	
//	@InjectMocks
//	@Spy
	WeatherInfoService weatherInfoService;
	ResponseEntity responseEntity = mock(ResponseEntity.class);
	
	WeatherInfo weatherInfo = mock(WeatherInfo.class);
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		weatherInfoService = new WeatherInfoServiceImpl();
	}
	
	@Test
	public void testGetWeatherInfoforMelbourne(){
		System.out.println("Running Test with mockito - 1");
		weatherInfo = populateWeatherInfoForMelbourne();
		
				
		when(restTemplate.getForObject(Mockito.anyString(),ArgumentMatchers.any(Class.class)
                )).thenReturn(weatherInfo);
		
		
		LaunchWindows launchWindows = weatherInfoService.getWeatherInfo("Melbourne");
		Assert.assertTrue("failure - list not filled", launchWindows.getLaunchWindows().size() > 0);
//		Assert.assertEquals("failure - incorrect value", 3, launchWindows.getLaunchWindows().size());
		
	}
	
	
	WeatherInfo populateWeatherInfoForMelbourne(){
		WeatherInfo weatherInfo = new WeatherInfo();
		weatherInfo.setCnt("2");
		weatherInfo.setCod("200");
		List<WeatherParameters> list = new ArrayList<>();
		WeatherParameters wp1 = new WeatherParameters();
		MainSection main = new MainSection();
		main.setTemp(25.0f);
		wp1.setMain(main);
		WindSection wind = new WindSection();
		wind.setDeg(150.0f);
		wind.setSpeed(4.77f);
		CloudSection clouds = new CloudSection();
		clouds.setAll(30);
		wp1.setMain(main);
		wp1.setWind(wind);
		wp1.setClouds(clouds);
		wp1.setDt_txt("09-03-2018: 18:30");
		list.add(wp1);
		
		WeatherParameters wp2 = new WeatherParameters();
		MainSection main2 = new MainSection();
		main2.setTemp(24.0f);
		wp1.setMain(main2);
		WindSection wind2 = new WindSection();
		wind2.setDeg(157.0f);
		wind2.setSpeed(3.77f);
		CloudSection clouds2 = new CloudSection();
		clouds.setAll(20);
		wp1.setMain(main2);
		wp1.setWind(wind2);
		wp1.setClouds(clouds2);
		wp1.setDt_txt("12-03-2018: 19:30");
		list.add(wp2);
		
		weatherInfo.setList(list);
		return weatherInfo;
				
	}

}
