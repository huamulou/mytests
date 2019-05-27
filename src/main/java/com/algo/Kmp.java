package com.algo;

public class Kmp {
    /**
     * 求出一个字符数组的next数组
     *
     * ababa 的前缀是  a  ab  aba abab
     * 后缀是 a ba aba baba
     * 由于最长匹配的前后缀长度和他的数组序号是匹配的，所以k = next[k]就是为了跳到最长匹配的段前面开始重新匹配
     * 减少了暴力检索的长度
     *
     * @param t 字符数组
     * @return next数组
     */
    public static int[] getNextArray(char[] t) {
        int[] next = new int[t.length];
        next[0] = -1;
        next[1] = 0;
        int k;//这个为最长匹配段的长度
        for (int j = 2; j < t.length; j++) {
            k = next[j - 1];
            while (k != -1) {
                if (t[j - 1] == t[k]) {
                    next[j] = k + 1;
                    break;
                } else {
                    k = next[k];
                }
                next[j] = 0;  //当k==-1而跳出循环时，next[j] = 0，否则next[j]会在break之前被赋值
            }
        }
        return next;
    }

    /**
     * 对主串s和模式串t进行KMP模式匹配
     *
     * @param s 主串
     * @param t 模式串
     * @return 若匹配成功，返回t在s中的位置（第一个相同字符对应的位置），若匹配失败，返回-1
     */
    public static int kmpMatch(String s, String t) {
        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();
        int[] next = getNextArray(t_arr);
        int i = 0, //这个为被搜索的字符串的位置
                j = 0;//这个为最长匹配段的长度
        while (i < s_arr.length && j < t_arr.length) {
            if (j == -1 || s_arr[i] == t_arr[j]) {
                i++;
                j++;
            } else {
                System.out.println(String.format("start i:j,  %s:%s", i, j));
                j = next[j];
                System.out.println(String.format("end   i:j,  %s:%s", i, j));
            }
        }
        if (j == t_arr.length)
            return i - j;
        else
            return -1;
    }

    public static void main(String[] args) {
        System.out.println(kmpMatch("12abaabaabababca", "abababca"));
    }

}
