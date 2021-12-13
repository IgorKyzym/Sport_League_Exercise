package com.learning;

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> {

    private String name;
    private ArrayList<T> league = new ArrayList<>();

    public League(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addTeam(T team) {
        if (league.contains(team)) {
            System.out.printf("%s is already in the %s.%n", team.getName(), this.name);
            return false;
        } else {
            league.add(team);
            System.out.printf("%s has successfully been added to the %s.%n", team.getName(), this.name);
            return true;
        }
    }

    public void showLeagueTable() {
        System.out.println("===========================");
        System.out.printf("%s ranking table%n", this.name);
        System.out.println("===========================");
        Collections.sort(league);
        for (T t : league) {
            System.out.printf("%s : %d%n", t.getName(), t.getTeamRanking());
        }
        System.out.println("===========================");
    }
}
