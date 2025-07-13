#include<iostream>
#include<vector>
using namespace std;

//Q1.SORTING COLOURS PROBLEM [SORT ARRAY WHICH CONSIST OF ONLY 0,1,2]

// COUNTING METHOD
// int main(){
//     vector<int> arr{2,1,0};
//     int zeros=0,ones=0,twos=0;
//     // counting 
//     for(int i=0;i<arr.size();i++){
//         if(arr[i]==0)
//             zeros++;
//         if(arr[i]==1)
//             ones++;
//         if(arr[i]==2)
//             twos++;
//     }
//     int i=0;
//     while(zeros--){
//         arr[i]=0;
//         i++;
//     }
//     while(ones--){
//         arr[i]=1;
//         i++;
//     }
//     while(twos--){
//         arr[i]=2;
//         i++;
//     }
//     // printing sorted array
//     for(int i=0;i<arr.size();i++){
//         cout<<arr[i]<<" ";
//     }
//     return 0;
// }

// IN PLACE METHOD [3 POINTERS APPROACH]
// int main(){
//     vector<int> arr{2,1,0};
//     int l=0,m=0,h=arr.size()-1;
//     while(m<=h){
//         if(arr[m]==0){
//             swap(arr[l],arr[m]);
//             l++ , m++;
//         }    
//         else if(arr[m]==1)
//             m++;
//         else{
//             swap(arr[m],arr[h]);
//             h--;
//         }    
//     }
//     // printing sorted array
//     for(int i=0;i<arr.size();i++){
//         cout<<arr[i]<<" ";
//     }
//     return 0;
// }

//Q2. MOVE ALL NEGATIVE NUMBERS TO LEFT SIDE 
// DUTCH NATIONAL FLAG METHOD
// void moveNegative(int arr[], int n){
//     int i=0, j=n-1;
//     while(i<j){
//         while(arr[i]<0 && i<j){ // move i until a positive element is encountered
//             i++;
//         }
//         while(arr[j]>0 && i<j){ // move j until a negative element is encountered
//             j--;
//         }
//         if(i<j){ // swap only when i is less than j
//             swap(arr[i], arr[j]); // swap the elements
//         }
//     }
// }
// int main(){          // TC: O(n) and SC: O(1)
//     int n = 5;
//     int arr[n] = {2, 3,-3, -1, 5, -4};
//     moveNegative(arr, n);
//     for(int i=0;i<n;i++){
//         cout<<arr[i]<<" ";
//     }
//     return 0;
// }

//                   Addition of 2 arrays with carry
// int main()
// {
//     int arr[]={9,9,9,9};
//     int brr[]={9,9,9,9};
//     int n=sizeof(arr)/sizeof(int);
//     // cout<<n<<endl;
//     int crr[n+1]={0};
//     int carry=0;
//     for(int i=n-1;i>=0;i--){
//         int sum=0;
//         sum=arr[i]+brr[i]+carry;
//         if(sum>9) {carry=1;}
//         else{carry=0;}
//         crr[i+1]=sum%10;
//     }
//     if(carry==1){  // special case
//         crr[0]=1;
//     }
//     // printing array
//     for(int i=0;i<n+1;i++){
//         cout<<crr[i]<<" ";
//     }
//     return 0;
// }

