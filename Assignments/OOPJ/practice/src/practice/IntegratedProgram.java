package practice;


import java.util.*;

//Functional Interface
@FunctionalInterface
interface SalaryCalculator {
 double calculate(double salary);
}

//Custom Exception
class InvalidSalaryException extends Exception {
 public InvalidSalaryException(String message) {
     super(message);
 }
}

//Employee class
class Employee {
 int id;
 String name;
 double salary;

 Employee(int id, String name, double salary) throws InvalidSalaryException {

     if (salary < 0) {
         throw new InvalidSalaryException("Salary cannot be negative");
     }

     this.id = id;
     this.name = name;
     this.salary = salary;
 }

 @Override
 public String toString() {
     return id + " " + name + " " + salary;
 }
}

public class IntegratedProgram {

 public static void main(String[] args) {

     // Collection
     ArrayList<Employee> employees = new ArrayList<>();

     try {
         employees.add(new Employee(1, "Amit", 60000));
         employees.add(new Employee(2, "Rohit", 45000));
         employees.add(new Employee(3, "Neha", 75000));
         employees.add(new Employee(4, "Priya", 40000));

     } catch (InvalidSalaryException e) {
         System.out.println(e.getMessage());
     }

     // Functional Interface + Lambda
     SalaryCalculator bonus = salary -> salary * 0.10;

     System.out.println("Employees with bonus:");

     for (Employee e : employees) {
         System.out.println(
             e.name + " Bonus = " + bonus.calculate(e.salary)
         );
     }

     // Stream API
     System.out.println("\nSalary greater than 50000:");

     employees.stream()
              .filter(e -> e.salary > 50000)
              .forEach(System.out::println);

     // Multithreading
     Thread t = new Thread(() -> {

         System.out.println("\nEmployee Details from Thread:");

         for (Employee e : employees) {
             System.out.println(e);
         }
     });

     t.start();

     try {
         t.join();
     } catch (InterruptedException e) {
         System.out.println("Thread interrupted");
     }
 }
}