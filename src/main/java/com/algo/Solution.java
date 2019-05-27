package com.algo;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    static String BLANK = " ";

    //1. pattern转公共rule
    //2. str转公共rule
    //2. check两个rule是否一致
    public boolean wordPattern(String str, String pattern) {
        int rule[] = this.patternToRule(this.patternToArray(pattern));
        int strPattern[] = this.patternToRule(this.inputToArray(str));

        return compareTo(rule, strPattern);
    }


    private int[] patternToRule(String[] patterns) {
        HashMap<String, Integer> set = new HashMap<String, Integer>();

        int index = 0;
        int[] rule = new int[patterns.length];
        for (int i = 0; i < patterns.length; i++) {
            String curStr = patterns[i];
            if (set.get(curStr) == null) {
                index++;
                set.put(curStr, index);
            } else {
                index = set.get(curStr);
            }
            rule[i] = index;
        }
        return rule;
    }


    private boolean compareTo(int[] left, int[] right) {
        if (left.length != right.length) {
            return false;
        }
        for (int i = 0; i < left.length; i++) {
            if (left[i] != right[i]) {
                return false;
            }
        }
        return true;
    }


    private String[] inputToArray(String input) {
        return input.split(BLANK);
    }

    private String[] patternToArray(String pattern) {
        String[] result = new String[pattern.length()];
        for (int i = 0; i < pattern.length(); i++) {
            result[i] = String.valueOf(pattern.charAt(i));
        }
        return result;

    }


}