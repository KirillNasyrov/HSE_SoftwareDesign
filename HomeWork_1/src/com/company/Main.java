package com.company;

public class Main {

    public static void main(String[] args) {
        factorial(3);
    }
    //Задача 1
    public static void Ex1() {
        for (int i = 1; i <= 100; ++i) {
            if (i % 15 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else {
                System.out.println(i);
            }
        }
    }

    //Задача 2
    static void fibonacci(int num) {
        int first = 0;
        int second = 1;
        int third = 1;
        if (num == 0) {
            System.out.println(0);
        } else if (num == 1) {
            System.out.println(1);
        } else {
            for (int i = 0; i < num - 1; ++i) {
                third = first + second;
                first = second;
                second = third;
            }
            System.out.println(third);
        }
    }

    //Задача 3
    static void factorial(int num) {
        int rez = 1;
        for (int i = 2; i <= num; ++i) {
            rez *= i;
        }
        System.out.println(rez);
    }

    static void bubbleSort(int[] arr) {
        int size = arr.length;
        int temp;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
