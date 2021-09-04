package core;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        int cnt = 0;
        List<Integer> arr = ar;

        for (int i = 0; i < arr.size() ; i++) {
            for (int j = i + 1; j < arr.size() ; j++) {
                if (arr.get(i) == arr.get(j)) {
                    cnt = cnt + 1;
                    arr.remove(j);
                    arr.remove(i);
                    i = -1;
                    // n = arr.size();

                    System.out.println("list : " + arr);
                    System.out.println("n : " + arr.size());
                    System.out.println("cnt :" + cnt);
                    break;
                }
            }

            System.out.println("i : " + i);
        }

        return cnt;
    }

}

class Solution {
    public static void main(String[] args) throws IOException {

        List<Integer> ar = new ArrayList<>();
//        4 5 5 5 6 6 4 1 4 4 3 6 6 3 6 1 4 5 5 5
//        ar.add(4);
//        ar.add(5);
//        ar.add(5);
//        ar.add(5);
//        ar.add(6);
        ar.add(6);
        ar.add(4);
//        ar.add(1);
//        ar.add(4);
//        ar.add(4);
//        ar.add(3);
//        ar.add(6);
//        ar.add(6);
//        ar.add(3);
//        ar.add(6);
//        ar.add(1);
//        ar.add(4);
        ar.add(5);
        ar.add(5);
//        ar.add(6);
        int result = Result.sockMerchant(20,ar);
    }
}
