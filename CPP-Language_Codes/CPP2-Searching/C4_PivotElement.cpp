#include<iostream>
#include<vector>
using namespace std;

// Pivot Element (imp*)
int findpivot(int arr[],int n){
    int s=0;
    int e=n-1;
    int mid=s+(e-s)/2;
    while(s<=e){
        if(s==e){
            return s;
        }
        if( mid+1<=e && arr[mid] >arr[mid+1]){
            return mid;
        }
        if(mid-1>=s && arr[mid-1] >arr[mid]){
            return mid-1;
        }
        if(arr[s]>arr[mid]){
            e=mid-1;        //searching in right
        }
        else{
            s=mid+1;        //searching in left
        }
        mid = s + (e-s)/2;
    }
    return -1;
}

int binarysearch(int arr[],int start,int end,int target){
    int mid=(start+end)/2;
    while(start<=end){
        if(arr[mid]==target)
            return mid;
        if(arr[mid] > target )
            end=mid-1; //searching in left
        else{
            start=mid+1; //searching in right
        }
        mid = (start + end)/2;
    }
    return -1;
}

// Search in a Rotated and Sorted Array (very imp**)
int search(int nums[], int n, int target) {
    int pivotIndex = findpivot(nums,n);
    //cout<<pivotIndex<<endl;
    int ans=0;
    if(target>=nums[0] && target<=nums[pivotIndex]){
        ans = binarysearch(nums,0,pivotIndex,target);
    }
    else{
        ans = binarysearch(nums,pivotIndex+1,n-1,target);
    }
    //cout<<ans<<endl;
    return ans;
}
int main(){
    int arr[]={6,1,2,3,4,5};
    int n=7;
    int target=4;
    int start=0;
    int end=n-1;
    cout<<"Pivot element present at index::"<<findpivot(arr,n)<<endl;

    int a = search( arr, n, target);
    if(a==-1)
        cout<<"Number not found"<<endl;
    else
        cout<<"Number found at index :: "<<a<<endl;    
    
    return 0;
}