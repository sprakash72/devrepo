package com.launchwindows.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.launchwindows.exception.LocationNotfoundException;
import com.launchwindows.model.LaunchWindow;
import com.launchwindows.model.LaunchWindows;
import com.launchwindows.model.weatherinfo.Constants;
import com.launchwindows.model.weatherinfo.WeatherInfo;
import com.launchwindows.model.weatherinfo.WeatherParameters;
import com.launchwindows.service.WeatherInfoService;

@Service
public class WeatherInfoServiceImpl implements WeatherInfoService {

	
	private RestTemplate restTemplate = new RestTemplate();
	
	public LaunchWindows getWeatherInfo(String city) {
		
		String locationId = Constants.citytocodemap.get(city);
		if(locationId == null)
			throw new LocationNotfoundException();
		 
		WeatherInfo locResponse = this.restTemplate.getForObject(
	        		"https://api.openweathermap.org/data/2.5/forecast?id={locationId}&units=metric&appid=" + Constants.API_KEY,
	                WeatherInfo.class, locationId);
		
		List<LaunchWindow> launchWindowlist = new ArrayList<>();
		launchWindowlist = ProcessWindowResults(launchWindowlist,locResponse, city);
		return CollectAndSort(launchWindowlist,5);
		      
	}
	
	@Override
	public LaunchWindows getWeatherInfo() {
		List<LaunchWindow> launchWindowlist = new ArrayList<>();
		
		for (Map.Entry<String, String> entry : Constants.citytocodemap.entrySet())  {
			String city = entry.getKey();
			String locationId = entry.getValue();
			
			WeatherInfo locResponse = this.restTemplate.getForObject(
	        		"https://api.openweathermap.org/data/2.5/forecast?id={locationId}&units=metric&appid=" + Constants.API_KEY,
	                WeatherInfo.class, locationId);

			launchWindowlist = ProcessWindowResults(launchWindowlist,locResponse, city);
		
		}
		return CollectAndSort(launchWindowlist,15);
	}
	
	
	
	List<LaunchWindow> ProcessWindowResults(List<LaunchWindow> launchWindowlist, WeatherInfo locResponse, String city){
		List<WeatherParameters> list = locResponse.getList(); 
		for (int i = 0; i < list.size(); ++i) {
        	WeatherParameters params = list.get(i);
        	Float temp = params.getMain().getTemp();
        	Float windDir = params.getWind().getDeg();
        	Float windSpeed = params.getWind().getSpeed();
        	int clouds = params.getClouds().getAll();
        	String datetime = params.getDt_txt();
        	
        	if (IsWindowValid(city, clouds, windSpeed) == false)
        		continue;
        	
        	int launchWindowScore = GetLaunchScore(temp, windSpeed, windDir);
        	
        	LaunchWindow launchWindow = new LaunchWindow();
        	launchWindow.setLocation(city);
        	launchWindow.setDatetime(datetime);
        	launchWindow.setScore(launchWindowScore);
        	
        	launchWindowlist.add(launchWindow);
        	
//        	System.out.println(datetime + " " + temp + " " + windDir + " "+ windSpeed + " " + clouds);
        }
		
		return launchWindowlist;
		
	}
	
	boolean IsWindowValid(String city, int clouds, Float windSpeed){
		if (Constants.cloudinessMap.containsKey(city) && clouds > Constants.cloudinessMap.get(city))
			return false;
		
		if (Constants.windspeedMap.containsKey(city) && clouds > Constants.windspeedMap.get(city))
			return false;
		
		return true; 
		
	}
	
	int GetLaunchScore(Float temp, Float windSpeed, Float windDir){
		return (int)(Math.abs(20-temp) + windSpeed + Math.abs(220 - windDir) * 0.1);
	}

	LaunchWindows CollectAndSort(List<LaunchWindow> launchWindowlist, int maxsize){
		//Sort WindowList on Score
        Collections.sort(launchWindowlist);
        LaunchWindows launchWindows = new LaunchWindows();
        
        //Create a sublist of at most top 5 results and add to window list
        launchWindows.setLaunchWindows(launchWindowlist.subList(0, Math.min(launchWindowlist.size(),maxsize)));
		 
		return launchWindows;
	}
	
	

}
