package BattleshipsinaBoard;

class Solution {

    public int countBattleships(char[][] board) {
        int count = 0;

        int r = board.length;
        if (r == 0)
            return 0;
        int c = board[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'X') {
                    if ((i > 0 && board[i - 1][j] == 'X') || (j > 0 && board[i][j - 1] == 'X'))
                        continue;
                    count++;
                }
            }
        }

        return count;
    }
}
