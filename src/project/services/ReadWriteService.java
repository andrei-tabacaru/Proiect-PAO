package project.services;

import project.classes.Client;
import project.classes.Hairdresser;
import project.classes.Manager;

import java.io.*;

public class ReadWriteService {
    private static ReadWriteService readWriteService;
    private static String clientFilePath;
    private static String hairDresserFilePath;

    private ReadWriteService() {
        clientFilePath = "src/project/csv_input/clientReportData.csv";
        hairDresserFilePath = "src/project/csv_input/hairDresserReportData.csv";
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
                bufferedWriter.append(((Hairdresser) ob).getEmail());
                bufferedWriter.append(",");
                bufferedWriter.append(((Hairdresser) ob).getPhoneNumber());
                bufferedWriter.append(",");
                bufferedWriter.append((char) ((Hairdresser) ob).getMonthlyAppointmentsCounter());
                bufferedWriter.append(",");
                bufferedWriter.append((char) ((Hairdresser) ob).getPayday());
                bufferedWriter.append(",");
                bufferedWriter.append((char) ((Hairdresser) ob).getSalary());
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
    }
}
