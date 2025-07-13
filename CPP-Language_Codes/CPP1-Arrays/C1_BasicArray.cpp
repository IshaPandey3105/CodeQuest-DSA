#include<iostream>
#include<limits.h>
using namespace std;


// Liner Search in Array
// int main(){
//     int arr[5]={1,2,3,4,5};
//     int n=5;
//     int key;
//     cout<<"enter the searching key :"<<endl;
//     cin>>key;
//     int flag=0;
//     for(int i=0;i<n;i++){
//         if(arr[i]==key){
//            cout<<"key is present"<<endl;
//            flag=1;
//            break;
//         }
//     }
//     if(flag==0){
//         cout<<"key is not present"<<endl;
//     }
//     return 0;
// }

// Maximum and Minimum number in Array
// int main(){
//     int arr[5]={1,2,3,4,5};
//     int n=5,max=INT_MIN,min=INT_MAX;  //for them we include a new header file i.e. <limits.h>
//     for(int i=0;i<n;i++){
//         if(arr[i]>max)
//            max=arr[i];
//         if(arr[i]<min)
//            min=arr[i];
//     }
//     cout<<"maximum value in array is = "<<max<<endl;
//     cout<<"minimum value in array is = "<<min<<endl;
//     return 0;
// }

//Extream Print in Array
//  int main() {
//     int arr[] = {1,2,3,4,5,6,7};
//     int n = sizeof(arr)/sizeof(arr[0]);   //to get the size
//     cout<<n<<endl;    
//     int s=arr[0];
//     int e=arr[n-1];
//     while(s<=e){
//         if(s==e)
//             cout<<s<<endl;
//         else
//            cout<<s<<","<<e<<",";
//         s++;
//         e--;
//     }
//     return 0;
//  }

//reversing of Array
//  int main() {
//     int arr[] = {1,2,3,4,5,6,7};
//     int n = sizeof(arr)/sizeof(arr[0]);   
//     cout<<n<<endl;    
//     int start=0;
//     int end=n-1;
//     while(start<=end){
//         swap(arr[start],arr[end]);  //swap
//         start++;
//         end--;
//     }
//     for(int i=0;i<n;i++){
//         cout<<arr[i]<<" ";
//     }
//     return 0;
//  }

// count 0's and 1's
// int main(){
//     int arr[]={1,0,1,5,0,1,0};
//     int size=sizeof(arr)/sizeof(int);
//     int count_0=0;
//     int count_1=0;
//     for(int i=0 ; i<size ; i++){
//         if(arr[i]==1)
//             count_1++;
//         if(arr[i]==0)
//             count_0++;    
//     }
//     cout<<"no. of 0's in array ::"<<count_0<<endl;
//     cout<<"no. of 1's in array ::"<<count_1<<endl;
//     return 0;
// }     

