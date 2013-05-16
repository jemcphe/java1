package com.jemcphe.teamgm;

import java.util.ArrayList;

import com.jemcphe.LayoutLib.Elements;
import com.jemcphe.LeagueLib.Json;
import com.jemcphe.LeagueLib.Teams;

import android.os.Bundle;
import android.app.Activity;
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

	LinearLayout mainLayout;
	LayoutParams mainParams;
	
	LinearLayout radioLayout;
	LayoutParams radioParams;
	
	LinearLayout entryBox;
	
	LinearLayout dataLayout;
	LayoutParams dataParams;
	
	TextView dataBox;
	TextView teamData;
	RadioGroup teamOptions;
	String[] teamNames;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //Create LinearLayout for Main Layout
        mainLayout = new LinearLayout(this);
        mainParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        mainLayout.setLayoutParams(mainParams);
        

        radioLayout = new LinearLayout(this);
        radioLayout.setOrientation(LinearLayout.VERTICAL);
        radioParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        radioLayout.setLayoutParams(radioParams);
        
        teamNames = getResources().getStringArray(R.array.remote);
        
        teamOptions = Elements.getTeam(this, teamNames);
        
        radioLayout.addView(teamOptions);
        
        entryBox = Elements.singleEntryWithButton(this, "\r\nPlayer Name", "ex. Sam Doe", "Add Player");
        entryBox.setOrientation(LinearLayout.VERTICAL);
        
        Button dataButton = (Button) entryBox.findViewById(2);
        dataButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				int selectedRadioId = teamOptions.getCheckedRadioButtonId();
				RadioButton selectedRadio = (RadioButton) findViewById(selectedRadioId);
				String radioText = (String) selectedRadio.getText();
				
				EditText player = (EditText) v.getTag();
				dataBox.setText("\r\nPlayer Added: " + player.getText().toString() + "\r\n" +
									"Placing On Team: " + radioText + "\r\n\r\n");
				teamData.setText(Json.readJSON(radioText));

			}
		});
        
        
        dataLayout = new LinearLayout(this);
        dataLayout.setOrientation(LinearLayout.VERTICAL);
        dataParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        dataLayout.setLayoutParams(dataParams);
        
        dataBox = new TextView(this);
        teamData = new TextView(this);
        
        dataLayout.addView(dataBox);
        dataLayout.addView(teamData);
        
        
        
        
//        entryBox.addView(dataLayout);
        mainLayout.addView(radioLayout);
        radioLayout.addView(entryBox);
        entryBox.addView(dataLayout);
        setContentView(mainLayout);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
