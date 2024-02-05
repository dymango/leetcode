package app.executor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dimmy
 */
public class Entrance {
    static String prefix = "app.leetcode.";
    static String targetClassName = "SubarraysDivByK_974";
    static Map<String, List<Object>> paramMap;

    public static void main(String[] args) {
        initParamMap();
        MainMethodExecutor mainMethodExecutor = new MainMethodExecutor();
        mainMethodExecutor.execute(prefix + targetClassName, paramMap.get(targetClassName));
    }

    private static void initParamMap() {
        paramMap = new HashMap<>();
        paramMap.put("StrongInt_970", List.of(1, 2, 100));
        paramMap.put("FlipMatchVoyage_971", List.of(1, 2, 100));
        paramMap.put("SubarraysDivByK_974", List.of(new int[]{4,5,0,-2,-3,1}, 5));
//        paramMap.put("SubarraysDivByK_974", List.of(new int[]{5}, 9));
    }
}
