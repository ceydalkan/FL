import java.util.Random;

public class FootballLeagueManager {
    static Team[] teams = new Team[10];
    static int[][] matchResults = new int[10][10];

    public static void main(String[] args) {
        fillTeamArray();
        simulateMatches();
        calculatePoints();
        displayTeams();
        displayMatchResults();
        displayPoints();
        announceChampion();
    }

    public static void fillTeamArray() {
        teams[0] = new Team(1, "galatasaray", "GS");
        teams[1] = new Team(2, "fenerbahce", "FB");
        teams[2] = new Team(3, "besiktas", "BJ");
        teams[3] = new Team(4, "sivasspor", "SS");
        teams[4] = new Team(5, "trabzonspor", "TS");
        teams[5] = new Team(6, "göztepe", "GT");
        teams[6] = new Team(7, "antalyaspor", "AS");
        teams[7] = new Team(8, "gaziantepspor", "GA");
        teams[8] = new Team(9, "genclerbirligi", "GB");
        teams[9] = new Team(10, "bursaspor", "BS");
    }

    public static void simulateMatches() {
        Random r = new Random();

        for (int i = 0; i < matchResults.length; i++) {
            for (int j = 0; j < matchResults[i].length; j++) {
                if (i != j)
                    matchResults[i][j] = r.nextInt(10);
            }
        }
    }

    public static void displayMatchResults() {
        for (int i = 0; i < matchResults.length; i++) {
            for (int j = 0; j < matchResults[i].length; j++) {
                System.out.print(matchResults[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void displayTeams() {
        for (int i = 0; i < teams.length; i++) {
            System.out.println(
                    teams[i].getTeamNumber() + " " + teams[i].getName() + " " + teams[i].getAbbreviation() + " "
                            + teams[i].getPoint());
        }
    }

    public static void displayPoints() {
        for (int i = 0; i < teams.length; i++)
            System.out.println(teams[i].getName() + " " + teams[i].getPoint());
    }

    public static void calculatePoints() {
        for (int i = 0; i < teams.length; i++) {
            for (int j = 0; j < teams.length; j++) {
                if (i != j) {
                    int homeGoals = matchResults[i][j];
                    int awayGoals = matchResults[j][i];
                    if (homeGoals > awayGoals) {
                        teams[i].wonMatch();
                    } else if (homeGoals < awayGoals) {
                        teams[j].wonMatch();
                    } else {
                        teams[i].tie();
                        teams[j].tie();
                    }
                }
            }
        }
    }

    public static void announceChampion() {
        Team champion = null;
        int maxPoints = 0;
        int bestGoalDifference = 0;

        for (int i = 0; i < teams.length; i++) {
            int goalDifference = teams[i].getGoalsScored(matchResults) - teams[i].getGoalsConceded(matchResults);
            if (teams[i].getPoint() > maxPoints
                    || (teams[i].getPoint() == maxPoints && goalDifference > bestGoalDifference)) {
                champion = teams[i];
                maxPoints = teams[i].getPoint();
                bestGoalDifference = goalDifference;
            }
        }

        System.out.println("Champion is: " + champion.getName() + " with " + maxPoints
                + " points and goal difference of " + bestGoalDifference);
    }
}
