import java.util.Arrays;

public class mazePrblms {
    public static void returnCnt(int r, int c, String p) {
        if (r == 0 && c == 0) {
            System.out.println(p);
            return;
        }

        if (c > 0) {
            returnCnt(r, c - 1, p + 'D');
        }
        if (r > 0) {
            returnCnt(r - 1, c, p + 'R');
        }

    }

    public static void pathRestricted(boolean[][] maze, String p, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }

        if (maze[r][c] == false) {
            return;
        }

        if (r < maze.length - 1) {
            pathRestricted(maze, p + 'D', r + 1, c);
        }
        if (c < maze[0].length - 1) {
            pathRestricted(maze, p + 'R', r, c + 1);
        }
    }

    public static void all4Directions(boolean[][] maze, String p, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }

        if (maze[r][c] == false) {
            return;
        }

        // I am considering this block in my path
        maze[r][c] = false;

        if (r < maze.length - 1) {
            all4Directions(maze, p + 'D', r + 1, c);
        }
        if (c < maze[0].length - 1) {
            all4Directions(maze, p + 'R', r, c + 1);
        }

        if (r > 0) {
            all4Directions(maze, p + 'U', r - 1, c);
        }
        if (c > 0) {
            all4Directions(maze, p + 'L', r, c - 1);
        }

        // So now this function is removed form stack and goes to previous call, Revert
        // the changes made by this call
        maze[r][c] = true;
    }

    public static void stepsCheck(boolean[][] maze, String p, int r, int c, int[][] ans, int steps) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            ans[r][c] = steps;
            for(int[] arr : ans){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }

        // If the cell is already visited earlier in this path → stop.
        if (maze[r][c] == false) {
            return;
        }

        // I am considering this block in my path
        maze[r][c] = false;
        ans[r][c] = steps;

        if (r < maze.length - 1) {
            stepsCheck(maze, p + 'D', r + 1, c, ans, steps + 1);
        }
        if (c < maze[0].length - 1) {
            stepsCheck(maze, p + 'R', r, c + 1, ans, steps + 1);
        }

        if (r > 0) {
            stepsCheck(maze, p + 'U', r - 1, c, ans, steps + 1);
        }
        if (c > 0) {
            stepsCheck(maze, p + 'L', r, c - 1, ans, steps + 1);
        }

        // So now this function is removed form stack and goes to previous call, Revert
        // the changes made by this call
        maze[r][c] = true;
        ans[r][c] = 0;

    }

    public static void main(String[] args) {
        // returnCnt(4, 4, "");
        boolean[][] maze = {
                { true, true, true, },
                { true, true, true, },
                { true, true, true, },
        };

        int[][] ans = new int[maze.length][maze[0].length];
        // all4Directions(maze, "", 0, 0);
        stepsCheck(maze, "", 0, 0, ans, 1);
    }

}
