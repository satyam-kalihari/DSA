package Heap;

import java.util.ArrayList;

public class HeapImp {
    
    public static class Heap {
        
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){
            arr.add(data);

            int x = arr.size()-1;
            int par = (x-1)/2;

            while (arr.get(x) < arr.get(par)) {
                
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x-1)/2;
            }
        }
    }

    public static void heapify(int i, ArrayList<Integer> arr){
        int left = i*2 + 1;
        int right = i*2 + 2;
        int minIdx = i;

        if (left < arr.size() && arr.get(i) > arr.get(left)) {
            minIdx = left;
        }
        if (right < arr.size() && arr.get(i) > arr.get(right)) {
            minIdx = right;
        }

        if (minIdx != i) {
            int temp = arr.get(i);
            arr.set(i, arr.get(minIdx));
            arr.set(minIdx, temp);

            heapify(minIdx, arr);
        }
    }

    public static int  remove(ArrayList<Integer> arr){
        int data = arr.get(0);

        //swap
        int temp = data;
        arr.set(0, arr.get(arr.size()-1));
        arr.set(arr.size()-1, temp);

        //remove the last element
        arr.remove(arr.size()-1);

        //fix the heap
        heapify(0, arr);

        return data;
    }

    public static void main(String[] args) {
        Heap objHeap = new Heap();
        objHeap.add(2);
        objHeap.add(3);
        objHeap.add(4);
        objHeap.add(5);
        objHeap.add(10);
        System.out.println(objHeap.arr);
        objHeap.add(1);
        System.out.println(objHeap.arr);
        remove(objHeap.arr);
        System.out.println(objHeap.arr);


    }
}
