package com.jemcphe.teamgm;

import com.jemcphe.LayoutLib.Elements;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class MainActivity extends Activity {

	LinearLayout mainLayout;
	LayoutParams mainParams;
	
	LinearLayout dataLayout;
	LayoutParams dataParams;
	
	TextView dataBox;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //Create LinearLayout for Main Layout
        mainLayout = new LinearLayout(this);
        mainParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        mainLayout.setLayoutParams(mainParams);
        
        LinearLayout entryBox = Elements.singleEntryWithButton(this, "Player Name", "ex. Sam Doe", "Add Player");
        entryBox.setOrientation(LinearLayout.VERTICAL);
        
        Button dataButton = (Button) entryBox.findViewById(2);
        dataButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				EditText player = (EditText) v.getTag();
				Log.i("", player.getText().toString());
				dataBox.setText("Player Added: " + player.getText().toString());

			}
		});
        
        mainLayout.addView(entryBox);
        
        dataLayout = new LinearLayout(this);
        dataLayout.setOrientation(LinearLayout.VERTICAL);
        dataParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        dataLayout.setLayoutParams(dataParams);
        
        dataBox = new TextView(this);
        
        dataLayout.addView(dataBox);
        
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
