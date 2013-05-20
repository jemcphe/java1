package com.jemcphe.LayoutLib;

import android.content.Context;
import android.widget.GridLayout;
import android.widget.TextView;

public class TeamDisplay extends GridLayout{

	TextView _name;
	TextView _pitcher;
	TextView _catcher;
	TextView _first;
	TextView _second;
	TextView _third;
	TextView _short;
	TextView _left;
	TextView _center;
	TextView _right;
	Context _context;
	
	public TeamDisplay(Context context) {
		super(context);
		
		_context = context;
		
		//give layout 2 columns
		this.setColumnCount(2);
		
		//Create TextView Labels
		TextView nameLabel = new TextView(_context);
		_name = new TextView(_context);
		nameLabel.setText("Team Name: ");
		
		TextView pitcherLabel = new TextView(_context);
		_pitcher = new TextView(_context);
		pitcherLabel.setText("Pitcher: ");
		
		TextView catcherLabel = new TextView(_context);
		_catcher = new TextView(_context);
		catcherLabel.setText("Catcher: ");
		
		TextView firstLabel = new TextView(_context);
		_first = new TextView(_context);
		firstLabel.setText("First Base: ");
		
		TextView secondLabel = new TextView(_context);
		_second = new TextView(_context);
		secondLabel.setText("Second Base: ");
		
		TextView thirdLabel = new TextView(_context);
		_third = new TextView(_context);
		thirdLabel.setText("Third Base: ");
		
		TextView shortLabel = new TextView(_context);
		_short = new TextView(_context);
		shortLabel.setText("Shortstop: ");
		
		TextView leftLabel = new TextView(_context);
		_left = new TextView(_context);
		leftLabel.setText("Left Field: ");
		
		TextView centerLabel = new TextView(_context);
		_center = new TextView(_context);
		centerLabel.setText("Center Field: ");
		
		TextView rightLabel = new TextView(_context);
		_right = new TextView(_context);
		rightLabel.setText("Right Field: ");
		
		this.addView(nameLabel);
		this.addView(_name);
		this.addView(pitcherLabel);
		this.addView(_pitcher);
		this.addView(catcherLabel);
		this.addView(_catcher);
		this.addView(firstLabel);
		this.addView(_first);
		this.addView(secondLabel);
		this.addView(_second);
		this.addView(thirdLabel);
		this.addView(_third);
		this.addView(shortLabel);
		this.addView(_short);
		this.addView(leftLabel);
		this.addView(_left);
		this.addView(centerLabel);
		this.addView(_center);
		this.addView(rightLabel);
		this.addView(_right);

	}
	
}
