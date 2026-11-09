package lw04.unguided;

import java.util.*;

public class Main {
        //pakai selection sort karena ambil paling kecil
        public static void main (String[] args){
                Scanner sc1 = new Scanner(Main.class.getResourceAsStream("cards.txt"));
                Scanner sc2 = new Scanner(Main.class.getResourceAsStream("cards2.txt"));

                //cards.txt
                int N1 = sc1.nextInt();
                int[] array1 = new int[N1];
                for (int i = 0; i < N1; i++){
                        array1[i] = sc1.nextInt();
                }
                int M1 = sc1.nextInt();
                int[] targets1 = new int[M1];
                for (int i = 0; i < M1; i++){
                        targets1[i] = sc1.nextInt();
                }
                sc1.close();
                sortCards(array1, 2);
                for (int i = 0; i < array1.length; i++){
                        System.out.print(array1[i]);
                        if (i < array1.length - 1) System.out.print(" ");
                }
                System.out.println();
                for (int t : targets1){
                        int findCardResult = findCard(array1, t);
                        if (findCardResult != -1){
                                System.out.println(t + ": FOUND at index " + findCardResult);
                        }
                        else System.out.println(t + ": NOT FOUND");
                }

                //cards2.txt
                int N2 = sc2.nextInt();
                int[] array2 = new int[N2];
                for (int i = 0; i < N2; i++){
                        array2[i] = sc2.nextInt();
                }
                int M2 = sc2.nextInt();
                int[] targets2 = new int[M2];
                for (int i = 0; i < M2; i++){
                        targets2[i] = sc2.nextInt();
                }
                sc2.close();
                sortCards(array2, 2);
                for (int i = 0; i < array2.length; i++){
                        System.out.print(array2[i]);
                        if (i < array2.length - 1) System.out.print(" ");
                }
                System.out.println();
                for (int t : targets2){
                        int findCardResult = findCard(array2, t);
                        if (findCardResult != -1){
                                System.out.println(t + ": FOUND at index " + findCardResult);
                        }
                        else System.out.println(t + ": NOT FOUND");
                }

        }

        static void sortCards(int[] arr, int passes){
                for (int i = 0; i < passes; i++){
                        int min = arr[i];
                        int minIndex = i;
                        for (int j = i + 1; j < arr.length; j++){
                                if (arr[j] < min){
                                        min = arr[j];
                                        minIndex = j;
                                }
                        }
                        int temp = arr[i];
                        arr[i] = min;
                        arr[minIndex] = temp;
                }
        }

        static int findCard(int[] arr, int target){
                for (int i = 0; i < arr.length; i++){
                        if (arr[i] == target) return i;
                }
                return -1;
        }
}
