#include<iostream>
#include<limits.h>
#include<vector>
using namespace std;


void printarray(int arr[][3],int row,int col){
	for(int i=0;i<row;i++){
		for(int j=0;j<col;j++){
			cout<<arr[i][j]<<" ";
		}
		cout<<endl;
	}
}

void printrowsum(int arr[][3],int row,int col){
	for(int i=0;i<row;i++){
		int sum=0;
		for(int j=0;j<col;j++){
			sum = sum + arr[i][j];
		}
		cout<<sum<<endl;
	}
}

void getmaxkey(int arr[][3],int row,int col){
	int max=INT_MIN;
	for(int i=0;i<row;i++){
		for(int j=0;j<col;j++){
			if(max <arr[i][j])
			 max = arr[i][j];
		}
	}
	cout<<"the maximum key is :: "<<max<<endl;
}

bool findkey(int arr[][3],int row,int col,int key){
	for(int i=0;i<row;i++){
		for(int j=0;j<col;j++){
			if(key==arr[i][j])
			  return true;
		}
	}
	return false;
}

void transpose(int arr[][3],int row,int col,int transpose_array[][3]){
	for(int i=0;i<row;i++){
		for(int j=0;j<col;j++){
			transpose_array[j][i]=arr[i][j];
		}
	}
}



//2d Array
// int main(){
// 	int arr[3][3]={{1,2,3},{4,5,6},{7,8,9}};
// 	int transpose_array[3][3];
// 	int row=3;
// 	int col=3;
// 	int key=5;
// 	cout<<"Enter your values::"<<endl;
// 	for(int i=0;i<row;i++){
// 		for(int j=0;j<col;j++){
// 			cin>>arr[i][j];
// 		}
// 		cout<<endl;
// 	}
//     printarray(arr , row , col);
// 	printrowsum(arr , row ,col);
// 	getmaxkey(arr , row ,col);
// 	cout<<findkey(arr , row ,col , key);
// 	transpose(arr , row ,col,transpose_array);
// 	printarray(transpose_array , row , col);
// 	return 0;
// }

// Rotate a matrix by 60 degrees
// void rotate(vector<vector<int>>& matrix) {
//     int n = matrix.size();
//     for (int i = 0; i < n / 2; i++) { // Fix 1: Only rotate the first half of rows
//         for (int j = i; j < n - i - 1; j++) { // Fix 2: Update the column loop to n-i-1
//             int temp = matrix[i][j];
//             matrix[i][j] = matrix[n - j - 1][i];
//             matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
//             matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
//             matrix[j][n - i - 1] = temp;
//         }
//     }
// }
// 
// int main() {
//     vector<vector<int>> matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
// 	for (int i = 0; i < matrix.size(); i++) {
//         for (int j = 0; j < matrix.size(); j++) {
//         	cout << matrix[i][j] << " ";
//         }
//         cout << endl;
//     }
//     rotate(matrix);
// 	cout <<"Rotated Array"<< endl;
//     for (int i = 0; i < matrix.size(); i++) {
//         for (int j = 0; j < matrix.size(); j++) {
//             cout << matrix[i][j] << " ";
//         }
//         cout << endl;
//     }
//     return 0;
// }
