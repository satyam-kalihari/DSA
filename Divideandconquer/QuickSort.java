package Divideandconquer;

public class QuickSort {

    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    
    public static void quickSort(int[] arr, int si, int ei){
        if (si >= ei) {
            return;
        }

        int pivotIdx = partition(arr, si, ei);
        quickSort(arr, si, pivotIdx-1);
        quickSort(arr, pivotIdx+1, ei);

    }

    public static int partition(int[] arr, int si, int ei){

        int pivot = arr[ei];
        int i = si-1;

        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 9, 5, 2, 8};
        quickSort(arr, 0, arr.length -1);
        printArray(arr);
    }
}
