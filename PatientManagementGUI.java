import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PatientManagementGUI extends JFrame {

    private PatientManagementSystem system;

    public PatientManagementGUI() {
        system = new PatientManagementSystem(); // Backend system initialization
        createGUI();
    }

    private void createGUI() {
        // Set basic properties of the GUI
        setTitle("Patient Management System");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Title Panel
        JLabel titleLabel = new JLabel("Hospital Patient Management System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(titleLabel, BorderLayout.NORTH);

        // Center Panel for actions
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(5, 2, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Buttons for different functionalities
        JButton addPatientBtn = new JButton("Add New Patient");
        JButton viewWaitingListBtn = new JButton("View Waiting List");
        JButton scheduleAppointmentBtn = new JButton("Schedule Appointment");
        JButton cancelAppointmentBtn = new JButton("Cancel Appointment");
        JButton generateReportBtn = new JButton("Generate Patient Report");
        JButton viewAppointmentsBtn = new JButton("View All Appointments");
        JButton generateRevenueBtn = new JButton("Generate Revenue Report");

        // Add buttons to the grid panel
        centerPanel.add(addPatientBtn);
        centerPanel.add(viewWaitingListBtn);
        centerPanel.add(scheduleAppointmentBtn);
        centerPanel.add(cancelAppointmentBtn);
        centerPanel.add(generateReportBtn);
        centerPanel.add(viewAppointmentsBtn);
        centerPanel.add(generateRevenueBtn);

        add(centerPanel, BorderLayout.CENTER);

        // Add action listeners to buttons
        addPatientBtn.addActionListener(e -> openAddPatientDialog());
        viewWaitingListBtn.addActionListener(e -> showWaitingList());
        scheduleAppointmentBtn.addActionListener(e -> scheduleAppointmentDialog());
        cancelAppointmentBtn.addActionListener(e -> cancelAppointmentDialog());
        generateReportBtn.addActionListener(e -> generatePatientReportDialog());
        viewAppointmentsBtn.addActionListener(e -> viewAppointments());
        generateRevenueBtn.addActionListener(e -> generateRevenueReport());

        // Bottom Panel for Exit
        JPanel bottomPanel = new JPanel();
        JButton exitBtn = new JButton("Exit");
        exitBtn.setFont(new Font("Arial", Font.BOLD, 16));
        exitBtn.addActionListener(e -> System.exit(0));
        bottomPanel.add(exitBtn);
        add(bottomPanel, BorderLayout.SOUTH);

        // Make the GUI visible
        setVisible(true);
    }

    // Open a dialog to add a new patient
    private void openAddPatientDialog() {
        JDialog dialog = new JDialog(this, "Add New Patient", true);
        dialog.setSize(400, 500);
        dialog.setLayout(new GridLayout(9, 2, 10, 10));

        // Input Fields
        JTextField nameField = new JTextField();
        JTextField ageField = new JTextField();
        JTextField dateField = new JTextField();
        JTextField timeField = new JTextField();
        JTextField medicalField = new JTextField();
        JTextField visitRecordsField = new JTextField();
        JTextField contactField = new JTextField();
        JTextField priorityField = new JTextField();

        // Add input labels and fields to the dialog
        dialog.add(new JLabel("Name:"));
        dialog.add(nameField);
        dialog.add(new JLabel("Age:"));
        dialog.add(ageField);
        dialog.add(new JLabel("Date (e.g., 10/11/2024):"));
        dialog.add(dateField);
        dialog.add(new JLabel("Time (e.g., 10AM):"));
        dialog.add(timeField);
        dialog.add(new JLabel("Medical History:"));
        dialog.add(medicalField);
        dialog.add(new JLabel("Visit Records:"));
        dialog.add(visitRecordsField);
        dialog.add(new JLabel("Contact Info:"));
        dialog.add(contactField);
        dialog.add(new JLabel("Priority (1-10):"));
        dialog.add(priorityField);

        // Action buttons
        JButton addBtn = new JButton("Add Patient");
        JButton cancelBtn = new JButton("Cancel");

        // Add action listeners
        addBtn.addActionListener(e -> {
            try {
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                String date = dateField.getText();
                String time = timeField.getText();
                String medical = medicalField.getText();
                String visitRecords = visitRecordsField.getText();
                String contact = contactField.getText();
                int priority = Integer.parseInt(priorityField.getText());

                // Add patient to the system
                system.addPatient(name, age, date, time, "Scheduled", medical, visitRecords, contact, priority);
                JOptionPane.showMessageDialog(dialog, "Patient added successfully!");
                dialog.dispose();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialog, "Invalid input. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        cancelBtn.addActionListener(e -> dialog.dispose());

        dialog.add(addBtn);
        dialog.add(cancelBtn);

        dialog.setVisible(true);
    }

    // Show waiting list
    private void showWaitingList() {
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        // Get waiting list details
        system.WaitingListDisplay();
        // You can redirect console outputs into this text area for better GUI integration

        JScrollPane scrollPane = new JScrollPane(textArea);
        JOptionPane.showMessageDialog(this, scrollPane, "Waiting List", JOptionPane.INFORMATION_MESSAGE);
    }

    // Schedule Appointment Dialog
    private void scheduleAppointmentDialog() {
        JDialog dialog = new JDialog(this, "Schedule Appointment", true);
        dialog.setSize(300, 200);
        dialog.setLayout(new GridLayout(4, 2, 10, 10));

        JTextField idField = new JTextField();
        JTextField dateField = new JTextField();
        JTextField timeField = new JTextField();

        dialog.add(new JLabel("Patient ID:"));
        dialog.add(idField);
        dialog.add(new JLabel("Date:"));
        dialog.add(dateField);
        dialog.add(new JLabel("Time:"));
        dialog.add(timeField);

        JButton scheduleBtn = new JButton("Schedule");
        dialog.add(scheduleBtn);

        scheduleBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                String date = dateField.getText();
                String time = timeField.getText();

                system.scheduleAppointment(id, date, time);
                JOptionPane.showMessageDialog(dialog, "Appointment Scheduled Successfully!");
                dialog.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialog, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        dialog.setVisible(true);
    }

    // Cancel Appointment Dialog
    private void cancelAppointmentDialog() {
        JDialog dialog = new JDialog(this, "Cancel Appointment", true);
        dialog.setSize(300, 200);
        dialog.setLayout(new GridLayout(3, 2, 10, 10));

        JTextField patientIdField = new JTextField();
        JTextField appointmentIdField = new JTextField();

        dialog.add(new JLabel("Patient ID:"));
        dialog.add(patientIdField);
        dialog.add(new JLabel("Appointment ID:"));
        dialog.add(appointmentIdField);

        JButton cancelBtn = new JButton("Cancel");
        dialog.add(cancelBtn);

        cancelBtn.addActionListener(e -> {
            try {
                int patientId = Integer.parseInt(patientIdField.getText());
                int appointmentId = Integer.parseInt(appointmentIdField.getText());

                system.cancelAppointment(patientId, appointmentId);
                JOptionPane.showMessageDialog(dialog, "Appointment Canceled Successfully!");
                dialog.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialog, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        dialog.setVisible(true);
    }

    // Generate Patient Report Dialog
    private void generatePatientReportDialog() {
        String patientIdStr = JOptionPane.showInputDialog(this, "Enter Patient ID:");
        try {
            int patientId = Integer.parseInt(patientIdStr);
            system.generateReport(patientId);
            JOptionPane.showMessageDialog(this, "Patient Report Generated Successfully!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // View Appointments
    private void viewAppointments() {
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        // Retrieve appointment records
        system.generateAppointmentRecord();
        // For better integration, you can redirect console outputs to this text area.

        JScrollPane scrollPane = new JScrollPane(textArea);
        JOptionPane.showMessageDialog(this, scrollPane, "Appointments", JOptionPane.INFORMATION_MESSAGE);
    }

    // Generate Revenue Report
    private void generateRevenueReport() {
        system.generateRevnue();
        JOptionPane.showMessageDialog(this, "Revenue Report Generated Successfully!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PatientManagementGUI::new);
    }
}
