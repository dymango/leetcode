package leetcodepractice.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author dimmy
 */
public class Racecar_818 {

    /**
     * 你的赛车起始停留在位置 0，速度为 +1，正行驶在一个无限长的数轴上。（车也可以向负数方向行驶。）
     * 你的车会根据一系列由 A（加速）和 R（倒车）组成的指令进行自动驾驶 。
     * 当车得到指令 "A" 时, 将会做出以下操作： position += speed, speed *= 2。
     * 当车得到指令 "R" 时, 将会做出以下操作：如果当前速度是正数，则将车速调整为 speed = -1 ；否则将车速调整为 speed = 1。  (当前所处位置不变。)
     * 例如，当得到一系列指令 "AAR" 后, 你的车将会走过位置 0->1->3->3，并且速度变化为 1->2->4->-1。
     * 现在给定一个目标位置，请给出能够到达目标位置的最短指令列表的长度。
     *
     *  
     *
     * 示例 1:
     * 输入:
     * target = 3
     * 输出: 2
     * 解释:
     * 最短指令列表为 "AA"
     * 位置变化为 0->1->3
     * 示例 2:
     * 输入:
     * target = 6
     * 输出: 5
     * 解释:
     * 最短指令列表为 "AAARA"
     * 位置变化为 0->1->3->7->7->6
     * 说明:
     *
     * 1 <= target（目标位置） <= 10000。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/race-car
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param target
     * @return
     */
    public static int racecar(int target) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 1));
        int count = 0;
        Map<Integer, Set<Integer>> cache = new HashMap<>();
        int currentMaxPosition = Integer.MIN_VALUE;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if(node.position == target) return count;
                if(node.position > target * 2 || node.position < 0 || node.position < currentMaxPosition/2) continue;
                Set<Integer> list = cache.get(node.position);
                if(list != null && list.contains(node.speed)) continue;
                cache.putIfAbsent(node.position, new HashSet<>());
                cache.get(node.position).add(node.speed);
                queue.offer(new Node(node.position + node.speed, node.speed *= 2));
                queue.offer(new Node(node.position, node.speed > 0 ? -1 : 1));
                currentMaxPosition = Math.max(currentMaxPosition, Math.max(node.position + node.speed, node.position));
            }

            count++;
        }

        return count;
    }

    public static class Node {
        public int position;
        public int speed;

        public Node(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }
    }

    public static void main(String[] args) {
        System.out.println(racecar(5478));
    }
}
