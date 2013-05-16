package com.jemcphe.LayoutLib;

import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class Elements {
	
	public static LinearLayout singleEntryWithButton(Context context, String label, String hint, String buttonText) {
		LinearLayout ll = new LinearLayout(context);
		ll.setOrientation(LinearLayout.VERTICAL);
		LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		ll.setLayoutParams(lp);
		
		//Create TextView, set label, and add to View
		TextView labelText = new TextView(context);
		labelText.setText(label);
		ll.addView(labelText);

		//Create EditText, setHint, add to View
		EditText entryText = new EditText(context);
		entryText.setHint(hint);
		ll.addView(entryText);
		
		//Create Button, setText, add to view
		Button button = new Button(context);
		button.setText(buttonText);
		ll.addView(button);
		
		return ll;
	}
	
	public static RadioGroup getPosition(Context context, String [] positions) {
		RadioGroup positionBox = new RadioGroup(context);
		
		for(int i=0; i<positions.length; i++){
			RadioButton rb = new RadioButton(context);
			rb.setText(positions[i]);
			positionBox.addView(rb);
		}
		
		return positionBox;
	}
}
