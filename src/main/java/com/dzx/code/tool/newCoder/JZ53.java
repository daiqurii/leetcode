package com.dzx.code.tool.newCoder;

public class JZ53 {
    public static void main(String[] args) {
        int[] A = new int[]{3,3,3,3};
        int number = GetNumberOfK(A, 3);
        System.out.println(number);
    }

    public static int GetNumberOfK(int[] array, int k) {
        //二分查找左右边界复习
        int left = 0, right = array.length - 1;
        //找左边界
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] < k) {
                left = mid + 1;
            } else if (array[mid] > k) {
                right = mid - 1;
            } else {
                right = mid - 1;
            }
        }
        int leftbound = left;
        left = 0;
        right = array.length - 1;
        //找右边界
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] < k) {
                left = mid + 1;
            } else if (array[mid] > k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        int rightbound = right;
        return rightbound - leftbound + 1;
    }
}
