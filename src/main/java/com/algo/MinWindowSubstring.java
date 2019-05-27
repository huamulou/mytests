package com.algo;


import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * <p>
 * Example:
 * <p>
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * Note:
 * <p>
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 * <p>
 * <p>
 * 这道题给了我们一个原字符串S，还有一个目标字符串T，让我们在S中找到一个最短的子串
 * ，使得其包含了T中的所有的字母，并且限制了时间复杂度为 O(n)。
 * 这道题的要求是要在 O(n) 的时间度里实现找到这个最小窗口字串，
 * 那么暴力搜索 Brute Force 肯定是不能用的，因为遍历所有的子串的时间复杂度是平方级的。那么我们想，时间复杂度卡的这么严，说明必须在一次遍历中完成任务，当然遍历若干次也是 O(n)，但不一定有这个必要，尝试就一次遍历拿下！那么再来想，既然要包含T中所有的字母，那么对于T中的每个字母，肯定要快速查找是否在子串中，既然总时间都卡在了 O(n)，我们肯定不想在这里还浪费时间，那么就用空间换时间（也就算法题中可以这么干了，七老八十的富翁就算用大别野也换不来时间啊。依依东望，望的就是时间呐 T.T），使用 HashMap，建立T中每个字母与其出现次数之间的映射
 * ，那么你可能会有疑问，为啥不用 HashSet 呢，别急，讲到后面你就知道用 HashMap 有多妙，简直妙不可言～
 */
public class MinWindowSubstring {


    public static String getMinWindowSubstring(String s, String t) {
        Map index = new HashMap();
        for (int i = 0; i < t.length(); i++) {
            index.put(t.charAt(i), 1);
        }

        int left = 0, cnt = 0, minLen = Integer.MAX_VALUE;
        String res = null;

        for (int i = 0; i < s.length(); i++) {
            if (index.get(s.charAt(i)) != null) {
                index.put(s.charAt(i), (Integer) index.get(s.charAt(i)) - 1);
                if ((Integer) index.get(s.charAt(i)) >= 0)
                    cnt++;
            }
            while (cnt == t.length()) {
                System.out.println("aaa" + left + "s" + i);
                if (minLen > i - left + 1) {
                    minLen = i - left + 1;
                    res = s.substring(left, left + minLen);
                }
                if (index.get(s.charAt(left)) != null) {
                    System.out.println("bbb" + left + "s" + i);
                    index.put(s.charAt(left), (Integer) index.get(s.charAt(left)) + 1);
                    System.out.println(s.substring(left, i));
                    if ((Integer) index.get(s.charAt(left)) > 0) {
                        cnt--;
                    }
                }
                ++left;
            }
        }

        return res;

    }

    public static void main(String[] args) {
        String S = "ADOBECODABCEBANC", T = "ABC";
        System.out.println(getMinWindowSubstring(S, T));
    }
}
