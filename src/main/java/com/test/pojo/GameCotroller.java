package com.test.pojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameCotroller {
    //游戏总牌队列
    private List<Card> countCardList = new ArrayList<Card>();

    //初始化填充牌
    {
        //循环添加
        for (int i = 1; i <= 52; i++) {
            countCardList.add(new Card(i));
        }
    }

    //洗牌
    public void washCard() {
        Random random = new Random();
        Collections.shuffle(countCardList, random);
    }


    /**
     * 保证输入的玩家数能够被卡牌数目整除
     * //存放所有玩家各自的牌
     * //存放所有玩家各自的牌
     *
     * @param palyerCards
     * @param playerNum
     */
    public void putPlayerCard(List<List<Card>> palyerCards, int playerNum) {
        //每个玩家一张一张牌的摸
        for (int i = 1; i <= playerNum; i++) {
            List<Card> cards = palyerCards.get(i - 1);
            for (int j = i; j <= countCardList.size() - (playerNum - i); j = j + playerNum) {
                cards.add(countCardList.get(j - 1));
            }
        }
    }

    //比较卡片值
    public void compareCard(List<List<Card>> palyerCards,List<Integer> palyerscore, int playerNum) {
        //每个玩家，拿出一张牌比较
        //i表示每个玩家一共多少张牌
        //j表示几个玩家
        for (int i = 0; i < countCardList.size()/playerNum; i++) {
            //用于临时存放玩家得牌，比较谁的牌最大
            List<Integer> temp = new ArrayList<Integer>();

            for (int j = 0; j < playerNum; j++) {
                List<Card> cards = palyerCards.get(j);
                temp.add(cards.get(i).getCardNum());
            }
            Integer max = getMaxIndex(temp);

            //将对应玩家的分数加1
            palyerscore.set(max,palyerscore.get(max) + 1);
        }
    }

    //获取数组中最大值的下标
    public int getMaxIndex(List<Integer> temp) {
        //定义数组中最大值为max
        int max = 0;
        //最大值下标
        int max_index = 0;
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i) > temp.get(max_index)) {
                max = temp.get(i);
                max_index = i;
            }
        }
        return max_index;
    }
}
