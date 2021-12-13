package com.learning;

import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>> {
    private String name;
    private int won;
    private int tied;
    private int lost;
    private int played;

    private ArrayList<T> players = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T player) {
        if (players.contains(player)) {
            System.out.printf("%s is already on the team", player.getName());
            return false;
        } else {
            players.add(player);
            System.out.printf("%s has been successfully added to the %s team.%n", player.getName(), this.name);
            return true;
        }
    }

    public int getNumberOfPlayersOnTheTeam() {
        return this.players.size();
    }

    public void recordMatchResults(Team<T> opponent, int ourScore, int opponentScore) {
        String message;
        if (ourScore > opponentScore) {
            won++;
            message = "beat";
        } else if (ourScore == opponentScore) {
            tied++;
            message = "tied with";
        } else {
            lost++;
            message = "lost to";
        }
        played++;
        if (opponent != null) {
            opponent.recordMatchResults(null, opponentScore, ourScore);
            System.out.printf("%s %s %s.%n", this.getName(), message, opponent.getName());
        }
    }

    public int getTeamRanking() {
        return won * 3 + tied;
    }

    @Override
    public int compareTo(Team<T> team) {
//        if (this.getTeamRanking() > team.getTeamRanking()) {
//            return -1;
//        } else if (this.getTeamRanking() < team.getTeamRanking()) {
//            return 1;
//        } else {
//            return 0;
//        }
        return team.getTeamRanking() - this.getTeamRanking();
    }

    @Override
    public String toString() {
        return "\"" + name + '\"';
    }
}
