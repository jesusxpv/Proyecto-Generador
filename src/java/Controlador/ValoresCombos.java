/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.GestionBD;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Maskatesta
 */
public class ValoresCombos extends HttpServlet {
    
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
            String nameBD =request.getParameter("nameBD");
            String nameTable=request.getParameter("nameTable");
            
            System.out.println(nameBD);
            System.out.println(nameTable);
            
            
            
            String atributos[] =new String[iteracion];
                   
            for (int i = 0; i < iteracion; i++) {
                atributos[i]=request.getParameter("txt"+(i+1));
            }
            
            String ruta = "C:\\"+nameBD+".sql";
            File archivo = new File(ruta);
            BufferedWriter bw;
            Random rand = new Random();
         
            
                bw = new BufferedWriter(new FileWriter(archivo));
                bw.write("create database "+nameBD+"; \r\n");      
                bw.write("use "+nameBD+"; \r\n\r\n");      
                
                bw.write("create table "+nameTable+"(\r\n");      
                bw.write("id_table int primary key auto_increment,\r\n");
                
                    for(int i = 0; i < iteracion; i++){
                        bw.write(atributos[i]+" varchar(200),\r\n");
                    }
                         bw.write("); \r\n\r\n");
                  
                int contador=0;
                     
               for (int j = 0; j < 1000000; j++) {  
                   
                bw.write("insert into "+nameTable+" values (");
                bw.write(String.valueOf(j+1)+",");     
                for (int i = 0; i < tipoDato.length(); i++) {
                    char c=tipoDato.charAt(i);
                    if(c != ','){
                            
                           
                            switch (c) {
                            
                            case '1':
                                bw.write(BD1[rand.nextInt(399)]);
                                break;
                            case '2':
                                bw.write(BD2[rand.nextInt(399)]);
                                break;
                            case '3':
                                bw.write(BD3[rand.nextInt(399)]);
                                break;
                            case '4':
                                bw.write(BD4[rand.nextInt(399)]);
                                break;
                            case '5':
                                bw.write(String.valueOf(rand.nextInt(9999)));
                                break;
                            case '6':
                                bw.write(String.valueOf(rand.nextInt(999999999)));
                                break;
                            case '7':
                                bw.write(BD1[rand.nextInt(399)]+"@"+BD5[rand.nextInt(399)]);
                                break;
                            }
                                bw.write(",");
                        }               
                       
                    }  
                 bw.write(" );\r\n");
                }
                 System.out.println("archivo Terminado");
                         
                
                bw.close();
            
            out.print("Archivo terminado");
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
