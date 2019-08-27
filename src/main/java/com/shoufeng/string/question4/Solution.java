package com.shoufeng.string.question4;


import java.util.ArrayList;
import java.util.List;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 *
 * @author shoufeng
 */
public class Solution {

    List<Pair> pairList = new ArrayList<Pair>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        boolean isIn = false;
        for (Pair pair : pairList) {
            if (pair.val == ch) {
                pair.num++;
                isIn = true;
            }
        }
        if (!isIn) {
            pairList.add(new Pair(ch));
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (Pair pair : pairList) {
            if (pair.num == 0) {
                return pair.val;
            }
        }
        return '#';
    }

    public class Pair {
        public Character val;
        public int num;

        public Pair(Character ch) {
            this.val = ch;
        }
    }
}
