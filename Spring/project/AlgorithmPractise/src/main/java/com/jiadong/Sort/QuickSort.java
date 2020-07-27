package com.jiadong.Sort;

public class QuickSort {

    public void sort(int[] arrays, int low, int high) {
        if (low < high) {
            int pv = quickSort(arrays, low, high);
            sort(arrays, low, pv - 1);
            sort(arrays, pv + 1, high);
        }
    }

    private int quickSort(int[] arr, int low, int high){
        int pivot = high;
        int i = low - 1;

        for (int j = low; j < arr.length; j++) {
            if (arr[j] < arr[pivot]) {
                i++;
                int tem = arr[i];
                arr[i] = arr[j];
                arr[j] = tem;
            }
        }

        i++;
        int tem = arr[i];
        arr[i] = arr[pivot];
        arr[pivot] = tem;

        return i;

    }

}
