//Time Complexity - O(n)

import java.util.*;
public class Main {
    private int[]  printProductSum(int [] arr) {
        int size = arr.length;

        if (size == 1) return arr;

        int i;
        int[] leftProductArr = new int[size];
        int[] rightProdutArr = new int[size];

        leftProductArr[0] = arr[0];
        for(i = 1;i<size;i++){
            leftProductArr[i] = leftProductArr[i-1]*arr[i];
        }
        rightProdutArr[size-1] = arr[size-1];
        for(i = size-2;i>=0;i--){
            rightProdutArr[i] = rightProdutArr[i+1]*arr[i];
        }

        arr[0] = rightProdutArr[1];

        arr[size - 1] = leftProductArr[size - 2];

        for (i = 1; i < size - 1; i++) {
            arr[i] = leftProductArr[i - 1] * rightProdutArr[i + 1];

        }
        return arr;

    }
        private void printArray(int [] arr) {
            for(int i : arr) {
                System.out.print(i +" ");
            }
            System.out.println();
        }
        public static void main (String [] args) throws Exception {
            Main ps =  new Main();
            int [] arr = new int [] {-1,1,0,-3,3};
            ps.printArray(arr);
            ps.printArray(ps.printProductSum(arr));
        }


    }
