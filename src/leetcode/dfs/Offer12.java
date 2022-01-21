package leetcode.dfs;

/**
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 **/
public class Offer12 {

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        String word = "ABCESEEEFS";
        boolean ans = exist(board, word);
        System.out.println(ans);
    }

    public static boolean exist(char[][] board, String word) {
        int l = board.length, w = board[0].length;
        if(l * w < word.length()) return false;
        for(int i = 0; i < l; i++){
            for(int j = 0; j < w; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board, word, i, j,0)) return true;
                }
            }
        }
        return false;
    }
    public static boolean dfs(char[][] board, String word, int i, int j,int cnt){
        boolean ans = false;
        // 满足条件
        if(i >= 0 && i < board.length && j >= 0 && j < board[0].length &&
                board[i][j] != '\0' && board[i][j] == word.charAt(cnt)) {
            if (cnt == word.length() - 1) return true;
            board[i][j] = '\0';
            ans =  dfs(board, word, i + 1, j, cnt + 1) ||
                    dfs(board, word, i - 1, j, cnt + 1) ||
                    dfs(board, word, i, j + 1, cnt + 1) ||
                    dfs(board, word, i, j - 1, cnt + 1);
            board[i][j] = word.charAt(cnt);
        }
        return ans;
    }
}
