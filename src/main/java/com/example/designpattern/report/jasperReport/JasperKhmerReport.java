package com.example.designpattern.report.jasperReport;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.engine.export.JRPdfExporter;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class JasperKhmerReport {

    public static void main(String[] args) {
        try {
            // Path to the compiled Jasper file
            String jasperPath = "src/main/resources/report_template.jasper";

            // Data source (Empty here as we use static text in the template)
            JRDataSource dataSource = new JREmptyDataSource();

            // Parameters for the report
            Map<String, Object> parameters = new HashMap<>();

            // Fill the report
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperPath, parameters, dataSource);

            // Export to PDF
            String outputPdfPath = "KhmerReport.pdf";
            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(new File(outputPdfPath)));

            // Configure PDF export
            SimplePdfExporterConfiguration exportConfig = new SimplePdfExporterConfiguration();
            exportConfig.setTagged(true); // Enable tagged PDFs for accessibility
            exporter.setConfiguration(exportConfig);

            // Export the report
            exporter.exportReport();

            System.out.println("PDF generated successfully: " + outputPdfPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
