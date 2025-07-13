#include<iostream>
#include<vector>
using namespace std;

int main(){
    vector<int>arr={8,10,7,1,5};
    int n=arr.size();
    //cout<<n<<endl;

    // outer loop --> (n-1) rounds/pass
    for(int i=0;i<n-1;i++){
        int minIndex=i;
        // inner loop --> find index of minimum from (i to n)
        for(int j=i+1;j<n;j++){
            if(arr[j] < arr[minIndex]){   // for decreasing order change this sign
                minIndex = j;   // new min than store it 
            }
        }
        // swap
        swap(arr[i],arr[minIndex]);
    }

    // printing
    cout<<"sorted array is ::"<<endl;
    for(int i=0;i<n;i++){
        cout<<arr[i]<<" ";
    }    
    return 0;

}