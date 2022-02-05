package leetcode.dfs;

import org.junit.Test;

import javax.sound.midi.Soundbank;

/**
 * 1219. 黄金矿工
 * 你要开发一座金矿，地质勘测学家已经探明了这座金矿中的资源分布，并用大小为m * n 的网格 grid 进行了标注。每个单元格中的整数就表示这一单元格中的黄金数量；如果该单元格是空的，那么就是 0。
 *
 * 为了使收益最大化，矿工需要按以下规则来开采黄金：
 *
 * 每当矿工进入一个单元，就会收集该单元格中的所有黄金。
 * 矿工每次可以从当前位置向上下左右四个方向走。
 * 每个单元格只能被开采（进入）一次。
 * 不得开采（进入）黄金数目为 0 的单元格。
 * 矿工可以从网格中 任意一个 有黄金的单元格出发或者是停止。
 *
 * 思路：DFS+回溯板子题
 * 记录一下是因为力扣一次没过，来idea调试一下
 **/
public class pathWithMaximumGold {
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    int l, w;

    public int getMaximumGold(int[][] grid) {
        l = grid.length;
        w = grid[0].length;
        int ans = 0;
        for(int i = 0; i < l; i++){
            for(int j = 0; j < w; j++){
                if(grid[i][j] != 0) {
                    ans = Math.max(ans,dfs(grid, i, j));
                }
            }
        }
        return ans;
    }
    public int dfs(int[][] grid, int dx, int dy) {
        // 记录当前值 用于复原数组
        int curV = grid[dx][dy];
        int val = grid[dx][dy];
        grid[dx][dy] = 0;
        for(int[] dir : dirs){
            int nx = dx + dir[0];
            int ny = dy + dir[1];
            if(nx < 0 || nx >= l || ny < 0 || ny >= w) continue;
            if(grid[nx][ny] == 0) continue;
            val = Math.max(val, dfs(grid, nx, ny) + curV);
        }
        // 复原当前数组
        grid[dx][dy] = curV;
        return val;
    }
    @Test
    public void testGetMaximumGold() {
        int[][] grid = new int[][]{{0,6,0},{5,8,7},{0,9,0}};
        for(int[] num1 : grid){
            for(int num2 : num1){
                System.out.print(num2 + " ");
            }
            System.out.println("");
        }
        System.out.println("--------");
        int ans = getMaximumGold(grid);
        System.out.println(ans);
    }
}
