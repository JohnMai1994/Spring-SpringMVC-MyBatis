package com.jiadong.Array;

public class MissingNumberInArray1 {
    /*
    * write a program to find the missing number in an array in Java, C# or any other language;
    * depending upon which language you choose

    * */
    public int getMissingNum(int[] arrays, int length){
        int expectSum = length * (length+1) / 2;
        int realSum = 0;
        for (int array : arrays) {
            realSum += array;
        }

        int missingNum = expectSum - realSum;

        return missingNum;
    }


}
