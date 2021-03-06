package com.jemcphe.LayoutLib;

import com.jemcphe.teamgm.R;

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
	
	//static Strings for JSON Data
	static String _teamNameData;
	static String _pitcherData;
	static String _catcherData;
	static String _firstData;
	static String _secondData;
	static String _thirdData;
	static String _shortData;
	static String _leftData;
	static String _centerData;
	static String _rightData;
	
	public TeamDisplay(Context context) {
		super(context);
		
		_context = context;
		
//		//give layout 2 columns
//		this.setColumnCount(2);
		
		//Create TextView Labels
//		TextView nameLabel = new TextView(_context);
		_name = (TextView) findViewById(R.id.teamNameData);
//		nameLabel.setText("Team Name: ");
		_name.setText(_teamNameData);
		
//		TextView pitcherLabel = new TextView(_context);
		_pitcher = (TextView) findViewById(R.id.pitcherData);
//		pitcherLabel.setText("Pitcher: ");
		_pitcher.setText(_pitcherData);
		
//		TextView catcherLabel = new TextView(_context);
		_catcher = (TextView) findViewById(R.id.catcherData);
//		catcherLabel.setText("Catcher: ");
		_catcher.setText(_catcherData);
		
//		TextView firstLabel = new TextView(_context);
		_first = (TextView) findViewById(R.id.firstData);
//		firstLabel.setText("First Base: ");
		_first.setText(_firstData);
		
//		TextView secondLabel = new TextView(_context);
		_second = (TextView) findViewById(R.id.secondData);
//		secondLabel.setText("Second Base: ");
		_second.setText(_secondData);
		
//		TextView thirdLabel = new TextView(_context);
		_third = (TextView) findViewById(R.id.thirdData);
//		thirdLabel.setText("Third Base: ");
		_third.setText(_thirdData);
		
//		TextView shortLabel = new TextView(_context);
		_short = (TextView) findViewById(R.id.shortData);
//		shortLabel.setText("Shortstop: ");
		_short.setText(_shortData);
		
//		TextView leftLabel = new TextView(_context);
		_left = (TextView) findViewById(R.id.leftData);
//		leftLabel.setText("Left Field: ");
		_left.setText(_leftData);
		
//		TextView centerLabel = new TextView(_context);
		_center = (TextView) findViewById(R.id.centerData);
//		centerLabel.setText("Center Field: ");
		_center.setText(_centerData);
		
//		TextView rightLabel = new TextView(_context);
		_right = (TextView) findViewById(R.id.rightData);
//		rightLabel.setText("Right Field: ");
		_right.setText(_rightData);
		
		//this.addView(nameLabel);
		this.addView(_name);
		//this.addView(pitcherLabel);
		this.addView(_pitcher);
		//this.addView(catcherLabel);
		this.addView(_catcher);
		//this.addView(firstLabel);
		this.addView(_first);
		//this.addView(secondLabel);
		this.addView(_second);
		//this.addView(thirdLabel);
		this.addView(_third);
		//this.addView(shortLabel);
		this.addView(_short);
		//this.addView(leftLabel);
		this.addView(_left);
		//this.addView(centerLabel);
		this.addView(_center);
		//this.addView(rightLabel);
		this.addView(_right);

	}
	
	public static String setName(String name){
		_teamNameData = name;
		return _teamNameData;
	}
	
	public static String setPitcher(String name){
		_pitcherData = name;
		return _pitcherData;
	}
	
	public static String setCatcher(String name){
		_catcherData = name;
		return _catcherData;
	}
	
	public static String setFirst(String name){
		_firstData = name;
		return _firstData;
	}
	
	public static String setSecond(String name){
		_secondData = name;
		return _secondData;
	}
	
	public static String setThird(String name){
		_thirdData = name;
		return _thirdData;
	}
	
	public static String setShort(String name){
		_shortData = name;
		return _shortData;
	}
	
	public static String setLeft(String name){
		_leftData = name;
		return _leftData;
	}
	
	public static String setCenter(String name){
		_centerData = name;
		return _centerData;
	}
	
	public static String setRight(String name){
		_rightData = name;
		return _rightData;
	}
	
	
}
