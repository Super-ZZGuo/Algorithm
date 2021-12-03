package com.zzg.sort;
/*
@date 2021/12/3 - 12:13 下午
*/


import org.junit.Test;

/**
 * 桶排序
 * @author zzg
 *
 */
public class BucketSort {
    /**
     *
     * @param arr 待排序数组
     * @param max 数组中的最大值
     */
    public static void bucketSort(int[] arr, int max){
        int[] bucket;
        if(max < 1 || arr == null)
            return;
        //初始化一个最大容量为数组最大值的桶
        bucket = new int[max];

        //计数，将数据放入桶中
        for(int i = 0 ; i < arr.length; i++)
            bucket[arr[i]]++;

        //排序，取出桶中数据
        for(int i = 0,j = 0 ; i < max; i++){
            while(bucket[i]-- > 0){
                arr[j++] = i;
            }
        }
    }

    @Test
    public void bucketSortTest(){
        int i;
        int a[] = {8,2,3,4,3,6,6,3,9};

        System.out.println("排序前:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);

        System.out.println("");

        bucketSort(a, 10); // 桶排序

        System.out.println("排序后:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
    }
}
