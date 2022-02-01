package leetcode.Moore_voting_method;

/**
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 进阶：
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 *
 *  摩尔投票法：能达到进阶要求
 **/
public class majority_element {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1,1,2,2};
        int ans = majorityElement(nums);
        System.out.println(ans);
    }
    public static int majorityElement(int[] nums) {
        int ans = 0;
        int cnt = 0;
        for(int num : nums){
            if(cnt <= 0) ans = num;
            if(ans == num) cnt++;
            else cnt--;
        }
        return ans;
    }
}
