package com.example.designpattern.report.jasperReport;

import net.sf.jasperreports.engine.JasperCompileManager;

public class CompileReport {
    public static void main(String[] args) {
        try {
            String jrxmlPath = "src/main/resources/report_template.jrxml";
            String jasperPath = "src/main/resources/report_template.jasper";
            JasperCompileManager.compileReportToFile(jrxmlPath, jasperPath);
            System.out.println("Report compiled successfully: " + jasperPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
