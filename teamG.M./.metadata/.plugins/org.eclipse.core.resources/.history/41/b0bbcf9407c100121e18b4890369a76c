package com.jemcphe.LeagueLib;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class WebData {
	
	//Global Variables
	static Boolean _isConnected = false;
	static String _connectionType = "Unavailable";
	
	//Method to return connection type
	public static String getConnectionType(Context context) {
		netInfo(context);
		return _connectionType;
	}
	
	//Method to return connection status
	public static Boolean getConnectionStatus(Context context) {
		netInfo(context);
		return _isConnected;
	}
	
	//CONNECTIVITY CHECK FUNCTION
	private static void netInfo(Context context) {
		ConnectivityManager connectManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connectManager.getActiveNetworkInfo();
		
		//Check for network connectivity
		if (networkInfo != null) {
			if(networkInfo.isConnected()) {
				_connectionType = networkInfo.getTypeName();
				_isConnected = true;
			}
		}
	}
	
}
