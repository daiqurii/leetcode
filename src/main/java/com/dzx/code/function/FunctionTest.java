package com.dzx.code.function;

import java.util.function.Function;

public class FunctionTest {
    public static void main(String[] args) {
        Function<Integer,Integer> addHandler = (a)->{
            return a+10;
        };
        System.out.println(addHandler.apply(5));
    }

}
