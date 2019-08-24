package com.shoufeng.array.question3;

import java.util.Arrays;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 *
 * @author shoufeng
 */
public class Solution {
    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        int[] B = new int[A.length];
        int[] left = getLeftArray(A);
        int[] right = getRightArray(A);
        for (int i = 0; i < B.length; i++) {
            B[i] = left[i]*right[i];

        }
        return B;
    }

    public static int[] getLeftArray(int[] arr){
        int[] resultArray = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            if (i == arr.length -1){
                resultArray[i] = 1;
            }else {
                resultArray[i] = resultArray[i+1]*arr[i+1];
            }
        }
        return resultArray;
    }

    public static int[] getRightArray(int[] arr){
        int[] resultArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i-1<0){
                resultArray[i] = 1;
            }else {
                resultArray[i] = resultArray[i-1]*arr[i-1];
            }
        }
        return resultArray;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5};
//        System.out.println(Arrays.toString(multiply(A)));
    }
}
