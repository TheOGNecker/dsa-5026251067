import java.util.Scanner;

public class Main {
        public static void main(String[] args){
                Scanner sc = new Scanner(Main.class.getResourceAsStream("rentals.txt"));
              
                int n = sc.nextInt();

                Rental[] rentals = new Rental[n];

                for(int i = 0; i < n; i++){
                        String type = sc.next();
                        String id = sc.next();
                        int days = sc.nextInt();
                        int units = sc.nextInt();

                        if(type.equals("PROJECTOR")){
                                Rental rental = new ProjectorRental(id, days);
                                rentals[i] = rental;
                                System.out.println(rentals[i].summary(units));
                        }
                        else {
                                Rental rental = new LaptopRental(id, days);
                                rentals[i] = rental;
                                System.out.println(rentals[i].summary(units));
                        }

                }

                sc.close();
        }
}
