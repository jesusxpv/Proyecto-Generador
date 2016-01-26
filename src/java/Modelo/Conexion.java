/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Maskatesta
 */
public class Conexion {
    private Connection con; // se decara para la comunicacion entre la aplicacion y la base de datos
    private final String ruta; // donde se encuentra la base de 
    private final String usuario;//nombre del usuario de la base de datos
    private final String password;  //contraseña de la base de datos


    public Conexion(){
        ruta="jdbc:mysql://localhost:3306/generadorbd"; //se da la ruta de la base de datos
        usuario="root"; //nombre del usuario
        password="";    //contraseña del usuario

    }


       public Connection getConexion(){ //se crea un metodo con Connection
           
           try {    //atrapamos los errores
               Class.forName("com.mysql.jdbc.Driver");      //ruta del drive a para la conexion
               con=DriverManager.getConnection(ruta,usuario,password);  //conexion a la base de datos atraves de la ruta, usuario y password
               return  con; //retorna la conexion si es verdadero
                     } catch (Exception e) {  //  atrapara el error
                          e.printStackTrace();
                          JOptionPane.showMessageDialog(null,"no se a conectado a la base de datos");//muestra cual fue tu error
                     }
           return con;// si no se conecta se repite el ciclo

       }
    
    
}
