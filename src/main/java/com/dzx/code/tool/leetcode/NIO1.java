package com.dzx.code.tool.leetcode;

import java.util.Scanner;

public class NIO1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int count = count(n, x);
        System.out.println(count);
    }
    public static int check(int n, int d)
    {
        int res = 0;
        while (n > 0)
        {
            if (n % 10 == d) res++;
            n /= 10;
        }
        return res;

    }
    public static int count(int n, int x)
    {
        //如果n为个位数了 就看看n是不是大于x 是的话就加1
        if (n < 10) return (x > 0 && n >= x)?1:0;

        if (n % 10 != 9) return check(n, x) + count(n - 1, x);
        //如果n最后一位为9 那么个位肯定能涵盖，即((x > 0)?1:0)， n/10表示十位有几个就可以有几个个位上的x ，10 * count(n / 10, x)表示原本十位上的
        return 10 * count(n / 10, x) + n / 10 + ((x > 0)?1:0);
    }


}
