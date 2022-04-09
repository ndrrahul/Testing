package core;

//import sun.awt.util.PerformanceLogger;

import java.io.*;
import java.util.*;

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

        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
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

    public static int sockPair(String[] arrPair) {
        // Write your code here
        Date timer = new Date();
        long current = timer.getTime();
        int temp = 0;
        String[] arr = arrPair;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i].equals("b") && arr[j].equals("b")){
                    temp  = temp + 1;
                }
//                System.out.println(arr[i] + " : " + arr[j]);
            }
        }
//        System.out.println("Performance = " + (current));
        Date timer2 = new Date();
        System.out.println("Performance = " + temp + "--"+ (timer2.getTime() - current));
        return temp;
    }
}

class Solution {
//    private static Object Arrays;

    public static void main(String[] args) throws IOException {

//        List<Integer> ar = new ArrayList<>();
//        4 5 5 5 6 6 4 1 4 4 3 6 6 3 6 1 4 5 5 5
//        ar.add(4);
//        ar.add(5);
//        ar.add(5);
//        ar.add(5);
//        ar.add(6);
//        ar.add(6);
//        ar.add(4);
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
//        ar.add(5);
//        ar.add(5);
//        ar.add(6);
//        int result = Result.sockMerchant(20, ar);
        String[] arr = new String[1000];
        for(int i =0; i< arr.length; i++){

            if (i%7 == 0){
                arr[i] = "b";
            }
            else
            {
                arr[i] = "a";
            }
        }
        int result = Result.sockPair(arr);
    }
}