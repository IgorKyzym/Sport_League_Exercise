package com.learning;

public class LeagueApplication {
    public static void main(String[] args) {

        FootballPlayer ronaldo = new FootballPlayer("Ronaldo");
        FootballPlayer figo = new FootballPlayer("Figo");
        FootballPlayer inzaghi = new FootballPlayer("Inzaghi");
        BaseballPlayer baseplayer = new BaseballPlayer("John");

        Team<FootballPlayer> oldFootballStars = new Team<>("DreamTeam");
        oldFootballStars.addPlayer(figo);
        oldFootballStars.addPlayer(ronaldo);
        oldFootballStars.addPlayer(inzaghi);
//        oldFootballStars.addPlayer(baseplayer); // can't add baseball player to a football team;

        Team<FootballPlayer> liverpool = new Team<>("Liverpool");
        Team<FootballPlayer> barcelona = new Team<>("Barcelona");
        Team<FootballPlayer> juventus = new Team<>("Juventus");
        Team<FootballPlayer> dynamo = new Team<>("Dynamo");

        League<Team<FootballPlayer>> premierLeague = new League<>("PremierLeague");
        premierLeague.addTeam(oldFootballStars);
        premierLeague.addTeam(liverpool);
        premierLeague.addTeam(barcelona);
        premierLeague.addTeam(juventus);
        premierLeague.addTeam(dynamo);

        oldFootballStars.recordMatchResults(liverpool, 5, 3);
        oldFootballStars.recordMatchResults(barcelona, 2, 3);
        oldFootballStars.recordMatchResults(juventus, 3, 3);
        oldFootballStars.recordMatchResults(dynamo, 4, 1);
        barcelona.recordMatchResults(dynamo, 4, 1);
        barcelona.recordMatchResults(liverpool, 3, 1);
        barcelona.recordMatchResults(juventus, 1, 1);
        liverpool.recordMatchResults(juventus, 3, 1);
        liverpool.recordMatchResults(dynamo, 1, 1);
        dynamo.recordMatchResults(juventus, 4, 1);

        premierLeague.showLeagueTable();


    }
}
