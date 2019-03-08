package com.launchwindows.model;

public class LaunchWindow implements Comparable{
	String location;
	String datetime;
	int score;
	
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public int compareTo(Object compareto) {
		int comparescore =((LaunchWindow)compareto).getScore();
        /* For Ascending order*/
        return this.score-comparescore;

	}
	
	
}
