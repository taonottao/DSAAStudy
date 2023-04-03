package com.attao.java1;

import java.util.ArrayList;
import java.util.List;

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
    public void shuffle(){

    }

}
