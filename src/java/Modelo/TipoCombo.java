/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

/**
 *
 * @author Maskatesta
 */
public class TipoCombo {
    
    public String nombreCombo;
    public int tipoDato;
    
   
    
    public void setNombreCombo(String nombreCombo){
        this.nombreCombo=nombreCombo;
    }
    
    public String getNombreCombo(){
        return this.nombreCombo;
    }
    
    
    public void setTipoDato(int tipoDato){
        this.tipoDato=tipoDato;
    }
    
     public int getTipoDato(){
        return this.tipoDato;
    }
    
    
}
