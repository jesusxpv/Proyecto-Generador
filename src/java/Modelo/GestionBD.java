/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.sql.CallableStatement;
import java.sql.ResultSet;

/**
 *
 * @author Maskatesta
 */
public class GestionBD {
     ResultSet resultado;

    
    
     public ResultSet consultas(){//metodod para buscar a persona
        try {//atrapamos errores
            Conexion objConexion=new Conexion();//objeto para hacer conexion a la BD
            String procedure="{call sp_datos()}";//variable que contiene el procedure a ejecutar
            CallableStatement cs=objConexion.getConexion().prepareCall(procedure);//ejecuatremos el procedure

            resultado=cs.executeQuery();
            
           
           return resultado;
        } catch (Exception e) {
            e.printStackTrace();
            return  resultado;
        }       
         
        
    }
    
}
