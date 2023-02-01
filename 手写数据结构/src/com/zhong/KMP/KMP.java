package com.zhong.KMP;

public class KMP {



    public static int[] getNext(String t) {
        int[] next = null;
        if (!t.equals("") && t != null) {
            next = new int[t.length()+1];
            next[1] = 0;
            int i = 1, k = 0;
            while (i < t.length()) {
                if (k == 0 || t.charAt(i) == t.charAt(k)) {
                    next[++i] = ++k;
                }else {
                    k = next[k-1];
                }
            }
        }else {
            next = new int[]{0};
        }
        return next;
    }

    public static int[] getNextVal(String t) {
        int[] next = null;
        if (!t.equals("") && t != null) {
            next = new int[t.length()+1];
            next[1] = 0;
            int i = 1, k = 0;
            while (i < t.length()) {
                if (k == 0 || t.charAt(i) == t.charAt(k)) {
                    next[++i] = ++k;
                }else {
                    k = next[k-1];
                }
            }
        }else {
            next = new int[]{0};
        }
        return next;
    }




}
