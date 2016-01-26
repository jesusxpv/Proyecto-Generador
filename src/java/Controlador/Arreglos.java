/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.GestionBD;
import Modelo.TipoCombo;
import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author Maskatesta
 */
public class Arreglos {
      
    public String[] BD1 = new String[400];
    public String[] BD2 = new String[400];
    public String[] BD3 = new String[400];
    public String[] BD4 = new String[400];
    public String[] BD5 = new String[400];
    
    public String[] combo1 = new String[1000000];
    public String[] combo2 = new String[1000000];
    public String[] combo3 = new String[1000000];
    public String[] combo4 = new String[1000000];
    public String[] combo5 = new String[1000000];
    public String[] combo6 = new String[1000000];
    public String[] combo7 = new String[1000000];
    
    public String btn;
    public int cargar;
    
    public Arreglos(String btn, int cargar){
        this.btn=btn;
        this.cargar=cargar;
    }
    
    public Arreglos(String btn){
        this.btn=btn;
        System.out.println(btn);
    }
  
    
    public void arrays() throws FileNotFoundException, IOException{
        if(btn.equals("btnSql")){
             
            System.out.println("iniciando archivo SQL");
             
            String ruta = "C:\\archivo3.txt";
            File archivo = new File(ruta);
            BufferedWriter bw;
            
            ResultSet resultadoBD;
            GestionBD GestionBD = new GestionBD();
            resultadoBD=GestionBD.consultas();

           try {
               int i=0;
               while (resultadoBD.next()) {
                   BD1[i]=resultadoBD.getString("nom");
                   BD2[i]=resultadoBD.getString("ape");
                   BD3[i]=resultadoBD.getString("pais");
                   BD4[i]=resultadoBD.getString("muni");
                   BD5[i]=resultadoBD.getString("correo");
                   i++;        
               }
           } catch (SQLException e) {
               System.out.println(e.getMessage()+"XDDDD");
           }

           Random rand = new Random();
           for (int i = 0; i < 1000000; i++) {
               combo1[i]=BD1[rand.nextInt(399)];
               combo2[i]=BD2[rand.nextInt(399)];
               combo3[i]=BD3[rand.nextInt(399)];
               combo4[i]=BD4[rand.nextInt(399)];
               combo5[i]=String.valueOf(rand.nextInt(9999));
               combo6[i]=String.valueOf(rand.nextInt(999999999));                  
               combo7[i]=BD1[rand.nextInt(399)]+"@"+BD5[rand.nextInt(399)];
           }
            System.out.println("Terminado");
            
            try {
                if(archivo.exists()) {
                     bw = new BufferedWriter(new FileWriter(archivo));
                     for (int i = 0; i < 1000000; i++){      
                         
                
                         bw.write("insert into jesus values("+combo1[i]+combo2[i]+combo3[i]+combo4[i]+combo5[i]+combo6[i]+combo7[i]+");\r\n");
                     }
                }else{
                    bw = new BufferedWriter(new FileWriter(archivo));
                    bw.write("Acabo de crear el fichero de texto.");
                }
                bw.close();
                System.out.println("Sql terminado");
            } catch (IOException ex) {
                     Logger.getLogger(Arreglos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else if(btn.equals("btnCvs")){
             /*La ruta donde se creará el archivo*/
        String rutaArchivo = "C:\\ejemploExcelJava.csv";//xls
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
        Sheet hoja = libro.createSheet("Mi hoja de trabajo 1");
        
        /*Hacemos un ciclo para inicializar los valores de 10 filas de celdas*/
        for(int f=0;f<10;f++){
            /*La clase Row nos permitirá crear las filas*/
            Row fila = hoja.createRow(f);
            
            /*Cada fila tendrá 5 celdas de datos*/
            for(int c=0;c<5;c++){
                /*Creamos la celda a partir de la fila actual*/
                Cell celda = fila.createCell(c);
                
                /*Si la fila es la número 0, estableceremos los encabezados*/
                if(f==0){
                    celda.setCellValue("Encabezado #"+c);
                }else{
                    /*Si no es la primera fila establecemos un valor*/
                    celda.setCellValue("Valor celda "+c+","+f);
                }
            }
        }
        
        /*Escribimos en el libro*/
        libro.write(archivo);
        /*Cerramos el flujo de datos*/
        archivo.close();
        /*Y abrimos el archivo con la clase Desktop*/
        Desktop.getDesktop().open(archivoXLS);
        
            
        }
        
    }
    
}
