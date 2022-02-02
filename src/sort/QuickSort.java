package sort;

/**
 * @Author zzguo
 * @Description 快排
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{0,0,2,3,2,1,1,2,0,4};
        quickSort(arr, 0, arr.length - 1);
        for(int num : arr) System.out.println(num);
        // return Arrays.copyOf(arr,k);
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
