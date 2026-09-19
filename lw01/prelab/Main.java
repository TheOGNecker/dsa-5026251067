import java.util.*;

public class Main {
        public static void main(String[] args){
                System.out.println("Current working directory: " + new java.io.File(".").getAbsolutePath());

                Scanner sc = new Scanner(Main.class.getResourceAsStream("lw01/prelab/jobs.txt"));

                List<PrintJob> jobs = new ArrayList<>();

                while (sc.hasNext()){
                        String type = sc.next();
                        String id = sc.next();
                        int pages = sc.nextInt();

                        if (type.equals("COLOUR")){
                                jobs.add(new ColourPrint(id, pages));

                        } else if (type.equals("MONO")){
                                jobs.add(new MonoPrint(id, pages));
                        }
                }
                for (PrintJob job : jobs){
                        System.out.println(job.summary());
                }
                sc.close();
        }
        
}
