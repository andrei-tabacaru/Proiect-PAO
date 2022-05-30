package project.classes;

public class Hairdresser extends Employee{// overrides salary

    public Hairdresser(String name, String phoneNumber, String email, int salary, int payday) {
        super(name, phoneNumber, email, salary, payday);
    }

    public Hairdresser(int personId, String name, String phoneNumber, String email, int salary, int payday) {
        super(personId, name, phoneNumber, email, salary, payday);
    }

    public Hairdresser() {
        super();
    }

    @Override
    public int getActualSalary(int month) {
        return super.getActualSalary(month) + 12*this.monthlyAppointmentsCounter.get(month);
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
