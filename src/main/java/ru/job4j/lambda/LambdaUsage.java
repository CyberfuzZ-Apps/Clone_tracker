package ru.job4j.lambda;

import java.util.Comparator;

public class LambdaUsage {
    public static void main(String[] args) {
        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("Compare - " + right.length()
                    + " : " + left.length());
            return right.length() - left.length();
        };
    }
}
