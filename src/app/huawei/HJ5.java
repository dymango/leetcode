package app.huawei;

import java.util.Scanner;

/**
 * @author dimmy
 */
public class HJ5 {
    /**
     * HJ5 进制转换
     * 题目
     * 题解(518)
     * 讨论(1k)
     * 排行
     * 面经new
     * 简单  通过率：35.48%  时间限制：1秒  空间限制：32M
     * 知识点
     * 字符串
     * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
     * 描述
     * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
     *
     * 数据范围：保证结果在 1 \le n \le 2^{31}-1 \1≤n≤2
     * 31
     *  −1
     * 输入描述：
     * 输入一个十六进制的数值字符串。
     *
     * 输出描述：
     * 输出该数值的十进制字符串。不同组的测试用例用\n隔开。
     *
     * 示例1
     * 输入：
     * 0xAA
     * 复制
     * 输出：
     * 170
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next();
            int i = Integer.parseInt(str.substring(2), 16);
            int i2 = Integer.parseInt(str.substring(2), 10);
            System.out.println(i);
            System.out.println(i2);
        }
    }
}
