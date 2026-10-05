package lw03.unguided;

import java.util.*;

public class Main {
        public static void main(String[] args) {
                Scanner sc = new Scanner(Main.class.getResourceAsStream("enrollment.txt"));

                Map<String, Integer> enrollment = new LinkedHashMap<>();

                int rejectedOperation = 0;
                while(sc.hasNextLine()){
                        String input = sc.nextLine();
                        String[] parts = input.split(" ", 2);
                        String operation = parts[0];
                        String course = parts[1];
                        //int studentCount = Integer.parseInt(parts[2]);

                        if(operation.equals("REGISTER")){
                                String[] registerParts = course.split(" ", 2);
                                course = registerParts[0];
                                int studentCount = Integer.parseInt(registerParts[1]);
                                if (studentCount <= 0) {
                                        rejectedOperation++;
                                        continue;
                                }
                                else if (enrollment.containsKey(course)){
                                        int currentEnrollmentCount = enrollment.get(course);
                                        enrollment.put(course, currentEnrollmentCount + studentCount);
                                }
                                else {
                                        enrollment.put(course, studentCount);
                                }
                        } 
                        else if(operation.equals("WITHDRAW")) {
                                String[] registerParts = course.split(" ", 2);
                                course = registerParts[0];
                                int studentCount = Integer.parseInt(registerParts[1]);
                                if (enrollment.containsKey(course) && enrollment.get(course) > studentCount) {
                                        int currentEnrollmentCount = enrollment.get(course);
                                        enrollment.put(course, currentEnrollmentCount - studentCount);
                                }
                                else {
                                        rejectedOperation++;
                                }

                        }
                        else if (operation.equals("CHECK")) {
                                if (!enrollment.containsKey(course)) {
                                        enrollment.put(course, 0);
                                }
                        }
                }

                sc.close();

                System.out.println("===== Enrollment Checks =====");
                for (String courseOutput : enrollment.keySet()) {
                        String output1;
                        if (enrollment.get(courseOutput) == 0) {
                                output1 = "Not found";
                        } else {
                                output1 = enrollment.get(courseOutput).toString();
                        }
                        System.out.println(courseOutput + ": " + output1 + " students");
                }

                System.out.println("\n===== Final Enrollment =====");
                for (String courseOutput : enrollment.keySet()) {
                        int output2 = enrollment.get(courseOutput);
                        if (output2 > 0){
                                System.out.println(courseOutput + ": " + output2 + " students");
                        }
                        else {
                                continue;
                        }
                }

                System.out.println("\nRejected operations: " + rejectedOperation);
        }
}

