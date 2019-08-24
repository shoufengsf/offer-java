package com.shoufeng.array.question1;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * @author shoufeng
 */
public class Solution {
    public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0){
            return false;
        }
        //列的长度
        int len1 = array.length;
        //列的长度
        int len2 = array[0].length;
        for (int i = 0; i < len1; i++) {
            if (array[i][len2 - 1] < target) continue;
            if (array[i][0] > target) {
                return false;
            }
            for (int i1 = 0; i1 < len2; i1++) {
                if (array[i][i1] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
