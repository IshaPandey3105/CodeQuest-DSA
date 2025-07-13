#include<iostream>
#include<vector>
using namespace std;

int main(){
    vector<int>arr={8,10,7,1,5};
    int n=arr.size();
    for(int i=0;i<n-1;i++){
        for(int j=0;j<n-i-1;j++){
            if(arr[j]>arr[j+1]){   
               swap(arr[j],arr[j+1]); 
            }
        }
    }
    // printing
    cout<<"sorted array is ::"<<endl;
    for(int i=0;i<n;i++){
        cout<<arr[i]<<" ";
    }    
    return 0;

}