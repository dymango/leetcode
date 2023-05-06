package app.leetcode;

/**
 * @author dimmy
 */
public class PushDominoes_838 {

    /**
     * 一行中有 N 张多米诺骨牌，我们将每张多米诺骨牌垂直竖立。
     * 在开始时，我们同时把一些多米诺骨牌向左或向右推。
     * 每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。
     * 同样地，倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。
     * 如果同时有多米诺骨牌落在一张垂直竖立的多米诺骨牌的两边，由于受力平衡， 该骨牌仍然保持不变。
     * 就这个问题而言，我们会认为正在下降的多米诺骨牌不会对其它正在下降或已经下降的多米诺骨牌施加额外的力。
     * 给定表示初始状态的字符串 "S" 。如果第 i 张多米诺骨牌被推向左边，则 S[i] = 'L'；如果第 i 张多米诺骨牌被推向右边，则 S[i] = 'R'；如果第 i 张多米诺骨牌没有被推动，则 S[i] = '.'。
     * 返回表示最终状态的字符串。
     *
     * 示例 1：
     *
     * 输入：".L.R...LR..L.."
     * 输出："LL.RR.LLRRLL.."
     * 示例 2：
     *
     * 输入："RR.L"
     * 输出："RR.L"
     * 说明：第一张多米诺骨牌没有给第二张施加额外的力。
     * 提示：
     *
     * 0 <= N <= 10^5
     * 表示多米诺骨牌状态的字符串只含有 'L'，'R'; 以及 '.';
     *
     * @param dominoes
     * @return
     */
    public String pushDominoes(String dominoes) {
        int[] leftArm = new int[dominoes.length()];
        int[] rightArm = new int[dominoes.length()];
        char[] chars = dominoes.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if(chars[i] == '.') {
                if(chars[i- 1] == '.') {
                    leftArm[i] = leftArm[i - 1] + 1;
                } else {
                    leftArm[i] = 0;
                }
            }
        }

        for (int i = chars.length - 2; i >= 0; i--) {
            if(chars[i] == '.') {
                if(chars[i + 1] == '.') {
                    rightArm[i] = rightArm[i + 1] + 1;
                } else {
                    rightArm[i] = 0;
                }
            }
        }

        char[] result = new char[chars.length];
        char preChar = chars[0];
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if(c == 'R') {
                preChar = 'R';
                result[i] = 'R';
            } else if(c == 'L') {
                preChar = 'L';
                result[i] = 'L';
            } else if(c == '.') {
                result[i] =  preChar == 'R' ? 'R' : '.';
            }
        }


        preChar = '.';
        for (int i = chars.length - 1; i >= 0; i--) {
            char c = chars[i];
            if(c == 'L') {
                preChar = 'L';
            } else if(c == 'R') {
                preChar = 'R';
            } else if(c == '.') {
                int ll = leftArm[i], rl = rightArm[i];
                char at = result[i];
                if(at == '.' && preChar == 'L') {
                    result[i] = 'L';
                } else if(ll == rl && at == 'R' && preChar == 'L') {
                    result[i] = '.';
                } else if(ll > rl && preChar == 'L') {
                    result[i] = 'L';
                }
            }
        }

        return String.valueOf(result);
    }

    public static void main(String[] args) {
        System.out.println(new PushDominoes_838().pushDominoes(".L.R...LR..L.."));
        System.out.println(new PushDominoes_838().pushDominoes("RR.L"));
    }
}
