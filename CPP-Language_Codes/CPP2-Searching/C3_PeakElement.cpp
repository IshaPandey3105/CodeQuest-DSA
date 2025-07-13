#include<iostream>
using namespace std;


// Peak Element in a Mountain Array  (very imp**)
int main(){
    int arr[]={1,2,3,4,10,5,4};
    int n=7;
    int start=0;
    int end=n-1;
    int mid=start+(end-start)/2;
    while(start<end){
        if(arr[mid]<arr[mid+1]){
           start=mid+1;
        }
        else{
            end=mid;
        }
        mid=start+(end-start)/2;    
    }

    cout<<"peak element in mountain array is at :: "<<start<<endl;
    cout<<"peak element in mountain array is at :: "<<end<<endl;
    cout<<"peak element in mountain array is at :: "<<mid<<endl;
    return 0;
}