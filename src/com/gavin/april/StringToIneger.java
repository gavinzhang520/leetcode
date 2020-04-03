package com.gavin.april;

public class StringToIneger {

    public int myAtoi(String str) {

        char[] chars = str.toCharArray();
        int n = str.length();
        int index = 0;

        while(index < n && chars[index] == ' '){//去除前置的空格
            index++;
        }

        if(index == n){
            return 0;
        }

        boolean negative = false;

        if (chars[index] == '-') {
            negative = true;
            index++;
        }else if(chars[index] == '+'){
            index++;
        }else if(!Character.isDigit(chars[index])){
            return 0;
        }

        int rst = 0;

        while (index < n && Character.isDigit(chars[index])){
            int digit = Character.getNumericValue(chars[index]);
            if(rst > (Integer.MAX_VALUE - digit) / 10){
                return negative? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            rst = rst * 10 + digit;
            index++;
        }
        return negative? -rst : rst;
    }
}
