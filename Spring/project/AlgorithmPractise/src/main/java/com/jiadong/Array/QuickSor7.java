package com.jiadong.Array;

public class QuickSor7 {

    public void sort(int[] arrays, int low, int high){
        if (low < high) {
            int pi = quickSort(arrays, low, high);
            sort(arrays, low, pi-1);
            sort(arrays, pi+1, high);
        }
    }

    private int quickSort(int[] arr, int low, int high ) {
        int pivot = high;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < arr[pivot]) {
                i++;
                int tem = arr[i];
                arr[i] = arr[j];
                arr[j] = tem;
            }
        }

        int tem = arr[i + 1];
        arr[i+1] = arr[pivot];
        arr[pivot] = tem;

        return i+1;
    }










}
