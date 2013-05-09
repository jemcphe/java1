package com.jemcphe.javawk1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	LinearLayout mainLayout;
	LinearLayout.LayoutParams mainParams;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Create layout
        mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        //Paramaters for mainLayout
        mainParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        mainLayout.setLayoutParams(mainParams);
        
        //Create TextViews to hold introText, playerLabel, atPlateLabel, & hitsLabel
        TextView introText = new TextView(this);
        introText.setText("The Texas Rangers Starting Lineup For Today\n");
        
        TextView playerLabel = new TextView(this);
        playerLabel.setText("Player Name:");
        
        TextView atPlateLabel = new TextView(this);
        atPlateLabel.setText("How many plate appearances?");
        
        TextView hitsLabel = new TextView(this);
        hitsLabel.setText("How many hits did this player have?");
        
        //Add introText TextView to the mainLayout
        mainLayout.addView(introText);
        
        //Add Edit Text Fields to mainLayout
        EditText playerEntry = new EditText(this);
        playerEntry.setHint("ex: Ian Kinsler");
        EditText plateEntry = new EditText(this);
        plateEntry.setHint("ex: 4");
        EditText hitsEntry = new EditText(this);
        hitsEntry.setHint("ex: 3");
        
        //Create button for getBattingAverage click event.
        Button calculateButton = new Button(this);
        calculateButton.setText("Calculate Batting Average");

        mainLayout.addView(playerLabel);
        mainLayout.addView(playerEntry);
        mainLayout.addView(atPlateLabel);
        mainLayout.addView(plateEntry);
        mainLayout.addView(hitsLabel);
        mainLayout.addView(hitsEntry);
        mainLayout.addView(calculateButton);
        
        
        //Set the Content of the application
        setContentView(mainLayout);
        
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
