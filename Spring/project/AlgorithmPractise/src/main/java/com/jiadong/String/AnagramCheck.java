package com.jiadong.String;

public class AnagramCheck {
    public boolean isAnagram(String word, String anagram) {
        if (word.length() != anagram.length()) {
            return false;
        }

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != anagram.charAt(anagram.length() - 1 - i)) {
                return false;
            };
        }

        return true;


    }

}
