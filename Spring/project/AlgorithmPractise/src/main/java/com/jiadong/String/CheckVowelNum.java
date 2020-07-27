package com.jiadong.String;

public class CheckVowelNum {
    public int vowelNum(String word) {
        int vowelNum = 0;
        char[] chars = word.toCharArray();
        for (char aChar : chars) {
            switch (aChar){
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    vowelNum++;
                    break;
                default:
            }

        }
        return vowelNum;


    }

}
