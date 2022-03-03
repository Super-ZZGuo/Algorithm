package sort;

import java.util.Arrays;

/**
 * @Author zzguo
 * @Date 2022/3/3
 * @Description 归并排序 O(nlogn)
 *              基于分治的思想,可以有 自顶向下或自底向上两种
 *              前者空间复杂度为O(logn + n)
 *              后者空间复杂度为O(1)
 **/
public class MergeSort {
    public static void main(String[] args) {
        int[] num = new int[]{3,5,6,1,5,2,77,1,76,1003,2,1,66};
        System.out.print("Before mergeSort:");
        for(int n:num) System.out.print(n + " ");
        System.out.println();
        int[] ans = mergeSort(num);
        System.out.print("After mergeSort:");
        for(int n:ans) System.out.print(n + " ");
        System.out.println();
    }
    //拆分操作 自顶向下版本
    public static int[] mergeSort(int[] num) {
        int len = num.length;
        int[] arr = Arrays.copyOf(num, len);

        // 数组分到1的时候就暂停
        if(len < 2) return arr;

        // 划分子数组
        int mid = len / 2;
        int[] left = Arrays.copyOfRange(arr,0,mid);
        int[] right = Arrays.copyOfRange(arr,mid, len);
        return merge(mergeSort(left),mergeSort(right));

    }
    // 合并数组操作
    public static int[] merge(int[] left, int[] right){
        int[] res = new int[left.length + right.length];
        int i = 0;
        while(left.length > 0 && right.length > 0) {
            if(left[0] <= right[0]) {
                res[i++] = left[0];
                left = Arrays.copyOfRange(left,1, left.length);
            }else{
                res[i++] = right[0];
                right = Arrays.copyOfRange(right,1, right.length);
            }
        }
        while(left.length > 0) {
            res[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }
        while (right.length > 0) {
            res[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }
        return res;
    }
}
