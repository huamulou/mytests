package com.algo;

public class MyKmpMatch {


    //1. 计算match的pmt表
    //2. 使用pmt表检索
    private  int kmpMatch(String source, String match) {
        char[] sArr = source.toCharArray();
        char[] mArr = match.toCharArray();

        int[] pmtTable = this.pmtTable(mArr);

        int i = 0, j = 0;

        while (i < sArr.length && j < mArr.length) {
            if(j == -1 ||sArr[i] == mArr[j]){
                i++;
                j++;
            }else {
                j = pmtTable[j];
            }

        }

        if(j == mArr.length){
            return i-j;
        }else {
            return -1;
        }
    }


    //1. 初始化0为-1， 1为0
    //2. 从2开始遍历，如果match则加一
    //3. 如果不match则回到最长反向串的开始位置
    private int[] pmtTable(char[] match) {
        int[] result = new int[match.length];

        result[0] = -1;
        result[1] = 0;

        int k = 0;

        for (int j = 2; j < match.length; j++) {
            k = result[j - 1];
            while (k != -1) {
                if (match[j - 1] == match[k]) {
                    result[j] = k + 1;
                    break;
                } else {
                    k = result[k];
                }
                result[j] = 0;  //当k==-1而跳出循环时，next[j] = 0，否则next[j]会在break之前被赋值
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MyKmpMatch().kmpMatch("12abaabaabababca", "abababca"));
    }

}
