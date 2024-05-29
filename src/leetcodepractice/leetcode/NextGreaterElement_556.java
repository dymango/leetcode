package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class NextGreaterElement_556 {

    /**
     * 给定一个32位正整数 n，你需要找到最小的32位整数，其与 n 中存在的位数完全相同，并且其值大于n。如果不存在这样的32位整数，则返回-1。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 12
     * 输出: 21
     * 示例 2:
     * <p>
     * 输入: 21
     * 输出: -1
     * <p>
     * 将n转换为字符串。
     * 字符串的前一个数必须不小于后一个数，否则就可以通过替换来使得n变大。
     * 倒着扫描，找到第一个比前面的数小的项（拿它开刀），在这里就用栈来记录前面的数。
     * 找到开刀的数之后，将他与栈内大于它的最小数进行交换，由于栈是递减的，所以一直pop就能找到。
     * 对开刀数后面的数进行排序，从小到大可以使得这个数变得更小。
     * 但是要注意，有时候交换数之后可能会溢出，所以要判断一下交换之后数有没有变大，若交换后数字反而小了，就说明溢出了。
     * <p>
     * string s=to_string(n);
     * stack<int> sta;
     * for(int i=s.length()-1;i>=0;i--){
     * if(sta.empty()||s[i]>=sta.top()){   //字符串需单调非递增，否则可以交换值使得整个数变得更大
     * sta.push(s[i]);
     * }else{
     * int j=0;
     * while(!sta.empty()&&s[i]<sta.top()){  //找到比s[i]大的最小数进行交换
     * sta.pop();
     * j++;
     * }
     * swap(s[i],s[i+j]);
     * string s1=s.substr(0,i+1),s2=s.substr(i+1,s.length());
     * sort(s2.begin(),s2.end());//将开刀数后面的数进行排序
     * s=s1+s2;
     * return atoi(s.c_str())>n?atoi(s.c_str()):-1;    //交换后可能超出范围
     * }* 		}
     * return -1;
     * <p>
     * 作者：mZ5HitKC8S
     * 链接：https://leetcode-cn.com/problems/next-greater-element-iii/solution/zhan-shuang-bai-kan-wo-by-mz5hitkc8s/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * <p>
     * 作者：mZ5HitKC8S
     * 链接：https://leetcode-cn.com/problems/next-greater-element-iii/solution/zhan-shuang-bai-kan-wo-by-mz5hitkc8s/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/next-greater-element-iii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     *
     * 1.从个位数开始往高位数遍历，如果每个高位数都大于相邻的低位数，则此数字已经是最大的了，直接返回-1。
     * 2.否则遍历直到发现首次出现高位数比相邻的低位数小的情况（称这个高位数所在的位为“分界点”），这时应该在分界点右边的所有数里面找出最小的比它大的数，把两个数交换位置，此时“分界点”右边的数仍然是从大到小，两两交换使它们顺序改为从小到大，然后转换成int返回。
     *
     * 作者：ben-da-xiong
     * 链接：https://leetcode-cn.com/problems/next-greater-element-iii/solution/javajie-fa-0msji-bai-100-by-ben-da-xiong/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *2321
     * @param n
     * @return
     */
    public static int nextGreaterElement(int n) {
        char[] charArr = String.valueOf(n).toCharArray();
        for (int i = charArr.length - 1; i > 0 ; i--) {
            if(charArr[i] <= charArr[i - 1]) continue;
            i -= 1;
            int j = i;
            while(j < charArr.length - 1 && charArr[j + 1] > charArr[i]) {
                j++;
            }

            swap(charArr, i, j);
            for (int k = i + 1; k <= i + (charArr.length - i)/2; k++) {
                swap(charArr, k, charArr.length - (k - i));
            }

            try{
                return Integer.parseInt(String.valueOf(charArr));
            }catch (Exception e) {
                return -1;
            }

        }

        return -1;
    }

    private static void swap(char[] chars, int i, int j){
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }

    public static void main(String[] args) {
//        System.out.println(nextGreaterElement(11));
//        System.out.println(nextGreaterElement(12));
//        System.out.println(nextGreaterElement(230241));
        System.out.println(nextGreaterElement(1999999999));
    }
}
