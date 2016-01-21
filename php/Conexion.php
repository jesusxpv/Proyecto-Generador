<?php



/**
* 
*/
class Conexion{
	public $Ruta="localhost";
	public $User="root";
	public $Password="";
	public $NameBD="GENERADORBD";	
	public $Conex;
	public $preparar;
	public $cadena;
	public $posicion;
	public $row;
	public $querie;
	public $datos;

	function __construct(){
		$this->Conex =  new mysqli($this->Ruta,$this->User,$this->Password,$this->NameBD);			
	}


	public function consultar($cadena){
		return $this->Conex->query($cadena);
	}
}







?>