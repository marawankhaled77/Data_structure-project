import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PatientManagementSystem system = new PatientManagementSystem();
        system.addPatient("Ahmed",20,"10/11/2024","10AM","Schedule","el7","1","011134524",5);

        system.addPatient("Mohamed",18,"10/5/2024","12PM","Schedule","diagno","7","01112404",7);

        system.addPatient("Hassaneen",14,"17/7/2024","8AM","Schedule","magnes","4","01234824",4);

        system.addPatient("Hossam",54,"5/5/2024","6PM","Schedule","zart","6","01578914524",2);

        system.addToWaitingList(1);

        system.addToWaitingList(2);

        system.addToWaitingList(3);

        system.addToWaitingList(4);
        System.out.println("Welcome to Hospital Management System");
        Scanner input = new Scanner(System.in);
        int choose1 = input.nextInt();;
        while (choose1 != -1){
            choose1 = input.nextInt();
            System.out.println("press -1 to exit");
        switch (choose1) {
            case 1:
                System.out.println("press 1 to add patient" + "\npress 2 to set schedule appointment" + "\npress 3 to reschedule appointment" + "\n press 4 to cancel appointment" + "\n press 5 to generate patient report" +
                        "\npress 6 to add bill for patient" + "\npress 7 to generate bill for patient"+"\n press 8 to see waiting list") ;
                int ch1 = input.nextInt();
                if (ch1 == 1) {

                    System.out.println("enter patient name");
                    String name = input.next();
                    System.out.println("enter patient age");
                    int age = input.nextInt();
                    System.out.println("enter date for patient to schedule");
                    String date = input.nextLine();
                    input.nextLine();
                    System.out.println("enter time for patient to schedule");
                    String time = input.nextLine();
                    System.out.println("enter the medical history for the patient");
                    String medical = input.nextLine();
                    System.out.println("enter the visit records for the patient");
                    String visit = input.nextLine();
                    System.out.println("enter the contact details for the patient");
                    String contact = input.nextLine();
                    System.out.println("enter periority of the case in scale from 1 to 10");
                    int per = input.nextInt();
                    System.out.println("If you want fast Entry press 1");
                    int ch = input.nextInt();
                    if (ch == 1) {
                        per = 10;
                    }
                    System.out.println("the patient added to waiting list successfully");
                    system.addPatient(name, age, date, time, "Schedule", medical, visit, contact, per);


                } else if (ch1 == 2) {
                    System.out.println("enter patient id");
                    int id = input.nextInt();
                    System.out.println("enter date for patient to schedule");
                    String date = input.next();
                    System.out.println("enter time for patient to schedule");
                    String time = input.next();
                    system.scheduleAppointment(id, date, time);

                } else if (ch1 == 3) {

                    System.out.println("enter patient id");
                    int id = input.nextInt();
                    System.out.println("enter date for patient to Reschedule");
                    String date = input.next();
                    input.nextLine();
                    System.out.println("enter time for patient to Reschedule");
                    String time = input.nextLine();
                    System.out.println("Please enter the Appointment ID you want to Reschedule");
                    int appointmentID = input.nextInt();
                    system.RescheduleAppointment(id, date, time, appointmentID);
                } else if (ch1 == 4) {
                    System.out.println("enter patient id");
                    int id = input.nextInt();
                    System.out.println("enter appointment id");
                    int appointmentID = input.nextInt();
                    system.cancelAppointment(id, appointmentID);
                } else if (ch1 == 5) {
                    System.out.println("enter patient id");
                    int id = input.nextInt();
                    system.generateReport(id);
                } else if (ch1 == 6) {
                    System.out.println("enter patient id");
                    int id = input.nextInt();
                    System.out.println("enter the value of bill");
                    int pay = input.nextInt();
                    system.addBillingRecord(id, pay);
                } else if (ch1 == 7) {

                    System.out.println("enter patient id");
                    int id = input.nextInt();
                    System.out.println("enter the value of bill");
                    int pay = input.nextInt();
                    system.generateBilling(pay,id);

                }else if (ch1 == 8) {
                system.WaitingListDisplay();

                }
                break;
            case 2:
                System.out.println("press 1 to view all appointments of hospital \n press 2 to get the Revenue of the Hospital");
                int choose2 = input.nextInt();
                if (choose2 == 1) {
                    system.generateAppointmentRecord();

                } else {
                    system.generateRevnue();
                }

                break;


            default:
                System.out.println("wrong input");
        }
        }




        }
    }








//public static void main(String[] args) {
//    new PatientManagementGUI(); // Launch the GUI
//}