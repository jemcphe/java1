package com.jemcphe.javawk1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
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
        
        //Create an Intro TextView
        TextView introText = new TextView(this);
        introText.setText("The Texas Rangers Starting Lineup For Today");
        
        //Add introText TextView to the mainLayout
        mainLayout.addView(introText);
        
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