package app.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author dimmy
 */
public class CarFleet_853 {

    /**
     * N 辆车沿着一条车道驶向位于 target 英里之外的共同目的地。
     * <p>
     * 每辆车 i 以恒定的速度 speed[i] （英里/小时），从初始位置 position[i] （英里） 沿车道驶向目的地。
     * <p>
     * 一辆车永远不会超过前面的另一辆车，但它可以追上去，并与前车以相同的速度紧接着行驶。
     * <p>
     * 此时，我们会忽略这两辆车之间的距离，也就是说，它们被假定处于相同的位置。
     * <p>
     * 车队 是一些由行驶在相同位置、具有相同速度的车组成的非空集合。注意，一辆车也可以是一个车队。
     * <p>
     * 即便一辆车在目的地才赶上了一个车队，它们仍然会被视作是同一个车队。
     * <p>
     * 会有多少车队到达目的地?
     * <p>
     *  
     * <p>
     * 示例：
     * <p>
     * 输入：target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
     * 输出：3
     * 解释：
     * 从 10 和 8 开始的车会组成一个车队，它们在 12 处相遇。
     * 从 0 处开始的车无法追上其它车，所以它自己就是一个车队。
     * 从 5 和 3 开始的车会组成一个车队，它们在 6 处相遇。
     * 请注意，在到达目的地之前没有其它车会遇到这些车队，所以答案是 3。
     * <p>
     * 提示：
     * <p>
     * 0 <= N <= 10 ^ 4
     * 0 < target <= 10 ^ 6
     * 0 < speed[i] <= 10 ^ 6
     * 0 <= position[i] < target
     * 所有车的初始位置各不相同。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/car-fleet
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param 12 [4,0,5,3,1,2]
     *           [6,10,9,6,7,2]
     * @param
     * @param
     * @return
     */
    public static void main(String[] args) {
        CarFleet_853 carFleet_853 = new CarFleet_853();
//        System.out.println(carFleet_853.carFleet(12, new int[]{10, 8, 0, 5, 3}, new int[]{2, 4, 1, 1, 3}));
        System.out.println(carFleet_853.carFleet(12, new int[]{4, 0, 5, 3, 1, 2}, new int[]{6, 10, 9, 6, 7, 2}));
    }

    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            cars.add(new Car(position[i], speed[i]));
        }

        cars.sort(Comparator.comparingInt(o -> o.position));
        int[] ufs = new int[cars.size()];
        for (int i = 0; i < ufs.length; i++) {
            ufs[i] = i;
        }

        for (int i = 0; i < ufs.length; i++) {
            for (int j = i + 1; j < ufs.length; j++) {
                Car carA = cars.get(i);
                Car carB = cars.get(j);
                if (carA.speed <= carB.speed) continue;
                double spendTime = (double) (carB.position - carA.position) / (carA.speed - carB.speed);
                double spendTime2 = (double) (target - carA.position) / carA.speed;
                if (spendTime2 >= spendTime) {
                    union(ufs, i, j);
                    break;
                }
            }
        }

        int c = 0;
        for (int i = 0; i < ufs.length; i++) {
            if (ufs[i] == i) c++;
        }

        return c;
    }

    private void union(int[] ufs, int i, int j) {
        int ip = findParent(ufs, i);
        int jp = findParent(ufs, j);
        if (ip == jp) return;
        ufs[jp] = ip;
    }

    private int findParent(int[] ufs, int i) {
        if (ufs[i] == i) return i;
        int uf = ufs[i];
        return findParent(ufs, uf);
    }

    public static class Car {
        public int speed;
        public int position;

        public Car(int position, int speed) {
            this.speed = speed;
            this.position = position;
        }
    }
}
