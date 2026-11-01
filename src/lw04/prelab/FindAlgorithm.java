package lw04.prelab;
import java.util.*;

public class FindAlgorithm {
        public static void main(String[] args){
                Scanner sc = new Scanner(FindAlgorithm.class.getResourceAsStream("test.txt"));
                
                List<Integer> list = new LinkedList<>();

                while(sc.hasNextInt()){
                        list.add(sc.nextInt());
                }
                sc.close();
                
                int[] array = new int[list.size()];
                for(int i = 0; i < list.size(); i++){
                        array[i] = list.get(i);
                } 

                // bubbleSort(array);
                // System.out.println("Bubble Sort: " + Arrays.toString(array));

                // selectionSort(array);
                // System.out.println("Selection Sort: " + Arrays.toString(array));
                
                insertionSort(array);
                System.out.println("Insertion Sort: " + Arrays.toString(array));                             
        }

        public static void bubbleSort(int[] array){
                for(int i = 0; i < 3; i++){
                        for(int j = 0; j < array.length - 2 - i; j++){
                                if(array[j] > array[j+1]){
                                        int temp = array[j];
                                        array[j] = array[j+1];
                                        array[j+1] = temp;
                                }
                        }
                }
        }

        public static void selectionSort(int[] array){
                for(int i = 0; i < 3; i++){
                        int maxIndex = i;
                        for(int j = i + i; j < array.length; j++){
                                if (array[j] > array[maxIndex]){
                                        maxIndex = j;
                                }
                        }
                        int temp = array[maxIndex];
                        array[maxIndex] = array[i];
                        array[i] = temp;
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

