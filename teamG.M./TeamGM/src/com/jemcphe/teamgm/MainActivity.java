package com.jemcphe.teamgm;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;
//import java.net.URLEncoder;

import com.jemcphe.LayoutLib.Elements;
import com.jemcphe.LayoutLib.SpinnerDisplay;
import com.jemcphe.LayoutLib.TeamDisplay;
import com.jemcphe.LayoutLib.TeamSearch;
import com.jemcphe.LeagueLib.FileInfo;
import com.jemcphe.LeagueLib.WebData;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
	//Create Linear Layouts
	LinearLayout _mainLayout;
//	LinearLayout mainLayout;
//	LayoutParams mainParams;
//	
//	LinearLayout radioLayout;
//	LayoutParams radioParams;
//	
//	LinearLayout entryBox;
//	
//	LinearLayout dataLayout;
//	LayoutParams dataParams;
	
	//Create Displays
	TeamSearch _search;
	TeamDisplay _teamDisplay;
	SpinnerDisplay _teamList;
	
	//Declare Variables
	TextView _searchLabel;
	TextView dataBox;
	TextView teamData;
	RadioGroup teamOptions;
	String[] teamNames;
	Boolean _connected = false;
	Context _context;
	HashMap<String, String> _history;

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        _context = this;
        LayoutParams lp;
        
        _history = new HashMap<String, String>();
        _history = getHistory();
        Log.i("HISTORY READ", _history.toString());
        
        
        //Determine data connection
        _connected = WebData.getConnectionStatus(_context);
        //Check for connection
        if(_connected) {
        	Log.i("Network Connection", WebData.getConnectionType(_context));
        }
        
        //Create LinearLayout for Main Layout
        _mainLayout = new LinearLayout(_context);
        lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        _mainLayout.setLayoutParams(lp);
        
		_searchLabel = new TextView(_context);
		_searchLabel.setText("Search For A Team");
        
        
        _search = new TeamSearch(_context, "ex. orioles, red sox, etc...", "GO");
        
        Button searchButton = _search.getButton();
        
        searchButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				getTeam(_search.getField().getText().toString());
			}
		});
        
        //array that holds resources remote
        teamNames = getResources().getStringArray(R.array.remote);
        //call getTeam function
        teamOptions = Elements.getTeam(this, teamNames);
        
        //Add Team Display
        _teamDisplay = new TeamDisplay(_context);
        
        //Add Views to _mainLayout
        _mainLayout.setOrientation(LinearLayout.VERTICAL);
        _mainLayout.addView(_searchLabel);
        _mainLayout.addView(_search);

        _mainLayout.addView(_teamDisplay);
        setContentView(_mainLayout);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    private void getTeam(String team){
    	Log.i("CLICK: ", team);
    	String baseURL = "http://jemcphe.cloudant.com/mlb/" + team;
    	//Create URL to pass to TeamRequest
    	URL finalURL;
    	try {
			finalURL = new URL(baseURL);
			TeamRequest tr = new TeamRequest();
			tr.execute(finalURL);
		} catch (MalformedURLException e) {
			Log.e("BAD URL", "MALFORMED URL");
			finalURL = null;
		}
    }
    
    @SuppressWarnings("unchecked")
	private HashMap<String, String> getHistory(){
    	Object stored = FileInfo.readObjectFile(_context, "history", false);
    	
    	HashMap<String, String> history;
    	if(stored == null){
    		Log.i("HISTORY", "NO HISTORY FILE FOUND");
    		history = new HashMap<String, String>();
    	} else {
    		history = (HashMap<String, String>) stored;
    	}
    	return history;
    }
    
    
    private class TeamRequest extends AsyncTask<URL, Void, String>{
    	@Override
    	protected String doInBackground(URL... urls){
    		String response = "";
    		for(URL url: urls){
    			response = WebData.getURLStringResponse(url);
    		}
    		return response;
    	}
    	
    	@Override
    	protected void onPostExecute(String result){
    		Log.i("URL RESPONSE", result);
    		try {
				JSONObject json = new JSONObject(result);
				JSONObject results = json.getJSONObject("info");
				if(results.getString("name").compareTo("") == 0) {
					Toast toast = Toast.makeText(_context, "Invalid Team", Toast.LENGTH_SHORT);
					toast.show();
				} else {
					Toast toast = Toast.makeText(_context, "Valid Entry" + results.getString("name"),  Toast.LENGTH_SHORT);
					toast.show();
					Log.i("TEAM DATA", results.toString());
					_history.put(results.getString("name"), results.toString());
					FileInfo.storeObjectFile(_context, "history", _history, false);
					FileInfo.storeStringFile(_context, "temp", results.toString(), true);
				}

			} catch (JSONException e) {
				Log.e("JSON", "JSON OBJECT EXCEPTION");
			}
    	}
    }
    
    
    
    
}
