package com.dzx.code.tool.newCoder;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class JZ51 {
    public static void main(String[] args) {
        int[] arr = {12, 23, 13, 43, 25, 24};
        System.out.println(sort(0, arr.length - 1, arr));
        Arrays.stream(arr).forEach(System.out::println);


    }

    public static int sort(int left, int right, int[] data) {
        int mid = left + (right - left) / 2;
        int temp = 0;
        if (left < right) {
            int a = sort(left, mid, data);
            int b = sort(mid + 1, right, data);
            int c = merge(left, right, data);
            temp = a + b + c;
        }
        return temp;
    }

    public static int merge(int left, int right, int[] data) {
        int[] temp = new int[right - left + 1];
        int mid = left + (right - left) / 2;
        int i = left;
        int j = mid + 1;
        int k = 0;
        int sum = 0;
        while (i <= mid && j <= right) {
            if (data[i] <= data[j]) {
                temp[k++] = data[i++];
            } else {
                sum += (mid-i+1);  //灵魂一步  如果是后半部分的数 则前面还未添加的数全部都要计算一遍
                temp[k++] = data[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = data[i++];
        }
        while (j <= right) {
            temp[k++] = data[j++];

        }
        for (int l = 0; l < temp.length; l++) {
            data[left + l] = temp[l];
        }
        return sum;
    }
}
