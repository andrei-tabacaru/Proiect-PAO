package project.services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;


public class AuditService {
    private static AuditService auditService;
    private static String auditFilePath;

    private AuditService() {
        AuditService.auditFilePath = "src/project/csv_files/auditReportData.csv";
    }
    public static AuditService getAuditService() {
        if (auditService == null) {
            auditService = new AuditService();
        }
        return auditService;
    }

    public void writeAuditDataReport(String action) {
        if(!(new File(auditFilePath).exists())) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(auditFilePath))) {
                bufferedWriter.append("ACTION");
                bufferedWriter.append(",");
                bufferedWriter.append("TIMESTAMP");
                bufferedWriter.append("\n");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(auditFilePath, true))) {
            bufferedWriter.append(action);
            bufferedWriter.append(",");
            bufferedWriter.append(String.valueOf(new Timestamp(System.currentTimeMillis())));
            bufferedWriter.append("\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
