package com.jemcphe.javawk1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class MainActivity extends Activity {

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
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /******************************* Main Layout *******************************/
        mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        //Paramaters for mainLayout
        mainParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        mainLayout.setLayoutParams(mainParams);
        
        /******************************** Roster Layout ****************************/
        rosterLayout = new LinearLayout(this);
        rosterLayout.setOrientation(LinearLayout.VERTICAL);
        rosterParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        //Create TextViews to hold introText, playerLabel, atPlateLabel, & hitsLabel
        TextView introText = new TextView(this);
        introText.setText("The Texas Rangers Starting Lineup For Today\n");
        //Append View to rosterLayout
        rosterLayout.addView(introText);
        //Append rosterLayout to mainLayout
        mainLayout.addView(rosterLayout);
        
        /******************************** Form Layout ******************************/
        formLayout = new LinearLayout(this);
        formLayout.setOrientation(LinearLayout.VERTICAL);
        formParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        
        TextView playerLabel = new TextView(this);
        playerLabel.setText("Player Name:");
        
        TextView atPlateLabel = new TextView(this);
        atPlateLabel.setText("How many plate appearances?");
        
        TextView hitsLabel = new TextView(this);
        hitsLabel.setText("How many hits did this player have?");
        
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
        setContentView(mainLayout);
        
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
