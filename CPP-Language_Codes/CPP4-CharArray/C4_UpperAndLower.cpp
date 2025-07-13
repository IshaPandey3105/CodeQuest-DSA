#include<iostream>
#include<string.h>
using namespace std;

void ConvertIntoUpperCase(char ch[30]){
    int n=strlen(ch);
    for(int i=0;i<n;i++){
        if('a'<=ch[i] && ch[i] <= 'z')   // when the word contain both upper and lower case elem
            ch[i]=ch[i] -'a'+'A';
    }
}

void ConvertIntolowerCase(char ch[30]){
    int n=strlen(ch);
    for(int i=0;i<n;i++){
        ch[i]=ch[i] + 'a'-'A';
    }
}

int main(){
    char ch[30];
    cout<<"enter a word"<<endl;
    cin>>ch;
    //ConvertIntoUpperCase(ch);
    ConvertIntolowerCase(ch);
    cout<<ch<<endl;
}