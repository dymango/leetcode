package app.executor;

import java.util.List;

/**
 * @author dimmy
 */
public class Entrance {
    static String prefix = "app.leetcode.";
    static String targetClassName = "pancakeSort_969";
    static List<Object> params = List.of(new int[]{1,2,3});

    public static void main(String[] args) {
        MainMethodExecutor mainMethodExecutor = new MainMethodExecutor();
        mainMethodExecutor.execute(prefix + targetClassName, params);
    }

}
