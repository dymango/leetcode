package app.leetcode;

import java.util.TreeSet;

/**
 * @author dimmy
 * 在考场里，一排有 N 个座位，分别编号为 0, 1, 2, ..., N-1 。
 * 当学生进入考场后，他必须坐在能够使他与离他最近的人之间的距离达到最大化的座位上。如果有多个这样的座位，他会坐在编号最小的座位上。(另外，如果考场里没有人，那么学生就坐在 0 号座位上。)
 * <p>
 * 返回 ExamRoom(int N) 类，它有两个公开的函数：其中，函数 ExamRoom.seat() 会返回一个 int （整型数据），代表学生坐的位置；函数 ExamRoom.leave(int p) 代表坐在座位 p 上的学生现在离开了考场。每次调用 ExamRoom.leave(p) 时都保证有学生坐在座位 p 上。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[],[4],[]]
 * 输出：[null,0,9,4,2,null,5]
 * 解释：
 * ExamRoom(10) -> null
 * seat() -> 0，没有人在考场里，那么学生坐在 0 号座位上。
 * seat() -> 9，学生最后坐在 9 号座位上。
 * seat() -> 4，学生最后坐在 4 号座位上。
 * seat() -> 2，学生最后坐在 2 号座位上。
 * leave(4) -> null
 * seat() -> 5，学生最后坐在 5 号座位上。
 * <p>
 * ["ExamRoom","seat","seat","seat","leave","leave","seat","seat","seat","seat","seat","seat","seat","seat","seat","leave","leave","seat","seat","leave","seat","leave","seat","leave","seat","leave","seat","leave","leave","seat","seat","leave","leave","seat","seat","leave"]
 * [[10],[],[],[],[0],[4],[],[],[],[],[],[],[],[],[],[0],[4],[],[],[7],[],[3],[],[3],[],[9],[],[0],[8],[],[],[0],[8],[],[],[2]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 10^9
 * 在所有的测试样例中 ExamRoom.seat() 和 ExamRoom.leave() 最多被调用 10^4 次。
 * 保证在调用 ExamRoom.leave(p) 时有学生正坐在座位 p 上。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/exam-room
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ExamRoom_855 {

    /**
     * Your ExamRoom object will be instantiated and called as such:
     * ExamRoom obj = new ExamRoom(n);
     * int param_1 = obj.seat();
     * obj.leave(p);
     */
    public static void main(String[] args) {
        ExamRoom_855 room_855 = new ExamRoom_855(10);
        System.out.println(room_855.seat());
        System.out.println(room_855.seat());
        System.out.println(room_855.seat());
        room_855.leave(0);
        room_855.leave(4);
    }

    TreeSet<Integer> treeSet = new TreeSet<>();
    int N;
    public ExamRoom_855(int n) {
        N = n;
    }

    public int seat() {
        if (treeSet.size() == 0) {
            treeSet.add(0);
            return 0;
        }


        int dis = Integer.MIN_VALUE;
        int position = 0;
        int pre = -1;
        int last = 0;
        for (Integer p : treeSet) {
            int d = (p - pre) / 2;
            if (d > dis) {
                dis = d;
                position = pre + d;
            }

            pre = p;
            last = p;
        }

        int first = 0;
        for (Integer p : treeSet) {
            first = p;
            break;
        }

        if(first != 0) {
            if(first - 0 > dis) {
                position = 0;
            }
        }

        if(last != N - 1) {
            if(N - 1 - last > dis) position = N - 1;
        }

        treeSet.add(position);
        return position;
    }

    public void leave(int p) {
        treeSet.remove(p);
    }
}
