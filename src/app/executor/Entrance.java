package app.executor;

import java.util.List;

/**
 * @author dimmy
 */
public class Entrance {
    static String prefix = "app.leetcode.";
    static String targetClassName = "NumsSameConsecDiff_967";
    static List<Object> params = List.of(3, 7);

    public static void main(String[] args) {
        MainMethodExecutor mainMethodExecutor = new MainMethodExecutor();
        mainMethodExecutor.execute(prefix + targetClassName, params);
    }
}
