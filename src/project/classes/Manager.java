package project.classes;

import java.time.LocalDateTime;

public class Manager extends Employee{
    private static String managerName;
    private static Manager manager;
    private Manager() {
        super("Mr. John Smith","0741112112", "manager@s.beauty.com", 0, 15, 0);
        managerName = "Mr. John Smith";
    }
    public static Manager getManager() { //3
        if (manager == null)
            manager = new Manager();
        return manager;
    }
    public static void showManager(){
        System.out.println("Manager: " + managerName);
    }

}
