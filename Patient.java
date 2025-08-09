
    public class  Patient {
        private int age,payment;
        private String name, contactInfo, medicalHistory, visitRecords;
        private static int idCounter = 0;
        private int patientID;
        private int periority;
        private Queuee q;
        Appointment appointment;

        public Patient(String name, int age,String date,String time,String status,String medicalHistory,String visitRecords, String contactInfo,int periority) {
            this.age = age;
            this.periority=periority;
            this.contactInfo = contactInfo;
            this.name = name;
            this.medicalHistory = medicalHistory;
            this.visitRecords = visitRecords;
            this.payment=payment;
            this.patientID = generatePatientId();
        this.appointment = new Appointment(date,time,status); // Initialize the `appointment`

        }

        public Appointment getAppointment() {
            return appointment;
        }

        public int getPayment() {
            return payment;
        }

        public void setPayment(int payment) {
            this.payment += payment;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getPer() {
            return periority;
        }

        public void setPer(int per) {
            System.out.println("enter priority");
            if (per < 1 || per > 10) {
                System.out.println("wrong");
            } else {
                this.periority = per;
            }
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setContactInfo(String contactInfo) {
            this.contactInfo = contactInfo;
        }

        public void setMedicalHistory(String medicalHistory) {
            this.medicalHistory = medicalHistory;
        }

        public String getMedicalHistory() {
            return medicalHistory;
        }

        public String getContactInfo() {
            return contactInfo;
        }
        public String getVisitRecords() {
            return visitRecords;
        }

        public int getPatientID() {
            return patientID;
        }

        public void addVisitRecord(String visitRecord) {
            this.visitRecords = visitRecord;
        }

        public void updateContactInfo(String contactInfo) {
            this.contactInfo = contactInfo;
        }

        public void getPatientInfo() {
            System.out.println("Name is: " + this.name +
                    "\n contact info is: " + this.contactInfo +
                    "\n medical history is: " + this.medicalHistory +
                    "\n visit record is :" + this.visitRecords +
                    "\n age is: " + this.age +
                    "\n id is: " + this.patientID+
                    "\n money must pay "+payment); // Use instance field patientID
        }

        public static int generatePatientId() {
            return ++idCounter;
        }

        public void Appdisplay(){
         appointment.toString();

        }





    }







