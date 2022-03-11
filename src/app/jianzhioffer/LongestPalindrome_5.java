package app.jianzhioffer;

import java.util.Arrays;

/**
 * @author dimmy
 */
public class LongestPalindrome_5 {

    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * <p>
     * 示例 1：
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     * <p>
     * 示例 2：
     * 输入：s = "cbbd"
     * 输出："bb"
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 1000
     * s 仅由数字和英文字母组成
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int index = 0;
        int max = Integer.MIN_VALUE;
        char[] originSArr = s.toCharArray();
        int newLength = 2 * originSArr.length + 1;
        char[] newSArr = new char[newLength];
        int[] radiusArr = new int[newLength];
        for (int i = 1; i < newSArr.length; i += 2) {
            newSArr[i] = originSArr[i / 2];
        }
        for (int i = 0; i < newSArr.length; i += 2) {
            newSArr[i] = '#';
        }
        Arrays.fill(radiusArr, 1);
        int center = -1;
        int rightBound = -1;
        int leftBound = -1;
        for (int i = 0; i < newLength; i++) {
            if (i > rightBound) {
                int left = i - 1;
                int right = i + 1;
                while (left >= 0 && right < newLength) {
                    if (newSArr[left] != newSArr[right]) break;
                    if (right > rightBound) {
                        rightBound = right;
                        leftBound = left;
                        center = i;
                    }
                    radiusArr[i]++;
                    left--;
                    right++;
                }

                if (radiusArr[i] > max) {
                    max = radiusArr[i];
                    index = i;
                }
            } else {
                int mirrorPoint = 2 * center - i;
                int mirrorPointRadius = radiusArr[mirrorPoint];
                int mirrorPointLeftBound = mirrorPoint - mirrorPointRadius + 1;
                if (leftBound < mirrorPointLeftBound) {
                    radiusArr[i] = mirrorPointRadius;
                    if (radiusArr[i] > max) {
                        max = radiusArr[i];
                        index = i;
                    }
                } else if (leftBound == mirrorPointLeftBound) {
                    radiusArr[i] = mirrorPoint - leftBound + 1;
                    int left = i - radiusArr[i];
                    int right = i + radiusArr[i];
                    while (left >= 0 && right < newLength) {
                        if (newSArr[left] != newSArr[right]) break;
                        if (right > rightBound) {
                            rightBound = right;
                            leftBound = left;
                            center = i;
                        }
                        radiusArr[i]++;
                        left--;
                        right++;
                    }
                } else {
                    radiusArr[i] = mirrorPoint - leftBound + 1;
                }

                if (radiusArr[i] > max) {
                    max = radiusArr[i];
                    index = i;
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        if (newSArr[index] != '#') stringBuilder.append(newSArr[index]);
        for (int i = 1; i < max; i++) {
            int left = index - i;
            int right = index + i;
            if (newSArr[left] == '#') continue;
            stringBuilder.insert(0, newSArr[left]).append(newSArr[right]);
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome_5().longestPalindrome("babad"));
        System.out.println(new LongestPalindrome_5().longestPalindrome("cbbd"));
        System.out.println(new LongestPalindrome_5().longestPalindrome("abbadcacda"));
    }
}
