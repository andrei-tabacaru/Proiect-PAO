package project.services;

import project.classes.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Service {
    private /*Array*/List<Client> clients;
    private /*Array*/List<Employee> employees;
    private /*Array*/List<Appointment> appointments;
    private static ReadWriteService readWriteService;
    private static AuditService auditService;

    public Service() throws IOException {
        this.clients = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.appointments = new ArrayList<>();
        Service.readWriteService = ReadWriteService.getReadWriteService();
        Service.auditService = AuditService.getAuditService();
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
                new Hairdresser("Name 1", "0741112113", "client1@mail.com", 1400, 15),
                new Hairdresser("Name 3", "0741112114", "client3@mail.com", 1400, 15),
                new Hairdresser("Name 2", "0741112115", "client2@mail.com", 1400, 15)
        );

        List<Beautifier> beautifiers = Arrays.asList(
                new Beautifier("Name 1", "0741112113", "client1@mail.com", 1400, 15/*, new ArrayList<String>(Arrays.asList("service0", "service1", "service2"))*/),
                new Beautifier("Name 3", "0741112114", "client3@mail.com", 1400, 15/*, new ArrayList<String>(Arrays.asList("service3", "service4", "service5"))*/),
                new Beautifier("Name 2", "0741112115", "client2@mail.com", 1400, 15/*, new ArrayList<String>(Arrays.asList("service6", "service7", "service7"))*/)
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
            System.out.println("\t 1.Generare/afisare raport Client");
            System.out.println("\t 2.Generare/afisare raport Hairdresser");
            System.out.println("\t 3.Generare/afisare raport Beautifier");
            System.out.println("\t 4.Generare/afisare raport Appointments");
            System.out.println("\t 5.Inchide");

            String line = scanner.nextLine();
            switch (line) {
                case "1":
                    boolean okClient = true;
                    while (okClient) {
                        System.out.println("\nAlegeti una din urmatoarele optiuni:");
                        System.out.println("\t 1.Generare raport sortat crescator dupa nume");
                        System.out.println("\t 2.Generare raport sortat descrescator dupa nume");
                        System.out.println("\t 3.Generare raport normal");
                        System.out.println("\t 4.Afiseaza raportul in consola");
                        System.out.println("\t 5.Inchide");

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
                        System.out.println("\t 1.Generare raport sortat crescator dupa nume");
                        System.out.println("\t 2.Generare raport sortat descrescator dupa nume");
                        System.out.println("\t 3.Generare raport normal");
                        System.out.println("\t 4.Afiseaza raportul in consola");
                        System.out.println("\t 5.Inchide");

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
                        System.out.println("\t 1.Generare raport sortat crescator dupa nume");
                        System.out.println("\t 2.Generare raport sortat descrescator dupa nume");
                        System.out.println("\t 3.Generare raport normal");
                        System.out.println("\t 4.Afiseaza raportul in consola");
                        System.out.println("\t 5.Inchide");

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
                        System.out.println("\t 1.Generare raport sortat crescator dupa pret");
                        System.out.println("\t 2.Generare raport sortat descrescator dupa pret");
                        System.out.println("\t 3.Generare raport normal");
                        System.out.println("\t 4.Afiseaza raportul in consola");
                        System.out.println("\t 5.Inchide");

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
        auditService.writeAuditDataReport("csvTest");
    }

    public /*Array*/List<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public /*Array*/List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public /*Array*/List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }

    public void start(){
        boolean okMenu = true;
        while(okMenu) {
            System.out.println("Alege una din urmatoarele optiuni: ");
            System.out.println("\t 1. Angajati ");
            System.out.println("\t 2. Clienti ");
            System.out.println("\t 3. Programari ");
            System.out.println("\t 4. Genereaza date ");
            System.out.println("\t 0. Inchide");
            Scanner scanner = new Scanner(System.in);
            String option = scanner.nextLine();
            switch (option){
                    case "1":
                        boolean okEmployee = true;
                        while(okEmployee) {
                            System.out.println("Alege una din urmatoarele optiuni:");
                            System.out.println("\t 1. Adauga angajati");
                            System.out.println("\t 2. Afisaza angajati");
                            System.out.println("\t 3. Sterge angajati (de implementat)");
                            System.out.println("\t 4. Editeaza angajati (de implementat)");
                            System.out.println("\t 0. Inapoi");
                            String empOption = scanner.nextLine();
                            switch (empOption) {
                                case "1" -> createEmployee();
    //                        break;
                                case "2" -> showEmployeesByName();
    //                        break;
                                case "3" -> showEmployeesByName();
    //                        break;
                                case "4" -> showEmployeesByName();
    //                        break;
                                default -> okEmployee = false;
                            }
                        }
                    break;
                case "2":
                    boolean okClient = true;
                    while(okClient) {
                        System.out.println("Alege una din urmatoarele optiuni:");
                        System.out.println("\t 1. Adauga clienti");
                        System.out.println("\t 2. Afisaza clienti");
                        System.out.println("\t 3. Sterge clienti (de implementat)");
                        System.out.println("\t 4. Editeaza clienti(de implementat)");
                        System.out.println("\t 0. Inapoi");
                        String optiuneClienti = scanner.nextLine();
                        switch (optiuneClienti) {
                            case "1" -> createClient();
//                            break;
                            case "2" -> showClientsByName();
//                            break;
                            case "3" -> showClientsByName();
//                            break;
                            case "4" -> showClientsByName();
//                            break;
                            default -> okClient = false;
                        }
                    }
                    break;
                case "3":
                    boolean okAppointment = true;
                    while(okAppointment) {
                        System.out.println("Alege una din urmatoarele optiuni:");
                        System.out.println("\t 1. Adauga programari");
                        System.out.println("\t 2. Afisaza programari + de implementat criterii");
                        System.out.println("\t 3. Sterge programari");
                        System.out.println("\t 4. Editeaza programari");
                        System.out.println("\t 0. Inapoi");
                        String optiuneProgramari = scanner.nextLine();
                        switch (optiuneProgramari) {
                            case "1" -> createAppointment();
//                            break;
                            case "2" -> showAppointmentRaw();
//                            break;
                            case "3" -> deleteAppointmentById();
//                            break;
                            case "4" -> editAppointmentById();
//                            break;
                            default -> okAppointment = false;
                        }
                    }
                break;
                case "4":
                    generateData();
                    System.out.println("Date generate cu succes!!!");
                    break;

                default: okMenu = false;
                break;
            }
        }
    }
    private void showEmployeesRaw(){
        if(employees.size() == 0)
            System.out.println("Nu exista angajati introdusi!");
        else {
            for (Employee emp : employees) {
                System.out.println(emp.toString());
            }
        }
    }

    private List<Employee> showEmployeesByName(){
        if(employees.size() == 0) {
            System.out.println("Nu exista angajati introdusi!");
            return null;
        }
        else {
            List<Employee> returnList = new ArrayList<>();
            boolean okShowEmp = true;
            while(okShowEmp) {
                System.out.println("Alegeti optiune:");
                System.out.println("\t 1. Afisati normal");
                System.out.println("\t 2. Afisati crescator dupa nume");
                System.out.println("\t 3. Afisati descrescator dupa nume");
                System.out.println("\t 0. Inapoi");
                Scanner scanner = new Scanner(System.in);
                String option = scanner.nextLine();
                switch (option) {
                    case "1":
                        for (int i = 0; i < employees.size(); i++) {
                            System.out.println((i + 1) + ". " + employees.get(i).getName());
                        }
                        returnList = employees;
                        break;
                    case "2":
                        List<Employee> ordereredEmp = employees.stream()
                                .sorted(Comparator.comparing(Employee::getName))
                                .toList();

                        for (int i = 0; i < ordereredEmp.size(); i++) {
                            System.out.println((i + 1) + ". " + ordereredEmp.get(i).getName());
                        }

                        returnList = ordereredEmp;
                        break;
                    case "3":
                        List<Employee> ordereredEmpReversed = employees.stream()
                                .sorted(Comparator.comparing(Employee::getName).reversed())
                                .toList();

                        for (int i = 0; i < ordereredEmpReversed.size(); i++) {
                            System.out.println((i + 1) + ". " + ordereredEmpReversed.get(i).getName());
                        }

                        returnList = ordereredEmpReversed;
                        break;
                    default: okShowEmp = false;
                }
            }
            return returnList;
        }
    }

    private List<Client> showClientsByName(){
        if(clients.size() == 0) {
            System.out.println("Nu exista clienti introdusi!");
            return null;
        }
        else {
            List<Client> returnList = new ArrayList<>();
            boolean okShowCli = true;
            while(okShowCli) {
                System.out.println("Alegeti optiune:");
                System.out.println("\t 1. Afisati normal");
                System.out.println("\t 2. Afisati crescator dupa nume");
                System.out.println("\t 3. Afisati descrescator dupa nume");
                System.out.println("\t 0. Inapoi");
                Scanner scanner = new Scanner(System.in);
                String option = scanner.nextLine();
                switch (option) {
                    case "1":
                        for (int i = 0; i < clients.size(); i++) {
                            System.out.println((i + 1) + ". " + clients.get(i).getName());
                        }
                        returnList = clients;
                        break;
                    case "2":
                        List<Client> ordereredCli = clients.stream()
                                .sorted(Comparator.comparing(Client::getName))
                                .toList();

                        for (int i = 0; i < ordereredCli.size(); i++) {
                            System.out.println((i + 1) + ". " + ordereredCli.get(i).getName());
                        }

                        returnList = ordereredCli;
                        break;
                    case "3":
                        List<Client> ordereredCliReversed = clients.stream()
                                .sorted(Comparator.comparing(Client::getName).reversed())
                                .toList();

                        for (int i = 0; i < ordereredCliReversed.size(); i++) {
                            System.out.println((i + 1) + ". " + ordereredCliReversed.get(i).getName());
                        }

                        returnList = ordereredCliReversed;
                        break;
                    default: okShowCli = false;
                }
            }
            return returnList;
        }
    }

    private List<Client> showClientsByName2(){
        if(clients.size() == 0) {
            System.out.println("Nu exista clienti introdusi!");
            return null;
        }
        else {
            List<Client> returnList = new ArrayList<>();
                System.out.println("Alegeti optiune:");
                System.out.println("\t 1. Afisati normal");
                System.out.println("\t 2. Afisati crescator dupa nume");
                System.out.println("\t 3. Afisati descrescator dupa nume");
                System.out.println("\t 0. Inapoi");
                Scanner scanner = new Scanner(System.in);
                String option = scanner.nextLine();
                switch (option) {
                    case "1":
                        for (int i = 0; i < clients.size(); i++) {
                            System.out.println((i + 1) + ". " + clients.get(i).getName());
                        }
                        returnList = clients;
                        break;
                    case "2":
                        List<Client> ordereredCli = clients.stream()
                                .sorted(Comparator.comparing(Client::getName))
                                .toList();

                        for (int i = 0; i < ordereredCli.size(); i++) {
                            System.out.println((i + 1) + ". " + ordereredCli.get(i).getName());
                        }

                        returnList = ordereredCli;
                        break;
                    case "3":
                        List<Client> ordereredCliReversed = clients.stream()
                                .sorted(Comparator.comparing(Client::getName).reversed())
                                .toList();

                        for (int i = 0; i < ordereredCliReversed.size(); i++) {
                            System.out.println((i + 1) + ". " + ordereredCliReversed.get(i).getName());
                        }

                        returnList = ordereredCliReversed;
                        break;
                }
            return returnList;
        }
    }

    private List<Employee> showEmployeesByJob(){
        if(employees.isEmpty()) {
            System.out.println("Nu exista angajati introdusi!");
            return null;
        }
        else {
            List<Employee> empList = null;
            System.out.println("Alege tipul de job:");
            Scanner scanner = new Scanner(System.in);
            System.out.println("\t 1. Cosmetica");
            System.out.println("\t 2. Coafor");
            System.out.println("\t 3. Manichiura");

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    System.out.println("Angajati cosmetica:");
                    empList = employees.stream()
                            .filter(job -> job instanceof Beautifier)
                            .collect(Collectors.toList());

                    for (int i = 0; i < empList.size(); i++) {
                        System.out.println("\t" + (i + 1) + ". " + empList.get(i).getName());
                    }
                break;
                case "2":
                    System.out.println("Angajati coafor:");
                    empList = employees.stream()
                            .filter(job -> job instanceof Hairdresser)
                            .collect(Collectors.toList());

                    for (int i = 0; i < empList.size(); i++) {
                        System.out.println("\t" + (i + 1) + ". " + empList.get(i).getName() + " position:" + i + " id:" + empList.get(i).getPersonId());
                    }
                break;
                case "3":
                    System.out.println("Angajati manichiura:");
                    empList = employees.stream()
                            .filter(job -> job instanceof Manicurist)
                            .collect(Collectors.toList());

                    for (int i = 0; i < empList.size(); i++) {
                        System.out.println("\t" + (i + 1) + ". " + empList.get(i).getName());
                    }
            }

            return empList;
        }
    }

    private void showAppointmentRaw(){
        if(appointments.size() == 0)
            System.out.println("Nu exista programari introduse!");
        else {
            for (Appointment app : appointments) {
                System.out.println(app.toString());
            }
        }
    }
    private Appointment getAppointmentById(int id){
//        Scanner scanner = new Scanner(System.in);
//        int id;
//        System.out.println("Dati id-ul programarii pe care doriti sa o stergeti:");
        for(int i = 0; i < appointments.size(); i++)
            if(appointments.get(i).getAppointmentId() == id)
                return appointments.get(i);

        return null;
    }
    private void editAppointmentById(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Dati ID-ul programarii pe care doriti sa o schimbati:");
        int appId = Integer.parseInt(scanner.nextLine());

        int auxEmpId = Objects.requireNonNull(getAppointmentById(appId)).getEmployeeId();
        int auxCliId = Objects.requireNonNull(getAppointmentById(appId)).getClientId();

        employees.forEach(employee -> {
            if(employee.getPersonId() == Objects.requireNonNull(getAppointmentById(appId)).getEmployeeId()) {
                List<Integer> aux = employee.getMonthlyAppointmentsCounter();
                if (Objects.requireNonNull(getAppointmentById(appId)).getStartDate().getDayOfMonth() <= employee.getPayday()) {
                    aux.set(Objects.requireNonNull(getAppointmentById(appId)).getStartDate().getMonthValue() - 1, aux.get(Objects.requireNonNull(getAppointmentById(appId)).getStartDate().getMonthValue() - 1) - 1);
                    employee.setMonthlyAppointmentsCounter(aux);
                }
                else{
                    aux.set(Objects.requireNonNull(getAppointmentById(appId)).getStartDate().getMonthValue(), aux.get(Objects.requireNonNull(getAppointmentById(appId)).getStartDate().getMonthValue()) - 1);
                    employee.setMonthlyAppointmentsCounter(aux);
                }
            }
        });
        List<Integer> aux = Manager.getManager().getMonthlyAppointmentsCounter();
        if (Objects.requireNonNull(getAppointmentById(appId)).getStartDate().getDayOfMonth() <= Manager.getManager().getPayday()) {
            aux.set(Objects.requireNonNull(getAppointmentById(appId)).getStartDate().getMonthValue() - 1, aux.get(Objects.requireNonNull(getAppointmentById(appId)).getStartDate().getMonthValue() - 1) - aux.get(Objects.requireNonNull(getAppointmentById(appId)).getCost()));
            Manager.getManager().setMonthlyAppointmentsCounter(aux);
        }
        else{
            aux.set(Objects.requireNonNull(getAppointmentById(appId)).getStartDate().getMonthValue(), aux.get(Objects.requireNonNull(getAppointmentById(appId)).getStartDate().getMonthValue()) - aux.get(Objects.requireNonNull(getAppointmentById(appId)).getCost()));
            Manager.getManager().setMonthlyAppointmentsCounter(aux);
        }

        int time;
        System.out.println("Alegeti durata (ore):");
        time = Integer.parseInt(scanner.nextLine());

        System.out.println("Introduceti data:");
        int year;
        System.out.println("\t An:");
        year = Integer.parseInt(scanner.nextLine());
        int month;
        System.out.println("\t Luna (1-12):");
        month = Integer.parseInt(scanner.nextLine());
        int day;
        System.out.println("Zi:");
        day = Integer.parseInt(scanner.nextLine());
        int finalEmpId = getAppointmentById(appId).getEmployeeId();
        List<Appointment> appointmentlist = appointments.stream()
                .filter(appointment -> appointment.getEmployeeId() == finalEmpId)
                .filter(appointment -> appointment.getStartDate().getYear() == year
                        && appointment.getStartDate().getMonthValue() == month
                        && appointment.getStartDate().getDayOfMonth() == day
                ).
                sorted(Comparator.comparing(Appointment::getStartDate)).toList();
        if (appointmentlist != null) {
            System.out.println("Urmatoarele intervale sunt ocupate:");
            for (int i = 0; i < appointmentlist.size(); i++)
                System.out.println(
                        String.valueOf(
                                appointmentlist.get(i).getStartDate().getHour()
                        )
                                + "-"
                                + String.valueOf(
                                appointmentlist.get(i).getEndDate().getHour()
                        )
                );
        }
        int hour;
        System.out.println("Alegeti ora:");
        hour = Integer.parseInt(scanner.nextLine());

        LocalDateTime startDate = LocalDateTime.of(year, month, day, hour, 0);
        LocalDateTime endDate = LocalDateTime.of(year, month, day, hour + time, 0);
        int cost;
        System.out.println("Alegeti pretul:");
        cost = Integer.parseInt(scanner.nextLine());

        appointments.forEach(appointment -> {
            if(appointment.getAppointmentId() == appId)
                appointments.remove(appointment);
        });

        appointments.add(new Appointment(auxEmpId, auxCliId, cost, startDate, endDate));

        employees.forEach(employee -> {
            if(employee.getPersonId() == finalEmpId) {
                List<Integer> aux2 = employee.getMonthlyAppointmentsCounter();
                if (day <= employee.getPayday()) {
                    aux2.set(month - 1, aux2.get(month - 1) + 1);
                    employee.setMonthlyAppointmentsCounter(aux2);
                }
                else{
                    aux2.set(month, aux2.get(month) + 1);
                    employee.setMonthlyAppointmentsCounter(aux2);
                }
            }
        });
        List<Integer> aux2 = Manager.getManager().getMonthlyAppointmentsCounter();
        if (day <= Manager.getManager().getPayday()) {
            aux2.set(month - 1, aux2.get(month - 1) + cost);
            Manager.getManager().setMonthlyAppointmentsCounter(aux2);
        }
        else{
            aux2.set(month, aux2.get(month) + cost);
            Manager.getManager().setMonthlyAppointmentsCounter(aux2);
        }
    }

    private void deleteAppointmentById(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dati id-ul programarii pe care doriti sa o stergeti:");
        int id = Integer.parseInt(scanner.nextLine());

        appointments.forEach(appointment -> {
            if(appointment.getAppointmentId() == id)
                appointments.remove(appointment);
        });
    }

    private void createEmployee(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose employee type:");
        System.out.println("\t 1. Beautifier");
        System.out.println("\t 2. Hairdresser");
        System.out.println("\t 3. Manicurist");
        String type = scanner.nextLine();
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Email: ");
        String email = scanner.nextLine();
        System.out.println("Salary: ");
        int salary = Integer.parseInt(scanner.nextLine());
        System.out.println("Payday: ");
        int payday = Integer.parseInt(scanner.nextLine());
        switch(type){
            case "1":
                employees.add(new Beautifier(name, phoneNumber, email, salary, payday));
                break;
            case "2":
                employees.add(new Hairdresser(name, phoneNumber, email, salary, payday));
                break;
            case "3":
                employees.add(new Manicurist(name, phoneNumber, email, salary, payday));
                break;
        }
    }

    private void createClient(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("New Client:");
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Email: ");
        String email = scanner.nextLine();
        System.out.println("Age: ");
        int age = Integer.parseInt(scanner.nextLine());
        clients.add(new Client(name, phoneNumber, email, age));
    }

    private void createAppointment(){
        Scanner scanner = new Scanner(System.in);
        boolean okEmp = true;
        int empId = -1;
        int clientId = -1;
        LocalDateTime startDate;
        LocalDateTime endDate;

        System.out.println("Alege angajat:");
        List<Employee> empList = showEmployeesByJob();
        System.out.println("\t 0. Inapoi");
        String optionEmployee = scanner.nextLine();
        if(!Objects.equals(optionEmployee, "0")) {
            empId = empList.get(Integer.parseInt(optionEmployee) - 1).getPersonId();
        }
        else okEmp = false;


        if(empId != -1) {
//            boolean clientOk = true;
            System.out.println("Client vechi sau nou?");
            System.out.println("\t 1. Nou");
            System.out.println("\t 2. Vechi");
            System.out.println("\t 0. Inapoi");
            String cliOption = scanner.nextLine();
            switch (cliOption) {
                case "1":
                    createClient();
                    // Ultimul adaugat este cel selectat
                    clientId = clients.get(clients.size() - 1).getPersonId();
//                    clientOk = false;
                    break;
                case "2":
                    System.out.println("Alege dintre urmatorii clienti:");
                    List<Client> clientList = showClientsByName2();
                    String choosenClient = scanner.nextLine();
                    clientId = clientList.get(Integer.parseInt(choosenClient) - 1).getPersonId();
//                    clientOk = false;
                    break;
                default:
//                    clientOk = false;
            }

            if(clientId != -1) {
                int time;
                System.out.println("Alegeti durata (ore):");
                time = Integer.parseInt(scanner.nextLine());

                System.out.println("Introduceti data:");
                int year;
                System.out.println("\t An:");
                year = Integer.parseInt(scanner.nextLine());
                int month;
                System.out.println("\t Luna (1-12):");
                month = Integer.parseInt(scanner.nextLine());
                int day;
                System.out.println("Zi:");
                day = Integer.parseInt(scanner.nextLine());
                int finalEmpId = empId;
                List<Appointment> appointmentlist = appointments.stream()
                        .filter(appointment -> appointment.getEmployeeId() == finalEmpId)
                        .filter(appointment -> appointment.getStartDate().getYear() == year
                                && appointment.getStartDate().getMonthValue() == month
                                && appointment.getStartDate().getDayOfMonth() == day
                        ).
                        sorted(Comparator.comparing(Appointment::getStartDate)).toList();
                if (appointmentlist != null) {
                    System.out.println("Urmatoarele intervale sunt ocupate:");
                    for (int i = 0; i < appointmentlist.size(); i++)
                        System.out.println(
                                String.valueOf(
                                        appointmentlist.get(i).getStartDate().getHour()
                                )
                                        + "-"
                                        + String.valueOf(
                                        appointmentlist.get(i).getEndDate().getHour()
                                )
                        );
                }
                int hour;
                System.out.println("Alegeti ora:");
                hour = Integer.parseInt(scanner.nextLine());

                startDate = LocalDateTime.of(year, month, day, hour, 0);
                endDate = LocalDateTime.of(year, month, day, hour + time, 0);
                int cost;
                System.out.println("Alegeti pretul:");
                cost = Integer.parseInt(scanner.nextLine());

                appointments.add(new Appointment(clientId, empId, cost, startDate, endDate));
                employees.forEach(employee -> {
                    if(employee.getPersonId() == finalEmpId) {
                        List<Integer> aux = employee.getMonthlyAppointmentsCounter();
                        if (day <= employee.getPayday()) {
                            aux.set(month - 1, aux.get(month - 1) + 1);
                            employee.setMonthlyAppointmentsCounter(aux);
                        }
                        else{
                            aux.set(month, aux.get(month) + 1);
                            employee.setMonthlyAppointmentsCounter(aux);
                        }
                    }
                });
                List<Integer> aux = Manager.getManager().getMonthlyAppointmentsCounter();
                if (day <= Manager.getManager().getPayday()) {
                    aux.set(month - 1, aux.get(month - 1) + cost);
                    Manager.getManager().setMonthlyAppointmentsCounter(aux);
                }
                else{
                    aux.set(month, aux.get(month) + cost);
                    Manager.getManager().setMonthlyAppointmentsCounter(aux);
                }
            }
        }
    }

    private void generateData(){
        clients.add(new Client(
                "Client 1",
                "0741112113",
                "client1@mail.com",
                20
        ));
        clients.add(new Client("Client 3",
                "0741112114",
                "client3@mail.com",
                22
        ));
        clients.add(new Client("Client 2",
                "0741112115",
                "client2@mail.com",
                21
        ));
        employees.add(new Hairdresser(
                "Hairdresser 1",
                "0741112113",
                "hairdresser1@mail.com",
                1400,
                15
        ));
        employees.add(new Hairdresser(
                "Hairdresser 3",
                "0741112114",
                "hairdresser3@mail.com",
                1400,
                15
        ));
        employees.add(new Hairdresser(
                "Hairdresser 2",
                "0741112115",
                "hairdresser2@mail.com",
                1400,
                15
        ));
        employees.add(new Beautifier(
                "Beautifier 1",
                "0741112113",
                "beautifier1@mail.com",
                1400,
                15
        ));
        employees.add(new Beautifier(
                "Beautifier 3",
                "0741112114",
                "beautifier3@mail.com",
                1400,
                15
        ));
        employees.add(new Beautifier(
                "Beautifier 2",
                "0741112115",
                "beautifier2@mail.com",
                1400,
                15
        ));
        LocalDateTime startDateTime1 = LocalDateTime.of(2022, 7, 1, 14, 0);
        LocalDateTime endDateTime1 = LocalDateTime.of(2022, 7, 1, 15, 0);
        LocalDateTime startDateTime2 = LocalDateTime.of(2022, 7, 1, 16, 0);
        LocalDateTime endDateTime2 = LocalDateTime.of(2022, 7, 1, 18, 0);
        LocalDateTime startDateTime3 = LocalDateTime.of(2022, 7, 2, 14, 0);
        LocalDateTime endDateTime3 = LocalDateTime.of(2022, 7, 2, 16, 0);
        appointments.add(new Appointment(1, 4, 200, startDateTime1, endDateTime1));
        appointments.add(new Appointment(2, 4, 220, startDateTime2, endDateTime2));
        appointments.add(new Appointment(3, 4, 210, startDateTime3, endDateTime3));
    }
}
