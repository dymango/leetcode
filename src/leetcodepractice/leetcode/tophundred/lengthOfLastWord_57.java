package leetcodepractice.leetcode.tophundred;

/**
 * @author dimmy
 */
public class lengthOfLastWord_57 {

    /**
     * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
     * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "Hello World"
     * 输出：5
     * 解释：最后一个单词是“World”，长度为5。
     * 示例 2：
     * <p>
     * 输入：s = "   fly me   to   the moon  "
     * 输出：4
     * 解释：最后一个单词是“moon”，长度为4。
     * 示例 3：
     * <p>
     * 输入：s = "luffy is still joyboy"
     * 输出：6
     * 解释：最后一个单词是长度为6的“joyboy”。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 104
     * s 仅有英文字母和空格 ' ' 组成
     * s 中至少存在一个单词
     *
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        int point = s.length() - 1;
        boolean start = false;
        int end = s.length() - 1;
        while (point >= 0) {
            if (s.charAt(point) == ' ') {
                if (start) break;
            } else {
                if (!start) end = point;
                start = true;
            }

            point--;
        }

        return end - point;
    }
}
