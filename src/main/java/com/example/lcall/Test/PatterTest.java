package com.example.lcall.Test;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class PatterTest {


        public static void main(String[] args) {
            // 输入的字符串，包含多个手机号
            String input = "request msg is some content body \"18604090617 additional text 13512345678 more content 19987654321";

            // 正则表达式，匹配11位手机号
            String regex = "(\\d{3})\\d{4}(\\d{4})";

            // 使用正则替换所有手机号中间四位为星号
            String maskedInput = input.replaceAll(regex, "$1****$2");

            // 输出结果
            System.out.println(maskedInput);
        }
    }