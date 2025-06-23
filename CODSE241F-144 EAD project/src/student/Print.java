/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student;

import java.sql.Connection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author User
 */
public class Print {
    public Print (String chid, Connection conn) {
        
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("chid",chid);
        try {
            JasperReport jasperReport =  (JasperReport) JRLoader.loadObject(getClass().getResourceAsStream("/student/jasperReport.jasper"));
            
            JasperPrint jp = JasperFillManager.fillReport(jasperReport, parameters, conn);
            
            JasperViewer.viewReport(jp,true);
        } catch (JRException ex) {
            Logger.getLogger(Print.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}


    

