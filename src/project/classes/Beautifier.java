package project.classes;

import java.util.List;
import java.util.Objects;

public class Beautifier extends Employee{
//    List<String> services;

    public Beautifier(String name, String phoneNumber, String email, int salary, int payday/*, List<String> services*/) {
        super(name, phoneNumber, email, salary, payday);
//        this.services = services;
    }

    public Beautifier(int personId, String name, String phoneNumber, String email, int salary, int payday /*, List<String> services*/) {
        super(personId, name, phoneNumber, email, salary, payday);
//        this.services = services;
    }

    public Beautifier() {
        super();
//        this.services = null;
    }

    @Override
    public int getActualSalary(int month) {
        return super.getActualSalary(month) + 10*this.monthlyAppointmentsCounter.get(month);
    }

//    public List<String> getServices() {
//        return services;
//    }

//    public void setServices(List<String> services) {
//        this.services = services;
//    }
/*

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Beautifier that = (Beautifier) o;
        return Objects.equals(services, that.services);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), services);
    }
*/

    @Override
    public String toString() {
        return "Beautifier{" +
               /* "services=" + services +*/
                ", salary=" + salary +
                ", payday=" + payday +
                ", monthlyAppointmentsCounter=" + monthlyAppointmentsCounter +
                ", personId=" + personId +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
