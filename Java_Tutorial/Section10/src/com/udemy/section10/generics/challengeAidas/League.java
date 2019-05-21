package com.udemy.section10.generics.challengeAidas;


// Create a generic class to implement a league table for a sport.
// The class should allow teams to be added to the list, and store
// a list of teams that belong to the league.
//
// Your class should have a method to print out the teams in order,
// with the team at the top of the league printed first.
//
// Only teams of the same type should be added to any particular
// instance of the league class - the program should fail to compile
// if an attempt is made to add an incompatible team.


import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> {
    private String name;

    private ArrayList<T> teamsInLeague = new ArrayList<T>();

    public League(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<T> getTeams() {
        return teamsInLeague;
    }

    public boolean addTeam (T teamToAdd) {
        if(teamsInLeague.contains(teamToAdd)) {
            System.out.println(teamToAdd.getName() + " is already on this league");
            return false;
        } else {
            teamsInLeague.add(teamToAdd);
            System.out.println(teamToAdd.getName() + " added to league");
            return true;
        }
    }

    public void printTeamsInLeague () {
        Collections.sort(teamsInLeague); // sorts according to method "public int compareTo(Team<T> team)".
        //Without sorting shows in that order in witch teams were added to list.
        System.out.println("==========");
        System.out.println("League " + this.getName() + " contains " + this.teamsInLeague.size() + " teams:");
        for (int i = 0; i < this.teamsInLeague.size(); i++) {
            System.out.println("Team Nr." + (i+1) + " " + this.teamsInLeague.get(i).getName() + ". Ranking " + this.teamsInLeague.get(i).ranking());
        }
        System.out.println("==========");

        for (T t : teamsInLeague) {
            System.out.println(t.getName() + " " + t.ranking());

        }
    }

}
