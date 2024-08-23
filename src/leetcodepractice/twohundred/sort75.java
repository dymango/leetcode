package leetcodepractice.twohundred;

/**
 * @author dimmy
 */
public class sort75 {

    /**
     * 75. 颜色分类
     * <p>
     * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * <p>
     * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     * <p>
     * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
     *
     * @param nums
     * 120
     * 102
     *
     * 201
     * 102
     * [2,0,2,1,1,0]
     *
     * [1,1,0,2,0,2]
     */
    public void sortColors(int[] nums) {
        int red = 0;
        int blue = nums.length - 1;
        int i = 0;
        while (i <= blue && red < blue) {
            if(nums[i] == 0) {
                var t = nums[red];
                nums[red] = nums[i];
                nums[i] = t;
                red++;
                if(i < red) i++;
                continue;
            } else if(nums[i] == 2){
                var t = nums[blue];
                nums[blue] = nums[i];
                nums[i] = t;
                blue--;
                continue;
            }

            i++;
        }
    }
}
