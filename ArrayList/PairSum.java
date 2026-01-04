package ArrayList;

import java.util.ArrayList;

//Find if any pair in a sorted & rotated ArrayList jas target sum
public class PairSum {

    public static void pairSumForSortedAndRotatedArrayList(ArrayList<Integer> arr, int target){
        int index = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (!(arr.get(i) < arr.get(i+1))) {
                index = i+1;
                break;
            }
        }

        int lP = index;
        int rP = index-1;
        int arrSize = arr.size();
        while (lP != rP) {
            int sum = arr.get(lP) + arr.get(rP);
            if (sum == target) {
                System.out.println("Target found at : " + lP + "+" + rP + " = " + (arr.get(lP)+ arr.get(rP)));
                return;
            }
            if (sum < target) {
                lP = (lP+1)%arrSize;
            }
            else{
                rP = (arrSize + rP -1)%arrSize;
            }
        }
        
        
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(11);
        arr.add(15);
        arr.add(6);
        arr.add(8);
        arr.add(9);
        arr.add(10);
        pairSumForSortedAndRotatedArrayList(arr, 16);
    }
}
