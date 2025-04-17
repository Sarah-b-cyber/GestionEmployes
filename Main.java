import java.util.ArrayList;
import java.util.List;

class Employee {
    private int id;
    private String name;
    private double salary;
    private String department;

    public Employee(int id, String name, double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary + ", Department: " + department;
    }
}

class EmployeeManagementSystem {
    private List<Employee> employees;

    public EmployeeManagementSystem() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee emp) {
        for (Employee e : employees) {
            if (e.getId() == emp.getId()) {
                System.out.println("Employee with ID " + emp.getId() + " already exists.");
                return;
            }
        }
        employees.add(emp);
        System.out.println("Employee added successfully.");
    }

    public void removeEmployee(int id) {
        employees.removeIf(emp -> emp.getId() == id);
        System.out.println("Employee with ID " + id + " removed successfully.");
    }

    public Employee findEmployee(int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
        return null;
    }

    public double calculateTotalSalary() {
        double totalSalary = 0;
        for (Employee emp : employees) {
            totalSalary += emp.getSalary();
        }
        return totalSalary;
    }

    public void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees in the system.");
        } else {
            for (Employee emp : employees) {
                System.out.println(emp);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        
        Employee e1 = new Employee(101, "Alice", 50000, "IT");
        Employee e2 = new Employee(102, "Bob", 60000, "HR");
        Employee e3 = new Employee(103, "Charlie", 70000, "Finance");

        ems.addEmployee(e1);
        ems.addEmployee(e2);
        ems.addEmployee(e3);

        System.out.println("\nAll Employees:");
        ems.displayAllEmployees();

        System.out.println("\nFinding Employee with ID 102:");
        System.out.println(ems.findEmployee(102));

        System.out.println("\nTotal Salary: " + ems.calculateTotalSalary());

        System.out.println("\nRemoving Employee with ID 101:");
        ems.removeEmployee(101);
        
        System.out.println("\nAll Employees after removal:");
        ems.displayAllEmployees();
    }
}
