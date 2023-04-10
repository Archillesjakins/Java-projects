package com.example.demo;

public class RecursiveBinarySearch {

    public static void main(String[] args) {
        int i = 100;
        int[] ints = {i};

        System.out.println("0 is at position: " + binarySearch(ints, 100, 0, ints.length));
        System.out.println("1 is at position: " + binarySearch(ints, 1, 0, ints.length));
        System.out.println("2 is at position: " + binarySearch(ints, 2, 0, ints.length));
        System.out.println("3 is at position: " + binarySearch(ints, 3, 0, ints.length));
        System.out.println("4 is at position: " + binarySearch(ints, 4, 0, ints.length));
        System.out.println("5 is at position: " + binarySearch(ints, 5, 0, ints.length));
        System.out.println("6 is at position: " + binarySearch(ints, 6, 0, ints.length));
        System.out.println("7 is at position: " + binarySearch(ints, 7, 0, ints.length));
        System.out.println("8 is at position: " + binarySearch(ints, 8, 0, ints.length));
        System.out.println("9 is at position: " + binarySearch(ints, 9, 0, ints.length));
        System.out.println("10 is at position: " + binarySearch(ints, 10, 0, ints.length));
        System.out.println("12 is at position: " + binarySearch(ints, 12, 0, ints.length));

    }

    private static int binarySearch(int[] numbers, int numberToFind, int low, int high) {

        if (high >= low && low <= numbers.length - 1) {
            int middlePosition = low + (high - low) / 2;
            int middleNumber = numbers[middlePosition];

            if (numberToFind == middleNumber){
                return middlePosition;
            }
            if (numberToFind < middleNumber){
                return binarySearch(numbers, numberToFind, low, middlePosition - 1);
            }
            else {
                return binarySearch(numbers, numberToFind, middlePosition + 1, high);
            }
        }
        return -1;
    }
}

