package com.launchwindows.model.weatherinfo;

import java.util.ArrayList;
import java.util.List;

public class WeatherInfo {
	String cod;
	String cnt;
	List<WeatherParameters> list = new ArrayList<>();
	
	public List<WeatherParameters> getList() {
		return list;
	}
	public void setList(List<WeatherParameters> list) {
		this.list = list;
	}
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getCnt() {
		return cnt;
	}
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	

}
