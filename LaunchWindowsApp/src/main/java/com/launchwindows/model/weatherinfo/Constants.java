package com.launchwindows.model.weatherinfo;

import java.util.HashMap;
import java.util.Map;

public class Constants {

//	public static Map<String,String> codetoc = new HashMap<String, String>(){{
//		put ("7839805", "Melbourne");
//		put ("2073124", "Darwin");
//		put ("2163355", "Hobart");
//		put ("2063523", "Perth");
//	}};
	
	public static Map<String,String> citytocodemap = new HashMap<String, String>(){{
		put ("Melbourne", "7839805");
		put ("Darwin", "2073124");
		put ("Hobart", "2163355");
		put ("Perth", "2063523");
	}};
	
	public static Map<String, Integer> cloudinessMap = new HashMap<String, Integer>(){{
		put ("Melbourne", 50);
		put ("Darwin", 40);
		put ("Hobart", 60);
		put ("Perth", 30);
	}};
	
	public static Map<String, Integer> windspeedMap = new HashMap<String, Integer>(){{
		put ("Melbourne", 20);
		put ("Darwin", 15);
		put ("Hobart", 10);
		put ("Perth", 5);
	}};
	
	public static String API_KEY = "18a3c9d67440a40a22dafdb6027d56b2";

}
