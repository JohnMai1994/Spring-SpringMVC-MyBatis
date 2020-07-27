package com.jiadong.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FindDupChar {

    public ArrayList<Character> findDupChar(String word) {
        Map<Character, Integer> maps = new HashMap<Character, Integer>();

        for (int i = 0; i < word.length(); i++) {

            char c = Character.toLowerCase(word.charAt(i));
            if (maps.get(c) == null) {
                maps.put(c, 1);
            } else{
                maps.put(c, maps.get(c) + 1 );
            }

        }

        ArrayList<Character> result = new ArrayList<>();
        for (Character character : maps.keySet()) {
            if (maps.get(character) > 1){
                result.add(character);
            }
        }
        return result;
    }
}
