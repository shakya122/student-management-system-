/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author User
 */
public class ReportPrinter {
   public void printReport() {
        String username = "root";
        String password = "hirumay22#";
        String dataConn = "jdbc:mysql://localhost:3306/student_management";
        java.sql.Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
                   con = DriverManager.getConnection(dataConn,username,password);
            String reportPath = "C:\\Users\\User\\JaspersoftWorkspace\\MyReports\\reports\\jasperReport1.jrxml";
            JasperReport jr = JasperCompileManager.compileReport(reportPath);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, con);

            JasperViewer.viewReport(jp);
            con.close();

        } catch (ClassNotFoundException | SQLException | JRException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}