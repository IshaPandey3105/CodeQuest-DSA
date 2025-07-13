#include<iostream>
#include <vector>
#include <climits>
using namespace std;

int main(){
    vector<int> arr{1,2,2,2,7,6,3,4};
    vector<int> brr{5,7,2,2,6,4,4,4};
    vector<int> ans ;
    int Max=0;
    for(int i=0;i<arr.size();i++){
        if(Max<arr[i]){  Max=arr[i];  }
    }
    for(int i=0;i<brr.size();i++){
        if(Max<brr[i]){  Max=brr[i];  }
    }
    int Count[Max]={0};
    int ptr1=0,ptr2=0;
    while(ptr1<arr.size() && ptr2<arr.size()){
        
    }

    for(int i=0; i<arr.size(); i++) {
		ans.push_back(arr[i]);
    }
	for(int j=0; j<brr.size(); j++){
         if(brr[j]!=INT_MIN){
				ans.push_back(brr[j]);
			}
	}
	cout<<"Final Array::"<<endl;
    // printArray(ans);
    return 0;
}        