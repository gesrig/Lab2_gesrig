package com.example.gregoryesrig24.lab2_gesrig;

import java.io.Serializable;

/**
 * Created by gregoryesrig24 on 3/3/17.
 */

public class Team implements Serializable {
    String teamName;
    String TeamLogo;
    String GameDate;
    String GameScore;
    String TeamArena;
    String TeamRecord;
    String TeamMascot;


    //public Team(String  team_logo, String team_name, String game_date, String game_score, String team_arena,String team_record, String team_mascot) {
    public Team(String [] infoarray) {
        setTeamName(infoarray[1]);
        setTeamLogo(infoarray[0]);
        setGameDate(infoarray[2]);
        setGameScore(infoarray[3]);
        setTeamArena(infoarray[4]);
        setTeamRecord(infoarray[5]);
        setTeamMascot(infoarray[6]);

    }

    public void setTeamName(String team_name) {
        this.teamName = team_name;
    }

    public String getTeamName() {
        return this.teamName;
    }
    public void setTeamLogo(String team_logo) {
        this.TeamLogo = team_logo;
    }

    public String getTeamLogo() {
        return this.TeamLogo;
    }
    public void setGameDate(String game_date) {
        this.GameDate = game_date;
    }

    public String getGameDate() {
        return this.GameDate;
    }
    public void setGameScore(String game_score) {
        this.GameScore = game_score;
    }

    public String getGameScore() {
        return this.GameScore;
    }
    public void setTeamArena(String team_arena) {
        this.TeamArena = team_arena;
    }
    public String getTeamArena() {
        return this.TeamArena;
    }
    public void setTeamRecord(String team_record) {
        this.TeamRecord = team_record;
    }
    public String getTeamRecord() {
        return this.TeamRecord;
    }
    public void setTeamMascot(String team_mascot) {
        this.TeamMascot = team_mascot;
    }
    public String getTeamMascot() {
        return this.TeamMascot;
    }
}