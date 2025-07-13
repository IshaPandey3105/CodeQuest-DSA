// #include <iostream>
// using namespace std;

// // sort 0's , 1's and 2's in a linked list

// class Node{
//         public:
//         int data;
//         Node* next;

//         Node(int data) {
//             this->data = data;
//             this->next = NULL;
//         }
// };

// void print(Node* head) {
//         Node* temp = head;
//         while(temp != NULL) {
//             cout << temp -> data << " ";
//             temp = temp -> next;
//         }
//         cout << endl;
// }

// // sorting using count method
// void sortZeroOneTwo(Node* &head) {
//         //step1: find count of zeroes, ones and twos
//         int zero = 0;
//         int one = 0;
//         int two = 0;

//         Node* temp = head;
//         while(temp != NULL) {
//                 if(temp -> data == 0)
//                     zero++;
//                 else if(temp -> data == 1)
//                     one++;
//                 else if(temp -> data == 2)
//                     two++;
//                 temp = temp -> next;
//         }

//         //step2: fill 0, 1 and 2s in the original ll
//         temp = head;
//                 // fill zeroes
//                 while(zero--) {
//                         temp -> data = 0;
//                         temp = temp -> next;
//                 }

//                 //fill ones
//                 while(one--) {
//                         temp -> data = 1;
//                         temp = temp -> next;
//                 }

//                 //fill 2s
//                 while(two--) {
//                         temp -> data = 2;
//                         temp = temp -> next;
//                 }
// }

// // if we dont want to do data replacement 
// // we can use new linked lists and push zeroes, ones and twos in it

// Node* sort2(Node* &head) {
//         if(head == NULL) {
//                 cout << "LL is empty " << endl;
//                 return NULL;
//         }
//         if(head -> next == NULL) {
//                 //sngle node in LL
//                 return head;
//         }

//         //create dummy nodes
//         Node* zeroHead = new Node(-101);
//         Node* zeroTail = zeroHead; 

//         Node* oneHead = new Node(-101);
//         Node* oneTail = oneHead; 

//         Node* twoHead = new Node(-101);
//         Node* twoTail = twoHead; 

//         //traverse the original LL
//         Node* curr = head;
//         while(curr != NULL) {
//                 if(curr -> data == 0) {
//                         //take out the zero wali node
//                         Node* temp = curr;
//                         curr = curr -> next;
//                         temp -> next = NULL;

//                         //append the zero node in zeroHead LL
//                         zeroTail -> next = temp;
//                         zeroTail = temp;
//                 }
//                 else if(curr -> data == 1) {
//                         //take out the one wali node
//                         Node* temp = curr;
//                         curr = curr -> next;
//                         temp -> next = NULL;

//                         //append the one node in oneHead LL
//                         oneTail -> next = temp;
//                         oneTail = temp;
//                 }
//                 else if(curr -> data == 2) {
//                         //take out the two wali node
//                         Node* temp = curr;
//                         curr = curr -> next;
//                         temp -> next = NULL;

//                         //append the two node in twoHead LL
//                         twoTail -> next = temp;
//                         twoTail = temp;
//                 }
//         }

//         //ab yha pr, zero , one, two, teeno LL readyv h 

//         // join them 
//         //remove dummmy nodes

//         //modify one wali list
//         Node* temp = oneHead;
//         oneHead = oneHead -> next;
//         temp -> next = NULL;
//         delete temp;

//         //modify two wali list
//         temp = twoHead;
//         twoHead = twoHead -> next;
//         temp -> next = NULL;
//         delete temp;

//         //join list
//         if(oneHead != NULL) {
//                 // one wali list is non empty
//                 //zero wali list ko one wali list se attach krdia 
//                 zeroTail -> next = oneHead;
                
//                 if(twoHead != NULL)
//                         oneTail -> next = twoHead;
//         }
//         else{
//                 //one wali list is empty
//                 if(twoHead != NULL)
//                         zeroTail -> next = twoHead;
//         }

//         //remove zerohead dummy Node
//         temp = zeroHead;
//         zeroHead = zeroHead -> next;
//         temp -> next = NULL;
//         delete temp;
        
//         //return head of the modified linked list
//         return zeroHead;

// }

// int main() {
//     Node* head = new Node(2);
//     Node* second = new Node(2);
//     Node* third = new Node(1);
//     Node* fourth = new Node(1);
//     Node* fifth = new Node(0);
//     Node* sixth = new Node(0);
//     head -> next = second;
//     second -> next = third;
//     third -> next = fourth;
//     fourth -> next = fifth;
//     fifth -> next = sixth;

//     cout << "input LL: ";
//     print(head);

//     // sorting using count method

//     //   cout << "output LL: ";
//     //   sortZeroOneTwo(head);
//     //   print(head);
    
//     // sorting using famous method

//     cout << "printing the sorted list " << endl;
//         //   Node* temp = NULL;
//         //   head = sort2(temp);

//     head = sort2(head);
//     print(head);

//     return 0;
// }



#include <iostream>
#include <fstream>
using namespace std;

void removeWhitespace(string& inputFile, string& outputFile) {
        ifstream inFile(inputFile);
        ofstream outFile(outputFile);
        if (!inFile) {
        cout<< "Error: Could not open the input file.\n";
        return;
}
if (!outFile) {
cout<< "Error: Could not open the output file.\n";
return;
}
char ch;
while (inFile.get(ch)) {
if (!isspace(static_cast<unsigned char>(ch))) {
outFile.put(ch);
}
}
cout << "Whitespace removal completed. Output stored in " << outputFile << ".\n";
inFile.close();
outFile.close();
}
int main() {
string inputFile = "input.txt";
string outputFile = "output.txt";
removeWhitespace(inputFile, outputFile);
return 0; }