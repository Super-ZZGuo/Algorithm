package sort;

/**
 * @Author zzguo
 * @Description
 * @Date 2022/3/1
 * @Param 选择排序 时间复杂度O(n^2)，每次选择最小的数放至未排序数组头部
 **/
public class SelectSort {
    public static void main(String[] args) {
        int[] num = new int[]{3,5,6,1,5,2,77,1,76,1003,2,1,66};
        System.out.print("Before selectSort:");
        for(int n:num) System.out.print(n + " ");
        System.out.println();
        selectSort(num);
        System.out.print("After selectSort:");
        for(int n:num) System.out.print(n + " ");
        System.out.println();
    }

    public static void selectSort(int[] num) {
        for(int i = 0; i < num.length - 1; i++) {
            // 记录每次内层遍历最小下标
            int index = i;
            for(int j = i + 1; j < num.length; j++) {
                if(num[j] < num[index]) index = j;
            }
            swap(num,i, index);
        }
    }
    public static void swap(int[] num, int l, int r) {
        int temp = num[l];
        num[l] = num[r];
        num[r] = temp;
    }
}
