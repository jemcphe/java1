package com.jemcphe.teamgm;

import com.jemcphe.LayoutLib.Elements;
import com.jemcphe.LayoutLib.SpinnerDisplay;
import com.jemcphe.LayoutLib.TeamDisplay;
import com.jemcphe.LeagueLib.Json;
import com.jemcphe.LeagueLib.WebData;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends Activity {
	//Create Linear Layouts
	LinearLayout mainLayout;
	LayoutParams mainParams;
	
	LinearLayout radioLayout;
	LayoutParams radioParams;
	
	LinearLayout entryBox;
	
	LinearLayout dataLayout;
	LayoutParams dataParams;
	
	//Create Displays
	TeamDisplay _teamDisplay;
	SpinnerDisplay _teamList;
	
	//Declare Variables
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
        
        //Determine data connection
        _connected = WebData.getConnectionStatus(_context);
        //Check for connection
        if(_connected) {
        	Log.i("Network Connection", WebData.getConnectionType(_context));
        }
        
        //Create LinearLayout for Main Layout
        mainLayout = new LinearLayout(_context);
        mainParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        mainLayout.setLayoutParams(mainParams);
        
        //RadioLayout & Params
        radioLayout = new LinearLayout(this);
        radioLayout.setOrientation(LinearLayout.VERTICAL);
        radioParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        radioLayout.setLayoutParams(radioParams);
        
        //array that holds resources remote
        teamNames = getResources().getStringArray(R.array.remote);
        //call getTeam function
        teamOptions = Elements.getTeam(this, teamNames);
        //Add teamOptions view to radioLayout
        radioLayout.addView(teamOptions);
        //Create entryBox that has single EditText With Button
        entryBox = Elements.singleEntryWithButton(this, "\r\nPlayer Name", "ex. Sam Doe", "Add Player");
        entryBox.setOrientation(LinearLayout.VERTICAL);
        //Create button and findViewById
        Button dataButton = (Button) entryBox.findViewById(2);
        dataButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//int to hold radio button id
				int selectedRadioId = teamOptions.getCheckedRadioButtonId();
				RadioButton selectedRadio = (RadioButton) findViewById(selectedRadioId);
				String radioText = (String) selectedRadio.getText();
				
				EditText player = (EditText) v.getTag();
				dataBox.setText("\r\nPlayer Added: " + player.getText().toString() + "\r\n" +
									"Placing On Team: " + radioText + "\r\n\r\n");
				teamData.setText(Json.readJSON(radioText));

			}
		});
        
        //Data layout
        dataLayout = new LinearLayout(this);
        dataLayout.setOrientation(LinearLayout.VERTICAL);
        dataParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        dataLayout.setLayoutParams(dataParams);
        
        dataBox = new TextView(this);
        teamData = new TextView(this);
        
        dataLayout.addView(dataBox);
        dataLayout.addView(teamData);
        
       
        
        //Add SpinnerDisplay
       // _teamList = new SpinnerDisplay(_context);
        
        //Add Team Display
        _teamDisplay = new TeamDisplay(_context);
        
        
        
//        entryBox.addView(dataLayout);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.addView(radioLayout);
        mainLayout.addView(entryBox);
        //mainLayout.addView(_teamList);
        mainLayout.addView(_teamDisplay);
        setContentView(mainLayout);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
