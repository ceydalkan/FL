public class TeamArray {
	int length;
	Team[] teamArr;
	
TeamArray(){
	teamArr = new Team[10];
	this.length = teamArr.length;
}

public void displayTeams() {
	for (int i = 0; i < teamArr.length; i++) {
		System.out.println(teamArr[i].getTeamNumber() + " " + teamArr[i].getName() + " " + teamArr[i].getAbb() + " " + teamArr[i].getPoint());
	}
	
}

public void displayPoints() {
	for (int i = 0; i < this.teamArr.length; i++) 
		System.out.println(this.teamArr[i].getPoint());
}
}