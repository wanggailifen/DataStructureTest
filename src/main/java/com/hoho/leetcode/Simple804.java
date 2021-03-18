package com.hoho.leetcode;


import java.util.TreeSet;

public class Simple804 {
    public int uniqueMorseRepresentations(String[] words) {
        String[] code = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        TreeSet<String> treeSet = new TreeSet<>();
        for (String word : words) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                result.append(code[word.charAt(i) -'a']);
            }
            treeSet.add(result.toString());
        }
        return treeSet.size();
    }
}
