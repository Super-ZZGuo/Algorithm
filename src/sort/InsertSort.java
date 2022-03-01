package sort;

/**
 * @Author zzguo
 * @Description
 * @Date 2022/3/1
 * @Param 插入排序 时间复杂度O(n^2),数组前部维护一段有序队列，在未排序的数组中选择插入有序队列中
 **/
public class InsertSort {
    public static void main(String[] args) {
        int[] num = new int[]{3,5,6,1,5,2,77,1,76,1003,2,1,66};
        System.out.print("Before insertSort:");
        for(int n:num) System.out.print(n + " ");
        System.out.println();
        insertSort(num);
        System.out.print("After insertSort:");
        for(int n:num) System.out.print(n + " ");
        System.out.println();
    }

    public static void insertSort(int[] num) {
        for(int i = 1; i < num.length; i++) {
            // 记录要插入的数
            int temp = num[i];
            int j = i;
            // 向左侧有序队列查找比自己小的值
            // 顺便将比自己大的值右移一位
            while(j > 0 && temp < num[j - 1]) {
                num[j] = num[j - 1];
                j--;
            }
            num[j] = temp;

        }
    }
}
