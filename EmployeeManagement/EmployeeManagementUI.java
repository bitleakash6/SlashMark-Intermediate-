import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManagementUI extends JFrame {
    private List<Employee> employees;
    private JTextField nameField, idField, departmentField;
    private JTextArea displayArea;

    public EmployeeManagementUI() {
        setTitle("Employee Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);

        employees = new ArrayList<>();

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Department:"));
        departmentField = new JTextField();
        inputPanel.add(departmentField);
        JButton addButton = new JButton("Add Employee");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEmployee();
            }
        });
        inputPanel.add(addButton);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(inputPanel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    private void addEmployee() {
        String name = nameField.getText();
        int id = Integer.parseInt(idField.getText());
        String department = departmentField.getText();

        Employee employee = new Employee(name, id, department);
        employees.add(employee);

        displayEmployees();
        clearFields();
    }

    private void displayEmployees() {
        displayArea.setText("");
        for (Employee employee : employees) {
            displayArea.append(employee.toString() + "\n");
        }
    }

    private void clearFields() {
        nameField.setText("");
        idField.setText("");
        departmentField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EmployeeManagementUI().setVisible(true);
            }
        });
    }
}

class Employee {
    private String name;
    private int id;
    private String department;

    public Employee(String name, int id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", ID: " + id + ", Department: " + department;
    }
}
