#include<iostream>
#include<limits.h>
#include<vector>
using namespace std;



//                  Priting aaray using recursion
// void Print(int arr[],int n,int index){
//     if(index >= n){  // base case
//         return;
//     }
//     cout<<arr[index]<<" ";    // processing
//     Print(arr,n,index+1);     // recursive code 
// }    
// int main(){
//     int arr[5]={1,2,3,4,5};
//     int n=5;
//     int index=0;
//     Print(arr,n,index);
//     return 0 ;
// }
//                  Climbing_stairs problem
// int climbing_stairs(int n){
//     if(n==0 || n==1){
//         return 1;
//     }
//     return climbing_stairs(n-1)+climbing_stairs(n-2); 
// }
// int main(){
//     int n;
//     cout<<"enter value of n"<<endl;
//     cin>>n; 
//     cout<<"no. of ways ::"<<climbing_stairs(n)<< endl;
//     return 0;
// }

//                  finding maximum number in aaray using recursion
// void FindMax(int arr[],int n,int index, int& maxi){
//     if(index >= n){
//         return;
//     }
//     if(arr[index]>maxi){
//         maxi=arr[index];
//     }    
//     FindMax(arr,n,index+1,maxi);
// }    
// int main(){
//     int arr[5]={1,2,3,4,5};
//     int n=5;
//     int index=0;
//     int maxi=INT_MIN;
//     FindMax(arr,n,index,maxi);
//     cout<<"maximum number::"<<maxi<<endl;
//     return 0 ;
// }

//                  finding letter in string using recursion
// int Check_key(string str,int n,char key, int i){
//     if(i >= n){
//         return -1;
//     }
//     if(str[i]==key){
//         return i;
//     }    
//     return Check_key(str,n,key,i+1);
// }    
// int main(){
//     string str = "isha pandey";
//     int n=str.length();
//     char key='a';
//     int i=0;
//     int ans=Check_key(str,n,key,i);
//     if(ans==-1)
//         cout<<"key not found"<<endl;
//     else
//         cout<<"key found at index::"<<ans<<endl;    
//     return 0 ;
// }

//                  Checking sorted array using recursion
// bool CheckSorted(vector<int> &arr,int& n,int i){
//     // base case
//     if(i==n-1)
//         return true;
//     // ek case solve kardo    
//     if(arr[i-1]>arr[i])
//         return false;  
//     // baki recursion sambhal lega    
//     return CheckSorted(arr,n,i+1);
// }
// int main(){
//     vector<int> v{1,2,3,9,5,6};
//     int n=v.size();
//     int i=0;
//     bool ans = CheckSorted(v,n,i);
//     if(ans)
//         cout<<"Array is sorted"<<endl;
//     else
//         cout<<"Array is not sorted"<<endl;    
//     return 0;
// }

//                  Binary Search in Sorted Array using recursion
// int BinarySearch(vector<int> &arr,int &n,int s, int e,int& key){
//     // base case
//     // case 1- key not found
//     if(s>e){
//         return -1;
//     }
//     int mid=s+(e-s)/2;
//     // case 2- key found
//     if(arr[mid]==key){
//         return mid;
//     }
//     // baki recursion samnhal lega
//     if(arr[mid]>key) 
//         return BinarySearch(arr,n,s,mid-1,key);
//     else
//          return BinarySearch(arr,n,mid+1,e,key);  
// }
// int main(){
//     vector<int> v{1,2,3,4,5,6,7,8,9};
//     int n=v.size();
//     int key=4;
//     int s=0;
//     int e=n-1;
//     int ans=BinarySearch(v,n,s,e,key);
//     if(ans==-1)
//         cout<<"key not found"<<endl;
//     else
//         cout<<"key found at index:: "<<ans<<endl;    
//     return 0;
// }

//                  Subsequence of a String Using Recursion
// void PrintSubSeq(string str,string OutPut,int i,vector<string>& v){
//     // base case
//     if(i>=str.length()){
//         // cout<<"{"<<OutPut<<"}"<<endl;
//         // store
//         v.push_back(OutPut);
//         return;
//     }   
//     // exclude case
//     PrintSubSeq(str,OutPut,i+1,v);  // it's a void function so never right return
//     // include case
//     OutPut.push_back(str[i]);
//     // OutPut = OutPut + str[i];
//     PrintSubSeq(str,OutPut,i+1,v);
// }
// int main(){
//     string str="abc";
//     string OutPut="";
//     vector<string> v;
//     int i=0;
//     cout<<"Subsequences of String are:: "<<endl;
//     PrintSubSeq(str,OutPut,i,v);
//     // Printing 
//     for(auto val: v){
//         cout<<val<<" ";
//     }
//     cout<<endl<<"size of vector::"<<v.size();  // it means empty string is also added
//     return 0;
// }

