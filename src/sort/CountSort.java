package sort;


/**
 * @Author zzguo
 * @Description 计数排序
 * @Date 2022/3/21
 **/
public class CountSort {
    public static void main(String[] args) {
        int[] num = new int[]{3,5,6,1,5,2,77,1,76,1003,2,1,66};
        System.out.print("Before shellSort:");
        for(int n:num) System.out.print(n + " ");
        System.out.println();
        CountSort(num);
        System.out.print("After shellSort:");
        for(int n:num) System.out.print(n + " ");
        System.out.println();
    }

    public static void CountSort(int[] num) {
        int[] cnt = new int[1005];
        for(int n : num) cnt[n]++;

        int idx = 0;
        for(int i = 0; i < num.length; i++) {
            while(cnt[idx] <= 0) idx++;
            num[i] = idx;
            cnt[idx]--;
        }
    }
}
