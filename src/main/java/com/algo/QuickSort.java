package com.algo;

import java.util.Random;

public class QuickSort {

    public static void quickSort(int[] a, int left, int right) {
        int value = a[left];
        int l = left, r = right;

        while (l < r) {
            //从右边开始扫描
            while (l < r && a[r] >= value) {
                r--;
            }
            //这个时候出现了right比left小的情况
            if (l < r) {
                a[l] = a[r]; //left与right的值交换
                l++;
            }
            //从左边开始扫描
            while (l < r && a[l] <= value) {
                l++;
            }
            //这个时候出现了left比right大的情况
            if (l < r) {
                a[r] = a[l];
                r--;
            }

            a[l] = value;
        }

        if (l > left + 1) {
            quickSort(a, left, l - 1);
        }
        if (r < right -1) {
            quickSort(a, r + 1, right );
        }

    }


    public static int chooseIndex(int[] input) {
        return new Random().nextInt(input.length);
    }

    public static void main(String[] args) {

        int[] array = new int[]{3, 2, 3, 4, 5, 6, 7, 3, 2, 1, 5, 9};
        int index = chooseIndex(array);
        System.out.println(index);
        Util.printArray(array);
        quickSort(array, 0, array.length -1);
        Util.printArray(array);
        System.out.println(array.length);
    }
}
