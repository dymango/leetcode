package app.metaapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author dimmy
 */
public class Test3 {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        Integer a = 1;
        map.put("a", a);
        a = 3;
        System.out.println(map.get("a"));
        System.out.println(a == map.get("a"));
        String str = "没人比我更懂java";
        StrObject obj = new StrObject("没人比我更懂java");
        StrObject obj2 = new StrObject("呵呵呵呵");
        map.put("str", str);

        map.put("obj", obj);
        obj.setStr("aaaa");
        str = "真的没人比我更懂java";
        System.out.printf(map.get("str").toString() + "; ");
        String str2 = "没人比我更懂java";
        map.put("str2", str2);
        System.out.println(map.get("str") == map.get("str2"));
        System.out.println(str == map.get("str"));
        System.out.println(str == map.get("str2"));

//        StrObject new_obj = (StrObject) map.get("obj");
//        new_obj = obj2;
////        new_obj.setStr("真的没人比我更懂java");
//        System.out.printf(map.get("obj").toString() + "; ");

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        Map<String, List<Integer>> m = new HashMap<>();
        m.put("a", list);
        list.add(9);
        System.out.println(m.get("a").size());
    }

    static class StrObject {
        String str;

        public StrObject(String str) {
            this.str = str;
        }

        public void setStr(String str) {
            this.str = str;
        }

        @Override
        public String toString() {
            return str;
        }
    }

//    public static void main(String[] args) {
//        System.out.println(searchMatrix(new int[][]{{1, 3, 5}, {2, 4, 6}, {7, 13, 24}}, 80));
//        byte[] bytes = new byte[0];
//        System.out.println(Charset.defaultCharset());
//        try {
//            bytes = "没人比我更懂java".getBytes("GBK");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
////        TreeNode n = new TreeNode(1);
////        TreeNode n2 = new TreeNode(2);
////        TreeNode n3 = new TreeNode(2);
////        TreeNode n4 = new TreeNode(3);
////        TreeNode n5 = new TreeNode(3);
////        n2.right = n4;
////        n3.right = n5;
////        n.left = n2;
////        n.right = n3;
////        System.out.println(isTreeSymmetric(n));
////
//////{"a":{"b":["v",2,{"c":0}]},"d":[1,null,3]}
////
////        Map<String, Object> map = new HashMap<>();
////        Map<String, Object> subMap = new HashMap<>();
////        Map<String, Object> subMap2 = new HashMap<>();
////
////        subMap.put("c", 0);
////        Object[] o1a = new Object[]{"v", 2, subMap};
////        Object[] o2a = new Object[]{1, null, 3};
////        subMap2.put("b", o1a);
////        map.put("a", subMap2);
////        map.put("d", o2a);
////        showMapV2(map);
//    }

    // 以下给出TreeNode类, 请勿修改
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isTreeSymmetric(TreeNode root) {
        //TODO your code goes here...
        return recursion(root.left, root.right);
    }

    public static boolean recursion(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return recursion(left.left, right.right) && recursion(left.right, right.left);
    }

    /**
     * 对任意一个Map<String, Object>, 其 key 为 String,
     * 其 value 为 Map<String, Object> Object[] Number String 中的任意一种,
     * 显然叶子节点是 value 类型为 Number 或 String的节点,
     * 将 Map 转为多条字符串, 每条字符串表达其中一个叶子节点,
     * 比如:
     * {"a":{"b":["v",2,{"c":0}]},"d":[1,null,3]}
     * 将转化为以下这些字符串
     * a.b[0] = v
     * a.b[1] = 2
     * a.b[2].c = 0
     * d[0] = 1
     * d[1] = null
     * d[2] = 3
     *
     * @param map 上述的 map
     * @return 所有的字符串
     */
//    public static Set<String> showMap(Map<String, Object> map) {
//        //TODO your code goes here...
//        Set<String> result = new HashSet<>();
//        Set<Map.Entry<String, Object>> entries = map.entrySet();
//        return list(map, "");
//    }
//
//    public static Set<String> list(Map<String, Object> map, String prefix) {
//        Set<String> set = new HashSet<>();
//        map.entrySet().forEach(entry -> {
//            Object value = entry.getValue();
//            String key = entry.getKey();
//            if (value instanceof Object[]) {
//                Object[] valueArr = (Object[]) value;
//                for (int i = 0; i < valueArr.length; i++) {
//                    Object o = valueArr[i];
//                    if (o instanceof String) {
//                        set.add(buildString(prefix, key, i, o, "."));
//                    } else if (o instanceof Integer) {
//                        set.add(buildString(prefix, key, i, o, "."));
//                    } else if (o instanceof Map) {
//                        set.addAll(list(((Map) o), prefix + "." + key + "[" + i + "]"));
//                    }
//                }
//            } else if (value instanceof String) {
//                set.add(buildString(prefix, key, value, ".", "="));
//            } else if (value instanceof Integer) {
//                set.add(buildString(prefix, key, value, ".", "="));
//            } else if (value instanceof Map) {
//                set.addAll(list(((Map) value), prefix + key));
//            }
//        });
//
//        return set;
//    }
    public static Set<String> showMapV2(Map<String, Object> map) {
        //TODO your code goes here...
        return list(map, "");
    }

    private static Set<String> list(Map<String, Object> map, String prefix) {
        Set<String> set = new HashSet<>();
        map.entrySet().forEach(entry -> {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Object[]) {
                Object[] valueArr = (Object[]) value;
                for (int i = 0; i < valueArr.length; i++) {
                    Object o = valueArr[i];
                    if (o == null) {
                        set.add(buildString(prefix, key, i, o, prefix.length() > 0 ? "." : ""));
                    } else if (o instanceof String) {
                        set.add(buildString(prefix, key, i, o, prefix.length() > 0 ? "." : ""));
                    } else if (o instanceof Integer) {
                        set.add(buildString(prefix, key, i, o, prefix.length() > 0 ? "." : ""));
                    } else if (o instanceof Map) {
                        set.addAll(list((Map) o, prefix + (prefix.length() > 0 ? "." : "") + key + "[" + i + "]"));
                    }
                }
            } else if (value instanceof String || value instanceof Integer) {
                set.add(buildString(prefix, key, value, prefix.length() > 0 ? "." : ""));
            } else if (value instanceof Integer) {
                set.add(buildString(prefix, key, value, prefix.length() > 0 ? "." : ""));
            } else if (value instanceof Map) {
                set.addAll(list((Map) value, prefix + (prefix.length() > 0 ? "." : "") + key));
            }
        });

        return set;
    }

    private static String buildString(String prefix, String key, Object value, String s) {
        return prefix + (s) + key + " = " + value;
    }

    private static String buildString(String prefix, String key, int i, Object o, String s) {
        return prefix + (s) + key + "[" + i + "]" + " = " + o;
    }

    public static boolean searchMatrix(int[][] nums, int x) {
        if (nums.length == 0) return false;
        int i = 0, j = nums[0].length - 1;
        while (i < nums.length && j >= 0) {
            if (nums[i][j] == x) return true;
            else if (nums[i][j] < x) i++;
            else j--;
        }

        return false;
    }

}
