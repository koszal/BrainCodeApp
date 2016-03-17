package uk.co.grandparade.androidtesting.data.model;

/**
 * Created by pawel.ogorzalek on 08/03/16.
 */
public class Career {

    private String primaryRace;
    private int terranWins;
    private int protossWins;
    private int zergWins;
    private String highest1v1Rank;
    private String highestTeamRank;
    private int seasonTotalGames;
    private int careerTotalGames;

    public Career(int careerTotalGames, String primaryRace) {
        this.careerTotalGames = careerTotalGames;
        this.primaryRace = primaryRace;
    }

    public String getPrimaryRace() {
        return primaryRace;
    }

    public int getTerranWins() {
        return terranWins;
    }

    public int getProtossWins() {
        return protossWins;
    }

    public int getZergWins() {
        return zergWins;
    }

    public String getHighest1v1Rank() {
        return highest1v1Rank;
    }

    public String getHighestTeamRank() {
        return highestTeamRank;
    }

    public int getSeasonTotalGames() {
        return seasonTotalGames;
    }

    public int getCareerTotalGames() {
        return careerTotalGames;
    }

}
