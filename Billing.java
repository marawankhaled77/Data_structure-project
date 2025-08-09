import java.text.DateFormat;
import java.util.Date;

public class Billing {
    private int billId, BilingAmount;
    public AVLTree T;
    private LinkedListSingle paymentRecords;
    static int paid ;// To store payment history of patients

    public Billing(AVLTree T) {
        this.T = T;
        this.paymentRecords = new LinkedListSingle(); // Initialize the linked list
    }

    public void addPayment(int payment, int id) {
        if (T.search(id) != null) {
            Patient p = T.search(id).data;
            p.setPayment(payment);
            System.out.println("done and the total is :" + p.getPayment());
        } else {
            System.out.println("id is not found");
        }
    }

    public void GenerateBill(Patient p, int pay) {
        p.setPayment((-1 * pay)); // Deduct payment from the total
        Date d = new Date();
        DateFormat df = DateFormat.getDateInstance();
        String date = df.format(d);
        BilingAmount = p.getPayment();
        System.out.println("In Day: " + date);
        if (BilingAmount < 0) {
            BilingAmount = 0;
        }
        System.out.println("Name: " + p.getName() + " , ID: " + p.getPatientID() + "\nHe/She pay :" + pay + " and Remains :" + BilingAmount);

        // Update payment history in the linked list
        if (BilingAmount < 0) {
            BilingAmount = 0;
        }
        String paymentRecord = "Date: " + date + ", Paid: " + pay + ", Remaining: " + BilingAmount;
        paymentRecords.add(new PaymentHistoryEntry(p.getPatientID(), paymentRecord)); // Add record to the linked list
        paid+=pay;
    }

    public void getPaymentStatus(Patient p) {
        if (p == null) {
            System.out.println("Invalid patient!");
            return;
        }

        System.out.println("Payment History for Patient: " + p.getName() + " (ID: " + p.getPatientID() + ")");
        boolean found = false;

        // Traverse the linked list to find payment history for the given patient
        Node temp = paymentRecords.head; // Start from the head of the linked list
        while (temp != null) {
            PaymentHistoryEntry entry = (PaymentHistoryEntry) temp.data;
            if (entry.getPatientId() == p.getPatientID()) {
                System.out.println(entry.getPaymentDetails());
                found = true;
            }
            temp = temp.next; // Move to the next node
        }

        if (!found) {
            System.out.println("No payment history available.");
        }
    }

    // Inner class to store payment history entries
    private class PaymentHistoryEntry {
        private int patientId;
        private String paymentDetails;

        public PaymentHistoryEntry(int patientId, String paymentDetails) {
            this.patientId = patientId;
            this.paymentDetails = paymentDetails;
        }

        public int getPatientId() {
            return patientId;
        }

        public String getPaymentDetails() {
            return paymentDetails;
        }
    }
}














