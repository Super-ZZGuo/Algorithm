package leetcode.kmp;


/**
 * @Author zzguo
 * 28.实现strStr()函数。
 *
 * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 * @Date 2022/1/19
 **/
public class Implement_strStr {
    public static void main(String[] args) {
        String hayStack = "mississippi";
        String needle = "aaabbab";
        int ans = strStr(hayStack,needle);
        System.out.println(ans);
    }
    public static int strStr(String haystack, String needle) {
        if(needle.isEmpty()) return 0;
        int n = haystack.length();
        int m = needle.length();

        haystack = " " + haystack;
        needle = " " + needle;
        char[] s = haystack.toCharArray();
        char[] p = needle.toCharArray();

        // 构造前缀next数组
        int[] next = new int[m + 1];
        for(int i = 2, j = 0; i <= m; i++){
            // 匹配失败, j指针回到开始重新匹配
            while (j > 0 && p[i] != p[j + 1]) j = next[j];
            // 匹配成功
            if(p[i] == p[j + 1]) j++;
            next[i] = j;
        }

        for(int num : next) System.out.print(num + " ");
        System.out.println();
        for(int i = 1, j = 0; i <= n; i++){
            // 匹配不成功，j指针回到开始重新匹配
            while (j > 0 && s[i] != p[j + 1]) j = next[j];
            // 匹配单个字符成功
            if(s[i] == p[j + 1]) j++;
            // 当j匹配长度达到匹配字符串长度时
            if(j == m) return i - m;
        }
        return -1;
    }
}
