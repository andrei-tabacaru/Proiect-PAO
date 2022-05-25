package project.classes;

public class Hairdresser extends Employee{// overrides salary

    public Hairdresser(String name, String phoneNumber, String email, int salary, int payday, int monthlyAppointmentsCounter) {
        super(name, phoneNumber, email, salary, payday, monthlyAppointmentsCounter);
        int actualSalary = salary + 12*this.monthlyAppointmentsCounter;
        super.setSalary(actualSalary);
    }

    public Hairdresser(int personId, String name, String phoneNumber, String email, int salary, int payday, int monthlyAppointmentsCounter) {
        super(personId, name, phoneNumber, email, salary, payday, monthlyAppointmentsCounter);
        int actualSalary = salary + 12*this.monthlyAppointmentsCounter;
        super.setSalary(actualSalary);
    }

    public Hairdresser() {
        super();
    }

    @Override
    public void setSalary(int salary) {
        super.setSalary(salary + 12*this.monthlyAppointmentsCounter);
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
