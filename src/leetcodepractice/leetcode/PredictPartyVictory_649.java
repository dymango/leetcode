package leetcodepractice.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dimmy
 *  Dota2 的世界里有两个阵营：Radiant(天辉)和 Dire(夜魇)
 *
 * Dota2 参议院由来自两派的参议员组成。现在参议院希望对一个 Dota2 游戏里的改变作出决定。他们以一个基于轮为过程的投票进行。在每一轮中，每一位参议员都可以行使两项权利中的一项：
 *
 * 禁止一名参议员的权利：
 *
 * 参议员可以让另一位参议员在这一轮和随后的几轮中丧失所有的权利。
 *
 * 宣布胜利：
 *
 *   如果参议员发现有权利投票的参议员都是同一个阵营的，他可以宣布胜利并决定在游戏中的有关变化。
 *
 *  
 *
 * 给定一个字符串代表每个参议员的阵营。字母 “R” 和 “D” 分别代表了 Radiant（天辉）和 Dire（夜魇）。然后，如果有 n 个参议员，给定字符串的大小将是 n。
 *
 * 以轮为基础的过程从给定顺序的第一个参议员开始到最后一个参议员结束。这一过程将持续到投票结束。所有失去权利的参议员将在过程中被跳过。
 *
 * 假设每一位参议员都足够聪明，会为自己的政党做出最好的策略，你需要预测哪一方最终会宣布胜利并在 Dota2 游戏中决定改变。输出应该是 Radiant 或 Dire。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: "RD"
 * 输出: "Radiant"
 * 解释:  第一个参议员来自  Radiant 阵营并且他可以使用第一项权利让第二个参议员失去权力，因此第二个参议员将被跳过因为他没有任何权利。然后在第二轮的时候，第一个参议员可以宣布胜利，因为他是唯一一个有投票权的人
 * 示例 2:
 *
 * 输入: "RDD"
 * 输出: "Di布re"
 *  * 解释:
 *  * 第一轮中,第一个来自 Radiant 阵营的参议员可以使用第一项权利禁止第二个参议员的权利
 *  * 第二个来自 Dire 阵营的参议员会被跳过因为他的权利被禁止
 *  * 第三个来自 Dire 阵营的参议员可以使用他的第一项权利禁止第一个参议员的权利
 *  * 因此在第二轮只剩下第三个参议员拥有投票的权利,于是他可以宣胜利
 *  
 *
 * 注意:
 *
 * 给定字符串的长度在 [1, 10,000] 之间.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dota2-senate
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PredictPartyVictory_649 {

    public static String predictPartyVictory(String senate) {
        char[] senateArr = senate.toCharArray();
        boolean[] canVote = new boolean[senate.length()];
        Arrays.fill(canVote, true);
        while(true) {
            for (int i = 0; i < canVote.length; i++) {
                if(canVote[i]) {
                    int nextOther = findNextOther(senateArr, canVote, i);
                    if(nextOther == -1) {
                        return senateArr[i] == 'R' ? "Radiant" : "Dire";
                    } else {
                        canVote[nextOther] = false;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println( predictPartyVictoryV2("RDD"));
        System.out.println( predictPartyVictoryV2("DDRRR"));
        System.out.println( predictPartyVictoryV2("DRDRR"));
    }

    public  static int findNextOther(char[] senateArr, boolean[] canVote, int index) {
        char user = senateArr[index];
        for (int i = index + 1; i < senateArr.length; i++) {
            if(senateArr[i] != user && canVote[i]) return i;
        }

        for (int i = 0; i < senateArr.length; i++) {
            if(senateArr[i] != user && canVote[i]) return i;
        }

        return -1;
    }

    public static String predictPartyVictoryV2(String senate) {
        char[] senateArr = senate.toCharArray();
        Queue<String> rQueue = new LinkedList<>();
        Queue<String> dQueue = new LinkedList<>();
        for (int i = 0; i < senateArr.length; i++) {
            if(senateArr[i] == 'R') rQueue.offer("R");
            else dQueue.offer("D");
        }

        int rBanned = 0;
        int dBanned = 0;
        while(true) {
            for (int i = 0; i < senateArr.length; i++) {
                if(senateArr[i] == 'R') {
                    if(rBanned == 0) {
                        dQueue.poll();
                        dBanned++;
                        if(dQueue.isEmpty()) return "Radiant";
                    }else {
                        rBanned--;
                    }
                } else {
                    if(dBanned == 0) {
                        rQueue.poll();
                        rBanned++;
                        if(rQueue.isEmpty()) return "Dire";
                    } else {
                        dBanned--;
                    }
                }
            }
        }
    }
}
