package com.manoj.sorting;

import java.util.Scanner;

public class SelectionSort {
    public static void main(String args[]) throws Exception {

        //This block is basically to convert string array to integer Array
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        String[] inputConstraints = name.split(" ");
        int N = Integer.parseInt(inputConstraints[0]);
        String[] inputElements = s.nextLine().split(" ");
        int[] intArray = new int[inputElements.length];
        for (int i = 0; i < inputElements.length; i++)
        {
            intArray[i] = Integer.parseInt(inputElements[i]);

        }

        // This block has the sorting logic
        for (int j = 0; j < intArray.length; j++) {

            int minimumNumber = j;
            for (int k = j; k < intArray.length; k++) {
                if (intArray[k] < intArray[minimumNumber]) {
                    minimumNumber = k;
                }
            }
            intArray[j] = intArray[minimumNumber];

        }
        StringBuilder str = new StringBuilder();
        for (int input : intArray) {
            str.append(input);
            str.append(" ");
        }
        ///final output
        System.out.println(str.toString());
    }
}
