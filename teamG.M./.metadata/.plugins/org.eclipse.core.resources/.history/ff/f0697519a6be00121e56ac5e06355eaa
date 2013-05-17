package com.jemcphe.LeagueLib;

import java.util.ArrayList;

import android.util.Log;

import com.jemcphe.LeagueLib.Teams;

import org.json.JSONException;
import org.json.JSONObject;

public class Json {
	ArrayList<String> playerTags;
	
	public static JSONObject buildJSON(){
		
		JSONObject teamObject = new JSONObject();
		
		JSONObject queryObject = new JSONObject();
		
		//Loop through Team Objects
		for(Teams team : Teams.values()){
			JSONObject teamInfo = new JSONObject();
			
			//Set teamInfo
			try {
				teamInfo.put("team name", team.setTeamName());
				teamInfo.put("key player", team.setKeyPlayer());
				teamInfo.put("position", team.setPosition());
				teamInfo.put("division", team.setDivision());
				
				//Add query to teamObject
				teamObject.put("query", queryObject);
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		}
		
		
		return teamObject;
	}
	
	public static String readJSON(String radioText){
		String result, teamName, keyPlayer, position, division;
		JSONObject object = buildJSON();
		try {
			teamName = object.getJSONObject("query").getJSONObject(radioText).getString("team name");
			keyPlayer = object.getJSONObject("query").getJSONObject(radioText).getString("key player");
			position = object.getJSONObject("query").getJSONObject(radioText).getString("position");
			division = object.getJSONObject("query").getJSONObject(radioText).getString("division");

			result = "Current Team Information:\r\n" + teamName + "\r\n" +
					"Key Player: " + keyPlayer + "\r\n" +
					"Position: " + position + "\r\n" +
					"Division: " + division + "\r\n";

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = e.toString();
		}
		Log.i("JSON SHOWS: ", result);
		return result;
	}
}
