#include<iostream>
#include<vector>
#include<unordered_map>
using namespace std;

unordered_map<int,bool> rowCheck;
unordered_map<int,bool> upperLeftDiagnolCheck;
unordered_map<int,bool> bottomLeftDiagnolCheck;

void PrintSolution(vector<vector<char>> &board,int n){
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            cout<<board[i][j]<<" ";
        }
        cout<<endl;
    }
    cout<<endl<<endl;
}

bool IsSafe(vector<vector<char>> &board, int row, int col, int n){
    int i=row;
    int j=col;

    if(rowCheck[row] == true )
        return false;
            
    if(upperLeftDiagnolCheck[n-1+col-row] == true)
        return false;
            
    if(bottomLeftDiagnolCheck[row+col] == true)
        return false;

    return true;

    // // check row
    // while(j>=0){
    //     if(board[i][j]=='Q'){
    //         return false;
    //     }
    //     j--;
    // }
    // //check upper left diagonal
    // i=row;   // as upper change ho gaye the
    // j=col;
    // while(i>=0 && j>=0){
    //     if(board[i][j]=='Q'){
    //         return false;
    //     }
    //     i--;
    //     j--;
    // }
    // // check lower left diagonal
    // i=row;   // as upper change ho gaye the
    // j=col;
    // while(i<n && j>=0){
    //     if(board[i][j]=='Q'){
    //         return false;
    //     }
    //     i++;
    //     j--;
    // }
    // // kahin par bhi queen nhi mili
    // // hence position is safe
    // return true;
}

void Solve(vector<vector<char>> &board,int col,int n){
    // base case
    if(col>=n){
        PrintSolution(board,n);
        return ;
    }
    // recursion sab sambhal lega
    for(int row=0;row<n;row++){
        if(IsSafe(board,row,col,n)){
            //queen rakh doo
            board[row][col]='Q';

            rowCheck[row] = true;
            upperLeftDiagnolCheck[n-1+col-row] = true;
            bottomLeftDiagnolCheck[row+col] = true;

            // recursive call
            Solve(board,col+1,n);

            // backtracking
            board[row][col]='-';

            rowCheck[row] = false;
            upperLeftDiagnolCheck[n-1+col-row] = false;
            bottomLeftDiagnolCheck[row+col] = false;
        }
    }
}

int main(){
    int n=4;
    vector<vector<char>> board(n,vector<char>(n,'-'));
    cout<<" Posssible Pattern :: "<<endl;
    int col=0;
    // '-' -> emplty cell
    // 'Q' -> queen in the cell
    Solve(board,col,n);
    return 0;
}