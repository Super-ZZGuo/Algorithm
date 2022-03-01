package sort;

/**
 * @Author zzguo
 * @Description 冒泡排序
 * @Date 2022/3/1
 * @Param 平均时间复杂度是O(n^2),要进行两次for循环，内层for交换最大的数至未排序数组末尾
 **/
public class BubbleSort {
    public static void main(String[] args) {
        int[] num = new int[]{3,5,6,1,5,2,77,1,76,1003,2,1,66};
        System.out.print("Before bubbleSort:");
        for(int n:num) System.out.print(n + " ");
        System.out.println();
        bubbleSort(num);
        System.out.print("After bubbleSort:");
        for(int n:num) System.out.print(n + " ");
        System.out.println();
    }

    public static void bubbleSort(int[] num) {
        for(int i = 0; i < num.length; i++) {
            for(int j = 0; j < num.length - 1 - i; j++) {
                if(num[j] > num[j + 1]) swap(num,j,j+1);
            }
        }
    }
    public static void swap(int[] num , int l, int r) {
        int temp = num[l];
        num[l] = num[r];
        num[r] = temp;
    }
}
