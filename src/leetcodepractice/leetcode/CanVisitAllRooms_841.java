package leetcodepractice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author dimmy
 */
public class CanVisitAllRooms_841 {

    /**
     * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
     * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，
     * 其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
     * 最初，除 0 号房间外的其余所有房间都被锁住。
     * <p>
     * 你可以自由地在房间之间来回走动。
     * <p>
     * 如果能进入每个房间返回 true，否则返回 false。
     * <p>
     * 示例 1：
     * <p>
     * 输入: [[1],[2],[3],[]]
     * 输出: true
     * 解释:
     * 我们从 0 号房间开始，拿到钥匙 1。
     * 之后我们去 1 号房间，拿到钥匙 2。
     * 然后我们去 2 号房间，拿到钥匙 3。
     * 最后我们去了 3 号房间。
     * 由于我们能够进入每个房间，我们返回 true。
     * 示例 2：
     * <p>
     * 输入：[[1,3],[3,0,1],[2],[0]]
     * 输出：false
     * 解释：我们不能进入 2 号房间。
     * 提示：
     * <p>
     * 1 <= rooms.length <= 1000
     * 0 <= rooms[i].length <= 1000
     * 所有房间中的钥匙数量总计不超过 3000。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/keys-and-rooms
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param rooms
     * @return
     */
    public static void main(String[] args) {
        CanVisitAllRooms_841 c = new CanVisitAllRooms_841();
//        List<List<Integer>> rooms  = new ArrayList<>();
//        rooms.add(List.of(1,3));
//        rooms.add(List.of(3,0,1));
//        rooms.add(List.of(2));
//        rooms.add(List.of(0));
//        System.out.println(c.canVisitAllRooms(rooms));

        List<List<Integer>> rooms2 = new ArrayList<>();
        rooms2.add(List.of(1));
        rooms2.add(List.of(2));
        rooms2.add(List.of(3));
        rooms2.add(List.of());
//        System.out.println(c.canVisitAllRooms(rooms2));
        System.out.println(c.canVisitAllRoomsV2(rooms2));
    }

    int[] roomArr;
    Map<Integer, Set<Integer>> map;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        roomArr = new int[rooms.size()];
        for (int i = 0; i < roomArr.length; i++) {
            roomArr[i] = i;
        }
        map = new HashMap<>();
        for (int i = 0; i < rooms.size(); i++) {
            List<Integer> canArriveRooms = rooms.get(i);
            for (Integer target : canArriveRooms) {
                map.putIfAbsent(target, new HashSet<>());
                map.get(target).add(i);
            }
        }

        for (int i = 0; i < roomArr.length; i++) {
            for (int j = i + 1; j < roomArr.length; j++) {
                int ip = find(i);
                int jp = find(j);
                if (ip == jp) continue;
                if (isConnection(i, j, new HashSet<>()) || isConnection(j, i, new HashSet<>())) {
                    connect(ip, jp);
                }
            }
        }

        int sign = find(0);
        for (int i = 1; i < roomArr.length; i++) {
            if (find(i) != sign) return false;
        }

        return true;
    }

    private boolean isConnection(int i, int j, Set<Integer> visited) {
        Set<Integer> set = map.getOrDefault(i, new HashSet<>());
        if (set.contains(j)) return true;
        for (Integer integer : set) {
            if (!visited.add(integer)) continue;
            boolean connection = isConnection(integer, j, visited);
            if (connection) return true;
        }

        return false;
    }

    private int find(int x) {
        if (roomArr[x] == x) return x;
        return find(roomArr[x]);
    }

    private void connect(int x, int y) {
        roomArr[x] = y;
    }

    public boolean canVisitAllRoomsV2(List<List<Integer>> rooms) {
        Set<Integer> history = new HashSet<>();
        Set<Integer> roomSet = new HashSet<>();
        roomSet.add(0);
        while (roomSet.size() != 0) {
            Set<Integer> newRoomSet = new HashSet<>();
            roomSet.stream().filter(integer -> !history.contains(integer)).forEach(integer -> {
                history.add(integer);
                newRoomSet.addAll(rooms.get(integer));
            });

            roomSet = newRoomSet;
        }

        return history.size() == rooms.size();
    }

}
