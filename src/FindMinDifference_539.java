import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author dimmy
 */
public class FindMinDifference_539 {

    /**
     * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：timePoints = ["23:59","00:00"]
     * 输出：1
     * 示例 2：
     *
     * 输入：timePoints = ["00:00","23:59","00:00"]
     * 输出：0
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-time-difference
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param timePoints
     * @return
     */
    public static int findMinDifference(List<String> timePoints) {
        List<Integer> ms = new ArrayList<>();
        for (int i = 0; i < timePoints.size(); i++) {
            String time = timePoints.get(i);
            String[] t1 = time.split(":");
            int t1h = Integer.parseInt(t1[0]);
            int t1m = Integer.parseInt(t1[1]);
            ms.add(t1h*60 + t1m);
        }


        int min = Integer.MAX_VALUE;
        Collections.sort(ms);
        for (int i = 0; i < ms.size(); i++) {
            for (int j = i + 1; j < ms.size(); j++) {
                int dif = ms.get(j) - ms.get(i);
                int difs2 = 1440-ms.get(j) + ms.get(i);
                min = Math.min(min, Math.min(dif, difs2));
            }
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println( findMinDifference(List.of("05:31","22:08","00:35")));
        System.out.println( findMinDifference(List.of("00:00","23:59","00:00")));
        System.out.println( findMinDifference(List.of("23:08","00:00")));
        System.out.println( findMinDifference(List.of("12:12","00:13")));
        System.out.println( findMinDifference(List.of("01:39","10:26","21:43")));
        //todo
    }
}
