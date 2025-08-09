public class Appointment {
    // Attributes
    private int appointmentID;
    private String date;
    private String time;
    private String status;
    private static int counter = 0;
    LinkedListSingle single = new LinkedListSingle();
    AVLTree PatientTree;

    // Constructor
    public Appointment(String date, String time, String status) {
        this.appointmentID = generateID();
        this.date = date;
        this.time = time;
        this.status = status;


    }
    public Patient findPatient(int id) {
        NodeAvl node = PatientTree.search(id); // Search the AVLTree for the patient
        if (node != null) {
            Patient patient = node.data;
            System.out.println("Patient found: " + patient.getName() + " (ID: " + patient.getPatientID() + ")");
            return patient;
        }
        System.out.println("Patient with ID " + id + " not found.");
        return null;
    }

    // Getters and Setters
    public int getAppointmentID() {
        return appointmentID;
    }

   



    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Methods
    public void schedule(String date, String time) {
        Appointment appointment = new Appointment(date, time, "Scheduled");
        this.date = date;
        this.time = time;
        this.status = "Scheduled";
        single.add(appointment);
        System.out.println("Appointment scheduled for " + date + " at " + time);
        System.out.println(appointmentID);
    }

    public void cancel(int appointmentID) {
        this.status = "Cancelled";
        System.out.println("Appointment cancelled.");
        single.DeleteApp(appointmentID);
    }

    public void reschedule(String newDate, String newTime,int CurrentAPPOINTMENTID) {
        if (single.isEmpty()) {
            System.out.println("Error: No appointments exist to reschedule.");
            return;
        }
        this.date = newDate;
        this.time = newTime;
        this.status = "Rescheduled";
        Appointment appointment = new Appointment(newDate, newTime, "Rescheduled");
        single.DeleteApp(CurrentAPPOINTMENTID);
        single.add(appointment);
        System.out.println("Appointment rescheduled to " + newDate + " at " + newTime);


    }

    // Generate unique Appointment ID
    private static synchronized int generateID() {
        return counter++;
    }

    // toString method for display
    @Override
    public String toString() {
        return "Appointment [ID=" + appointmentID +
                ", Date=" + date +
                ", Time=" + time +
                ", Status=" + status + "]";
    }
    public void report2(){
        Node temp = single.head;
        while(temp!=null){
            System.out.println(temp.data.toString());
        }
    }





}
