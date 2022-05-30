package project.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class Employee extends Person {
    private static int empCounter;
    protected int salary;
    protected int payday;
    protected List<Integer> monthlyAppointmentsCounter;

    public Employee(String name, String phoneNumber, String email, int salary, int payday) {
        super(name, phoneNumber, email);
        Employee.empCounter++;
        this.salary = salary;
        this.payday = payday;
        this.monthlyAppointmentsCounter = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
    }

    public Employee(int personId, String name, String phoneNumber, String email, int salary, int payday) {
        super(personId, name, phoneNumber, email);
        Employee.empCounter++;
        this.salary = salary;
        this.payday = payday;
        this.monthlyAppointmentsCounter = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
    }

    public Employee() {
        super();
        Employee.empCounter++;
        this.salary = 0;
        this.payday = 0;
        this.monthlyAppointmentsCounter = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
    }

    public static int getEmpCounter() {
        return empCounter;
    }

    public static void removedEmp() {
        Employee.empCounter = Employee.empCounter - 1;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getActualSalary(int month) { return this.salary;}

    public int getPayday() {
        return payday;
    }

    public void setPayday(int payday) {
        this.payday = payday;
    }

    public List<Integer> getMonthlyAppointmentsCounter() {
        return monthlyAppointmentsCounter;
    }

    public void setMonthlyAppointmentsCounter(List<Integer> monthlyAppointmentsCounter) {
        this.monthlyAppointmentsCounter = monthlyAppointmentsCounter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && payday == employee.payday && monthlyAppointmentsCounter == employee.monthlyAppointmentsCounter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), salary, payday, monthlyAppointmentsCounter);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", payday=" + payday +
                ", monthlyAppointmentsCounter=" + monthlyAppointmentsCounter +
                ", personId=" + personId +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
