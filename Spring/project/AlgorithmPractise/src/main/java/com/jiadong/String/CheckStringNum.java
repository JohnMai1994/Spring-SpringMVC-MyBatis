package com.jiadong.String;

public class CheckStringNum {

    public boolean onlyNum(String word){
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) <= '9' && word.charAt(i) >= '0'){
                continue;
            }
            return false;
        }
        return true;

    }
}
