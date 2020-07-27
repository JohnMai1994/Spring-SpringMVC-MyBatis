package com.jiadong.String;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueChar {
    public Character firstUniqueChar(String word) {
        Map<Character, Integer> maps = new HashMap<>();
        Character firstChar = null;

        for (int i = 0; i < word.length(); i++) {
            if (maps.get(word.charAt(i)) == null) {
                maps.put(word.charAt(i), i);
            } else {
                maps.remove(word.charAt(i));
            }
        }

        for (int i = 0; i < word.length(); i++) {
            if (maps.containsValue(i)) {
                firstChar =  word.charAt(i);
                break;
            }
        }
        return firstChar;


    }

}
