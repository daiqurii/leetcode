package com.dzx.code.tool.newCoder;

import java.util.ArrayList;
import java.util.Collections;

public class JZ74 {
    public static void main(String[] args) {

    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        // 分奇偶判断 不是太好的方法 时间复杂度(n2) 空间复杂度temp n1/2
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 2; i * i < 2 * sum; i++) {
            if (sum % i == 0 && i % 2 == 1) {
                int num = sum / i;
                ArrayList<Integer> list = new ArrayList<>();
                for (int j = num - i / 2; j <= num + i / 2; j++) {
                    list.add(j);
                }
                res.add(list);
            } else if (sum % i == i / 2 && i % 2 == 0) {
                int num = sum / i;
                ArrayList<Integer> list = new ArrayList<>();
                for (int j = num - i / 2 + 1; j <= num + i / 2; j++) {
                    list.add(j);
                }
                res.add(list);
            }
        }
        Collections.sort(res, (a, b) -> (a.get(0) - b.get(0)));
        return res;
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence2(int sum) {
        //滑动窗口
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int l = 1, r = 2; l < r; ) {
            int sum1 = (l + r) * (r - l + 1) / 2;
            if (sum1 == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = l; i <= r; i++) {
                    list.add(i);
                }
                res.add(list);
                l++;
            } else if (sum1 < sum) {
                r++;
            } else {
                l++;
            }
        }
        return res;
    }
}
