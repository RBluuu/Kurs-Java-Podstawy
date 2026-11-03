package com.java.course.com.lesson79.quicksort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {4,3,21,1,2,3,3,4,2,2,31};
        quicksort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    //quicksort
    public static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partinion(arr, low, high);
            quicksort(arr,low,pivotIndex-1);
            quicksort(arr,pivotIndex+1,high);
        }
    }

    private static int partinion(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
