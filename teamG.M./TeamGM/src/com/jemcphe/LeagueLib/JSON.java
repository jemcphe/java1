package com.jemcphe.LeagueLib;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

public class JSON {
	ArrayList<String> playerTags;
	
	public static JSONObject buildJSON() throws JSONException {
		
		JSONObject teamObject = new JSONObject();
		
		JSONObject queryObject = new JSONObject();
		
		//Loop through Team Objects
		for(Teams team : Teams.values()){
			JSONObject teamInfo = new JSONObject();
			
			//Set teamInfo
			teamInfo.put("teamName", team.setTeamName());
			teamInfo.put("keyPlayer", team.setKeyPlayer());
			teamInfo.put("position", team.setPosition());
			teamInfo.put("division", team.setDivision());

		}
		//Add query to teamObject
		teamObject.put("query", queryObject);
		
		return teamObject;
	}
	
	public static String readJSON(String selected) throws JSONException {
		String result, teamName, keyPlayer, position, division;
		JSONObject object = buildJSON();
		
		teamName = object.getJSONObject("query").getJSONObject(selected).getString("teamName");
		keyPlayer = object.getJSONObject("query").getJSONObject(selected).getString("keyPlayer");
		position = object.getJSONObject("query").getJSONObject(selected).getString("position");
		division = object.getJSONObject("query").getJSONObject(selected).getString("division");
		
		result = "Team: " + teamName + "\r\n" +
				"Key Player: " + keyPlayer + "\r\n" +
				"Position: " + position + "\r\n" +
				"Division: " + division + "\r\n";

		return result;
	}
}
