package app.leetcode;

/**
 * @author dimmy
 */
public class CheckInclusion_567 {

    /**
     * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
     *
     * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
     *
     * 示例1:
     *
     * 输入: s1 = "ab" s2 = "eidbaooo"
     * 输出: True
     * 解释: s2 包含 s1 的排列之一 ("ba").
     *  
     *
     * 示例2:
     *
     * 输入: s1= "ab" s2 = "eidboaoo"
     * 输出: False
     *  
     *
     * 注意：
     *
     * 输入的字符串只包含小写字母
     * 两个字符串的长度都在 [1, 10,000] 之间
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/permutation-in-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        if(s1.length() == 0) return true;
        int[] charArr = new int[26];
        int windowWidth = s1.length();
        for (int i = 0; i < windowWidth; i++) {
            charArr[s1.charAt(i) - 97]++;
        }

        int start = 0;
        int end = start + windowWidth - 1;
        int[] carr = new int[26];
        for (int i = start; i <= end; i++) {
            carr[s2.charAt(i) - 97]++;
        }

        while(end < s2.length()) {
            boolean match = true;
            for (int i = 0; i < 26; i++) {
                if(charArr[i] != carr[i]) {
                    match = false;
                }
            }

            if(match) return true;
            carr[s2.charAt(start) - 97]--;
            start++;
            end++;
            if(end < s2.length()) carr[s2.charAt(end) - 97]++;
        }

        return false;
    }

    public static void main(String[] args) {

        checkInclusion("ab", "eidboaoo");
    }
}
