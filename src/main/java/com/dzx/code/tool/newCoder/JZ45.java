package com.dzx.code.tool.newCoder;

import java.util.Arrays;
import java.util.Comparator;

public class JZ45 {
    public String PrintMinNumber(int[] numbers) {
        String[] nums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(nums,(a,b)->{
            return (a+b).compareTo(b+a);
        });
        StringBuffer buffer = new StringBuffer();
        for(String s:nums){
            buffer.append(s);
        }
        return buffer.toString();
    }
}
