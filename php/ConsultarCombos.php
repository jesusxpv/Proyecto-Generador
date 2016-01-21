<?php


/**
* 
*/
class Combos{
	public $ejecutar;
	public $Conex;
	public $tipo;
	public $row;
	public $datos;
	
	function __construct(){
		include_once("Conexion.php");
		$this->Conex = new Conexion();

	}


	public function verificar(){

			
				$this->cadena="select * from nombres";
				$this->querie=$this->Conex->consultar($this->cadena);
				$this->datos=$this->querie->fetch_all(MYSQLI_ASSOC);
	
				foreach ($this->datos as $this->row) {
					 
						
						$this->nombre=$this->row["nombre"];
						$nameBD[]=$this->nombre;
						
				}	


				
				for($a=0;$a<1000000;$a++){
					$name[]=$nameBD[rand(0,399)];
				}



				return $name;

	}
}

$ejecutar= new Combos();
$ejecutar->verificar();

?>