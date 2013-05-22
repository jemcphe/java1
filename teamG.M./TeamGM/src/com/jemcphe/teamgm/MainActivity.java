package com.jemcphe.teamgm;

import com.jemcphe.LayoutLib.Elements;
import com.jemcphe.LayoutLib.SpinnerDisplay;
import com.jemcphe.LayoutLib.TeamDisplay;
import com.jemcphe.LayoutLib.TeamSearch;
import com.jemcphe.LeagueLib.Json;
import com.jemcphe.LeagueLib.WebData;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
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
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        _context = this;
        LayoutParams lp;
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
    }
    
    
    
    
    
    
}
