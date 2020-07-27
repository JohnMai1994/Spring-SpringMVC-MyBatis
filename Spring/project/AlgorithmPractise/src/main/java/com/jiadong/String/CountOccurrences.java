package com.jiadong.String;

public class CountOccurrences {

    public int countTimes(Character character, String word) {
        char[] chars = word.toCharArray();
        int count = 0;

        for (char aChar : chars) {
            if (character == aChar){
                count++;
            }
        }
        return count;


    }
}
