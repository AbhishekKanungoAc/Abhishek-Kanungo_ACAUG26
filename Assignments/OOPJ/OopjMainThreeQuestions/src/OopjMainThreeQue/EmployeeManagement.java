package OopjMainThreeQue;


import java.util.ArrayList;

abstract class Employee {

    private int id;
    private String name;
    private double salary;

    // Constructor
    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    // Abstract method
    abstract void calculateSalary();

    // Display method
    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }
}


// Manager class
class Manager extends Employee {

    private double bonus;

    Manager(int id, String name, double salary, double bonus) {
        super(id, name, salary);
        this.bonus = bonus;
    }

    @Override
    void calculateSalary() {
        double totalSalary = getSalary() + bonus;
        System.out.println("Manager Salary: " + totalSalary);
    }

    @Override
    void display() {
        System.out.println("\n--- Manager ---");
        super.display();
        calculateSalary();
    }
}


// Developer class
class Developer extends Employee {

    private double projectAllowance;

    Developer(int id, String name, double salary, double projectAllowance) {
        super(id, name, salary);
        this.projectAllowance = projectAllowance;
    }

    @Override
    void calculateSalary() {
        double totalSalary = getSalary() + projectAllowance;
        System.out.println("Developer Salary: " + totalSalary);
    }

    @Override
    void display() {
        System.out.println("\n--- Developer ---");
        super.display();
        calculateSalary();
    }
}


// Tester class
class Tester extends Employee {

    private double testingAllowance;

    Tester(int id, String name, double salary, double testingAllowance) {
        super(id, name, salary);
        this.testingAllowance = testingAllowance;
    }

    @Override
    void calculateSalary() {
        double totalSalary = getSalary() + testingAllowance;
        System.out.println("Tester Salary: " + totalSalary);
    }

    @Override
    void display() {
        System.out.println("\n--- Tester ---");
        super.display();
        calculateSalary();
    }
}


// Main class
public class EmployeeManagement {

    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();

        // Parent reference holding child objects
        employees.add(new Manager(101, "Rahul", 50000, 10000));
        employees.add(new Developer(102, "Amit", 45000, 5000));
        employees.add(new Tester(103, "Priya", 40000, 4000));

        // Runtime polymorphism
        for (Employee e : employees) {
            e.display();
        }
    }
}