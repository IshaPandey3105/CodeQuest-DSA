#include<iostream>
#include<string.h>
using namespace std;

int getlength(char ch[20]){
    int len=0;
    int i=0;
    while(ch[i]!='\0'){
        i++;
        len++;
    }
    return len;
}

void reversal(char ch[20]){
    int n= getlength(ch);
    int i=0;
    int j=n-1;
    while(i<=j){
        swap(ch[i],ch[j]);
        i++;
        j--;
    }
}

void replacespaces(char sentance[20]){
    int n= strlen(sentance);
    int i=0;
    for(int i=0;i<n;i++){
        if(sentance[i]==' '){
            sentance[i]='@';
        }
    }
    
}

int main(){
    //char ch[20];
    // cin>>ch;   // by this we can take whole ch in input
    // cout<<ch;
    // ch[2]='c';
    // cin>>ch[0]>>ch[1];   // we can also take input one by one
    // cout<<ch[0]<<ch[1]<<ch[2];

    // cin>>ch;                 // enter isha
    // for(int i=0;i<5;i++){
    //     cout<<"index "<< i <<" value is :: "<<ch[i]<<endl;    // you will give each letter
    // }
    // int value=(int)ch[4];
    // cout<<"value is :: "<<value<<endl;     // this will prove that at this position null charater is present
    
    //cin>>ch;        // if we write "isha pandey"
    //cout<<ch;       // ans will be only "isha" 

    // but now how to get full name  [by using getline fn] 
    // cin.getline(ch,15);
    // cout<<ch; 

    return 0;
}