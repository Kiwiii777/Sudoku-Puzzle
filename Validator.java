public class Validator {
    public static boolean solve(int[][] board) {
        // go through the entire board
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == 0) {
                    // go through values 1-9
                    for (int num = 1; num <= 9; num++) {
                        // check if the value works
                        if (isValid(board, r, c, num)) {
                            board[r][c] = num;
                            // if it doesn't 
                            if (solve(board)) {
                                return true;
                            }
                            board[r][c] = 0;
                        }
                    }
                    return false; 
                }
            }
        }
        return true;
    }

    public static boolean isValid(int[][] board, int row, int column, int num) {
        // checks the row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }
        // checks the column
        for (int j = 0; j < 9; j++) {
            if (board[j][column] == num) {
                return false;
            }
        }
        // get the 3 by 3 squares
        int r = (row/3)*3;
        int c = (column/3)*3;
        // check the square
        for (int k = r; k < r + 3; k++) {
            for (int l = c; l < c + 3; l++) {
                if (board[k][l] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}