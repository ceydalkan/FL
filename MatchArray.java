import java.util.Random;

public class MatchArray {
	int length;
	 int[][] matchArr;
	
MatchArray(){
	 matchArr = new int[10][10];
	 this.length = matchArr.length;
}
	



public void fillMatchArr() {
	Random r = new Random();
	
	for(int i = 0; i < this.matchArr.length; i++) {
		for (int j = 0; j < this.matchArr[i].length; j++) {
			if(i!=j)
				this.matchArr[i][j]=r.nextInt(10);
		}
	}	
}

public void displayMatchArr() {
	
	for (int i = 0; i < this.length; i++) {
		for (int j = 0; j < this.matchArr[i].length; j++) {
			System.out.print(this.matchArr[i][j] + " ");
		}
		System.out.println();
	}
}


}