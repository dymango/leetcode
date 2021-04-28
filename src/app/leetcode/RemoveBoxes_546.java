package app.leetcode;

/**
 * @author dimmy
 */
public class RemoveBoxes_546 {

    /**
     * 给出一些不同颜色的盒子，盒子的颜色由数字表示，即不同的数字表示不同的颜色。
     * 你将经过若干轮操作去去掉盒子，直到所有的盒子都去掉为止。每一轮你可以移除具有相同颜色的连续 k 个盒子（k >= 1），这样一轮之后你将得到 k*k 个积分。
     * 当你将所有盒子都去掉之后，求你能获得的最大积分和。
     *
     * 优化：
     * 这里有重复计算，但是如何做记忆化递归呢
     *  
     *
     * 示例：
     *
     * 输入：boxes = [1,3,2,2,2,3,4,3,1]
     * 输出：23
     * 解释：
     * [1, 3, 2, 2, 2, 3, 4, 3, 1]
     * ----> [1, 3, 3, 4, 3, 1] (3*3=9 分)
     * ----> [1, 3, 3, 3, 1] (1*1=1 分)
     * ----> [1, 1] (3*3=9 分)
     * ----> [] (2*2=4 分)
     *  
     *
     * 提示：
     *
     * 1 <= boxes.length <= 100
     * 1 <= boxes[i] <= 100
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-boxes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param boxes
     * @return
     */
    public static int removeBoxes(int[] boxes) {
        if(boxes.length <= 1) return boxes.length;
        int score = Integer.MIN_VALUE;
        int l = boxes.length;
        int point = 1;
        int pre = 0;
        while(point < l) {
            if(boxes[point] == boxes[point - 1]) {
                point++;
            } else {
                int length = point - pre;
                int nextScore = length*length;
                int newBoxesSize = l - length;
                int[] newBoxes = new int[newBoxesSize];
                int index = 0;
                for (int i = 0; i < pre; i++) {
                    newBoxes[index++] = boxes[i];
                }

                for (int i = point; i < l; i++) {
                    newBoxes[index++] = boxes[i];
                }

                score = Math.max(score, nextScore + removeBoxes(newBoxes));
                pre = point;
                point++;
            }
        }


        int length = point - pre;
        int newBoxesSize = l - length;
        if(length == 1) {
            score = Math.max(score, 1);
        } else {
            int[] newBoxes = new int[newBoxesSize];
            int index = 0;
            int nextScore = length*length;
            for (int i = 0; i < pre; i++) {
                newBoxes[index++] = boxes[i];
            }

            for (int i = point; i < l; i++) {
                newBoxes[index++] = boxes[i];
            }

            score = Math.max(score, nextScore + removeBoxes(newBoxes));
        }

        return score;
    }
//
//    public static int search(int[] boxes) {
//        if(boxes.length <= 1) return boxes.length;
//        int score = Integer.MIN_VALUE;
//        int l = boxes.length;
//        int point = 1;
//        int pre = 0;
//        while(point < l) {
//            if(boxes[point] == boxes[point - 1]) {
//                point++;
//            } else {
//                int length = point - pre;
//                int nextScore = length*length;
//                int newBoxesSize = l - length;
//                int[] newBoxes = new int[newBoxesSize];
//                int index = 0;
//                for (int i = 0; i < pre; i++) {
//                    newBoxes[index++] = boxes[i];
//                }
//
//                for (int i = point; i < l; i++) {
//                    newBoxes[index++] = boxes[i];
//                }
//
//                score = Math.max(score, nextScore + search(newBoxes));
//                pre = point;
//                point++;
//            }
//        }
//
//
//        int length = point - pre;
//        int newBoxesSize = l - length;
//        if(length == 1) {
//            score = Math.max(score, 1);
//        } else {
//            int[] newBoxes = new int[newBoxesSize];
//            int index = 0;
//            int nextScore = length*length;
//            for (int i = 0; i < pre; i++) {
//                newBoxes[index++] = boxes[i];
//            }
//
//            for (int i = point; i < l; i++) {
//                newBoxes[index++] = boxes[i];
//            }
//
//            score = Math.max(score, nextScore + search(newBoxes));
//        }
//
//        return score;
//    }

    public static void main(String[] args) {
        System.out.println(removeBoxes(new int[]{1,3,2,2,2,3,4,3,1}));
        System.out.println(removeBoxes(new int[]{3,8,8,5,5,3,9,2,4,4,6,5,8,4,8,6,9,6,2,8,6,4,1,9,5,3,10,5,3,3,9,8,8,6,5,3,7,4,9,6,3,9,4,3,5,10,7,6,10,7}));
    }


    public int removeBoxes2(int[] boxes) {
        int[][][] dp = new int[100][100][100];
        return calculatePoints(boxes, dp, 0, boxes.length - 1, 0);
    }

    public int calculatePoints(int[] boxes, int[][][] dp, int l, int r, int k) {
        if (l > r) return 0;
        if (dp[l][r][k] != 0) return dp[l][r][k];
        while (r > l && boxes[r] == boxes[r - 1]) {
            r--;
            k++;
        }
        dp[l][r][k] = calculatePoints(boxes, dp, l, r - 1, 0) + (k + 1) * (k + 1);
        for (int i = l; i < r; i++) {
            if (boxes[i] == boxes[r]) {
                dp[l][r][k] = Math.max(dp[l][r][k], calculatePoints(boxes, dp, l, i, k + 1) + calculatePoints(boxes, dp, i + 1, r - 1, 0));
            }
        }
        return dp[l][r][k];
    }
}
