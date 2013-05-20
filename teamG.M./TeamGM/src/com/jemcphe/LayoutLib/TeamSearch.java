package com.jemcphe.LayoutLib;

import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TeamSearch extends LinearLayout{

	Context _context;
	EditText _searchField;
	Button _searchButton;
	TextView _searchLabel;
	
	public TeamSearch(Context context, String hint, String buttonText) {
		super(context);
		_context = context;
		
		LayoutParams lp;
		
		//Instantiate searchField & searchButton
		_searchField = new EditText(_context);
		lp = new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1.0f);
		_searchField.setLayoutParams(lp);
		_searchField.setHint(hint);
		
		_searchButton = new Button(_context);
		_searchButton.setText(buttonText);
		
		this.addView(_searchField);
		this.addView(_searchButton);
	}
	
}
