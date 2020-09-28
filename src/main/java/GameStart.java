import com.test.pojo.Card;
import com.test.pojo.Player;

import java.util.*;

/**
 * 卡片比较游戏：
 * 有一副牌，通过洗牌之后，将牌分发给两个玩家
 * 之后每个玩家取出一张牌，比较大小，数字大的玩家赢
 * 当玩家手中的牌全部比较完，游戏结束
 * @author wanhongjia 2020-09-28
 *
 */
public class GameStart {
    //游戏总牌队列
    List<Card> countCardList = new ArrayList<Card>();

    //游戏开始入口
    public static void main(String[] args) {
        GameStart gameStart = new GameStart();
        //添加牌
        gameStart.addCard();
        //洗牌
        gameStart.washCard();

        //玩家游戏
        Scanner in  = new Scanner(System.in);
        //输入玩家信息
        System.out.println("一号玩家名称：");
        String oneName = in.next();
        Player onePlayer = new Player(oneName);

        System.out.println("二号玩家名称：");
        String twoName = in.next();
        Player twoPlayer = new Player(twoName);

        //给每位玩家分发牌
        //采用每个玩家一人一张的方式发放
        gameStart.putPlayerCard(onePlayer,twoPlayer);

        //比较大小
        gameStart.compareCard(onePlayer,twoPlayer);

    }

    //添加卡片，固定是52张
    public void addCard(){
        //循环添加
        for(int i=1; i <= 52; i++){
            countCardList.add(new Card(i));
        }
    }

    //洗牌
    public void washCard(){
        Random random = new Random();
        Collections.shuffle(countCardList,random);
    }

    //给玩家发放牌
    public void putPlayerCard(Player onePlay,Player twoPlay){
        //玩家一的牌
        List<Card> playerOne = new ArrayList<Card>();
        //玩家二的牌
        List<Card> playerTwo = new ArrayList<Card>();

        for(int i=1;i<=countCardList.size();i++){
            if(i%2==0){
                //先给玩家一发牌
                playerOne.add(countCardList.get(i-1));
            }else{
                playerTwo.add(countCardList.get(i-1));
            }
        }
//        System.out.println("一号玩家的卡片：");
//        for(int i=0;i<playerOne.size();i++){
//            System.out.println(playerOne.get(i).getCardNum());
//        }
//        System.out.println("二号玩家的卡片：");
//        for(int i=0;i<playerTwo.size();i++){
//            System.out.println(playerTwo.get(i).getCardNum());
//        }
        onePlay.setCardList(playerOne);
        twoPlay.setCardList(playerTwo);
    }

    //比较卡片值
    public void compareCard(Player onePlay,Player twoPlay){
        for(int i=1;i<=countCardList.size()/2;i++){
            Card cardOne = onePlay.getCardList().get(i-1);
            Card cardTwo = twoPlay.getCardList().get(i-1);
            boolean isWin = cardOne.getCardNum() > cardTwo.getCardNum() ? true:false;
            if(isWin){
                System.out.println("第"  + i + "把卡牌比较，一号玩家赢！！！！");
            }else{
                System.out.println("第"  + i + "把卡牌比较，二号玩家赢！！！！");
            }
        }
        System.out.println("卡牌游戏完成");
    }
}
