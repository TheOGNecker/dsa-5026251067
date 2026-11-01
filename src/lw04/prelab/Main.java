package lw04.prelab;
import java.util.Scanner;

//pakai insertion sort
public class Main {
        public static void main(String[] args){
                Scanner sc = new Scanner(Main.class.getResourceAsStream("branches.txt"));

                int branchesSize = sc.nextInt();
                int[] branches = new int[branchesSize];
                for(int i = 0; i < branchesSize; i++){
                        branches[i] = sc.nextInt();
                }
                int targetAmount = sc.nextInt();
                int[] targets = new int[targetAmount];
                for(int i = 0; i < targetAmount; i++){
                        targets[i] = sc.nextInt();
                }
                sc.close();

                insertionSort(branches);
                
                for(int i = 0; i < branchesSize; i++){
                        System.out.print(branches[i] + " ");
                }

                System.out.println();
                
                for(int i = 0; i < targetAmount; i++){
                        boolean found = false;
                        int foundIndex = 0;
                        for(int j = 0; j < branchesSize; j++){
                                if(targets[i] == branches[j]){
                                        found = true;
                                        foundIndex = j;
                                }
                        }
                        if (found == true){
                                System.out.println(targets[i] + ": FOUND at index " + foundIndex);
                        }
                        else {
                                System.out.println(targets[i] + ": NOT FOUND");
                        }
                }

        }

        public static void insertionSort(int[] array){
                for(int i = 1; i <= 3; i++){
                        int key = array[i];
                        int j = i - 1;

                        while(j >= 0 && array[j] < key){
                                array[j + 1] = array[j];
                                j--;
                        }
                        array[j + 1] = key;
                }
        }
}
