import com.test.pojo.Card;
import com.test.pojo.GameCotroller;
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

    //游戏开始入口
    public static void main(String[] args) {
//        1.Java的类属性应该是private
//        2.GameStart.main()不应该掺入游戏初始化的逻辑
//        3.考虑可能的变化点，如果我需要改成四个玩家，要改动多少代码？
//        4.gameStart.putPlayerCard(onePlayer,twoPlayer)，你传入参数给gameStart，是否说明你要传的参数，应该是它的属性
//        5.compareCard()，该方法的目的是得出谁的分数最高，最终结果不是打印出来。试想如果我是手机端游戏，你打印的信息玩家如何看得到？

        GameCotroller gameCotroller = new GameCotroller();

        //玩家游戏
        Scanner in  = new Scanner(System.in);
        //存放玩家卡牌，用于比较
        List<List<Card>> palyerCards = new ArrayList<List<Card>>();
        //存放玩家的分数
        List<Integer> palyerscore = new ArrayList<Integer>();
        //存放玩家列表
        List<Player> palyers = new ArrayList<Player>();


        //输入玩家个数，并且保证玩家的个数能被52整除
        System.out.println("请输入玩家个数(请保证52张牌能均匀发放)：");
        int playerNum = in.nextInt();
        while(!(52%playerNum==0)){
            System.out.println("玩家个数必须能保证52张牌被均匀发放，请重新输入：");
            playerNum = in.nextInt();
        }
        for(int i=1;i<=playerNum;i++){
            System.out.println("请输入" + i + "号玩家名称：");
            String name = in.next();
            Player player = new Player(name);
            palyerCards.add(player.getCardList());
            palyerscore.add(player.getScore());
            palyers.add(player);
        }

        //洗牌
        gameCotroller.washCard();

        //给每位玩家分发牌
        gameCotroller.putPlayerCard(palyerCards,playerNum);

        //比较大小
        //比较大小和判断哪个玩家分数最高可以直接传入玩家列表，但是为了防止数据破坏，新增了分数列表和卡牌列表传入计算
        gameCotroller.compareCard(palyerCards,palyerscore,playerNum);
        
        //判断哪个玩家分数最高
        int maxPlayer = gameCotroller.getMaxIndex(palyerscore);
        System.out.println((maxPlayer+1) + "号玩家" + palyers.get(maxPlayer).getPlayerName() + ",赢得了比赛！！！！" + "分数为" + palyerscore.get(maxPlayer).toString());

    }
}
