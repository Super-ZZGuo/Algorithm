package leetcode.TopK;

import java.util.Arrays;

/**
 * 剑指 Offer 40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数
 *
 * 时间复杂度O(N),空间复杂度O(logN)
 **/
public class getLeastNumbers {
    public static void main(String[] args) {
        int[] arr = new int[]{0,0,2,3,2,1,1,2,0,4};
        int k = 8;
        int[] ans = getLeastNumbers(arr, k);
        for(int num : ans) System.out.print(num + " ");
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        if(k >= arr.length) return arr;
        return quickSort(arr, 0, arr.length - 1, k);
    }
    public static int[] quickSort(int[] arr, int l, int r, int k){
        // 基准哨兵为arr[l] 即默认数组最左侧下标
        int i = l, j = r;
        while(i < j) {
            while (i < j && arr[j] >= arr[l]) j--;
            while (i < j && arr[i] <= arr[l]) i++;
            swap(arr, i ,j);
        }
        swap(arr, i, l);
        // 哨兵下标 > k; 说明 第k+1小的数 在左数组
        if(i > k) quickSort(arr,l, i - 1, k);
        // 哨兵下标 < k; 说明 第k+1小的数 在右数组
        if(i < k) quickSort(arr,i + 1, r, k);
        return Arrays.copyOf(arr, k);
    }

    public static void swap(int[]arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
