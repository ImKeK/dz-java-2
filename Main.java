import java.util.Arrays;

class Employee {
    private String name;
    private double salary;
    private int year;
    private int month;
    private int day;

    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Метод для сравнения дат
    public static int compareDates(int year1, int month1, int day1, int year2, int month2, int day2) {
        return (year1 != year2 ? Integer.compare(year1, year2) :
                (month1 != month2 ? Integer.compare(month1, month2) :
                        Integer.compare(day1, day2)));
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', salary=" + salary + "}";
    }
}

class Manager extends Employee {
    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
    }

    // Статический метод для повышения зарплаты
    public static void increaseSalary(Employee[] employees, double percentage) {
        for (Employee employee : employees) {
            if (!(employee instanceof Manager)) { // Проверяем, что это не руководитель
                double newSalary = employee.getSalary() * (1 + percentage / 100);
                employee.setSalary(newSalary);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[3];
        employees[0] = new Employee("Alice", 50000, 2020, 5, 20);
        employees[1] = new Employee("Bob", 60000, 2019, 3, 15);
        employees[2] = new Manager("Charlie", 80000, 2021, 7, 10);

        System.out.println("Before salary increase:");
        Arrays.stream(employees).forEach(System.out::println);

        // Повышаем зарплату всем сотрудникам на 10%
        Manager.increaseSalary(employees, 10);

        System.out.println("nAfter salary increase:");
        Arrays.stream(employees).forEach(System.out::println);
    }
}
