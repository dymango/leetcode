package app.leetcode;

import java.util.Arrays;

/**
 * @author dimmy
 */
public class MinEatingSpeed_875 {

    /**
     * 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
     * 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
     * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
     * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
     * <p>
     * 示例 1：
     * 输入: piles = [3,6,7,11], H = 8
     * 输出: 4
     * *
     * 示例 2：
     * 输入: piles = [30,11,23,4,20], H = 5
     * 输出: 30
     * <p>
     * 示例 3：
     * 输入: piles = [30,11,23,4,20], H = 6
     * 输出: 23
     *  
     * 提示：
     * 1 <= piles.length <= 10^4
     * piles.length <= H <= 10^9
     * 1 <= piles[i] <= 10^9
     *
     * @param piles
     * @param h
     * @return
     */
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int max = Arrays.stream(piles).max().getAsInt();
        int end = max;
        int minSpeed = Integer.MAX_VALUE;
        boolean useMaxSpeed = true;
        while (start < end) {
            int middle = start + (end - start) / 2;
            int costTime = costTime(piles, middle);
            if (costTime > h) {
                //eat slow
                start = middle + 1;
            } else {
                //eat fast
                end = middle;
                minSpeed = Math.min(minSpeed, middle);
                useMaxSpeed = false;
            }
        }

        return useMaxSpeed ? max : minSpeed;
    }

    private int costTime(int[] piles, int eatSpeed) {
        int costTime = 0;
        for (int pile : piles) {
            if (pile <= eatSpeed) costTime++;
            else if (pile % eatSpeed == 0) {
                costTime += pile / eatSpeed;
            } else {
                costTime += pile / eatSpeed + 1;
            }
        }

        return costTime;
    }

    public static void main(String[] args) {
        //[873375536,395271806,617254718,970525912,634754347,824202576,694181619,20191396,886462834,442389139,572655464,438946009,791566709,776244944,694340852,419438893,784015530,588954527,282060288,269101141,499386849,846936808,92389214,385055341,56742915,803341674,837907634,728867715,20958651,167651719,345626668,701905050,932332403,572486583,603363649,967330688,484233747,859566856,446838995,375409782,220949961,72860128,998899684,615754807,383344277,36322529,154308670,335291837,927055440,28020467,558059248,999492426,991026255,30205761,884639109,61689648,742973721,395173120,38459914,705636911,30019578,968014413,126489328,738983100,793184186,871576545,768870427,955396670,328003949,786890382,450361695,994581348,158169007,309034664,388541713,142633427,390169457,161995664,906356894,379954831,448138536]
        //943223529
        System.out.println(new MinEatingSpeed_875().minEatingSpeed(new int[]{873375536, 395271806, 617254718, 970525912, 634754347, 824202576, 694181619, 20191396, 886462834, 442389139, 572655464, 438946009, 791566709, 776244944, 694340852, 419438893, 784015530, 588954527, 282060288, 269101141, 499386849, 846936808, 92389214, 385055341, 56742915, 803341674, 837907634, 728867715, 20958651, 167651719, 345626668, 701905050, 932332403, 572486583, 603363649, 967330688, 484233747, 859566856, 446838995, 375409782, 220949961, 72860128, 998899684, 615754807, 383344277, 36322529, 154308670, 335291837, 927055440, 28020467, 558059248, 999492426, 991026255, 30205761, 884639109, 61689648, 742973721, 395173120, 38459914, 705636911, 30019578, 968014413, 126489328, 738983100, 793184186, 871576545, 768870427, 955396670, 328003949, 786890382, 450361695, 994581348, 158169007, 309034664, 388541713, 142633427, 390169457, 161995664, 906356894, 379954831, 448138536}, 943223529));
        System.out.println(new MinEatingSpeed_875().minEatingSpeed(new int[]{312884470}, 312884469));
        System.out.println(new MinEatingSpeed_875().minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        System.out.println(new MinEatingSpeed_875().minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
        System.out.println(new MinEatingSpeed_875().minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
        System.out.println(new MinEatingSpeed_875().minEatingSpeed(new int[]{2, 2}, 2));
    }
}
