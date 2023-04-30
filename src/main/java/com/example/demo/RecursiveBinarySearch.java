package com.example.demo;

import java.util.Arrays;

public class RecursiveBinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[1000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        Arrays.sort(arr);


        System.out.println(binarySearch(arr, 100, 70, 200));

    }

    private static int binarySearch(int[] numbers, int numberToFind, int low, int high) {

        if (high >= low && low <= numbers.length -1 ) {
            int middlePosition =  (low + high) / 2;
            int middleNumber = numbers[middlePosition];

            if (numberToFind == middleNumber){
                return middlePosition;
            }
            if (numberToFind < middleNumber){
                return binarySearch(numbers, numberToFind, low, middlePosition -1 );
            }
            else {
                return binarySearch(numbers, numberToFind, middlePosition + 1, high);
            }
        }
        return -1;
    }


}

