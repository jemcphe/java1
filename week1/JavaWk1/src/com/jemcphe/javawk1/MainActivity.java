package com.jemcphe.javawk1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
//import android.widget.LinearLayout.LayoutParams;

public class MainActivity extends Activity {
	//ScrollView
	ScrollView scrollView;
	
	//define the layouts for the application roster, form, data layouts wrapped with mainLayout
	//main Layout
	LinearLayout mainLayout;
	LinearLayout.LayoutParams mainParams;
	
	//roster layout
	LinearLayout rosterLayout;
	LinearLayout.LayoutParams rosterParams;
	//form layout
	LinearLayout formLayout;
	LinearLayout.LayoutParams formParams;
	//data layout
	LinearLayout dataLayout;
	LinearLayout.LayoutParams dataParams;
	
	//define EditText
	EditText playerEntry;
	EditText plateEntry;
	EditText hitsEntry;
	
	String[] startingLineup;
	
	String player;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        scrollView = new ScrollView(this);
        scrollView.measure(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        
    	String[] startingLineup = {
    			getString(R.string.player_name1),
    			getString(R.string.player_name2),
    			getString(R.string.player_name3),
    			getString(R.string.player_name4),
    			getString(R.string.player_name5),
    			getString(R.string.player_name6),
    			getString(R.string.player_name7),
    			getString(R.string.player_name8),
    			getString(R.string.player_name9),
    	};
    	
    	//System.out.println(startingLineup.length);
        
        /******************************* Main Layout *******************************/
        mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        //Paramaters for mainLayout
        mainParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        mainLayout.setLayoutParams(mainParams);
        //append mainLayout to scrollView
        scrollView.addView(mainLayout);
        
        /******************************** Roster Layout ****************************/
        rosterLayout = new LinearLayout(this);
        rosterLayout.setOrientation(LinearLayout.VERTICAL);
        rosterParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        //Create TextViews to hold introText, playerLabel, atPlateLabel, & hitsLabel
        TextView introText = new TextView(this);
        introText.setText("The Texas Rangers Starting Lineup For Today\n");
        
        //Append View to rosterLayout
        rosterLayout.addView(introText);
        
        //Set the startingLineup array and loop through it to display players
        //player = new String();
        for(int i=0, j= startingLineup.length; i<j; i++){
        	TextView playerRoster = new TextView(this);
        	player = (startingLineup[i]);
        	playerRoster.setText(player);
        	rosterLayout.addView(playerRoster);
        }
        

        //Append rosterLayout to mainLayout
        mainLayout.addView(rosterLayout);
        
        /******************************** Form Layout ******************************/
        formLayout = new LinearLayout(this);
        formLayout.setOrientation(LinearLayout.VERTICAL);
        formParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        
        TextView playerLabel = new TextView(this);
        playerLabel.setText("\nPlayer Name:");
        
        TextView atPlateLabel = new TextView(this);
        atPlateLabel.setText("How many plate appearances?");
        
        TextView hitsLabel = new TextView(this);
        hitsLabel.setText("How many hits did this player have?");
        
        //Add Edit Text Fields to mainLayout
        playerEntry = new EditText(this);
        playerEntry.setHint("ex: Ian Kinsler");
        plateEntry = new EditText(this);
        plateEntry.setHint("ex: 4");
        hitsEntry = new EditText(this);
        hitsEntry.setHint("ex: 3");
        
      //Create button for getBattingAverage click event.
        Button calculateButton = new Button(this);
        calculateButton.setText("Calculate Batting Average");
        calculateButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
        
        //Append views to formLayout
        formLayout.addView(playerLabel);
        formLayout.addView(playerEntry);
        formLayout.addView(atPlateLabel);
        formLayout.addView(plateEntry);
        formLayout.addView(hitsLabel);
        formLayout.addView(hitsEntry);
        formLayout.addView(calculateButton);
        
        //Append formLayout to mainLayout
        mainLayout.addView(formLayout);
        
        /******************************** Data Layout ******************************/
        dataLayout = new LinearLayout(this);
        dataLayout.setOrientation(LinearLayout.VERTICAL);
        dataParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        
        
        
        //Set the Content of the application
        setContentView(scrollView);
        
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
