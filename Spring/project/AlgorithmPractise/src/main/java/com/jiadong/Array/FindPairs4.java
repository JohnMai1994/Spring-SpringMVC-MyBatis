package com.jiadong.Array;

import java.util.HashMap;
import java.util.Map;

public class FindPairs4 {
    public Map<String , Integer> findPair(int[] arrays, int sum) {
        Map<String , Integer> maps = new HashMap<>();


        for (int i = 0; i < arrays.length; i++) {
            int first = arrays[i];
            for (int j = i+ 1; j < arrays.length; j++) {
                int second = arrays[j];
                if ((first + second) == sum) {
                    maps.put("firstNum", arrays[i]);
                    maps.put("secondNum", arrays[j]);

                    return maps;
                }
            }

        }

        return maps;

    }

}
