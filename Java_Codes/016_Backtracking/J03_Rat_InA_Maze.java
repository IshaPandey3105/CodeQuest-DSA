import java.util.ArrayList;
import java.util.List;

// Rat in a Maze Problem
// TC : O(4^(n^2)) and O(3^(n^2)) - because we are exploring 4 directions and in the worst case we can explore all the cells of the maze.
// SC: O(n^2) - 

public class J03_Rat_InA_Maze {
    public static void Maze(int[][] maze, int row, int col, String path, int n , List<String> ans,boolean[][] visited) {
        if (row == n-1 && col == n-1 ) { // bc
            ans.add(path);
            return;
        }
        if(row>=0 && row<n && col>=0 && col<n ){
            if(maze[row][col] == 0 || visited[row][col] == true){
                return;
            }
            visited[row][col] = true;
            Maze(maze, row - 1, col, path + "U",n, ans,visited);
            Maze(maze, row + 1, col, path + "D",n, ans,visited);
            Maze(maze, row, col - 1, path + "L",n, ans,visited);
            Maze(maze, row, col + 1, path + "R",n, ans,visited);
            visited[row][col] = false;
        }
    }
    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {1, 1, 1, 1}
        };
        List<String> ans = new ArrayList<>();
        int n = maze.length; 
        boolean[][] visited = new boolean[n][n];
        Maze(maze, 0, 0, "",n, ans,visited);
        System.out.println("All possible paths from source to destination:"+ ans);
    }
}
