package app.executor;

import app.leetcode.base.TreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dimmy
 */
public class Entrance {
    static String prefix = "app.leetcode.";
    static String targetClassName = "StrWithout3a3b_984";
    static Map<String, List<Object>> paramMap;

    public static void main(String[] args) {
        initParamMap();
        MainMethodExecutor mainMethodExecutor = new MainMethodExecutor();
        mainMethodExecutor.execute(prefix + targetClassName, paramMap.get(targetClassName));
    }

    private static void initParamMap() {
        paramMap = new HashMap<>();
        paramMap.put("StrongInt_970", buildParam(1, 2, 100));
        paramMap.put("FlipMatchVoyage_971", buildParam(1, 2, 100));
        paramMap.put("SubarraysDivByK_974", buildParam(new int[]{4, 5, 0, -2, -3, 1}, 5));
        paramMap.put("kClosest_970", buildParam(new int[][]{{1, 3}, {5, 5}}, 1));
        paramMap.put("SortedSquares_977", buildParam(new int[]{-4, -1, 0, 3, 10}));
        paramMap.put("mincostTickets_983", buildParam(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}));
        paramMap.put("StrWithout3a3b_984", buildParam(2, 5));

        TreeNode treeNode = new TreeNode(0);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(0);
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        paramMap.put("DistributeCoins_979", buildParam(treeNode));

//        paramMap.put("SubarraysDivByK_974", List.of(new int[]{5}, 9));
    }

    private static List<Object> buildParam(Object... elements) {
        return List.of(elements);
    }
}
