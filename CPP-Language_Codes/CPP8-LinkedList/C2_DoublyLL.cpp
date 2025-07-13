#include<iostream>
using namespace std;

class Node{
    public:
        int data;
        Node* prev;
        Node* next;
        Node(){
            this->data=0;
            this->prev=NULL;
            this->next=NULL;
        }
        Node(int data){
            this->data=data;
            this->prev=NULL;
            this->next=NULL;
        }
        ~Node(){
            cout << "\nNode with value: " << this->data << " deleted" << endl;
        }
};

void print(Node* &head){    // for printing of linked list
    Node* temp=head;
    while(temp != NULL) {
        cout << temp->data << " ";
        temp = temp->next;
    }
    cout<<endl;
}

int getLength(Node* head){    // To get length
    Node* temp =head;
    int len=0;
    while(temp!=NULL){
        temp=temp->next;
        len++;
    }
    return len;
}

void insertAtHead(Node* &head, Node* &tail, int data) {
        //check for Empty LL
        if(head == NULL) {
            Node* newNode = new Node(data);
            head = newNode;
            tail = newNode;
        }
        else {
            //step1:
            Node* newNode = new Node(data);
            //step2:
            newNode -> next = head;
            //step3:
            head->prev = newNode;
            //step4:
            head = newNode;
        }
}

void insertAtTail(Node* &head, Node* &tail, int data) {
        //check for Empty LL
        if(head == NULL) {
            Node* newNode = new Node(data);
            head = newNode;
            tail = newNode;
        }
        else {
            //step1:
            Node* newNode = new Node(data);
            //step2:
            newNode -> prev = tail;
            //step3:
            tail-> next = newNode;
            //step4:
            tail = newNode;
        }
}

void insertAtPosition( Node* &head, Node* &tail,int data, int position) {
        if(head == NULL) {
                Node* newNode = new Node(data);
                head = newNode;
                tail = newNode;
                return;
        }

        // find the  position: 

        if(position == 1) {         // I am starting the position with 1 index soo that len = position

                insertAtHead(head, tail , data);
                return;
        }
       
        int len = getLength(head);
        
        if(position > len) {       // equal sign nahi aayega 
                insertAtTail(head, tail, data);
                return;
        }
        //ste1:find prev and curr
        int i = 1;
        Node* ptr = head;
        while(i < position-1) {
            ptr = ptr -> next;
            i++;
        }
        // Node* curr = ptr -> next;

        //step2;
        Node* newNode = new Node(data);
        //step3:
        newNode -> prev = ptr;
        //step3:
        newNode -> next = ptr -> next;
        //step4:
        ptr -> next = newNode;
        //step5:
        ptr -> next -> prev =newNode;
}

void deleteNode(int position, Node* &head, Node* &tail) {
        if(head == NULL) {
                cout << "Cannot delete, LL is empty";
                return;
        }

        //deleting first node

        // if linked list has only one element
        if(head -> next == NULL){
            Node* temp = head;
            head=NULL;
            tail=NULL;
            delete temp;
            return;
        }

        if(position == 1) {
            Node* temp = head;
            head = head -> next;
            head -> prev = NULL;
            temp -> next = NULL;
            delete temp;
            return;
        }

        //deleting last node
        
        int len  = getLength(head);

        if(position > len){
            cout<<"Wrong position "<<endl;
            return ;
        }
        if(position == len) {
                //step1:
                Node* temp = tail;
                //step2:
                tail = tail->prev;
                //step3:
                temp->prev = NULL;
                //step4:
                tail->next = NULL;
                //step5:
                delete temp;
                return;
        }
        //deleting middle node

        // step  : find left ,curr and right
        int i =1;
        Node* left = head;
        while( i < position-1) {
                left= left -> next;
                i++;
        }
        Node* curr = left -> next;
        Node* right = curr -> next;

        //step1:
        left -> next = right;
        //step2:
        right -> prev = left;
        //step3:
        curr -> next = NULL;
        //step4:
        curr -> prev = NULL;
        //step5:
        delete curr;
}

int main(){
    Node* first=new Node(10);
    Node* second=new Node(20);
    Node* third=new Node(30);
    Node* fourth=new Node(40);
    Node* head = first;
    Node* tail = fourth;

    first->next=second;
    second->prev=first;
    second->next=third;

    third->prev=second;
    third->next=fourth;
    fourth->prev=third;

    insertAtHead(head,tail,5);
    insertAtTail(head,tail,101);
    insertAtPosition(head,tail,100,3);
    print(head);

    cout<<"length:: "<<getLength(head)<<endl;
    deleteNode(1,head,tail);
    print(head);
    cout<<"length:: "<<getLength(head)<<endl;

    deleteNode(6,head,tail);
    print(head);
    cout<<"length:: "<<getLength(head)<<endl;

    deleteNode(4,head,tail);
    print(head);
    cout<<"length:: "<<getLength(head)<<endl;

    return 0;
    
}