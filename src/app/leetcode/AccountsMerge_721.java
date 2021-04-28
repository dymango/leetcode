package app.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author dimmy
 */
public class AccountsMerge_721 {

    /**
     * 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该账户的邮箱地址。
     *
     * 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。
     *
     * 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是按字符 ASCII 顺序排列的邮箱地址。账户本身可以以任意顺序返回。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：
     * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
     * 输出：
     * [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
     * 解释：
     * 第一个和第三个 John 是同一个人，因为他们有共同的邮箱地址 "johnsmith@mail.com"。
     * 第二个 John 和 Mary 是不同的人，因为他们的邮箱地址没有被其他帐户使用。
     * 可以以任何顺序返回这些列表，例如答案 [['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
     * ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']] 也是正确的。
     *  
     *
     * 提示：
     *
     * accounts的长度将在[1，1000]的范围内。
     * accounts[i]的长度将在[1，10]的范围内。
     * accounts[i][j]的长度将在[1，30]的范围内。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/accounts-merge
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 0 1 1 1 0
     * [["David","David0@m.co","David1@m.co"],
     * ["David","David3@m.co","David4@m.co"],
     * ["David","David4@m.co","David5@m.co"],
     * ["David","David2@m.co","David3@m.co"],
     * ["David","David1@m.co","David2@m.co"]]
     * @param accounts
     * @return
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int[] parent = new int[accounts.size()];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        Map<String, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            List<String> collect = account.stream().skip(1).collect(Collectors.toList());
            for (String str : collect) {
                Set<Integer> set = map.getOrDefault(str, new HashSet<>());
                set.add(i);
                map.put(str, set);
            }
        }

        map.entrySet().forEach(entry -> {
            List<Integer> value = new ArrayList<>(entry.getValue());
            for (int i = 1; i < value.size(); i++) {
                union(parent, i, i - 1);
            }
        });

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < parent.length; i++) {
            set.add(parent[i]);
        }

        List<List<String>> result = new ArrayList<>();
        set.forEach(integer -> {
            String name = "";
            List<String> emails = new ArrayList<>();
            for (int i = 0; i < parent.length; i++) {
                if(parent[i] == integer) {
                    List<String> strings = accounts.get(i);
                    name = strings.get(0);
                    emails.addAll(strings.stream().skip(1).collect(Collectors.toList()));
                }
            }

            emails = emails.stream().distinct().collect(Collectors.toList());
            Collections.sort(emails);
            emails.add(0, name);
            result.add(emails);
        });

        return result;
    }

    private int find(int[] parent, int num) {
        return (parent[num] == num) ? num: (parent[num] = find(parent, parent[num]));
    }

    private void union(int[] parent, int x, int x2) {
        if(parent[x] == parent[x2]) return;
        int xp = find(parent, x);
        parent[x2] = xp;
    }

    int[] parent, rank;
    public List<List<String>> accountsMergeV2(List<List<String>> accounts) {
        int size = accounts.size();
        parent = new int[size];
        rank = new int[size];
        Arrays.fill(rank, 1);
        for (int i = 0; i < size; i++) parent[i] = i;
        // 根据邮箱是否有重复来合并
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < size; i++) {
            List<String> arr = accounts.get(i);
            for (int j = 1; j < arr.size(); j++) {
                String email = arr.get(j);
                if (!map.containsKey(email) || map.get(email) == i) map.put(email, i);
                else merge(i, map.get(email));
            }
        }
        // 合并union
        Map<Integer, Set<String>> res_map = new HashMap<Integer, Set<String>>();
        for (int i = 0; i < size; i++) {
            int root = find(i);
            List<String> arr = accounts.get(i);
            if (!res_map.containsKey(root)) {
                Set<String> set = new TreeSet<String>();
                for (int j = 1; j < arr.size(); j++) set.add(arr.get(j));
                res_map.put(root, set);
            }
            else for (int j = 1; j < arr.size(); j++) res_map.get(root).add(arr.get(j));
        }
        // 输出结果，把第一个元素换成姓名
        List<List<String>> res = new ArrayList<List<String>>();
        for (Map.Entry<Integer, Set<String>> entry: res_map.entrySet()) {
            List<String> arr = new ArrayList<String>();
            arr.add(accounts.get(entry.getKey()).get(0));
            arr.addAll(entry.getValue());
            res.add(arr);
        }
        return res;
    }
    private int find(int num) {
        return (parent[num] == num)? num: (parent[num] = find(parent[num]));
    }
    private void merge(int x, int y) {
        int x_root = find(x), y_root = find(y);
        if (x_root == y_root) return;
        parent[x_root] = y_root;
    }
}
