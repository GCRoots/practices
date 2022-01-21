package poker_02;

import java.util.ArrayList;
import java.util.Collections;

//扑克模拟器：装牌、洗牌、发牌、看牌
public class PokerDemo {

    public static void main(String[] args) {
        //🎴牌盒
        ArrayList<String> pokers =new ArrayList<>();

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
        String[] numbers={"2","3","4","5","6","7","8","9","10","J","Q","K","A"};

        for (String coler: colors){
            for (String number:numbers){
                pokers.add(coler+number);
            }
        }
        pokers.add("R-Joker");
        pokers.add("B-Joker");

        System.out.println(pokers);

        //洗牌
        Collections.shuffle(pokers);
        System.out.println(pokers);

        //玩家A、B、C
        ArrayList<String> playerA=new ArrayList<>();
        ArrayList<String> playerB=new ArrayList<>();
        ArrayList<String> playerC=new ArrayList<>();

        //三张底牌
        ArrayList<String> cards=new ArrayList<>();

        //发牌
        for (int i = 0; i< pokers.size(); i++){
            String poker=pokers.get(i);

            if (i>= pokers.size()-3){ //发底牌
                cards.add(poker);
            }else {  //给玩家发牌
                int num=i%3;
                switch (num){
                    case 0:
                        playerA.add(poker);
                        break;
                    case 1:
                        playerB.add(poker);
                        break;
                    case 2:
                        playerC.add(poker);
                        break;
                    default:
                }
            }
        }

        //看牌
        lookPokers("playerA",playerA);
        lookPokers("playerB",playerB);
        lookPokers("playerC",playerC);
        lookPokers("底牌",cards);


    }

    public static void lookPokers(String player,ArrayList<String> pokers){
        System.out.print(player+"的牌是:\t");
        for (String poker:pokers){
            System.out.print(poker+" ");
        }
        System.out.println();
    }


}
