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
    }
}
