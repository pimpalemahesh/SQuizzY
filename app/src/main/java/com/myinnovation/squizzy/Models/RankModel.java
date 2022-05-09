package com.myinnovation.squizzy.Models;

public class RankModel {
    String rank_id, user_rank, user_image, user_name, user_score;

    public RankModel(String rank_id, String user_rank, String user_image, String user_name, String user_score) {
        this.rank_id = rank_id;
        this.user_rank = user_rank;
        this.user_image = user_image;
        this.user_name = user_name;
        this.user_score = user_score;
    }

    public RankModel() {
    }

    public String getRank_id() {
        return rank_id;
    }

    public void setRank_id(String rank_id) {
        this.rank_id = rank_id;
    }

    public String getUser_rank() {
        return user_rank;
    }

    public void setUser_rank(String user_rank) {
        this.user_rank = user_rank;
    }

    public String getUser_image() {
        return user_image;
    }

    public void setUser_image(String user_image) {
        this.user_image = user_image;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_score() {
        return user_score;
    }

    public void setUser_score(String user_score) {
        this.user_score = user_score;
    }
}
