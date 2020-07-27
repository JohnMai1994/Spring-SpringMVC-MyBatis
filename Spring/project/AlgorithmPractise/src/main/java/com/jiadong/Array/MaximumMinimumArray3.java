package com.jiadong.Array;

import java.util.HashMap;
import java.util.Map;

public class MaximumMinimumArray3 {

    public Map<String , Integer> largetAndSmallest(int[] arrays) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Map<String , Integer> maps= new HashMap<>();
        maps.put("MaxNum", max);
        maps.put("MinNum", min);

        for (int i = 0; i < arrays.length; i++) {

            if (arrays[i] > max) {
                max = arrays[i];
            }

            if (arrays[i] < min){
                min = arrays[i];
            }
        }

        maps.put("MaxNum", max);
        maps.put("MinNum", min);
        return maps;

    }

}
