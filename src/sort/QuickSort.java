package sort;

/**
 * @Author zzguo
 * @Description 快排 简单的递归方法
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] num = new int[]{3,5,6,1,5,2,77,1,76,1003,2,1,66};
        System.out.print("Before quickSort:");
        for(int n:num) System.out.print(n + " ");
        System.out.println();

        quickSort(num, 0, num.length - 1);

        System.out.print("After quickSort:");
        for(int n:num) System.out.print(n + " ");
        System.out.println();
    }

    public static void quickSort(int[] arr, int l, int r){
        if(l >= r) return ;
        // 基准哨兵为arr[l] 即默认数组最左侧下标
        int i = l, j = r;
        while(i < j) {
            while (i < j && arr[j] >= arr[l]) j--;
            while (i < j && arr[i] <= arr[l]) i++;
            swap(arr, i ,j);
        }
        swap(arr, i, l);
        // 划分区间 递归
        quickSort(arr, l, i - 1);
        quickSort(arr, i + 1, r);
    }

    public static void swap(int[]arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
