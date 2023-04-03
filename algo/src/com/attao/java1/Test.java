package com.attao.java1;

import java.util.List;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/4/3 22:49
 */
public class Test {
    public static void main(String[] args) {
        Game game = new Game();
        List<Poker> pokers = game.buyPoker();
        System.out.println(pokers);
    }
}
