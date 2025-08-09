import java.util.ArrayList;
import java.util.Arrays;

public class Heap {
    private Patient[] heap ;
    private int size ;  // for the number of the element in the array and it is follow the last element of the array not last index
    private int capacity ;  // the length of an array

    Heap (int capacity ){
        this.capacity = capacity;
        this.heap = new  Patient[capacity] ;
        size = 1 ; // size begin from "1"
    }

    private int Parent (int i ){
        return i/2 ;
    }
    private int leftChild (int i ){
        return 2*i ;
    }
    private int rightChild (int i ){
        return (2*i)+1 ;
    }
    private boolean isFull(){
        return size==capacity;
    }
    public void swap (int i , int j ){

        Patient temp = heap[i] ;
        heap[i]= heap[j];
        heap[j]=temp;

    }

    // Implement type of MAX Heap
    public void insert (Patient data){

        if(isFull()){
            System.out.println("the heap is Overflow");
        }

        heap[size]= data;
        int current = size;
        size++; // this the index that has order to be insert and it's empty right now

        while ( current>1 && heap[current].getPer()>heap[Parent(current)].getPer()){// " Heapify up "
            // if current greater than it's parent then swap value
            swap(current,Parent(current));
            // let check again by move index of current to it's parent
            current = Parent(current); // will check until getting to the root
        }

    }

    public Patient delete (){
        // heap is empty
        if (size == 1){
            System.out.println("the Heap is underflow ");
        }
        int rootIndex = 1;
        Patient root = heap [1]; // 1) take root
        heap[rootIndex] = heap[size-1]; // 2) Exchange root value to the last element inserted to the heap
        size--;
        heapify(rootIndex);  // 3) " Heapify down "
        return root;
    }

    public void heapify (int i){

        int largest = i ;
        int left = leftChild(largest);
        int right = rightChild(largest);

        // left must be smaller than size to not get out of bounds
        if (left<size&&heap[left].getPer()>heap[largest].getPer()){
            largest = left ;
        }
        // right must be smaller than size
        if (right<size&&heap[right].getPer()>heap[largest].getPer()){
            largest = right ;
        }
        // to make it Recursion condition
        // it well stop when there is no swap;
        if (largest!=i){
            swap(i,largest);
            heapify(largest);
        }

    }
    public void print (){
        for (int i = 1 ; i<size ; i++){
            heap[i].getPatientInfo();
        }
    }

}
