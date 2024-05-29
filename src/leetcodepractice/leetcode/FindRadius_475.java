package leetcodepractice.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author dimmy
 */
public class FindRadius_475 {

    /**
     * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
     *
     * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
     *
     * 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。
     *
     * 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: houses = [1,2,3], heaters = [2]
     * 输出: 1
     * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
     * 示例 2:
     *
     * 输入: houses = [1,2,3,4], heaters = [1,4]
     * 输出: 1
     * 解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/heaters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param houses
     * @param heaters
     * @return
     */
    public static int findRadius(int[] houses, int[] heaters) {
        for (int i = 0; ; i++) {
            Set<Integer> rangeSet = new HashSet<>();
            for (int j = 0; j < heaters.length; j++) {
                for (int k = heaters[j] - i; k <=  heaters[j] + i; k++) {
                    rangeSet.add(k);
                }
            }

            boolean cover = true;
            for (int j = 0; j < houses.length; j++) {
                if(!rangeSet.contains(houses[j])) {
                    cover = false;
                    break;
                }
            }

            if(cover) return i;
        }
    }

    public static int findRadius2(int[] houses, int[] heaters) {
//        Arrays.sort(houses);
//        Arrays.sort(heaters);
//        int instance = 0;
//        for (int i = 0; ; i++) {
//            int position = houses[i];
//            for (int j = 0; j < heaters.length; j++) {
//                if(heaters[j] >= position) {
//                    instance = Math.max(instance, Math.min(heaters[j] - position, position - heaters[j - 1]));
//                }
//            }
//        }

        Arrays.sort(houses);
        Arrays.sort(heaters);
        int res= 0;
        int right = 0;
        for(int i = 0; i < houses.length; i++){
            // 找到恰好比当前房屋大的加热器
            while(right+1<heaters.length&&heaters[right]<houses[i]){
                right++;
            }
            // 特判， 否则会出现越界
            if(right==0){
                res = Math.max(res,Math.abs(heaters[right] - houses[i]));
            }else{
                res = Math.max(res,Math.min(Math.abs(heaters[right] - houses[i]),Math.abs(houses[i] - heaters[right-1])));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println( findRadius(new int[]{1,2,3}, new int[]{2}));
    }
}
