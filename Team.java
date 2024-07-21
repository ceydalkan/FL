public class Team {
    private String name;
    private String abbreviation;
    private int point = 0;
    private int teamNumber;

    Team(int teamNumber, String name, String abbreviation) {
        this.teamNumber = teamNumber;
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public void lostMatch() {
    }

    public void wonMatch() {
        this.point = point + 3;
    }

    public void tie() {
        this.point = point + 1;
    }

    public String getAbbreviation() {
        return this.abbreviation;
    }

    public String getName() {
        return this.name;
    }

    public int getPoint() {
        return this.point;
    }

    public int getGoalsScored(int[][] matchResults) {
        int sum = 0;
        int i = this.teamNumber;

        for (int j = 0; j < matchResults.length; j++) {
            sum += matchResults[i - 1][j];
        }

        return sum;
    }

    public int getGoalsConceded(int[][] matchArr) {
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
