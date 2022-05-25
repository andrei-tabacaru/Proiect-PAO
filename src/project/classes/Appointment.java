package project.classes;

import java.time.LocalDateTime;
import java.util.Objects;

public class Appointment {
    static int maxId;
    private int appointmentId;
    private int clientId;
    private int employeeId;
    private int cost;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public Appointment(int appointmentId, int clientId, int employeeId, int cost, LocalDateTime startDate, LocalDateTime endDate) {
        this.appointmentId = appointmentId;
        this.clientId = clientId;
        this.employeeId = employeeId;
        this.cost = cost;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Appointment(int clientId, int employeeId, int cost, LocalDateTime startDate, LocalDateTime endDate) {
        Appointment.maxId++;
        this.appointmentId = Appointment.maxId;
        this.clientId = clientId;
        this.employeeId = employeeId;
        this.cost = cost;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Appointment() {
        Appointment.maxId++;
        this.appointmentId = Appointment.maxId;
        this.clientId = 0;
        this.employeeId = 0;
        this.cost = 0;
        this.startDate = null;
        this.endDate = null;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return appointmentId == that.appointmentId && clientId == that.clientId && employeeId == that.employeeId && cost == that.cost && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appointmentId, clientId, employeeId, cost, startDate, endDate);
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", clientId=" + clientId +
                ", employeeId=" + employeeId +
                ", cost=" + cost +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
