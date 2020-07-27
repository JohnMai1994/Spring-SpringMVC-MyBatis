package com.jiadong.Sort;

public class InsertionSort {

    public void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int numberToInsert = array[i];
            int compareIndex = i;
            while (compareIndex > 0 && array[compareIndex - 1] > numberToInsert) {
                array[compareIndex] = array[compareIndex - 1]; // shifting element
                compareIndex--; // moving backwards, towards index 0
            }
            array[compareIndex] = numberToInsert;
        }
    }
}
