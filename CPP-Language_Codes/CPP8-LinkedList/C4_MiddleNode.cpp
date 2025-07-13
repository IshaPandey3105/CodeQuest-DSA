#include <iostream>
using namespace std;
                       // FINDING MIDDLE NODE OF LINKED LIST
class Node{
        public:
        int data;
        Node* next;

        Node(int data) {
                this -> data = data;
                this -> next = NULL;
        }
};

void print(Node* head) {
        Node* temp = head; 
        while(temp != NULL) {
                cout << temp -> data << " ";
                temp = temp -> next;
        }
        cout << endl;
}

Node* getMiddle(Node* &head) {
        if(head == NULL) {
                cout << "LL is empty" << endl;
                return head;
        }
        if(head -> next == NULL) {
                //only 1 node in LL
                return head;
        }

        // LL have > 1 node
        Node* slow = head;
        Node* fast = head;
        // Node* fast = head -> next;     // To get middle of LL with even number of nodes

        while(slow != NULL && fast != NULL) {
                fast = fast -> next;
                if(fast != NULL) {
                        fast = fast -> next;
                        slow = slow -> next;
                }
        }
        return slow;
}

int main() {
    Node* head = new Node(10);
    Node* second = new Node(20);
    Node* third = new Node(30);
    Node* fourth = new Node(40);
    Node* fifth = new Node(50);
    Node* sixth = new Node(60);
    Node* seventh = new Node(70);
    Node* eighth = new Node(80);
    // Node* ninth = new Node(90);
    head -> next = second;
    second -> next = third;
    third -> next = fourth;
    fourth -> next = fifth;
    fifth -> next = sixth;
    sixth -> next = seventh;
    seventh -> next = eighth;
    // eighth -> next = ninth;
    
    print(head);

    cout << "Middle Node is: " << getMiddle(head) -> data << endl;

    return 0;
}