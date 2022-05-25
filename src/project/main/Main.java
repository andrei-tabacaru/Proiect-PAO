package project.main;

import project.classes.*;
import project.services.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.format.DateTimeFormatter.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Service s = new Service();

        Service.csvTest();
    }
}
