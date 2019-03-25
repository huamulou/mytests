package com.algo;

@SuppressWarnings("ALL")
public class Util {

    public final static void printArray(Object[] array) {
        if (array == null) {
            System.out.println("null");
        } else {
            StringBuilder out = new StringBuilder();
            out.append("[");
            for (int i = 0; i < array.length; i++) {
                out.append(array[i]);
                if (i != array.length - 1) {
                    out.append(", ");
                }
            }
            out.append("]");
            System.out.println(out.toString());
        }
    }

    public final static void printArray(int[] array) {
        if (array == null) {
            System.out.println("null");
        } else {
            StringBuilder out = new StringBuilder();
            out.append("[");
            for (int i = 0; i < array.length; i++) {
                out.append(array[i]);
                if (i != array.length - 1) {
                    out.append(", ");
                }
            }
            out.append("]");
            System.out.println(out.toString());
        }
    }
}
