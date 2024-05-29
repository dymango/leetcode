package leetcodepractice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class ExclusiveTime_636 {

    /**
     * 给出一个非抢占单线程CPU的 n 个函数运行日志，找到函数的独占时间。
     *
     * 每个函数都有一个唯一的 Id，从 0 到 n-1，函数可能会递归调用或者被其他函数调用。
     *
     * 日志是具有以下格式的字符串：function_id：start_or_end：timestamp。例如："0:start:0" 表示函数 0 从 0 时刻开始运行。"0:end:0" 表示函数 0 在 0 时刻结束。
     *
     * 函数的独占时间定义是在该方法中花费的时间，调用其他函数花费的时间不算该函数的独占时间。你需要根据函数的 Id 有序地返回每个函数的独占时间。
     *
     * 示例 1:
     *
     * 输入:
     * n = 2
     * logs =
     * ["0:start:0",
     *  "1:start:2",
     *  "1:end:5",
     *  "0:end:6"]
     * 输出:[3, 4]
     * 说明：
     * 函数 0 在时刻 0 开始，在执行了  2个时间单位结束于时刻 1。
     * 现在函数 0 调用函数 1，函数 1 在时刻 2 开始，执行 4 个时间单位后结束于时刻 5。
     * 函数 0 再次在时刻 6 开始执行，并在时刻 6 结束运行，从而执行了 1 个时间单位。
     * 所以函数 0 总共的执行了 2 +1 =3 个时间单位，函数 1 总共执行了 4 个时间单位。
     * 说明：
     *
     * 输入的日志会根据时间戳排序，而不是根据日志Id排序。
     * 你的输出会根据函数Id排序，也就意味着你的输出数组中序号为 0 的元素相当于函数 0 的执行时间。
     * 两个函数不会在同时开始或结束。
     * 函数允许被递归调用，直到运行结束。
     * 1 <= n <= 100
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/exclusive-time-of-functions
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 1
     * ["0:start:0","0:start:2","0:end:5" "0:end:7"]
     * 2
     * ["0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7"]
     * @param n
     * @param logs
     * @return
     */
    static int[] timeArr;
    public static int[] exclusiveTime(int n, List<String> logs) {
        timeArr = new int[n];
        List<Integer> idList = new ArrayList<>();
        List<String> actionList = new ArrayList<>();
        List<Integer> occupyTimeList = new ArrayList<>();
        logs.forEach(s -> {
            String[] split = s.split(":");
            idList.add(toInt(split[0]));
            actionList.add(split[1]);
            occupyTimeList.add(toInt(split[2]));
        });

        divideV2(idList, actionList, occupyTimeList, 0, logs.size() - 1);
//        divide(logs, 0, logs.size() - 1);
        return timeArr;
    }

    //返回占用时间
    public static int divideV2(List<Integer> idList, List<String> actionList,  List<Integer> occupyTimeList, int start, int end) {
        if(start >= end) return 0;
        if(end - start == 1) {
            int dif = occupyTimeList.get(end) - occupyTimeList.get(start) + 1;
            timeArr[idList.get(end)] += dif;
            return dif;
        }

        int startIndex = start;
        int id = idList.get(startIndex);
        int startTime = occupyTimeList.get(startIndex);
        int totalOccupyTime = 0;
        int level = 1;
        for (int i = start + 1; i <= end; i++) {
            String action = actionList.get(i);
            int occupyTime = occupyTimeList.get(i);
            if(idList.get(i) == id) {
                if(action.equals("start")) {
                    level++;
                } else if(action.equals("end")) {
                    if(level == 1) {
                        if(i == end) {
                            int otherOccupyTime = divideV2(idList, actionList, occupyTimeList, startIndex + 1, end - 1);
                            int mainTimeRange = occupyTime - startTime + 1;
                            int mainOccupyTime = mainTimeRange - otherOccupyTime;
                            timeArr[id] += mainOccupyTime;
                            totalOccupyTime += mainTimeRange;
                        } else {
                            int otherOccupyTime = divideV2(idList, actionList, occupyTimeList, startIndex +1, i - 1);
                            int mainTimeRange = occupyTime - startTime + 1;
                            int mainOccupyTime = mainTimeRange - otherOccupyTime;
                            timeArr[id] += mainOccupyTime;
                            totalOccupyTime += mainTimeRange;
                            startIndex = i + 1;
                            id = idList.get(startIndex);
                            startTime = occupyTimeList.get(startIndex);
                            i = startIndex;
                        }
                    } else level--;
                }
            }
        }

        return totalOccupyTime;
    }

    //返回占用时间
    public static int divide(List<String> logs, int start, int end) {
        if(start >= end) return 0;
        if(end - start == 1) {
            String[] arr = logs.get(end).split(":");
            int dif = toInt(arr[2]) - toInt(logs.get(start).split(":")[2]) + 1;
            timeArr[toInt(arr[0])] += dif;
            return dif;
        }

        int startIndex = start;
        String[] split = logs.get(startIndex).split(":");
        String id = split[0];
        int totalOccupyTime = 0;
        int level = 1;
        for (int i = start + 1; i <= end; i++) {
            String[] stringArr = logs.get(i).split(":");
            if(stringArr[0].equals(id)) {
                if(stringArr[1].equals("start")) {
                    level++;
                } else if(stringArr[1].equals("end")) {
                    if(level == 1) {
                        if(i == end) {
                            int otherOccupyTime = divide(logs, startIndex + 1, end - 1);
                            int mainTime = toInt(stringArr[2]) - toInt(split[2]) + 1 - otherOccupyTime;
                            timeArr[Integer.parseInt(stringArr[0])] += mainTime;
                            totalOccupyTime += (mainTime +otherOccupyTime);
                        } else {
                            int otherOccupyTime = divide(logs, startIndex +1, i - 1);
                            int mainTime = toInt(stringArr[2]) - toInt(split[2]) + 1 - otherOccupyTime;
                            timeArr[Integer.parseInt(stringArr[0])] += mainTime;
                            totalOccupyTime += (mainTime +otherOccupyTime);
                            startIndex = i + 1;
                            split = logs.get(startIndex).split(":");
                            id = split[0];
                            i = startIndex;
                        }
                    } else level--;
                }
            }
        }

        return totalOccupyTime;
    }

    public static int toInt(String string) {
        return Integer.parseInt(string);
    }

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("0:start:0");
//        list.add("1:start:2");
//        list.add("1:end:5");
//        list.add("0:end:6");
//        int[] ints = exclusiveTime(2, list);

//        List<String> list = new ArrayList<>();
//        list.add("0:start:0");
//        list.add("0:start:2");
//        list.add("0:end:5");
//        list.add("1:start:6");
//        list.add("1:end:6");
//        list.add("0:end:7");
//        int[] ints = exclusiveTime(2, list);
        List<String> list = new ArrayList<>();
        list.add("0:start:0");
        list.add("0:start:2");
        list.add("0:end:5");
        list.add("0:start:6");
        list.add("0:end:6");
        list.add("0:end:7");
        int[] ints = exclusiveTime(1, list);

//        List<String> list = new ArrayList<>();
//        list.add("0:start:0");
//        list.add("0:start:1");
//        list.add("0:start:2");
//        list.add("0:end:3");
//        list.add("0:end:4");
//        list.add("0:end:5");
//        int[] ints = exclusiveTime(1, list);
    }
}
