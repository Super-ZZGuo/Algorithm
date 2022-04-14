package sort;

/**
 * @Author zzguo
 * @Description 堆排序
 * @Date 2022/3/21
 **/
public class HeapSort {
    public static void main(String[] args) {
        int[] num = new int[]{3,5,6,1,5,2,77,1,76,1003,2,1,66};
        System.out.print("Before HeapSort:");
        for(int n:num) System.out.print(n + " ");
        System.out.println();
        heapSort(num);
        System.out.print("After HeapSort:");
        for(int n:num) System.out.print(n + " ");
        System.out.println();
    }

    public static void heapSort(int[] nums){
        int len = nums.length;
        for(int i = (len - 1) / 2; i >= 0;i--) {
            adjustHeap(nums, i, len - 1);
        }
        for(int i = len - 1;i >= 1;) {
            swap(nums, 0, i);
            i--;
            adjustHeap(nums, 0, i);
        }
    }

    /**
     * 调整大顶堆
     * @param nums
     * @param k
     * @param end
     */
    public static void adjustHeap(int []nums,int k, int end){
        while(k * 2 + 1 <= end){
            int j = k * 2 + 1;
            if(j + 1 <= end && nums[j] < nums[j + 1]) {
                j++;
            }
            if(nums[j] > nums[k]) {
                swap(nums, k, j);
            }else break;
            k = j;

        }
    }

    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
