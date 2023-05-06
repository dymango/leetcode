package app.leetcode;

/**
 * @author dimmy
 */
public class IsLongPressedName_925 {

    /**
     * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
     * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：name = "alex", typed = "aaleex"
     * 输出：true
     * 解释：'alex' 中的 'a' 和 'e' 被长按。
     * 示例 2：
     * <p>
     * 输入：name = "saeed", typed = "ssaaedd"
     * 输出：false
     * 解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= name.length, typed.length <= 1000
     * name 和 typed 的字符都是小写字母
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/long-pressed-name
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param name
     * @param typed
     * @return
     */
    //"vtkgn"
    //"vttkgnn"
    //"alex"
    //"aaleelx"
    public boolean isLongPressedName(String name, String typed) {
        int namePointer = 0;
        int typedPointer = 0;
        char pre = name.charAt(0);
        while (namePointer < name.length() && typedPointer < typed.length()) {
            char nameChar = name.charAt(namePointer);
            char typedChar = typed.charAt(typedPointer);
            if (nameChar == typedChar) {
                pre = nameChar;
                namePointer++;
                typedPointer++;
                continue;
            } else if (typedChar != pre) return false;

            typedPointer++;
        }


        if (namePointer == name.length()) {
            if (typedPointer == typed.length()) return true;
            return validTyped(typed, typedPointer - 1);
        }

        return false;
    }

    private boolean validTyped(String str, int index) {
        char c = str.charAt(index);
        for (int i = index + 1; i < str.length(); i++) {
            if (c != str.charAt(i)) return false;
        }

        return true;
    }
}
