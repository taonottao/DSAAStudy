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

        //洗牌
        System.out.println("洗牌:");
        game.shuffle(pokers);
        System.out.println(pokers);

        //揭牌
        List<List<Poker>> list = game.personGame(pokers);
        System.out.println("揭牌");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("第" + (i+1) + "个人的牌：" + list.get(i));
        }
        System.out.println("剩下的牌：");
        System.out.println(pokers);

//        String s = "hello";
//        char c = s.charAt(1);
//        System.out.println(c);
    }
}
