public class NQueens {

    public static int checkBoard(boolean[][] board, int row) {
        if (row == board.length) {
            display(board);
            return 1;
        }

        int count = 0;

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += checkBoard(board, row + 1);
                board[row][col] = false; // backtrack
            }
        }

        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {

        // 1️⃣ check same column
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }

        // 2️⃣ check left diagonal
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }

        // 3️⃣ check right diagonal
        int maxRight = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i]) {  
                return false;
            }
        }

        return true;
    }

    public static void display(boolean[][] board) {
        for (boolean[] arr : board) {
            for (boolean x : arr) {
                System.out.print(x ? "Q " : "X ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        boolean[][] board = {
            {false,false,false,false},
            {false,false,false,false},
            {false,false,false,false},
            {false,false,false,false},
        };

        System.out.println(checkBoard(board, 0)); 
    }

}
