#include<iostream>
using namespace std;

int binarysearch(int arr[],int n,int target){
    int start=0;
    int end=n-1;
    int mid=(start+end)/2;
    while(start<=end){
        if(arr[mid]==target)
            return mid;
        else if(arr[mid] > target )
            end=mid-1; //searching in left
        else{
            start=mid+1; //searching in right
        }
        mid = (start + end)/2;
    }
    return -1;
}

 
int main(){
    int arr[]={1,2,3,4,5,6};
    int n=6;
    int target=6;
    int index_var = binarysearch(arr,n,target);
    if(index_var == -1) // we can't use direct fn name 
        cout<<"target  not found"<<endl;
    else   
        cout<<"target found at index::"<<index_var<<endl;

    return 0;
}
