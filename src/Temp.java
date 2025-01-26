import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author dimmy
 */
public class Temp {

    public static void main(String[] args) {
        Integer YJ = 1;
        Integer Y = 3;
        Integer J = 2;
        Integer SS = 4;
        Map<String, Integer> subjects = new HashMap<>();
        subjects.put("超车", 1);
        subjects.put("通过急弯", 1);
        subjects.put("通过坡路", 1);
        subjects.put("通过拱桥", 1);
        subjects.put("通过人行横道", 1);
        subjects.put("通过没有交通信号灯控制的路口", 1);
        subjects.put("同方向近距离跟车行驶", 2);
        subjects.put("与机动车会车", 2);
        subjects.put("通过有交通信号灯路口", 2);
        subjects.put("在照明良好的道路上行驶", 2);
        subjects.put("在无照明的道路上行驶", 3);
        subjects.put("在照明不良的道路上行驶", 3);
        subjects.put("路边临时停车", 4);

        Map<Integer, Integer> resultCount = new HashMap<>();

        var titles = subjects.keySet().stream().toList();
        var r = ThreadLocalRandom.current();
        int errorCount = 0;
        int rightCount = 0;
        double totalTime = 0;
        double maxTime = 0;
        for (int i = 0; i < 50; i++) {
            var title = titles.get(r.nextInt(0, 13));
            System.out.println(title);
            Scanner scanner = new Scanner(System.in);
            System.out.print("请回答: ");
            long startTime = System.nanoTime();
            int number = scanner.nextInt();
            var answer = subjects.get(title);
            if (number == answer) {
                System.out.print("回答正确,");
                rightCount++;
            } else {
                System.out.print("回答错误,");
                errorCount++;
            }

            // 记录结束时间
            long endTime = System.nanoTime();
            // 计算执行时间（单位：纳秒）
            double duration = ((double) (endTime - startTime) / 1000000000);
            totalTime += duration;
            maxTime = Math.max(maxTime, duration);
            // 输出执行时间
            System.out.println("耗时： " + duration + "秒");
            System.out.print("\n");
        }

        System.out.printf("答题结束, 正确%d题, 错误%d题, 平均耗时:%.4f秒, 最大耗时: %.4f秒", rightCount, errorCount, totalTime / 50, maxTime);
    }
}
