package com.test.pojo;

public class Card {
    //卡片数字
    private int cardNum = 0;

    public Card(int num){
        this.cardNum = num;
    }

    public int getCardNum() {
        return cardNum;
    }

    public void setCardNum(int cardNum) {
        this.cardNum = cardNum;
    }
}
