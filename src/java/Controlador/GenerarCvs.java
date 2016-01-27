/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.GestionBD;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author Maskatesta
 */
public class GenerarCvs extends HttpServlet {
       public String[] BD1 = new String[400];
    public String[] BD2 = new String[400];
    public String[] BD3 = new String[400];
    public String[] BD4 = new String[400];
    public String[] BD5 = new String[400];


    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                
            
            ResultSet resultadoBD;
            GestionBD GestionBD = new GestionBD();
            resultadoBD=GestionBD.consultas();

           try {
               int r=0;
               while (resultadoBD.next()) {
                   BD1[r]=resultadoBD.getString("nom");
                   BD2[r]=resultadoBD.getString("ape");
                   BD3[r]=resultadoBD.getString("pais");
                   BD4[r]=resultadoBD.getString("muni");
                   BD5[r]=resultadoBD.getString("correo");
                   r++;        
               }
           } catch (SQLException e) {
               System.out.println(e.getMessage()+"XDDDD");
           }

            
            
             int iteracion=Integer.valueOf(request.getParameter("iteracion2"));
            String tipoDato= request.getParameter("campos2");
            String delimitador =request.getParameter("delimit");
            String nameArchivo=request.getParameter("nameCVS");
            
            System.out.println(delimitador);
            System.out.println(nameArchivo);
            
            
            
            String atributos[] =new String[iteracion];
                   
            for (int i = 0; i < iteracion; i++) {
                atributos[i]=request.getParameter("txt"+(i+1));
            }
            
              String rutaArchivo = "C:\\"+nameArchivo+".xls";//xls
        /*Se crea el objeto de tipo File con la ruta del archivo*/
        File archivoXLS = new File(rutaArchivo);
        /*Si el archivo existe se elimina*/
        if(archivoXLS.exists()) archivoXLS.delete();
        /*Se crea el archivo*/
        archivoXLS.createNewFile();
        
        /*Se crea el libro de excel usando el objeto de tipo Workbook*/
            Workbook libro = new HSSFWorkbook();
        /*Se inicializa el flujo de datos con el archivo xls*/
            FileOutputStream archivo = new FileOutputStream(archivoXLS);
        
        /*Utilizamos la clase Sheet para crear una nueva hoja de trabajo dentro del libro que creamos anteriormente*/
            Sheet hoja = libro.createSheet("Datos");
        
        /*Hacemos un ciclo para inicializar los valores de 10 filas de celdas*/
            Row fila = hoja.createRow(0);
            Cell celda;
            Random rand = new Random();
             for(int f=0;f<iteracion;f++){
                 celda = fila.createCell(f);
                 celda.setCellValue(atributos[f]);
            }
             
               for (int j = iteracion; j < (10+iteracion); j++) {  
                 celda = fila.createCell(j);
                   
                
                for (int i = 0; i < tipoDato.length(); i++) {
                    char c=tipoDato.charAt(i);
                    if(c != ','){
                            
                           
                            switch (c) {
                            
                            case '1':
                                celda.setCellValue(BD1[rand.nextInt(399)]);
                                break;
                            case '2':
                                celda.setCellValue(BD2[rand.nextInt(399)]);
                                break;
                            case '3':
                                celda.setCellValue(BD3[rand.nextInt(399)]);
                                break;
                            case '4':
                                celda.setCellValue(BD4[rand.nextInt(399)]);
                                break;
                            case '5':
                                celda.setCellValue(String.valueOf(rand.nextInt(9999)));
                                break;
                            case '6':
                                celda.setCellValue(String.valueOf(rand.nextInt(999999999)));
                                break;
                            case '7':
                                celda.setCellValue(BD1[rand.nextInt(399)]+"@"+BD5[rand.nextInt(399)]);
                                break;
                            }
                                celda.setCellValue(String.valueOf(delimitador));
                        }               
                       
                    }  
                 
                }
               
            
        libro.write(archivo);
        archivo.close();
        Desktop.getDesktop().open(archivoXLS);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
