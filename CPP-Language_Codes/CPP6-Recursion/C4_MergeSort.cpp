#include<iostream>
using namespace std;

void merge(int* arr,int s, int e){
    int mid=(s+e)/2;
    int len1 = mid-s+1;
    int len2 = e-mid; 
    // creating 2 arrays 
    int* Left_array = new int[len1];
    int* Right_array = new int[len2];

    // copy values
    int k=s;
    for(int i=0;i<len1;i++){
        Left_array[i]=arr[k];
        k++;
    }

    k=mid+1;
    for(int i=0;i<len2;i++){
        Right_array[i]=arr[k];
        k++;
    }
    // merging 2 sorted array
    int i=0;
    int j=0;
    int index=s;
    while( (i<len1) && (j<len2) ) {
        if(Left_array[i] < Right_array[j])
            arr[index++] =  Left_array[i++];
        else
            arr[index++] =  Right_array[j++];
    }

    while( i<len1 ) {
        arr[index++] =  Left_array[i++];
    }

    while( j<len2 ) {
         arr[index++] =  Right_array[j++];
    }
}

void MergeSort(int* arr, int s, int e){
    // base case
    // s==e --> single elem
    // s>e --> invalid
    if(s>=e)
        return;
    int mid=(s+e)/2;    
    // call for left part    
    MergeSort(arr,s,mid);
    // call for right part
    MergeSort(arr,mid+1,e);
    // call for merging 
    merge(arr,s,e);        
}

int main(){
    int arr[]={2,5,4,6,8,4,1,66};
    int n=8;
    int s=0;
    int e=n-1;
    //calling function
    MergeSort(arr,s,e);
    // Printing the sorted array
    for(int i=0;i<n;i++){
        cout<<arr[i]<<" ";
    }
    return 0;
}