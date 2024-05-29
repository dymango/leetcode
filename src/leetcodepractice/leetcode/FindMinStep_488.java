package leetcodepractice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class FindMinStep_488 {

    /**
     * 回忆一下祖玛游戏。现在桌上有一串球，颜色有红色(R)，黄色(Y)，蓝色(B)，绿色(G)，还有白色(W)。 现在你手里也有几个球。
     *
     * 每一次，你可以从手里的球选一个，然后把这个球插入到一串球中的某个位置上（包括最左端，最右端）。接着，如果有出现三个或者三个以上颜色相同的球相连的话，就把它们移除掉。重复这一步骤直到桌上所有的球都被移除。
     *
     * 找到插入并可以移除掉桌上所有球所需的最少的球数。如果不能移除桌上所有的球，输出 -1 。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：board = "WRRBBW", hand = "RB"
     * 输出：-1
     * 解释：WRRBBW -> WRR[R]BBW -> WBBW -> WBB[B]W -> WW
     * 示例 2：
     *
     * 输入：board = "WWRRBBWW", hand = "WRBRW"
     * 输出：2
     * 解释：WWRRBBWW -> WWRR[R]BBWW -> WWBBWW -> WWBB[B]WW -> WWWW -> empty
     * 示例 3：
     *
     * 输入：board = "G", hand = "GGGGG"
     * 输出：2
     * 解释：G -> G[G] -> GG[G] -> empty
     * 示例 4：
     *
     * 输入：board = "RBYYBBRRB", hand = "YRBGB"
     * 输出：3
     * 解释：RBYYBBRRB -> RBYY[Y]BBRRB -> RBBBRRB -> RRRB -> B -> B[B] -> BB[B] -> empty
     *  
     *
     * 提示：
     *
     * 你可以假设桌上一开始的球中，不会有三个及三个以上颜色相同且连着的球。
     * 1 <= board.length <= 16
     * 1 <= hand.length <= 5
     * 输入的两个字符串均为非空字符串，且只包含字符 'R','Y','B','G','W'。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zuma-game
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param board
     * @param hand
     * @return
     */
    public static void main(String[] args) {
//        System.out.println(findMinStep("WRRBBW", "RB"));
//        System.out.println(findMinStep("WWRRBBWW", "WRBRW"));
//        System.out.println(findMinStep("G", "GGGGG"));
//        System.out.println(findMinStep("RBYYBBRRB", "YRBGB"));
//        System.out.println(findMinStep("WWGWGW", "GWBWR"));
//        System.out.println(findMinStep("RRWWRRBBRR", "WB"));
        System.out.println(findMinStep("WWBBWBBWW", "BB"));

    }

    public static int findMinStep(String board, String hand) {
        simulation(board, hand, 0);
        return minEliminateCount == Integer.MAX_VALUE ? -1 : minEliminateCount;
    }

    public static int minEliminateCount = Integer.MAX_VALUE;
    public static void simulation(String boardBallStr, String handBallStr, int eliminateCount) {
        if(eliminateCount > minEliminateCount) return;
        if(boardBallStr.length() == 0) {
            minEliminateCount = Math.min(minEliminateCount, eliminateCount);
            return;
        }

        if(boardBallStr.length() != 0 && handBallStr.length() == 0) return;
        List<Integer> canPlaceIndexs = findCanPlaceBallPosition(boardBallStr, handBallStr);
        if(!canPlaceIndexs.isEmpty()) {
            for (int i = 0; i < canPlaceIndexs.size(); i++) {
                int index = canPlaceIndexs.get(i);
                String newBoardBallStr = boardBallStr.substring(0, index) + boardBallStr.substring(index + 2);
                String newHandBallStr = deleteHandBall(handBallStr, String.valueOf(boardBallStr.charAt(index)));
                simulation(eliminateThreeNearBall(newBoardBallStr), newHandBallStr, eliminateCount + 1);
//                simulation(newBoardBallStr, newHandBallStr, eliminateCount + 1);
            }
        }
        //匹配一个色球，不匹配两个色球
        for (int i = 0; i < handBallStr.length(); i++) {
            List<String> newBoardBallStr = placeBall(boardBallStr, handBallStr.charAt(i));
            String newHandBallStr = deleteHandBall(handBallStr, String.valueOf(handBallStr.charAt(i)));
            for (int j = 0; j < newBoardBallStr.size(); j++) {
                simulation(newBoardBallStr.get(j), newHandBallStr, eliminateCount + 1);
            }
        }
    }

    public static String eliminateThreeNearBall(String boardBallStr) {
        int count = 1;
        for (int i = 1; i < boardBallStr.length(); i++) {
            if(boardBallStr.charAt(i) == boardBallStr.charAt(i - 1)) {
                count++;
            } else {
                if(count >= 3) {
                    return eliminateThreeNearBall(boardBallStr.substring(0, i - count) + boardBallStr.substring(i));
                }

                count = 1;
            }
        }

        if(count >= 3) {
            return boardBallStr.substring(0, boardBallStr.length() - count);
        }

        return boardBallStr;
    }

    public static List<String> placeBall(String boardBallStr, char ball) {
        List<String> ballList = new ArrayList<>();
        if(boardBallStr.length() == 1) {
            if(boardBallStr.charAt(0) == ball) ballList.add(boardBallStr + ball);
        } else {
            for (int i = 0; i < boardBallStr.length(); i++) {
                if(i == 0) {
                    if(boardBallStr.charAt(i + 1) != ball) ballList.add(boardBallStr.substring(0, i) + ball + boardBallStr.substring(i));
                } else if(i == boardBallStr.length() - 1) {
                    if(boardBallStr.charAt(i - 1) != ball) ballList.add(boardBallStr.substring(0, i) + ball + boardBallStr.substring(i));
                } else {
                    if(boardBallStr.charAt(i - 1) != ball && boardBallStr.charAt(i + 1) != ball)  ballList.add(boardBallStr.substring(0, i) + ball + boardBallStr.substring(i));
                }
            }

            if(ballList.isEmpty()) {
                ballList.add(boardBallStr + ball);
            }
        }

        return ballList;
    }

    public static String deleteHandBall(String handBallStr, String deleteBall) {
        int deleteIndex = handBallStr.indexOf(deleteBall);
        return handBallStr.substring(0, deleteIndex) + handBallStr.substring(deleteIndex + 1);
    }

    public static List<Integer> findCanPlaceBallPosition(String ballStr, String handBallStr) {
        List<Integer> indexs = new ArrayList<>();
        if(ballStr.length() == 2) {
            if(ballStr.charAt(0) == ballStr.charAt(1) && handBallStr.contains(String.valueOf(ballStr.charAt(0)))) indexs.add(0);
        } else {
            for (int i = 0; i < ballStr.length() - 1; i++) {
                if(ballStr.charAt(i) == ballStr.charAt(i + 1) && handBallStr.contains(String.valueOf(ballStr.charAt(i)))) {
                    if(i - 1 >= 0 && i + 2 < ballStr.length()) {
                        if(ballStr.charAt(i) != ballStr.charAt(i - 1) && ballStr.charAt(i + 1) != ballStr.charAt(i + 2)) indexs.add(i);
                    } else if(i - 1 >= 0) {
                        if(ballStr.charAt(i) != ballStr.charAt(i - 1)) indexs.add(i);
                    } else {
                        if(ballStr.charAt(i + 1) != ballStr.charAt(i + 2)) indexs.add(i);
                    }
                }
            }
        }


        return indexs;
    }
}
