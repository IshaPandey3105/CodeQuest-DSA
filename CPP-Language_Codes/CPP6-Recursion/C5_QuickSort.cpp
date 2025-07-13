#include<iostream>
using namespace std;

int partition(int arr[], int s, int e){
    // step 1 : choose element
    int PivotIndex = s;
    int PivotElem = arr[s];

    // step 2: finding right index
    int count=0;
    for(int i=s+1;i<=e;i++){
        if(arr[i]<=PivotElem)    // equal isliye as same elem hue toh hum right most prefer karenge
            count++;
    }
    int RightIndex=s+count;
    swap(arr[s],arr[RightIndex]);
    PivotIndex=RightIndex;
    
    // step 3: making correct left and right part
    int i=s,j=e;
    while( (i<PivotIndex) && (j>PivotIndex) ){
        while(arr[i] < PivotElem){
            i++;
        }
        while(arr[j] > PivotElem){
            j--;
        }
        if ( (i<PivotIndex) && (j>PivotIndex)){
            swap(arr[i],arr[j]);
            i++;
            j--;
        }
    }
    return PivotIndex;

}

void QuickSort(int arr[], int s, int e){
    if(s>=e)
        return; 

    // Partition function for pivot element 
    int p = partition(arr,s,e);   

    //left    
    QuickSort(arr,s,p-1);
    //right 
    QuickSort(arr,p+1,e);
    
}

int main(){
    int arr[]={5,2,4,6,5,58};
    cout<<"hello"<<endl;
    int n=6;
    int s=0;
    int e=n-1;
    //calling function
    QuickSort(arr,s,e);
    // Printing the sorted array
    for(int i=0;i<n;i++){
        cout<<arr[i]<<" ";
    }
    return 0;
}