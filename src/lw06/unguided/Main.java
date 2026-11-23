package lw06.unguided;

import java.util.Scanner;

public class Main {
        public static void main(String[] args){
                Scanner read = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));
                String[] numbers = read.nextLine().split(" ");
                int target = read.nextInt();

                read.close();

                BinarySearchTree tree = new BinarySearchTree();
                for (String number : numbers){
                        tree.insert(Integer.parseInt(number));
                }
                
                System.out.print("Preorder : ");
                tree.preOrder();
                System.out.print("Inorder : ");
                tree.inOrder();
                System.out.print("Postorder : ");
                tree.postOrder();
                System.out.println("Search 50 : " + tree.search(target));
                System.out.println("Minimum : " + tree.findMin());
                System.out.println("Maximum : " + tree.findMax());
        }
}

