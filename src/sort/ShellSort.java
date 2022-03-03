package sort;

/**
 * @Author zzguo
 * @Description 希尔排序 O(n(logn)^2)
 *              通过局部的插入排序 加速 全局的排序
 *              非稳定(指相同的数字下如：两个8，经过排序后可能原本位置在后面的8移动到了前面)
 * @Date 2022/3/3
 **/
public class ShellSort {
    public static void main(String[] args) {
        int[] num = new int[]{3,5,6,1,5,2,77,1,76,1003,2,1,66};
        System.out.print("Before shellSort:");
        for(int n:num) System.out.print(n + " ");
        System.out.println();
        shellSort(num);
        System.out.print("After shellSort:");
        for(int n:num) System.out.print(n + " ");
        System.out.println();
    }

    public static void shellSort(int[] num) {
        int len = num.length;
        int temp;
        for(int step = len/2; step >= 1; step /= 2) {
            // 内层循环还是插入排序
            for(int i = step; i < len; i++) {
                temp = num[i];
                int j = i - step;
                // 向左有序队列中查找比 temp 小的
                while (j >= 0 && num[j] > temp) {
                    num[j + step] = num[j];
                    j -= step;
                }
                num[j + step] = temp;
            }
        }
    }

}
