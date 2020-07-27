package com.jiadong.String;

import java.util.Arrays;

public class Rotation {

    public boolean isRotated(String word, String rotatedWord) {
        char[] wordArrays = word.toCharArray();
        char[] rotatedWordArrays = rotatedWord.toCharArray();

        Arrays.sort(wordArrays);
        Arrays.sort(rotatedWordArrays);

        if (wordArrays.length != rotatedWordArrays.length) {
            return false;
        }

        for (int i = 0; i < wordArrays.length; i++) {
            if (wordArrays[i] != rotatedWordArrays[i]){
                return false;
            }

        }
        return true;
    }

}
