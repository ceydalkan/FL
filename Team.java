public class Team {
    private String name;
    private String abb;
    private int point = 0;
    private int teamNumber;

    Team(int teamNumber, String name, String abb) {
        this.teamNumber = teamNumber;
        this.name = name;
        this.abb = abb;

    }

    public void lostMatch() {
    }

    public void wonMatch() {
        this.point = point + 3;
    }

    public void tie() {
        this.point = point + 1;
    }

    public String getAbb() {
        return this.abb;
    }

    public String getName() {
        return this.name;
    }

    public int getPoint() {
        return this.point;
    }

    public int getGoals(int[][] matchArr) {
        int sum = 0;
        int i = this.teamNumber;
        for (int j = 0; j < matchArr.length; j++) {
            sum += matchArr[i - 1][j];
        }
        return sum;
    }

    public int getKickedGoals(int[][] matchArr) {
        int sum = 0;
        int j = this.teamNumber;
        for (int i = 0; i < matchArr.length; i++) {
            sum += matchArr[i][j - 1];
        }
        return sum;
    }

    public int getTeamNumber() {
        return this.teamNumber;
    }

}
