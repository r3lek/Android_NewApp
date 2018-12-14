package com.example.rkjc.news_app_2;



public class PlayerStatsAL {

    private String epicUserHandle; //found inside first object, `epicUserHandle`

    /* 8 to 12 found inside `lifeTimeStats`*/
//    private String lifeMatchesPlayed;
//    private String lifeWins;
//    private String lifePercentWins;
//    private String lifeKills;
//    private String lifeKD;

    /*15 to 19. Inside p2. p2 includes Lifetime solo stats*/
    private String soloWins;
    private String soloKD;
    private String soloMatches;
    private String soloKills;
    private String soloKPG; //killsPerGame;

    /*21 to 26. Inside p2. p2 includes Lifetime duos stats*/
    private String duosWins;
    private String duosKD;
    private String duosMatches;
    private String duosKills;
    private String duosKPG; //killsPerGame;

    /*28 to 34. Inside p2. p2 includes Lifetime squad stats*/
    private String squadWins;
    private String squadKD;
    private String squadMatches;
    private String squadKills;
    private String squadKPG; //killsPerGame;


    //Contructor for STATS OF PLAYER. WILL NEED TO BE CALLED 3 TIMES


    public PlayerStatsAL(String epicUserHandle, String soloWins, String soloKD, String soloMatches, String soloKills, String soloKPG, String duosWins, String duosKD, String duosMatches, String duosKills, String duosKPG, String squadWins, String squadKD, String squadMatches, String squadKills, String squadKPG) {
        this.epicUserHandle = epicUserHandle;
        this.soloWins = soloWins;
        this.soloKD = soloKD;
        this.soloMatches = soloMatches;
        this.soloKills = soloKills;
        this.soloKPG = soloKPG;
        this.duosWins = duosWins;
        this.duosKD = duosKD;
        this.duosMatches = duosMatches;
        this.duosKills = duosKills;
        this.duosKPG = duosKPG;
        this.squadWins = squadWins;
        this.squadKD = squadKD;
        this.squadMatches = squadMatches;
        this.squadKills = squadKills;
        this.squadKPG = squadKPG;
    }

    public String getEpicUserHandle() {
        return epicUserHandle;
    }

    public void setEpicUserHandle(String epicUserHandle) {
        this.epicUserHandle = epicUserHandle;
    }

//    public String getLifeMatchesPlayed() {
//        return lifeMatchesPlayed;
//    }
//
//    public void setLifeMatchesPlayed(String lifeMatchesPlayed) {
//        this.lifeMatchesPlayed = lifeMatchesPlayed;
//    }
//
//    public String getLifeWins() {
//        return lifeWins;
//    }
//
//    public void setLifeWins(String lifeWins) {
//        this.lifeWins = lifeWins;
//    }
//
//    public String getLifePercentWins() {
//        return lifePercentWins;
//    }
//
//    public void setLifePercentWins(String lifePercentWins) {
//        this.lifePercentWins = lifePercentWins;
//    }
//
//    public String getLifeKills() {
//        return lifeKills;
//    }
//
//    public void setLifeKills(String lifeKills) {
//        this.lifeKills = lifeKills;
//    }
//
//    public String getLifeKD() {
//        return lifeKD;
//    }
//
//    public void setLifeKD(String lifeKD) {
//        this.lifeKD = lifeKD;
//    }

    public String getSoloWins() {
        return soloWins;
    }

    public void setSoloWins(String soloWins) {
        this.soloWins = soloWins;
    }

    public String getSoloKD() {
        return soloKD;
    }

    public void setSoloKD(String soloKD) {
        this.soloKD = soloKD;
    }

    public String getSoloMatches() {
        return soloMatches;
    }

    public void setSoloMatches(String soloMatches) {
        this.soloMatches = soloMatches;
    }

    public String getSoloKills() {
        return soloKills;
    }

    public void setSoloKills(String soloKills) {
        this.soloKills = soloKills;
    }

    public String getSoloKPG() {
        return soloKPG;
    }

    public void setSoloKPG(String soloKPG) {
        this.soloKPG = soloKPG;
    }

    public String getDuosWins() {
        return duosWins;
    }

    public void setDuosWins(String duosWins) {
        this.duosWins = duosWins;
    }

    public String getDuosKD() {
        return duosKD;
    }

    public void setDuosKD(String duosKD) {
        this.duosKD = duosKD;
    }

    public String getDuosMatches() {
        return duosMatches;
    }

    public void setDuosMatches(String duosMatches) {
        this.duosMatches = duosMatches;
    }

    public String getDuosKills() {
        return duosKills;
    }

    public void setDuosKills(String duosKills) {
        this.duosKills = duosKills;
    }

    public String getDuosKPG() {
        return duosKPG;
    }

    public void setDuosKPG(String duosKPG) {
        this.duosKPG = duosKPG;
    }

    public String getSquadWins() {
        return squadWins;
    }

    public void setSquadWins(String squadWins) {
        this.squadWins = squadWins;
    }

    public String getSquadKD() {
        return squadKD;
    }

    public void setSquadKD(String squadKD) {
        this.squadKD = squadKD;
    }

    public String getSquadMatches() {
        return squadMatches;
    }

    public void setSquadMatches(String squadMatches) {
        this.squadMatches = squadMatches;
    }

    public String getSquadKills() {
        return squadKills;
    }

    public void setSquadKills(String squadKills) {
        this.squadKills = squadKills;
    }

    public String getSquadKPG() {
        return squadKPG;
    }

    public void setSquadKPG(String squadKPG) {
        this.squadKPG = squadKPG;
    }
}
