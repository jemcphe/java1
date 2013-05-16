package com.jemcphe.teamgm;

import com.jemcphe.LayoutLib.Elements;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class MainActivity extends Activity {

	LinearLayout mainLayout;
	LayoutParams mainParams;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //Create LinearLayout for Main Layout
        mainLayout = new LinearLayout(this);
        mainParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        mainLayout.setLayoutParams(mainParams);
        
        LinearLayout entryBox = Elements.singleEntryWithButton(this, "Player Name", "ex. Sam Doe", "Add Player");
        entryBox.setOrientation(LinearLayout.VERTICAL);
        mainLayout.addView(entryBox);
        
        
        
        setContentView(mainLayout);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
