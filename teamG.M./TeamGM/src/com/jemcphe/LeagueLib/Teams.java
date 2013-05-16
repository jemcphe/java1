package com.jemcphe.LeagueLib;

public enum Teams {
	TEXAS("Texas Rangers", "Ian Kinsler", "2nd Base", "AL West"),
	YANKEES("New York Yankees", "Derek Jeter", "Shortstop", "AL East");
	
	private final String teamName;
	private final String keyPlayer;
	private final String position;
	private final String division;
	
	private Teams(String teamName, String keyPlayer, String position, String division){
		this.teamName = teamName;
		this.keyPlayer = keyPlayer;
		this.position = position;
		this.division = division;
	}

	public String setTeamName(){
		return teamName;
	}
	public String setKeyPlayer(){
		return keyPlayer;
	}
	public String setPosition(){
		return position;
	}
	public String setDivision(){
		return division;
	}
}