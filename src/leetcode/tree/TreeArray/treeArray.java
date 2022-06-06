package leetcode.tree.TreeArray;


/**
 * @Author zzguo
 * @Description 树状数组模版
 * @Date 2022/6/6
 **/
public class treeArray {
    int[] tree;
    int lowbit(int x){
        return x & -x;
    }
    void add(int idx, int val){
        for(int i = idx; i < len; i += lowbit(i)) tree[i] += val;
    }

    int query(int idx){
        int ans = 0;
        for(int i = idx; i > 0; i -= lowbit(i)) ans += tree[i];
        return ans;
    }

    int len;
    int nums[];
    // 构造函数
    public treeArray(int[] _nums){
        nums = _nums;
        len = nums.length;
        tree = new int[len + 1];
        for(int i = 0; i < len; i++) add(i + 1, nums[i]);
    }

    // 单点更新
    public void update(int idx, int val){
        add(idx + 1, nums[idx] - val);
        nums[idx] = val;
    }
    // 区间查询
    public int sumRange(int l, int r) {
        return query(r + 1) - query(l);
    }

}
