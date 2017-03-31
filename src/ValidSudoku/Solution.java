package ValidSudoku;


/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 * Each column must have the numbers 1-9 occuring just once.
 * And the numbers 1-9 must occur just once in each of the 9 sub-boxes of the grid.
 */
public class Solution {

    private static int char2Int(char ch) {
        return ch == '.' ? 0 : Character.digit(ch, 10);
    }

    private static boolean checkRow(char[][] board, int rowNum) {
        int[] flag = new int[10];
        for (char ch : board[rowNum]) {
            flag[char2Int(ch)]++;
        }
        return isValid(flag);
    }

    private static boolean checkColumn(char[][] board, int col) {
        int[] flag = new int[10];
        for (int i = 0; i < 9; i++) {
            flag[char2Int(board[i][col])]++;
        }
        return isValid(flag);
    }

    private static boolean isValid(int[] flag) {
        for (int i = 1; i <= 9; i++) {
            if (flag[i] > 1) return false;
        }
        return true;
    }

    private static boolean checkSubGrid(char[][] board, int topLeftX, int topLeftY) {
        int[] flag = new int[10];
        for (int i = topLeftX; i < topLeftX + 3; i++) {
            for (int j = topLeftY; j < topLeftY + 3; j++) {
                flag[char2Int(board[i][j])]++;
            }
        }
        return isValid(flag);
    }

    private static boolean checkSubGrids(char[][] board) {
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!checkSubGrid(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        if (board.length != 9) return false;
        for (int i = 0; i < 9; i++) {
            if (!checkRow(board, i) || !checkColumn(board, i)) {
                return false;
            }
        }
        return checkSubGrids(board);
    }
}