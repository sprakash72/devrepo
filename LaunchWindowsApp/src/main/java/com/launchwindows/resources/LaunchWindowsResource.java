package com.launchwindows.resources;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.launchwindows.model.LaunchWindows;
import com.launchwindows.service.WeatherInfoService;
import com.launchwindows.service.impl.WeatherInfoServiceImpl;


@RestController
public class LaunchWindowsResource {
	
	@Resource
	WeatherInfoService weatherInfoService; 
	
	@RequestMapping(value= "/launchwindows")
	public ResponseEntity<LaunchWindows> getLaunchWindow(@RequestParam(name="location",required=false) String location)
	{
		System.out.println("Location: " + location);
		LaunchWindows  launchWindows = null;
		if (location == null)
			launchWindows = weatherInfoService.getWeatherInfo();
		else
			launchWindows = weatherInfoService.getWeatherInfo(location);
		
		return new ResponseEntity<LaunchWindows>(launchWindows, HttpStatus.OK);
	}

}
