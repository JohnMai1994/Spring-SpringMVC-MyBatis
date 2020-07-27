package com.jiadong.Array;

public class ReverseArray9 {

    public void reverse(int[] arrays){
        for (int i = 0; i < arrays.length/2; i++) {
            int tem = arrays[i];
            arrays[i] = arrays[arrays.length - 1 - i];
            arrays[arrays.length - 1 - i] = tem;
        }


    }

}
