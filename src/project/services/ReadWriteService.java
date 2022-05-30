package project.services;

import project.classes.*;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import static java.time.format.DateTimeFormatter.ofLocalizedDateTime;
import static java.time.format.FormatStyle.SHORT;

public class ReadWriteService {
    private static ReadWriteService readWriteService;
    private static String clientFilePath;
    private static String hairDresserFilePath;
    private static String beautifierFilePath;
    private static String appointmentFilePath;

    private ReadWriteService() {
        clientFilePath = "src/project/csv_files/clientReportData.csv";
        hairDresserFilePath = "src/project/csv_files/hairDresserReportData.csv";
        beautifierFilePath = "src/project/csv_files/beautifierReportData.csv";
        appointmentFilePath = "src/project/csv_files/appointmentReportData.csv";
    }
    public static ReadWriteService getReadWriteService() {
        if (readWriteService == null)
            readWriteService = new ReadWriteService();
        return readWriteService;
    }

    public <T> void writeDataToReport(T ob){
        if(ob instanceof Client) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(clientFilePath, true))) {
                bufferedWriter.append(((Client) ob).getName());
                bufferedWriter.append(",");
                bufferedWriter.append(((Client) ob).getEmail());
                bufferedWriter.append(",");
                bufferedWriter.append(((Client) ob).getPhoneNumber());
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(((Client) ob).getAge()));
                bufferedWriter.append("\n");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else if(ob instanceof Hairdresser){
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(hairDresserFilePath, true))) {
                bufferedWriter.append(((Hairdresser) ob).getName());
                bufferedWriter.append(",");
                bufferedWriter.append(((Hairdresser) ob).getPhoneNumber());
                bufferedWriter.append(",");
                bufferedWriter.append(((Hairdresser) ob).getEmail());
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(((Hairdresser) ob).getSalary()));
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(((Hairdresser) ob).getPayday()));
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(((Hairdresser) ob).getMonthlyAppointmentsCounter()));
                bufferedWriter.append("\n");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else if(ob instanceof Beautifier){
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(beautifierFilePath, true))) {
                bufferedWriter.append(((Beautifier) ob).getName());
                bufferedWriter.append(",");
                bufferedWriter.append(((Beautifier) ob).getPhoneNumber());
                bufferedWriter.append(",");
                bufferedWriter.append(((Beautifier) ob).getEmail());
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(((Beautifier) ob).getSalary()));
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(((Beautifier) ob).getPayday()));
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(((Beautifier) ob).getMonthlyAppointmentsCounter()));
                bufferedWriter.append(",");
//                bufferedWriter.append(String.valueOf(((Beautifier) ob).getServices()));
                bufferedWriter.append("\n");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else if(ob instanceof Appointment){
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(appointmentFilePath, true))) {
                bufferedWriter.append(String.valueOf(((Appointment) ob).getClientId()));
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(((Appointment) ob).getEmployeeId()));
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(((Appointment) ob).getCost()));
                bufferedWriter.append(",");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                bufferedWriter.append(((Appointment) ob).getStartDate().format(formatter));
                bufferedWriter.append(",");
                bufferedWriter.append(((Appointment) ob).getEndDate().format(formatter));
                bufferedWriter.append("\n");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


    public void initReportHeader(String type) {
        if(type.equals("Client")) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(clientFilePath))) {
                bufferedWriter.append("NAME");
                bufferedWriter.append(",");
                bufferedWriter.append("EMAIL");
                bufferedWriter.append(",");
                bufferedWriter.append("PHONE NUMBER");
                bufferedWriter.append(",");
                bufferedWriter.append("AGE");
                bufferedWriter.append("\n");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else if(type.equals("Hairdresser")) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(hairDresserFilePath))) {
                bufferedWriter.append("NAME");
                bufferedWriter.append(",");
                bufferedWriter.append("EMAIL");
                bufferedWriter.append(",");
                bufferedWriter.append("PHONE NUMBER");
                bufferedWriter.append(",");
                bufferedWriter.append("SALARY");
                bufferedWriter.append(",");
                bufferedWriter.append("PAYDAY");
                bufferedWriter.append(",");
                bufferedWriter.append("NO. OF APPOINTMENTS");
                bufferedWriter.append("\n");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else if(type.equals("Beautifier")) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(beautifierFilePath))) {
                bufferedWriter.append("NAME");
                bufferedWriter.append(",");
                bufferedWriter.append("EMAIL");
                bufferedWriter.append(",");
                bufferedWriter.append("PHONE NUMBER");
                bufferedWriter.append(",");
                bufferedWriter.append("SALARY");
                bufferedWriter.append(",");
                bufferedWriter.append("PAYDAY");
                bufferedWriter.append(",");
                bufferedWriter.append("NO. OF APPOINTMENTS");
                bufferedWriter.append(",");
                bufferedWriter.append("SERVICES");
                bufferedWriter.append("\n");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else if(type.equals("Appointment")) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(appointmentFilePath))) {
                bufferedWriter.append("CLIENT ID");
                bufferedWriter.append(",");
                bufferedWriter.append("EMPLOYEE ID");
                bufferedWriter.append(",");
                bufferedWriter.append("PRICE");
                bufferedWriter.append(",");
                bufferedWriter.append("DATA START");
                bufferedWriter.append(",");
                bufferedWriter.append("DATA END");
                bufferedWriter.append("\n");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void readDataFromCsv(String type) {
        if(type.equals("Client")) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(clientFilePath))) {
                String record;
                while ((record = bufferedReader.readLine()) != null) {
                    String[] recordData = record.split(",");
                    System.out.println(recordData[0] + " " + recordData[1] + " " + recordData[2] + " " + recordData[3]);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else if(type.equals("Hairdresser")) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(hairDresserFilePath))) {
                String record;
                while ((record = bufferedReader.readLine()) != null) {
                    String[] recordData = record.split(",");
                    System.out.println(recordData[0] + " " + recordData[1] + " " + recordData[2] + " " + recordData[3]
                            + " " + recordData[4] + " " + recordData[5]);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else if(type.equals("Beautifier")) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(beautifierFilePath))) {
                String record;
                while ((record = bufferedReader.readLine()) != null) {
                    String[] recordData = record.split(",");
                    System.out.println(recordData[0] + " " + recordData[1] + " " + recordData[2] + " " + recordData[3]
                            + " " + recordData[4] + " " + recordData[5] + " " + recordData[6]);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else if(type.equals("Appointment")) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(appointmentFilePath))) {
                String record;
                while ((record = bufferedReader.readLine()) != null) {
                    String[] recordData = record.split(",");
                    System.out.println(recordData[0] + " " + recordData[1] + " " + recordData[2] + " " + recordData[3]
                            + " " + recordData[4]);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
