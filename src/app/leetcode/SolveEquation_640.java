package app.leetcode;

import app.leetcode.base.BaseClass;
import app.leetcode.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 *
 * 求解一个给定的方程，将x以字符串"x=#value"的形式返回。该方程仅包含'+'，' - '操作，变量 x 和其对应系数。
 *
 * 如果方程没有解，请返回“No solution”。
 *
 * 如果方程有无限解，则返回“Infinite solutions”。
 *
 * 如果方程中只有一个解，要保证返回值 x 是一个整数。
 *
 * 示例 1：
 *
 * 输入: "x+5-3+x=6+x-2"
 * 输出: "x=2"
 * 示例 2:
 *
 * 输入: "x=x"
 * 输出: "Infinite solutions"
 * 示例 3:
 *
 * 输入: "2x=x"
 * 输出: "x=0"
 * 示例 4:
 *
 * 输入: "2x+3x-6x=x+2"
 * 输出: "x=-1"
 * 示例 5:
 *
 * 输入: "x=x+2"
 * 输出: "No solution"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/solve-the-equation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolveEquation_640 extends BaseClass {

    public static String solveEquation(String equation) {
        String[] split = equation.split("=");
        List<List<Integer>> leftData = data(split[0]);
        List<Integer> leftXPrefixList = leftData.get(0);
        List<Integer> leftNumList = leftData.get(1);
        List<List<Integer>> rightData = data(split[1]);
        List<Integer> rightXPrefixList = rightData.get(0);
        List<Integer> rightNumList = rightData.get(1);
        int leftSum = 0;
        for (Integer i: leftXPrefixList) {
            leftSum += i;
        }

        int rightSum = 0;
        for (Integer i: rightXPrefixList) {
            rightSum += i;
        }

        int a = leftSum - rightSum;

        int leftTotalNum = 0;
        for (Integer i: leftNumList) {
            leftTotalNum += i;
        }

        int rightTotalNum = 0;
        for (Integer i: rightNumList) {
            rightTotalNum += i;
        }

        int b = rightTotalNum - leftTotalNum;
        if(a == 0) {
            if(b==0)  return "Infinite solutions";
            return "No solution";
        }

        return "x=" + b/a;
    }

    public static List<List<Integer>> data(String str) {
        if(!str.startsWith("-")) {
            str = ("+" + str);
        }

        List<Integer> prefixList = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        String left = str;
        for (int i = 0; i < left.length(); i++) {
            char c = left.charAt(i);
            if(c == 'x') {
                int start = i - 1;
                while(left.charAt(start) != '+' && left.charAt(start) != '-') {
                    start--;
                }

                String n = left.substring(left.charAt(start) == '+' ? start + 1 : start, i);
                if(n.length() == 1 && n.equals("-")) n = "-1";
                prefixList.add(toInt(n.length() == 0 ? "1" : n));
            } else if(c == '+' || c == '-') {
                if(i == 0) continue;
                if(left.charAt(i - 1) != 'x') {
                    int start = i - 1;
                    while(left.charAt(start) != '+' && left.charAt(start) != '-') {
                        start--;
                    }

                    numList.add(toInt(left.substring(start, i)));
                }
            }

            if(i == left.length() - 1) {
                if(left.charAt(left.length() - 1) != 'x') {
                    int start = i - 1;
                    while(left.charAt(start) != '+' && left.charAt(start) != '-') {
                        start--;
                    }

                    numList.add(toInt(left.substring(left.charAt(start) == '+' ? start + 1 : start, i + 1)));
                }
            }
        }

        return List.of(prefixList, numList);
    }

    public static void main(String[] args) {
//        solveEquation("x+5-3+x=6+x-2");
//        solveEquation("2x+3x-6x=x+2");
//        solveEquation("x=x+2");
//        solveEquation("x=x");
//        solveEquation("-x=-1");
        System.out.println(solveEquation("3x=10"));
    }
}
