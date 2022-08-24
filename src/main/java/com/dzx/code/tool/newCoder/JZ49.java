package com.dzx.code.tool.newCoder;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class JZ49 {
    public int GetUglyNumber_Solution(int index) {
        if(index <= 6) return index;
        int[] res = new int[index];
        int i2 = 0,i3 = 0, i5 = 0;
        res[0] = 1;
        for (int i = 1; i < index; i++) {
            //这里 i2 i3 i5 相当于三个独立的index 都从0开始增加 非常重要！！！
            res[i] = Math.min(res[i2] * 2,Math.min(res[i3] * 2, res[i5] * 2));
            if(res[i] == res[i2]*2)
                i2++;
            if(res[i] == res[i3]*3)
                i3++;
            if(res[i] == res[i5]*5)
                i5++;

        }
        return res[index-1];

    }
}
