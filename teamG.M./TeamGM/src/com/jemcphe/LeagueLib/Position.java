package com.jemcphe.LeagueLib;

public enum Position {
	PITCHER(1),
	CATCHER(2),
	FIRST(3), 
	SECOND(4),
	THIRD(5),
	SHORTSTOP(6),
	LEFT(7),
	CENTER(8),
	RIGHT(9);
		
		private final int value;
		
		Position(int value){
			this.value = value;
		}
		
		public void getTeamDetails() {
			String positionText = new String();
			switch (value) {
			case 1:

				break;
			case 2:
				
				break;
			case 3:

				break;
			case 4:

				break;
			case 5:

				break;
			case 6:

				break;
			case 7:

				break;
			case 8:

				break;
			case 9:

				break;
			default:
				break;
			}
		}
		
}
