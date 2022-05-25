package project.services;

import project.classes.Appointment;
import project.classes.Client;
import project.classes.Employee;

import java.io.IOException;
import java.util.*;

public class Service {
    private ArrayList<Client> clients;
    private ArrayList<Employee> employees;
    private ArrayList<Appointment> appointments;
    private static ReadWriteService readWriteService;

    public Service() throws IOException {
        this.clients = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.appointments = new ArrayList<>();
        Service.readWriteService = ReadWriteService.getReadWriteService();
    }

    public static void csvTest(){
        Scanner scanner = new Scanner(System.in);
//        ReadWriteService readWriteService = ReadWriteService.getReadWriteService();

        List<Client> clients = Arrays.asList(
                new Client("Name 1", "0741112113", "client1@mail.com", 20),
                new Client("Name 3", "0741112114", "client3@mail.com", 22),
                new Client("Name 2", "0741112115", "client2@mail.com", 21)
        );


        boolean ok = true;
        while(ok)
        {
            System.out.println("\nAlegeti una din urmatoarele optiuni:");
            System.out.println("1.Generare raport sortat crescator dupa nume");
            System.out.println("2.Generare raport sortat descrescator dupa nume");
            System.out.println("3.Generare raport normal");
            System.out.println("4.Afiseaza raportul in consola");
            System.out.println("5.Inchide");
            System.out.println("Alege un numar:");

            String line = scanner.nextLine();
            switch (line) {
                case "1":
                    Collections.sort(clients, Comparator.comparing(Client::getName));
                    readWriteService.initReportHeader("Client");
                    clients.forEach(client -> readWriteService.writeDataToReport(client));
                    System.out.println("Report was generated with success!!!");
                    break;
                case "2":
                    Collections.sort(clients, Comparator.comparing(Client::getName).reversed());
                    readWriteService.initReportHeader("Client");
                    clients.forEach(client -> readWriteService.writeDataToReport(client));
                    System.out.println("Report was generated with success!!!");
                    break;
                case "3":
                    readWriteService.initReportHeader("Client");
                    clients.forEach(client -> readWriteService.writeDataToReport(client));
                    System.out.println("Report was generated with success!!!");
                    break;
                case "4":
                    readWriteService.readDataFromCsv("Client");
                    break;
                case "5":
                    ok = false;
                    break;
            }
        }
    }
}
