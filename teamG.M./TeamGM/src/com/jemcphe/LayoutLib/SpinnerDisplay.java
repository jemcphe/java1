package com.jemcphe.LayoutLib;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class SpinnerDisplay extends LinearLayout {

	Context _context;
	Spinner _dropDown;
	
	public SpinnerDisplay(Context context) {
		super(context);
		
		_context = context;
		LayoutParams lp;
		
		//Create Spinner
		_dropDown = new Spinner(_context);
		lp = new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1.0f);
		_dropDown.setLayoutParams(lp);
		
		this.addView(_dropDown);
	}
	
}