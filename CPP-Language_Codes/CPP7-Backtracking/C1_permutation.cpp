#include<iostream>
using namespace std;

// permutation in string
void Permutation(string &str,int i){
    // base case
    if(i>=str.length()){
        cout<<str<<" ";
        return;
    }    
    for(int j=i;j<str.length();j++){
        swap(str[i],str[j]);   
        Permutation(str,i+1);
        //  backtraking
        swap(str[i],str[j]);
    }
}

int main(){
    string str ={"abc"};
    int i=0;
    Permutation(str,i);
    return 0;
}
