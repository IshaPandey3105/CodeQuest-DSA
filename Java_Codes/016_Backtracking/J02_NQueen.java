import java.util.ArrayList;
import java.util.List;

// Time Complexity: O(N!) - The time complexity of the N-Queens problem is O(N!) 
// because we are trying to place N queens on an N x N chessboard, and for each queen, we have N choices for its position. 
// As we place each queen, the number of available positions decreases, leading to a factorial growth in the number of possibilities.
// Space Complexity: O(N^2) - The space complexity is O(N^2) because we are using a 2D array (the chessboard) to represent the positions of the queens.

public class J02_NQueen {
    public static List<List<String>> solveNQueens(int n) {
        char [][] board = new char[n][n];

        // Filling board with '.'
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }

        List<List<String>> ans = new ArrayList<>();
        Queen(0,board,ans);

        return ans;
    }

    public  static void Queen(int row , char[][] board , List<List<String>> ans){
        // BC
        if(row == board.length){
            ans.add(MakeString(board));
            return;
        }
        for(int col =0;col<board.length;col++){
            if(isSafe(row,col,board)){
                board[row][col] = 'Q';
                Queen(row+1,board,ans);  // Backtracking
                board[row][col] = '.';
            }
        }
    }
    public static List<String> MakeString(char[][] board){
        List<String> list = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            String row = new String(board[i]);
            list.add(row);
        }
        return list;
    }
    public static Boolean isSafe(int row , int col , char[][] board){
        // check vertically - No queen exists below
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=='Q')
            return false;
        }
        // chack left diagonal
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
            if(board[i][j]=='Q')
                return false;
        }
        // chack right diagonal
        for(int i=row-1, j=col+1;i>=0 && j<board.length;i--, j++){
            if(board[i][j]=='Q')
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        List<List<String>> result = solveNQueens(4);
        for (List<String> solution : result) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }

    }
}
