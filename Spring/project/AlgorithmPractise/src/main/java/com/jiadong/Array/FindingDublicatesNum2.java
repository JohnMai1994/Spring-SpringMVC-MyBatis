package com.jiadong.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindingDublicatesNum2 {
    public ArrayList findDubNum(int[] arrays){
        Arrays.sort(arrays);
        ArrayList result = new ArrayList<Integer>();
        Map<Integer, Integer> maps = new HashMap<Integer, Integer>();
        for (int i = 0; i < arrays.length; i++) {
            if (maps.get(arrays[i]) == null) {
                maps.put(arrays[i], 1);
            } else {
                maps.put(arrays[i], maps.get(arrays[i]) + 1);
            }
        }

        for(Integer key: maps.keySet()) {
            if (maps.get(key) > 1) {
                result.add(key);
            }
        }

        return result;

    }

}
