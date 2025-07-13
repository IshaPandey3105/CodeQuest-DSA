#include<iostream>
using namespace std;


// Finding First Occurnce of an Element || Lower Bound Problem
int main(){
    int arr[]={1,2,3,4,4,4,4,4,5,6};
    int n=10;
    int start=0;
    int end=n-1;
    int mid=start+(end-start)/2;
    int target=4;
    int index=-1;
    while(start<=end){
        if(arr[mid]==target){
           index=mid;
           end=mid-1;
        }
        else if(arr[mid]<target)  
            start=mid+1;
        else
            end=mid-1;

        mid=start+(end-start)/2;    
    }

    cout<<"first occurrence is at :: "<<index<<endl;
    return 0;
}

//Finding last Occurnce of an Element || Upper Bound Problem
// int main(){
//     int arr[]={1,2,3,4,4,4,4,4,5,6};
//     int n=10;
//     int start=0;
//     int end=n-1;
//     int mid=start+(end-start)/2;
//     int target=4;
//     int index=-1;
//     while(start<=end){
//         if(arr[mid]==target){
//            index=mid;
//            start=mid+1;
//         }
//         else if(arr[mid]<target)  
//             start=mid+1;
//         else
//             end=mid-1;
//
//         mid=start+(end-start)/2;    
//     }
//
//     cout<<"last occurrence is at :: "<<index<<endl;
//     return 0;
// }