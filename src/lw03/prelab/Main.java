package lw03.prelab;

import java.util.*;

public class Main {
        public static void main(String[] args){
                //=========================Problem 1 Solution==========================
                Scanner scPlaylist = new Scanner(Main.class.getResourceAsStream("playlist.txt"));
                List<String> playlist = new ArrayList<>();
                while (scPlaylist.hasNextLine()){
                        String input = scPlaylist.nextLine();
                        String[] parts = input.split(" ", 2);
                        String operation = parts[0];
                        String song = parts[1];
                        if (operation.equals("ADD")){
                                playlist.add(song);
                        }
                        else if (operation.equals("INSERT")){
                                String[] insertParts = song.split(" ", 2);
                                int index = Integer.parseInt(insertParts[0]);
                                String songName = insertParts[1];
                                playlist.add(index, songName);
                        }
                        else if (operation.equals("REMOVE")){
                                playlist.remove(song);
                        }
                }

                scPlaylist.close();

                System.out.println("===== Problem 1 =====");
                System.out.println("Total songs: " + playlist.size());
                for (int i = 0; i < playlist.size(); i++){
                        System.out.println((i + 1) + ": " + playlist.get(i));
                }
                

                //=========================Problem 2 Solution==========================
                Scanner scParticipants = new Scanner(Main.class.getResourceAsStream("participants.txt"));
                
                Set<String> participants = new LinkedHashSet<>();
                int duplicateCount = 0;
                while (scParticipants.hasNext()){
                        String participant = scParticipants.next();
                        if (!participants.add(participant)){
                                duplicateCount++;
                        }
                }

                scParticipants.close();

                System.out.println("\n===== Problem 2 =====");
                System.out.println("Unique participants: " + participants.size());
                int i = 1;
                for (String participant : participants){
                        System.out.println((i) + ". " + participant);
                        i++;
                }
                System.out.println("Duplicate registrations: " + duplicateCount);
                
                
                //=========================Problem 3 Solution==========================
                Scanner scInventory = new Scanner(Main.class.getResourceAsStream("inventory.txt"));
                
                Map<String, Integer> inventory = new LinkedHashMap<>();
                int failedSales = 0;while (scInventory.hasNextLine()){
                        String input = scInventory.nextLine();
                        String[] inputParts = input.split(" ", 3);
                        String operation = inputParts[0];
                        String item = inputParts[1];
                        int quantity = Integer.parseInt(inputParts[2]);
                        
                        if (operation.equals("ADD")){
                                if(inventory.containsKey(item)){
                                        inventory.put(item, inventory.get(item) + quantity);
                                } else {
                                        inventory.put(item, quantity);
                                }
                        }
                        else if (operation.equals("SELL")){
                                if(inventory.containsKey(item)){
                                        int currentQuantity = inventory.get(item);
                                        if (currentQuantity >= quantity){
                                                inventory.put(item, (currentQuantity - quantity));
                                        }
                                        else {
                                                failedSales++;
                                        }
                                }
                                else {
                                        failedSales++;;
                                }
                        }
                }
                scInventory.close();

                System.out.println("\n===== Problem 3 =====");
                for (String item : inventory.keySet()){
                        System.out.println(item + ": " + inventory.get(item));
                }
                System.out.println("Failed sales: " + failedSales);                
        }
}
