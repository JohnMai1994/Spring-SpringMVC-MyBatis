package com.jiadong.Sort;

public class BubbleSort {

    public void sort(int[] array) {

        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array.length -1 ; j++) {
                if (array[j] > array[j+1]) {
                    int tem = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tem;
                }
            }

        }

    }
}
