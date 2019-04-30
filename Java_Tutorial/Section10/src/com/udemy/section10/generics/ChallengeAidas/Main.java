package com.udemy.section10.generics.ChallengeAidas;

public class Main {

    public static void main(String[] args) {
	    FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");

        Team<FootballPlayer> adelaideCrows = new Team<>("Adelaide Crows");
        adelaideCrows.addPlayer(joe);
//        adelaideCrows.addPlayer(pat);
//        adelaideCrows.addPlayer(beckham);

        System.out.println(adelaideCrows.numPlayers());

        Team<BaseballPlayer> baseballTeam = new Team<>("Chicago Cubs");
        baseballTeam.addPlayer(pat);

        Team<SoccerPlayer> brokenTeam = new Team<>("This won't work");
        brokenTeam.addPlayer(beckham);

        Team<FootballPlayer> melbourne = new Team<>("Melbourne");
        FootballPlayer banks = new FootballPlayer("Gordon");
        melbourne.addPlayer(banks);

        Team<FootballPlayer> hawthorn= new Team<>("Hawthorn");
        Team<FootballPlayer> fremantle= new Team<>("Fremantle");

        hawthorn.matchResult(fremantle, 1, 0);
        hawthorn.matchResult(adelaideCrows, 3, 8);

        adelaideCrows.matchResult(fremantle, 2, 1);
        //adelaideCrows.matchResult(baseballTeam, 1, 1);

        System.out.println("Rankings");
        System.out.println(adelaideCrows.getName() + ": " + adelaideCrows.ranking());
        System.out.println(melbourne.getName() + ": " + melbourne.ranking());
        System.out.println(fremantle.getName() + ": " + fremantle.ranking());
        System.out.println(hawthorn.getName() + ": " + hawthorn.ranking());

        System.out.println(adelaideCrows.compareTo(melbourne));
        System.out.println(adelaideCrows.compareTo(hawthorn));
        System.out.println(hawthorn.compareTo(adelaideCrows));
        System.out.println(melbourne.compareTo(fremantle));

        //ArrayList<Team> teams;
        //Collections.sort(teams);
        System.out.println("=============================");

        League <Team<FootballPlayer>> footballLeague = new League("FIFA"); //this is good
        League <Team> footballLeague2 = new League("FIFA"); //this is no good, raw type
        League footballLeague3 = new League("FIFA"); // this is no good at all, very raw type
        footballLeague.addTeam(adelaideCrows);
//        footballLeague.addTeam(baseballTeam);
//        footballLeague.addTeam(brokenTeam);
        footballLeague.addTeam(melbourne);
        footballLeague.addTeam(hawthorn);
        footballLeague.addTeam(fremantle);
        footballLeague.addTeam(melbourne); //shouldn't add

        League <Team<BaseballPlayer>> baseballLeague = new League("BIBA");
//        baseballLeague.addTeam(adelaideCrows);
        baseballLeague.addTeam(baseballTeam);
//        baseballLeague.addTeam(brokenTeam);
//        baseballLeague.addTeam(melbourne);
//        baseballLeague.addTeam(hawthorn);
//        baseballLeague.addTeam(fremantle);

        footballLeague.printTeamsInLeague();
        baseballLeague.printTeamsInLeague();
    }
}
