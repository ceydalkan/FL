
public class Test {

    static Team galatasaray = new Team(1, "galatasaray", "GS");
    static Team fenerbahce = new Team(2, "fenerbahce", "FB");
    static Team besiktas = new Team(3, "besiktas", "BJ");
    static Team sivasspor = new Team(4, "sivasspor", "SS");
    static Team trabzonspor = new Team(5, "trabzonspor", "TS");
    static Team göztepe = new Team(6, "göztepe", "GT");
    static Team antalyaspor = new Team(7, "antalyaspor", "AS");
    static Team gaziantepspor = new Team(8, "gaziantepspor", "GA");
    static Team genclerbirligi = new Team(9, "genclerbirligi", "GB");
    static Team bursaspor = new Team(10, "bursaspor", "BS");

    public static void main(String[] args) {

        TeamArray teamArr = new TeamArray();
        MatchArray matchArr = new MatchArray();
        Test t = new Test();

        fillTeamArr(teamArr);
        matchArr.fillMatchArr();
        t.points(teamArr, matchArr);
        teamArr.displayTeams();
        matchArr.displayMatchArr();
        teamArr.displayPoints();
        champ(teamArr, matchArr);

    }

    public static void fillTeamArr(TeamArray teamArray) {
        teamArray.teamArr[0] = galatasaray;
        teamArray.teamArr[1] = fenerbahce;
        teamArray.teamArr[2] = besiktas;
        teamArray.teamArr[3] = sivasspor;
        teamArray.teamArr[4] = trabzonspor;
        teamArray.teamArr[5] = göztepe;
        teamArray.teamArr[6] = antalyaspor;
        teamArray.teamArr[7] = gaziantepspor;
        teamArray.teamArr[8] = genclerbirligi;
        teamArray.teamArr[9] = bursaspor;
    }

    public void points(TeamArray teamObj, MatchArray matchObj) {

        for (int i = 0; i < teamObj.length; i++) {
            for (int j = 0; j < teamObj.length; j++) {
                if (i < j) {
                    if (matchObj.matchArr[i][j] > matchObj.matchArr[j][i]) {
                        teamObj.teamArr[i].wonMatch();
                        teamObj.teamArr[j].lostMatch();
                    } else if (matchObj.matchArr[i][j] == matchObj.matchArr[j][i]) {
                        teamObj.teamArr[i].tie();
                        teamObj.teamArr[j].tie();
                    } else {
                        teamObj.teamArr[j].wonMatch();
                        teamObj.teamArr[i].lostMatch();

                    }
                }
            }
        }

    }

    public static void champ(TeamArray teamObj, MatchArray matchObj) {
        Team[] pointChamps = new Team[10];

        int p = 0;
        for (int i = 0; i < teamObj.length; i++) {
            if (i == 0)
                pointChamps[0] = teamObj.teamArr[0];
            else {
                if (teamObj.teamArr[i].getPoint() > pointChamps[p].getPoint()) {
                    if (p >= 1) {
                        for (int a = 0; a <= p; a++) {
                            if (a == 0)
                                pointChamps[0] = teamObj.teamArr[i];
                            else
                                pointChamps[a] = null;
                        }
                        p = 0;
                    } else
                        pointChamps[0] = teamObj.teamArr[i];
                } else if (teamObj.teamArr[i].getPoint() == pointChamps[p].getPoint()) {
                    p++;
                    pointChamps[p] = teamObj.teamArr[i];
                }
            }
        }

        if (p >= 1) {
            Team[] goalChamps = new Team[10];

            int g = 0;
            for (int j = 0; j <= g; j++) {
                if (j == 0)
                    goalChamps[0] = pointChamps[0];
                else {
                    if (pointChamps[j].getGoals(matchObj.matchArr) > goalChamps[g].getGoals(matchObj.matchArr)) {
                        if (g >= 1) {
                            for (int a = 0; a <= g; a++) {
                                if (a == 0)
                                    goalChamps[0] = pointChamps[j];
                                else
                                    goalChamps[a] = null;
                            }
                            g = 0;
                        } else
                            goalChamps[g] = pointChamps[j];
                    }

                    else if (pointChamps[j].getGoals(matchObj.matchArr) == goalChamps[g].getGoals(matchObj.matchArr)) {
                        g++;
                        goalChamps[g] = pointChamps[j];
                    }
                }
            }

            if (g >= 1) {
                Team[] kckdGoalChamps = new Team[10];
                int k = 0;

                for (int m = 0; m <= k; m++) {
                    if (m == 0)
                        kckdGoalChamps[0] = goalChamps[0];
                    else {
                        if (goalChamps[m].getKickedGoals(matchObj.matchArr) < kckdGoalChamps[k]
                                .getKickedGoals(matchObj.matchArr)) {
                            if (k >= 1) {
                                for (int a = 0; a <= k; a++) {
                                    if (a == 0)
                                        kckdGoalChamps[0] = goalChamps[m];
                                    else
                                        kckdGoalChamps[a] = null;
                                }
                                k = 0;
                            } else
                                kckdGoalChamps[k] = goalChamps[m];
                        } else if (goalChamps[m].getKickedGoals(matchObj.matchArr) == kckdGoalChamps[k]
                                .getKickedGoals(matchObj.matchArr)) {
                            k++;
                            kckdGoalChamps[k] = goalChamps[m];
                        }
                    }
                }

                if (k >= 1) {
                    System.out.print("champs are: ");
                    for (int n = 0; n < kckdGoalChamps.length; n++) {
                        System.out.print(kckdGoalChamps[n].getName() + " ");
                    }
                } else
                    System.out.println("champ is: " + kckdGoalChamps[0].getName());

            } else
                System.out.println("champ is: " + goalChamps[0].getName());

        } else
            System.out.println("champ is: " + pointChamps[0].getName());

    }

}