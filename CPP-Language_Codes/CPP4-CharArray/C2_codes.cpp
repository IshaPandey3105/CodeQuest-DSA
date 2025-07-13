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
    // char ch[20];
    // cout<<"enter a string"<<endl;
    // cin>>ch;

    // //length of string
    // cout<<"length of string is ::"<<getlength(ch)<<endl;
    // cout<<"length of string is ::"<<strlen(ch)<<endl;    // using pre define function

    // // revercing of string
    // reversal(ch);
    // cout<<"Now String is ::"<<ch<<endl;

    //Replacing all spaces with @
    char sentance[30];
    cout<<"Enter a new string with spaces"<<endl;
    cin.getline(sentance,30);
    replacespaces(sentance);
    cout<<"Now  after replacing spaces our string is ::"<<sentance<<endl;

    return 0;
}