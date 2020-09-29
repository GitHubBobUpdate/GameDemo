package com.test.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Player {
    //玩家名称
    private String playerName;

    //玩家的分数
    private int score = 0;

    //卡片队列
    private List<Card> cardList = new ArrayList<Card>();

    public Player(String name){
        this.playerName = name;
    }

    public Player(String name,ArrayList<Card> list){
        this.playerName = name;
        this.cardList = list;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }
}
