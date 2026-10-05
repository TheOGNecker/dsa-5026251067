package lw02.unguided;

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(Main.class.getResourceAsStream("borrowing.txt"));
        
        LinkedList<String[]> requests = new LinkedList<>();
        LinkedList<String[]> bookStocks = new LinkedList<>();
        LinkedList<String[]> members = new LinkedList<>();
        
        Queue<String[]> queue = new LinkedList<>(); 
        Stack<String[]> failed = new Stack<>();
        int MAX_BORROW = 2;

        while(sc.hasNext()){
            String[] request = new String[2];
            request[0] = sc.next();
            request[1] = sc.next();
            requests.add(request);
        }
        sc.close();

        bookStocks.add(new String[]{"Kalkulus", "2"});
        bookStocks.add(new String[]{"Fisika", "1"});
        bookStocks.add(new String[]{"Statistika", "2"});
        
        queue.addAll(requests);
        requests.clear(); 

        while(!queue.isEmpty()){
            String[] request = queue.poll();
            String name = request[0];
            String currentBook = request[1];

            String[] currentMember = null;
            for(String[] data : members){
                if(data[0].equals(name)){
                    currentMember = data;
                    break;
                }
            }

            if(currentMember == null){
                currentMember = new String[]{name, "0"};
                members.add(currentMember);
            }

            String[] currentBookData = null;
            for(String[] data : bookStocks){
                if(data[0].equals(currentBook)){
                    currentBookData = data;
                    break;
                }
            }        

            int stock = Integer.parseInt(currentBookData[1]);
            int borrowed = Integer.parseInt(currentMember[1]);
            
            
            if(stock > 0 && borrowed < MAX_BORROW){
                stock--;
                borrowed++;
                currentBookData[1] = String.valueOf(stock);
                currentMember[1] = String.valueOf(borrowed);
                
                requests.add(request); 
            } else {
                failed.push(request);
            }
        }
        
        System.out.println("\n=== Successfully Processed Requests ===");
        for(String[] request : requests){
            System.out.println(request[0] + " " + request[1]);
        }

        System.out.println("\n=== Remaining Book Stock ===");
        for(String[] book : bookStocks){
            System.out.println(book[0] + ": " + book[1]);
        }

        System.out.println("\n=== Failed Requests ===");
        while(!failed.isEmpty()){
            String[] request = failed.pop();
            System.out.println(request[0] + " " + request[1]);
        }
    }
}