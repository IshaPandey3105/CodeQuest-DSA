#include<iostream>
#include<limits.h>
#include <vector>
using namespace std;

void printArray(vector<int> arr) {
	for(auto i:arr) {
		cout << i << " ";
	}
	cout << endl;
}

// finding unique number
// int main(){
// 	vector<int> arr{1,2,3,4,1,2,3};
// 	int ans=0;
// 	for(int i=0;i<arr.size();i++){
// 		ans=ans^arr[i];
// 	}
// 	cout<<"unique number in array is :: "<<ans<<endl;
// 	return 0;
// }
  
//INTERSECTION
// int main(){
//     vector<int> arr{1,2,3,3,4,6,8};
//     vector<int> brr{3,3,4,10};
//     vector<int> ans ;
// 
//     //outer loop on arr vector
//         for(int i=0; i<arr.size(); i++) {
//              int element = arr[i];
//             // for every element, run loop on brr
//             for(int j=0; j<brr.size(); j++) {
//                 if(element == brr[j]) {
//                     //mark 
//                     brr[j] = -1;
//                     ans.push_back(element);
//                 }
//             }
//         }
//         printArray(ans);
//         return 0;
// }        

//Pair Sum Problem (imp*)
// int main(){
// 	vector<int>arr{10,20,30,40,60,70};
// 	int sum=80;
// 	for(int i=0;i<arr.size();i++){
// 	   int element=arr[i];
// 	   for(int j=i+1;j<arr.size();j++){
// 	       if(element + arr[j]==sum){
// 			cout<<"("<<element<<","<<arr[j]<<")"<<endl;
// 		   }
// 	   }   
// 	}
// 	return 0;
// }

//Sorting 0 and 1
// int main(){
// 	vector<int> arr{0,1,0,1,1,0,1,0,1,1};
// 	int start = 0;
// 	int end = arr.size() -1;
// 	int i = 0;
//
// 	while( i != end) { //we can also give other conditions too
// 		if(arr[i] == 0) {
// 			swap(arr[start], arr[i]);
// 			start++;
// 			i++;
// 		}
// 		else {
// 			swap(arr[end], arr[i]);
// 			end--;
// 		}
// 	}
// 	printArray(arr);
// 	return 0;
// }
//                OR
//
// int main(){
// 	vector<int> arr{0,1,0,1,1};
// 	int start = 0;
// 	int end = arr.size() -1;
// 	while( start <= end) { //we can also give other conditions too
// 		if(arr[end] == 0) {
// 			swap(arr[start], arr[end]);
// 			start++;
// 			//i++;
// 		}
// 		else {
// 			end--;
// 		}
// 	}
// 	printArray(arr);
// 	return 0;
// }

// Union of Array
// int main(){
//     vector<int> arr{1,2,2,3,4};
//     vector<int> brr{1,2,2,5,6};
//     vector<int> ans ;
//         for(int i=0; i<arr.size(); i++) {
// 			ans.push_back(arr[i]);
// 			for(int j=0; j<brr.size(); j++){
// 				if(arr[j]==brr[j]){
// 					brr[j]=INT_MIN;
// 					break;
// 				}
// 			}
//         }
// 		for(int j=0; j<brr.size(); j++){
//              if(brr[j]!=INT_MIN){
// 					ans.push_back(brr[j]);
// 				}
// 		}
// 		cout<<"Final Array::"<<endl;
//         printArray(ans);
//         return 0;
// }        