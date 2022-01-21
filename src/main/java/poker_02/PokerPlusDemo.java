package poker_02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

/*
    扑克模拟器：装牌、洗牌、发牌、看牌，实现牌的排序
    思路：
        1：HashMap：K是编号，V是花色
        2：ArrayList：编号
        3：花色数组colors 和 数字数组numbers
        4：从零开始往HashMap里存储编号与对应的牌号，从零开始往ArrayList里存储编号
        5：洗牌，Collections的shuffle()方法，操作ArrayList，即对编号进行洗牌
        6：发牌，发编号，为保证有序，用TreeSet接受
        7：看牌，通过编号在HashMap中查看对应的牌号
 */
public class PokerPlusDemo {

    public static void main(String[] args) {

        //🎴牌盒
        HashMap<Integer,String> hashMap=new HashMap<>();
        ArrayList<Integer> array =new ArrayList<>();

        /*
        装牌
        ♦2，♦3，♦4，♦5，♦6，♦7，♦8，♦9，♦10，♦J，♦Q，♦K，♦A
        ♣2，♣3，♣4，♣5，♣6，♣7，♣8，♣9，♣10，♣J，♣Q，♣K，♣A
        ♥2，♥3，♥4，♥5，♥6，♥7，♥8，♥9，♥10，♥J，♥Q，♥K，♥A
        ♠2，♠3，♠4，♠5，♠6，♠7，♠8，♠9，♠10，♠J，♠Q，♠K，♠A
        大王 R-Joker：Red Joker
        小王 B-Joker：Black Joker
         */
        //花色
        String[] colors ={"♦","♣","♥","♠"};
        //点数
        String[] numbers={"3","4","5","6","7","8","9","10","J","Q","K","A","2"};

        int index=0;
        for (String number:numbers){
            for (String color : colors){
                hashMap.put(index,color+number);
                array.add(index++);
            }
        }
        hashMap.put(index,"R-Joker");
        array.add(index++);
        hashMap.put(index,"B-Joker");
        array.add(index);

        System.out.println(hashMap);
        System.out.println(array);

        //洗牌
        Collections.shuffle(array);
        System.out.println(array);

        //玩家A、B、C
        TreeSet<Integer> playerA=new TreeSet<>();
        TreeSet<Integer> playerB=new TreeSet<>();
        TreeSet<Integer> playerC=new TreeSet<>();

        //三张底牌
        TreeSet<Integer> cards=new TreeSet<>();

        //发牌
        for (int i = 0; i< array.size(); i++) {
            Integer poker = array.get(i);

            if (i > array.size() - 4) { //发底牌
                cards.add(poker);
            } else if (i % 3 == 0) {
                playerA.add(poker);
            } else if (i % 3 == 1) {
                playerB.add(poker);
            } else if (i % 3 == 2) {
                playerC.add(poker);
            }
        }

        //看牌
        lookPokers("playerA",playerA,hashMap);
        lookPokers("playerB",playerB,hashMap);
        lookPokers("playerC",playerC,hashMap);
        lookPokers("底牌",cards,hashMap);

    }

    public static void lookPokers(String player,TreeSet<Integer> pokers,HashMap<Integer,String> hashMap){
        System.out.print(player+"的牌是:\t");
        for (Integer poker:pokers){
            System.out.print(hashMap.get(poker)+" ");
        }
        System.out.println();
    }


}
