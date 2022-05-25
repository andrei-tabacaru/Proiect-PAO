package project;

import project.classes.*;

public class Main {
    public static void main(String[] args) {
        Person cli = new Client();
        System.out.println(cli);
        cli.setEmail("test");
        cli.setName("test");
        cli.setPhoneNumber("test");
        System.out.println(cli);

        Employee emp = new Beautifier();
        System.out.println(emp.getClass());

        Beautifier b = null;
        if(emp instanceof Beautifier)
            b = (Beautifier)emp;

        System.out.println(b.getClass());

        Employee manager = new Manager();
    }
}
