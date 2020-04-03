package com.gavin.april;

/**
 * #8.字符串转换整数（atoi）
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 */
public class StringToIneger {

    public int myAtoi(String str) {

        char[] chars = str.toCharArray();
        int n = str.length();
        int index = 0;

        while (index < n && chars[index] == ' ') {//去除前置的空格
            index++;
        }

        if (index == n) {//前置空格取出后，字符串为空，则返回0
            return 0;
        }

        boolean negative = false;//标记是否为负数

        if (chars[index] == '-') {//判断数字开头的符号
            negative = true;
            index++;
        } else if (chars[index] == '+') {
            index++;
        } else if (!Character.isDigit(chars[index])) {
            return 0;
        }

        int rst = 0;

        while (index < n && Character.isDigit(chars[index])) {//遍历字符串
            int digit = Character.getNumericValue(chars[index]);//获取数字
            if (rst > (Integer.MAX_VALUE - digit) / 10) {//rst * 10 + digit > Integer.MAX_VALUE
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            rst = rst * 10 + digit;
            index++;
        }
        return negative ? -rst : rst;
    }
}
