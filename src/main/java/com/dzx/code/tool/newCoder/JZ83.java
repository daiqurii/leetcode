package com.dzx.code.tool.newCoder;

public class JZ83 {
    //剪绳子
    public static void main(String[] args) {

    }

    public long cutRope(long number) {
        // write code here
        //尽可能分成多个3 最接近自然指数e
        // 快速幂
        if (number == 2) {
            return 1;
        } else if (number == 3) {
            return 2;
        }
        long res = number % 3;
        long n = 0;
        if (res == 1) {
            n = number / 3 - 1;
            return quickIndex(n) * 4 % 998244353;
        } else if (res == 2) {
            n = number / 3;
            return quickIndex(n) * 2 % 998244353;
        } else {
            n = number / 3;
            return quickIndex(n);
        }


    }

    public long quickIndex(long n) {
        if (n == 0) return 1L;
        if (n == 1) return 3L;
        if (n % 2 == 1) {
            long temp = quickIndex(n / 2) % 998244353;
            return (temp * temp * 3) % 998244353;
        } else {
            long temp = quickIndex(n / 2) % 998244353;
            return (temp * temp) % 998244353;
        }
    }
}
