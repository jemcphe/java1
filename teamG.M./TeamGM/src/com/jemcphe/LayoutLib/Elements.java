package com.jemcphe.LayoutLib;

import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class Elements {
	public static LinearLayout singleEntryWithLabel(Context context, String label, String hint) {
		LinearLayout ll = new LinearLayout(context);
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
		
		return ll;
	}
	
	public static Button singleButton(Context context, String buttonText){
		//Create Button, setText
		Button button = new Button(context);
		button.setText(buttonText);
		
		return button;
	}
	
	public static Spinner singleSpinner(Context context, String prompt, String teams){
		
		Spinner teamSpinner = new Spinner(context);
		teamSpinner.setPrompt(prompt);
		
		return teamSpinner;
	}
}
