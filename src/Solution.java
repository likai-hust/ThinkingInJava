/**
 * Created by KaiLee on 2016/3/23.
 */
public class Solution {

    private void solveSudoku(char[][] board) {
        char[][] result = board.clone();
        int loc = nextLocation(0, board);
        solve(loc, board, result);
    }
    private int nextLocation(int loc, char[][] board) {
        for(int i = loc; i < 81; i++)
            if(board[i / 9][i % 9] == '.')
                return i;
        return 81;
    }
    public boolean check(int loc, char[][] result) {
        boolean[] rowCheck = new boolean[9];
        boolean[] colCheck = new boolean[9];
        boolean[] blockCheck = new boolean[9];
        int m = 0;
        try{
            for(int i = 0; i < 9; i++) {
                m = i;
                if(result[loc / 9][i] != '.') {
                    if(rowCheck[result[loc / 9][i] - '1'])
                        return false;
                    rowCheck[result[loc / 9][i] - '1'] = true;
                }
                if(result[i][loc % 9] != '.') {
                    if(colCheck[result[i][loc % 9] - '1'])
                        return false;
                    colCheck[result[i][loc % 9] - '1'] = true;
                }
                if(result[(loc / 9) / 3 * 3 + i / 3][(loc % 9) / 3 * 3 +  i % 3] != '.') {
                    if(blockCheck[result[(loc / 9) / 3 * 3 + i / 3][(loc % 9) / 3 * 3 +  i % 3] - '1'])
                        return false;
                    blockCheck[result[(loc / 9) / 3 * 3 + i / 3][(loc % 9) / 3 * 3 +  i % 3] - '1'] = true;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("i = " + m + ",loc = " + loc + ",result: " + result[m][loc % 9]);
            e.printStackTrace();
            System.exit(0);
        }
        return true;
    }
    private void solve(int loc, char[][] board, char[][] result) {

        if(loc == 81)
            return;
        else {
            for(int i = 1; i < 10; i++) {
                result[loc / 9][loc % 9] = (char)(i + '0');
                if(check(loc, result)) {
                    loc = nextLocation(loc, board);
                    solve(nextLocation(loc, board), board, result);
                }
            }

        }
    }
    public static void main(String... args) {
        Solution s = new Solution();
        char[][] sudo = new char[][]{
                "..9748...".toCharArray(),
                "7........".toCharArray(),
                ".2.1.9...".toCharArray(),
                "..7...24.".toCharArray(),
                ".64.1.59.".toCharArray(),
                ".98...3..".toCharArray(),
                "...8.3.2.".toCharArray(),
                "........6".toCharArray(),
                "...2759..".toCharArray()
        };
        s.solveSudoku(sudo);
        for(char[] row : sudo) {
            for(char c : row)
                System.out.print(c + " ");
            System.out.println();
        }
    }
}
