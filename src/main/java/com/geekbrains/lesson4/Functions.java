package com.geekbrains.lesson4;

public class Functions {
    //2332
    //12321
    //1
    public static boolean isPalindrome(String word) {
        if (word.length() < 2) return true;

        if (word.charAt(0) != word.charAt(word.length() - 1)) {
            return false;
        }

        return isPalindrome(word.substring(1, word.length() - 1));
    }
 // 1 -   12321 =true
    //2 - 232  =true
    //3 - 3    = true
}
