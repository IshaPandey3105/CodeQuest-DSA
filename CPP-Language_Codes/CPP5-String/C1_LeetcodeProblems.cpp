#include<iostream>
#include<string>
using namespace std;

// // remove all adjacent duplicates in string[problem no.1047]
// string removeDuplicats(string str){
//     string ans="";                        // there is some problem in this code.
//     int i=0;
//     while(i<str.length()){
//         if(ans.length()>0){
//             if(ans[ans.length()-1 == str[i]]){
//                 ans.pop_back();
//             }
//             else{
//                 ans.push_back(str[i]);
//             }
//         }
//         else{
//             ans.push_back(str[i]);
//         }
//         i++;
//     }
//     return ans;
// }

// //Remove all occurance of a substring[problem no. 1910]
// string RAO(string s, string part){
//     int pos=s.find(part);
//     while(pos!=string::npos){
//         s.erase(pos,part.length());
//         pos=s.find(part);
//     }
//     return s;
// }

// int main(){
//     string str ="abbaca";
//     string s="dabcbabca";
//     string part="abc";
//     // cout<<removeDuplicats(str);
//     cout<<RAO(s,part);
//     return 0;
// }

bool isPalindrome(int x) {
    if (x < 0) return false;
    vector<int> v;
    int i=0;
    while(i!=0){
        int n =x%10;
        v[i]=n;
        x=x/10;
        i++;
    }
    for(int j=0;j<v.length();j++){
        if(v[j]!=v[v.length()-1-j]){
            return false;
        }
    }
    return true;        
}
