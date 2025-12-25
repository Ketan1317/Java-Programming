public class NKnights {

    public static int helper(boolean[][] board, int row, int col, int targets) {
        if (targets == 0) {
            display(board);
            return 1;
        }

        // FIXED base case
        if (row == board.length) {
            return 0;
        }

        int cnt = 0;

        // move to next row properly
        if (col == board.length) {
            return helper(board, row + 1, 0, targets);
        }

        // Option 1: place knight if safe
        if (isSafe(board, row, col)) {
            board[row][col] = true;
            cnt += helper(board, row, col + 1, targets - 1);
            board[row][col] = false;
        }

        cnt += helper(board, row, col + 1, targets);

        return cnt;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        // A knight placed at (r, c) can ONLY be attacked from positions that were already processed

        if (isValid(board, row - 2, col + 1) && board[row - 2][col + 1]) return false;
        if (isValid(board, row - 2, col - 1) && board[row - 2][col - 1]) return false;
        if (isValid(board, row + 1, col + 2) && board[row + 1][col + 2]) return false;
        if (isValid(board, row - 1, col + 2) && board[row - 1][col + 2]) return false;

        return true;
    }

    private static boolean isValid(boolean[][] board, int row, int col) {
        int n = board.length;
        return row >= 0 && row < n && col >= 0 && col < n;
    }

    public static void display(boolean[][] board) {
        for (boolean[] arr : board) {
            for (boolean x : arr) {
                System.out.print(x ? "K " : "X ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        boolean[][] board = new boolean[3][3];
        System.out.println(helper(board, 0, 0, 3));
    }
}
