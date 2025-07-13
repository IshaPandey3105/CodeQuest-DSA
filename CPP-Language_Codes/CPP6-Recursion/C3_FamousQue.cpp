#include<iostream>
#include<vector>
#include<limits.h>
using namespace std;

// Problem 1
// int solve(vector<int>& arr,int target){
//     // base case
//     if(target==0){
//         return 0;
//     }
//     if(target<0){
//         return INT_MAX;
//     }
//     // lets solve one case
//     int mini=INT_MAX;
//     for(int i=0;i<arr.size();i++){
//         int ans=solve(arr,target-arr[i]);
//         if(ans!=INT_MAX)
//             mini=min(mini,ans+1);
//     }
//     return mini;
// }
// int main(){
//     vector<int> arr{1,2};
//     int target=5;
//     int ans=solve(arr,target);
//     cout<<"Answer is::"<<ans<<endl;
//     return 0;
// }

// Problem 2
// int solve(int n, int x, int y,int z){
//     // base case
//     if(n==0){
//         return 0;
//     }
//     if(n < 0){
//         return INT_MIN;
//     }
//     int a= solve(n-x,x,y,z)+1;
//     int b= solve(n-y,x,y,z)+1;
//     int c= solve(n-z,x,y,z)+1;
//     int ans=max(a,max(b,c));
//     return ans;
// }
// int main(){
//     int n=8;
//     int x=4;
//     int y=3;
//     int z=3;
//     int ans=solve(n,x,y,z);
//     if(ans<0){
//         ans=0;
//     }
//     cout<<"Answer is::"<<ans<<endl;
//     return 0;
// }

// Problem 3
// void solve(vector<int> arr,int i, int sum, int& maxi){
//     // base case
//     if(i>=arr.size()){
//         maxi=max(sum,maxi);
//         return;
//     }   
//     // include case
//     solve(arr,i+2,sum+arr[i],maxi);
//     // exclude case
//     solve(arr,i+1,sum,maxi);  
// }
// int main(){
//     vector<int> v{2,1,4,9};
//     int i=0;
//     int sum=0;
//     int maxi=INT_MIN;
//     solve(v,i,sum,maxi);
//     cout<<maxi<<endl;
//     return 0;
// }


