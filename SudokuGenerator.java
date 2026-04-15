public class SudokuGenerator {

    // makes the 2D array storing the board
    int[][] board;

    // sets the size of the 2D array to be 9 by 9
    public void initializeBoard() {
        board = new int[9][9];
    }

    // fills out each value in the board using the solve method which uses the isValid method
    public void generate() {
        int[] numbers = {1,2,3,4,5,6,7,8,9};
        for (int i = numbers.length - 1; i > 0; i--) {
            int j = (int)(Math.random()*(i+1));
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }

        for (int j = 0; j < 9; j++) {
            board[0][j] = numbers[j];
        }
        Validator.solve(board);
    }

    // prints the board, checking the index of rows and columns and seeing when to print the dividing lines
    public void printBoard() {
        String[] elements = {"+-------+-------+-------+", "| "};
        for (int r = 0; r < 9; r++) {
            if (r % 3 == 0) {
                System.out.println(elements[0]);
            }
            System.out.print(elements[1]);
            for (int c = 0; c < 9; c++) {
                System.out.print(board[r][c] + " ");
                if ((c+1)%3==0) {
                    System.out.print(elements[1]);
                }
            }
            System.out.println();
        }
        System.out.println(elements[0]);
    }

    public static void main(String[] args) {
        SudokuGenerator board = new SudokuGenerator();
        board.initializeBoard();
        board.generate();
        board.printBoard();
    }
}