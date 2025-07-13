#include<iostream>
#include<limits.h>
using namespace std;

//                  Factorial Code
// int printfactorial(int n){
//     if(n==1) return 1;
//     else
//        return n*printfactorial(n-1);
// }
// int main(){
//     int n;
//     cout<<"enter value of n"<<endl;
//     cin>>n; 
//     cout<<printfactorial(n);
//     return 0;
// }

//                  Reverse Counting Printing
// int reverse_counting(int n){
//     if(n==0) {     // base case
//         return 0;
//     }
//     cout<<n<<" ";    // processing part
//     return reverse_counting(n-1);  // recursive relation
// }
// int main(){
//     int n;
//     cout<<"enter value of n"<<endl;
//     cin>>n; 
//     reverse_counting(n);
//     return 0;
// }

//                  Fibonacci value at required index
// int fibonacci(int n){
//     if(n==0 || n==1){
//         return n;
//     }
//     return fibonacci(n-1)+fibonacci(n-2); 
// }
// int main(){
//     int n;
//     cout<<"enter value of n"<<endl;
//     cin>>n; 
//     cout<<n<<"th term is::"<<fibonacci(n)<< endl;
//     return 0;
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

//                  Printing all digits using recursion
// void digits(int n){
//     if(n==0){             // base case
//         return;
//     }  
//     int newvalue=n/10;
//     digits(newvalue);  // recursive call
//     int lastDigit = n%10;     // processing part
//     cout<<lastDigit<<" "; 
// }
// int main(){
//     int n;
//     cout<<"Enter your number:: ";
//     cin>>n;
//     cout<<"All digits are:: "<<endl;
//     digits(n);
//     return 0;
// }

