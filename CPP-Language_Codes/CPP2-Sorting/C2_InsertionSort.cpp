#include<iostream>
#include<vector>
using namespace std;

int main(){
    vector<int>arr={8,10,7,1,5};
    int n=arr.size();
    for(int i=1;i<n;i++){
        // step 1 --> fetch
        int val=arr[i];
        // step 2 --> compare
        int j;
        for(j=i-1;j>=0;j--){
            // step 3 --> shift
            if(arr[j] > val){   // for decreasing order change this sign
                arr[j+1]=arr[j];
            }
            else{
                break;
            }
        }
        arr[j+1]=val;  // step 4 -->copy
    }

    // printing
    cout<<"sorted array is ::"<<endl;
    for(int i=0;i<n;i++){
        cout<<arr[i]<<" ";
    }    
    return 0;

}