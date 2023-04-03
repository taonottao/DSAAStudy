package com.attao.java1;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/4/3 22:49
 */
public class Poker {

    private String suit;//花色
    private int rank;//牌

    public Poker(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "{" + suit +" " + rank + "}";
    }
}
