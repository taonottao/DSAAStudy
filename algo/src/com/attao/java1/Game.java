package com.attao.java1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/4/3 22:49
 */
public class Game {

    private static final String[] suits = {"♥","♣","♦","♠"};

    //生成一副牌，不包含大小王
    public List<Poker> buyPoker(){
        List<Poker> pokers = new ArrayList<>();
        for (int i = 1; i <= 13; i++) {
            for (int j = 0; j < 4; j++) {
                String suit = suits[j];
                int rank = i;
                pokers.add(new Poker(suit, rank));
            }
        }
        return pokers;
    }

    //洗牌
    public void shuffle(List<Poker> pokers){

        for (int i = pokers.size() - 1; i > 0; i--) {
            Random random = new Random();
            int index =  random.nextInt(i);
            swap(pokers, i, index);
        }

    }

    private void swap(List<Poker> pokers,  int i, int j){
        Poker tmp = pokers.get(i);
        pokers.set(i, pokers.get(j));
        pokers.set(j, tmp);
    }

    public List<List<Poker>> personGame(List<Poker> pokers) {
        List<List<Poker>> hand = new ArrayList<>();
        List<Poker> hand1 = new ArrayList<>();
        List<Poker> hand2 = new ArrayList<>();
        List<Poker> hand3 = new ArrayList<>();
        List<Poker> hand4 = new ArrayList<>();
        List<Poker> hand5 = new ArrayList<>();
        hand.add(hand1);
        hand.add(hand2);
        hand.add(hand3);
        hand.add(hand4);
        hand.add(hand5);

        for (int i = 0; i < 3; i++) {//控制轮数
            for (int j = 0; j < 5; j++) {//五人轮流抓牌
                Poker poker = pokers.remove(0);
                hand.get(j).add(poker);
            }
        }
        return  hand;

    }

}
