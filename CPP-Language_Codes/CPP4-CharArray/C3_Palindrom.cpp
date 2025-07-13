#include<iostream>
#include<string.h>
using namespace std;

bool find_palindrom(char word[20]){
    int n=strlen(word);
    int i=0;
    int j=n-1;
    while(i<=j){
        if (word[i]!=word[j]){
            return false;
        }
        else{
            i++;
            j--;
        }
    }
    return true;
}

int main(){
    char word[20];
    cout<<"Enter a string: "<<endl;
    cin>>word;
    int val = find_palindrom(word);
    if(val==0)
       cout<<"string is not palindrom";
    else
       cout<<"string is palindrom";

    return 0;
}