public class sudoku {

    // Main solver function
    public static boolean solved(int[][] board) {
        int n = board.length;
        int row = -1;
        int col = -1;

        boolean emptyLeft = true;

        // find first empty cell (value = 0)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) { // empty cell found
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }
            if (!emptyLeft)
                break;
        }

        // if no empty cell left → board is solved
        if (emptyLeft) {
            return true;
        }

        // try numbers 1 to 9
        for (int number = 1; number <= 9; number++) {

            // place the number if it's safe
            if (isSafe(board, row, col, number)) {
                board[row][col] = number;

                // continue solving the rest until return true
                if (solved(board)) {
                    return true;
                }

                board[row][col] = 0; // backtrack
            }
        }

        // poora loop chlane ke baad bhi na kuch mila
        return false; // no valid number found
    }

    // check if placing num at (row, col) is valid
    public static boolean isSafe(int[][] board, int row, int col, int num) {

        // check row
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == num)
                return false;
        }

        // check column
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == num)
                return false;
        }

        // check 3x3 block
        int size = (int) Math.sqrt(board.length);
        int rowStart = row - (row % size);
        int colStart = col - (col % size);

        for (int r = rowStart; r < rowStart + size; r++) {
            for (int c = colStart; c < colStart + size; c++) {
                if (board[r][c] == num)
                    return false;
            }
        }

        return true;
    }

    // display Sudoku board
    public static void display(int[][] board) {
        System.out.println("Solved Sudoku:");
        for (int[] row : board) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[][] board = {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };

        if (solved(board)) {
            display(board); // ← print only when everything is fully solved
        }

        if (!solved(board)) {
            System.out.println("No solution exists.");
        }
    }
}
