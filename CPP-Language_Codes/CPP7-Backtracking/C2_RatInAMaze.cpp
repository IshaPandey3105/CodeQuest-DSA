#include<iostream>
#include<vector>
using namespace std;

bool IsSafe(int maze[][3],int i,int j,int row, int col,vector<vector<bool>>& visited){
    if((i>=0 && i<row ) && (j>=0 && j<col) && (maze[i][j]==1) && (visited[i][j]==false)){
        return true;
    }
    else{
        return false;
    }
}

void SolveMaze(int maze[][3],int row, int col,int i,int j,vector<vector<bool>>& visited,string output, vector<string>& path){
    // base case
    if(i==row-1 && j==col-1){
        path.push_back(output);
        return ;
    }

    // down ->(i+1,j)
    if(IsSafe(maze,i+1, j, row, col, visited)) {
        visited[i+1][j] = true;
        SolveMaze(maze, row, col, i+1, j, visited, output + 'D',path);
        //backtrack 
        visited[i+1][j] = false;
    }


    // left ->(i,j-1)
    if(IsSafe(maze,i, j-1, row, col, visited)) {
        visited[i][j-1] = true;
        SolveMaze(maze, row, col, i, j-1, visited, output + 'L',path);
        //backtrack 
        visited[i][j-1] = false;
    }

    // right ->(i,j+1)
    if(IsSafe(maze,i, j+1, row, col, visited)) {
        visited[i][j+1] = true;
        SolveMaze(maze, row, col, i, j+1, visited, output + 'R',path);
        //backtrack 
        visited[i][j+1] = false;
    }

    // up ->(i-1,j)
    if(IsSafe(maze,i-1, j, row, col, visited)) {
        visited[i-1][j] = true;
        SolveMaze(maze, row, col, i-1, j, visited, output + 'U',path);
        //backtrack 
        visited[i-1][j] = false;
    }

}

int main(){
    int maze[3][3]={{1,0,0},{1,1,0},{1,1,1}};
    string output="";
    int row=3;
    int col=3;
    if(maze[0][0]==0){
        cout<<"path does not exist"<<endl;
        return 0;
    }
    vector<vector<bool>> visited(row,vector<bool> (col,false));
    visited[0][0]=true;
    vector<string> path;

    SolveMaze(maze,row,col,0,0,visited,output,path);

    cout << "printing the results " << endl;
    for(auto i: path) {
        cout << i << " ";
    }
    cout << endl;

    if(path.size() == 0 ){
        cout << "No Path Exists " << endl;
    }
    return 0;
}