package com.jdurieu.reddevils.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class Team {

    public static class Player {
        private String c_ClubNatioShort;
        private String c_FunctionShort;
        private String c_Image;
        private String c_ImageURL;
        private String c_Person;
        private String c_PersonLong;
        private String c_PersonShirt;
        private String c_PersonShort;
        private String c_ShareURL;
        private Integer n_PersonID;
        private Integer n_ShirtNr;
        private Integer n_TeamID;

        public Player() {

        }

        public String getC_ClubNatioShort() {
            return c_ClubNatioShort;
        }

        public void setC_ClubNatioShort(String c_ClubNatioShort) {
            this.c_ClubNatioShort = c_ClubNatioShort;
        }

        public String getC_FunctionShort() {
            return c_FunctionShort;
        }

        public void setC_FunctionShort(String c_FunctionShort) {
            this.c_FunctionShort = c_FunctionShort;
        }

        public String getC_Image() {
            return c_Image;
        }

        public void setC_Image(String c_Image) {
            this.c_Image = c_Image;
        }

        public String getC_ImageURL() {
            return c_ImageURL;
        }

        public void setC_ImageURL(String c_ImageURL) {
            this.c_ImageURL = c_ImageURL;
        }

        public String getC_Person() {
            return c_Person;
        }

        public void setC_Person(String c_Person) {
            this.c_Person = c_Person;
        }

        public String getC_PersonLong() {
            return c_PersonLong;
        }

        public void setC_PersonLong(String c_PersonLong) {
            this.c_PersonLong = c_PersonLong;
        }

        public String getC_PersonShirt() {
            return c_PersonShirt;
        }

        public void setC_PersonShirt(String c_PersonShirt) {
            this.c_PersonShirt = c_PersonShirt;
        }

        public String getC_PersonShort() {
            return c_PersonShort;
        }

        public void setC_PersonShort(String c_PersonShort) {
            this.c_PersonShort = c_PersonShort;
        }

        public String getC_ShareURL() {
            return c_ShareURL;
        }

        public void setC_ShareURL(String c_ShareURL) {
            this.c_ShareURL = c_ShareURL;
        }

        public Integer getN_PersonID() {
            return n_PersonID;
        }

        public void setN_PersonID(Integer n_PersonID) {
            this.n_PersonID = n_PersonID;
        }

        public Integer getN_ShirtNr() {
            return n_ShirtNr;
        }

        public void setN_ShirtNr(Integer n_ShirtNr) {
            this.n_ShirtNr = n_ShirtNr;
        }

        public Integer getN_TeamID() {
            return n_TeamID;
        }

        public void setN_TeamID(Integer n_TeamID) {
            this.n_TeamID = n_TeamID;
        }
    }

    public static class Players {
        public String c_FunctionShort;
        public ArrayList<Player> players;

        public Players() {

        }

        public String getC_FunctionShort() {
            return c_FunctionShort;
        }

        public void setC_FunctionShort(String c_FunctionShort) {
            this.c_FunctionShort = c_FunctionShort;
        }

        public ArrayList<Player> getPlayers() {
            return players;
        }

        public void setPlayers(ArrayList<Player> players) {
            this.players = players;
        }
    }

    public static class TeamData {
        private ArrayList<Players> players;

        public TeamData() {

        }

        public ArrayList<Players> getPlayers() {
            return players;
        }

        public void setPlayers(ArrayList<Players> players) {
            this.players = players;
        }
    }

    private TeamData data;

    public TeamData getData() {
        return data;
    }

    public void setData(TeamData data) {
        this.data = data;
    }
}
