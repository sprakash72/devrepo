package com.launchwindows.model.weatherinfo;

public class WeatherParameters {
	MainSection main;
	CloudSection clouds;
	WindSection wind;
	
	String dt_txt;

	public MainSection getMain() {
		return main;
	}

	public void setMain(MainSection main) {
		this.main = main;
	}

	public String getDt_txt() {
		return dt_txt;
	}

	public void setDt_txt(String dt_txt) {
		this.dt_txt = dt_txt;
	}

	public CloudSection getClouds() {
		return clouds;
	}

	public void setClouds(CloudSection clouds) {
		this.clouds = clouds;
	}

	public WindSection getWind() {
		return wind;
	}

	public void setWind(WindSection wind) {
		this.wind = wind;
	}

}
