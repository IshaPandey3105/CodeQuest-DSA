#include<iostream>
using namespace std;

// binary search in 2d array
bool binarysearch_2D(int arr[][3],int row,int col,int target){
    int start=0;
    int end=row*col-1;
    int mid=(start+end)/2;
    while(start<=end){
        int rowIndex=mid/col;
        int colIndex=mid%col;
        int mid_element=arr[rowIndex][colIndex];

        if(mid_element==target){
            cout << "Found at [" << rowIndex <<"] [" << colIndex <<"]"<< endl;
            return true;
        }
        else if(mid_element > target )
            end=mid-1; //searching in left
        else{
            start=mid+1; //searching in right
        }
        mid = (start + end)/2;
    }
    return false;
}

 
int main(){
    int arr[2][3]={{1,2,3},{4,5,6}};
    int row=2;
    int col=3;
    int target=6;
    int index_var = binarysearch_2D(arr,row,col,target);
    if(index_var == 0) {
        cout<<"target  not found"<<endl;
    }
    return 0;
}