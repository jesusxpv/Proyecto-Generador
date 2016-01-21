<?php


/**
* 
*/
class Archivotxt{
	public $ejecutar;
	public $Conex;
	public $tipo;
	public $row;
	public $datos;
	
	
	public $Combos;
	public $valor;

	public $name;
	public $nameBD;

	function __construct(){
		include_once("Conexion.php");
		$this->Conex = new Conexion();
		$this->valor=$_POST['valor'];
	}	

	public function manipulacion(){
		switch ($this->valor) {
			case '1': //inicia las consultas y aleatoriamente guarda 1,000,000 de registros en el array

				$this->consultasGenerales();
				
				
				break;

			case '2': 

			$this->crearCsv();
			
			
				break;
			
			default:
				# code...
				break;
		}

	}

	public function consultasGenerales(){
			$this->cadena="select * from nombres";
			$this->querie=$this->Conex->consultar($this->cadena);
			$this->datos=$this->querie->fetch_all(MYSQLI_ASSOC);

			foreach ($this->datos as $this->row) {
					$this->nombre=$this->row["nombre"];
					$this->nameBD[]=$this->nombre;	
			}	
			
			for($a=0;$a<100;$a++){
				$this->name[]=$this->nameBD[rand(0,399)];
			}
	}



	public function crearCsv(){
		
		
		$ar = fopen("C:\\resource.txt", "w") or
			die("Problemas en la creacion");

		for($a=0;$a<10;$a++){
			
			
		 fwrite($ar,$a.$this->nameBD[$a]);
		 fwrite($ar,"\r\n");  					
		}

		fclose($ar);
		


	}
}



$ejecutar= new Archivotxt();
$ejecutar->manipulacion();

?>