package app.executor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dimmy
 */
public class Entrance {
    static String prefix = "app.leetcode.";
    static String targetClassName = "StrongInt_970";
    static Map<String, List<Object>> paramMap;

    public static void main(String[] args) {
        initParamMap();
        MainMethodExecutor mainMethodExecutor = new MainMethodExecutor();
        mainMethodExecutor.execute(prefix + targetClassName, paramMap.get(targetClassName));
    }

    private static void initParamMap() {
        paramMap = new HashMap<>();
        paramMap.put("StrongInt_970", List.of(1, 2, 100));
    }
}
