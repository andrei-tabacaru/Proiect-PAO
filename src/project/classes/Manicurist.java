package project.classes;

public class Manicurist extends Employee{// overrides salary

    public Manicurist(String name, String phoneNumber, String email, int salary, int payday, int monthlyAppointmentsCounter) {
        super(name, phoneNumber, email, salary, payday, monthlyAppointmentsCounter);
        int actualSalary = salary + 8*this.monthlyAppointmentsCounter;
        super.setSalary(actualSalary);
    }

    public Manicurist(int personId, String name, String phoneNumber, String email, int salary, int payday, int monthlyAppointmentsCounter) {
        super(personId, name, phoneNumber, email, salary, payday, monthlyAppointmentsCounter);
        int actualSalary = salary + 8*this.monthlyAppointmentsCounter;
        super.setSalary(actualSalary);
    }

    public Manicurist() {
        super();
    }

    @Override
    public void setSalary(int salary) {
        super.setSalary(salary + 8*this.monthlyAppointmentsCounter);
    }

    @Override
    public String toString() {
        return "Hairdresser{" +
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
