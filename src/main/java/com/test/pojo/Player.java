package com.test.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Player {
    //玩家名称
    String playerName;

    //卡片队列
    List<Card> cardList = new ArrayList<Card>();

    public Player(String name){
        this.playerName = name;
    }

    public Player(String name,ArrayList<Card> list){
        this.playerName = name;
        this.cardList = list;
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
