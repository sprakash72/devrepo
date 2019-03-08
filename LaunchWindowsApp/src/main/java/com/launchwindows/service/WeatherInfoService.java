package com.launchwindows.service;

import com.launchwindows.model.LaunchWindows;
import com.launchwindows.model.weatherinfo.WeatherInfo;

public interface WeatherInfoService {
	LaunchWindows getWeatherInfo(String location);
	LaunchWindows getWeatherInfo();
}


