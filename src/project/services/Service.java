package project.services;

import project.classes.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
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

        List<Hairdresser> hairdressers = Arrays.asList(
                new Hairdresser("Name 1", "0741112113", "client1@mail.com", 1400, 15, 0),
                new Hairdresser("Name 3", "0741112114", "client3@mail.com", 1400, 15, 0),
                new Hairdresser("Name 2", "0741112115", "client2@mail.com", 1400, 15, 0)
        );

        List<Beautifier> beautifiers = Arrays.asList(
                new Beautifier("Name 1", "0741112113", "client1@mail.com", 1400, 15, 0, new ArrayList<String>(Arrays.asList("service0", "service1", "service2"))),
                new Beautifier("Name 3", "0741112114", "client3@mail.com", 1400, 15, 0, new ArrayList<String>(Arrays.asList("service3", "service4", "service5"))),
                new Beautifier("Name 2", "0741112115", "client2@mail.com", 1400, 15, 0, new ArrayList<String>(Arrays.asList("service6", "service7", "service7")))
        );
        LocalDateTime startDateTime = LocalDateTime.of(2014, 1, 2, 14, 0);
        LocalDateTime startEndTime = LocalDateTime.of(2014, 1, 2, 16, 0);
        List<Appointment> appointments = Arrays.asList(
                new Appointment(1, 4, 200, startDateTime, startEndTime),
                new Appointment(2, 5, 220, startDateTime, startEndTime),
                new Appointment(3, 6, 210, startDateTime, startEndTime)
        );

        boolean okFirst = true;
        while(okFirst) {
            System.out.println("\nAlegeti una din urmatoarele optiuni:");
            System.out.println("1.Generare/afisare raport Client");
            System.out.println("2.Generare/afisare raport Hairdresser");
            System.out.println("3.Generare/afisare raport Beautifier");
            System.out.println("4.Generare/afisare raport Appointments");
            System.out.println("5.Inchide");
            System.out.println("Alege un numar:");

            String line = scanner.nextLine();
            switch (line) {
                case "1":
                    boolean okClient = true;
                    while (okClient) {
                        System.out.println("\nAlegeti una din urmatoarele optiuni:");
                        System.out.println("1.Generare raport sortat crescator dupa nume");
                        System.out.println("2.Generare raport sortat descrescator dupa nume");
                        System.out.println("3.Generare raport normal");
                        System.out.println("4.Afiseaza raportul in consola");
                        System.out.println("5.Inchide");
                        System.out.println("Alege un numar:");

                        String lineClient = scanner.nextLine();
                        switch (lineClient) {
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
                                okClient = false;
                                break;
                        }
                    }
                    break;
                case "2":
                    boolean okHairdresser = true;
                    while (okHairdresser) {
                        System.out.println("\nAlegeti una din urmatoarele optiuni:");
                        System.out.println("1.Generare raport sortat crescator dupa nume");
                        System.out.println("2.Generare raport sortat descrescator dupa nume");
                        System.out.println("3.Generare raport normal");
                        System.out.println("4.Afiseaza raportul in consola");
                        System.out.println("5.Inchide");
                        System.out.println("Alege un numar:");

                        String lineHairdresser = scanner.nextLine();
                        switch (lineHairdresser) {
                            case "1":
                                Collections.sort(hairdressers, Comparator.comparing(Hairdresser::getName));
                                readWriteService.initReportHeader("Hairdresser");
                                hairdressers.forEach(hairdresser -> readWriteService.writeDataToReport(hairdresser));
                                System.out.println("Report was generated with success!!!");
                                break;
                            case "2":
                                Collections.sort(hairdressers, Comparator.comparing(Hairdresser::getName).reversed());
                                readWriteService.initReportHeader("Hairdresser");
                                hairdressers.forEach(hairdresser -> readWriteService.writeDataToReport(hairdresser));
                                System.out.println("Report was generated with success!!!");
                                break;
                            case "3":
                                readWriteService.initReportHeader("Hairdresser");
                                hairdressers.forEach(hairdresser -> readWriteService.writeDataToReport(hairdresser));
                                System.out.println("Report was generated with success!!!");
                                break;
                            case "4":
                                readWriteService.readDataFromCsv("Hairdresser");
                                break;
                            case "5":
                                okHairdresser = false;
                                break;
                        }
                    }
                    break;
                case "3":
                    boolean okBeautifier = true;
                    while (okBeautifier) {
                        System.out.println("\nAlegeti una din urmatoarele optiuni:");
                        System.out.println("1.Generare raport sortat crescator dupa nume");
                        System.out.println("2.Generare raport sortat descrescator dupa nume");
                        System.out.println("3.Generare raport normal");
                        System.out.println("4.Afiseaza raportul in consola");
                        System.out.println("5.Inchide");
                        System.out.println("Alege un numar:");

                        String lineBeautifier = scanner.nextLine();
                        switch (lineBeautifier) {
                            case "1":
                                Collections.sort(beautifiers, Comparator.comparing(Beautifier::getName));
                                readWriteService.initReportHeader("Beautifier");
                                beautifiers.forEach(beautifier -> readWriteService.writeDataToReport(beautifier));
                                System.out.println("Report was generated with success!!!");
                                break;
                            case "2":
                                Collections.sort(beautifiers, Comparator.comparing(Beautifier::getName).reversed());
                                readWriteService.initReportHeader("Beautifier");
                                beautifiers.forEach(beautifier -> readWriteService.writeDataToReport(beautifier));
                                System.out.println("Report was generated with success!!!");
                                break;
                            case "3":
                                readWriteService.initReportHeader("Beautifier");
                                beautifiers.forEach(beautifier -> readWriteService.writeDataToReport(beautifier));
                                System.out.println("Report was generated with success!!!");
                                break;
                            case "4":
                                readWriteService.readDataFromCsv("Beautifier");
                                break;
                            case "5":
                                okBeautifier = false;
                                break;
                        }
                    }
                    break;
                case "4":
                    boolean okAppointment = true;
                    while (okAppointment) {
                        System.out.println("\nAlegeti una din urmatoarele optiuni:");
                        System.out.println("1.Generare raport sortat crescator dupa pret");
                        System.out.println("2.Generare raport sortat descrescator dupa pret");
                        System.out.println("3.Generare raport normal");
                        System.out.println("4.Afiseaza raportul in consola");
                        System.out.println("5.Inchide");
                        System.out.println("Alege un numar:");

                        String lineAppointment = scanner.nextLine();
                        switch (lineAppointment) {
                            case "1":
                                Collections.sort(appointments, Comparator.comparing(Appointment::getCost));
                                readWriteService.initReportHeader("Appointment");
                                appointments.forEach(appointment -> readWriteService.writeDataToReport(appointment));
                                System.out.println("Report was generated with success!!!");
                                break;
                            case "2":
                                Collections.sort(appointments, Comparator.comparing(Appointment::getCost).reversed());
                                readWriteService.initReportHeader("Appointment");
                                appointments.forEach(appointment -> readWriteService.writeDataToReport(appointment));
                                System.out.println("Report was generated with success!!!");
                                break;
                            case "3":
                                readWriteService.initReportHeader("Appointment");
                                appointments.forEach(appointment -> readWriteService.writeDataToReport(appointment));
                                System.out.println("Report was generated with success!!!");
                                break;
                            case "4":
                                readWriteService.readDataFromCsv("Appointment");
                                break;
                            case "5":
                                okAppointment = false;
                                break;
                        }
                    }
                    break;
                case "5":
                    okFirst = false;
                    break;
            }
        }
    }
}
