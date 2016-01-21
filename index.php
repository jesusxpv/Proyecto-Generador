<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="utf-8"/>
	<title>Generador</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body onload="start()">

<div id="abc">
	
</div>

<div class="container">
	<div class="row">

		<!--
		<div class="col-md-4 col-md-offset-4">
			<form class="text-center">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Número de filas" />
				</div>
				<div class="form-group">
					<input type="button" value="Agregar" class="btn btn-xl" onclick="addFilas()" />
				</div>
			</form>
		</div>
		-->

		<div class="col-md-8 col-md-offset-2">	
		 	<form  id="nomFilas" class="text-center"> 
		 		<div id="filasAgragadas">
		 			<ul class='list-inline'>
		 				<li><input type='text' id="txt1" class='form-control' placeholder='Nombre de columna'></li>
		 				<li><select  id="comb1" onchange="comb1Busqueda()" class='form-control'>
		 						<option>Seleccionar tipo de dato</option>
		 						<option value="name">Nombre</option>
		 						<option value="last">Apellido</option>
		 						<option value="country">País</option>
		 						<option value="state">Estado</option>
		 						<option value="muni">Municipio</option>
		 						<option value="cp">Codigo postal</option>
		 						<option value="phone">Telefono</option>
		 					</select>
		 				</li>
		 			</ul>
		 			<ul class='list-inline'>
		 				<li><input type='text' id="txt2" class='form-control' placeholder='Nombre de columna'></li>
		 				<li><select id="comb2" class='form-control'>
		 						<option>Seleccionar tipo de dato</option>
		 						<option>Nombre</option>
		 						<option>Apellido</option>
		 						<option>País</option>
		 						<option>Estado</option>
		 						<option>Municipio</option>
		 						<option>Codigo postal</option>
		 						<option>Telefono</option>
		 					</select>
		 				</li>
		 			</ul>
		 			<ul class='list-inline'>
		 				<li><input type='text' id="txt3" class='form-control' placeholder='Nombre de columna'></li>
		 				<li><select id="comb3" class='form-control'>
		 						<option>Seleccionar tipo de dato</option>
		 						<option>Nombre</option>
		 						<option>Apellido</option>
		 						<option>País</option>
		 						<option>Estado</option>
		 						<option>Municipio</option>
		 						<option>Codigo postal</option>
		 						<option>Telefono</option>
		 					</select>
		 				</li>
		 			</ul>
		 			<ul class='list-inline'>
		 				<li><input type='text' id="txt4" class='form-control' placeholder='Nombre de columna'></li>
		 				<li><select id="comb4" class='form-control'>
		 						<option>Seleccionar tipo de dato</option>
		 						<option>Nombre</option>
		 						<option>Apellido</option>
		 						<option>País</option>
		 						<option>Estado</option>
		 						<option>Municipio</option>
		 						<option>Codigo postal</option>
		 						<option>Telefono</option>
		 					</select>
		 				</li>
		 			</ul>
		 			<ul class='list-inline'>
		 				<li><input type='text' id="txt5" class='form-control' placeholder='Nombre de columna'></li>
		 				<li><select id="comb5" class='form-control'>
		 						<option>Seleccionar tipo de dato</option>
		 						<option>Nombre</option>
		 						<option>Apellido</option>
		 						<option>País</option>
		 						<option>Estado</option>
		 						<option>Municipio</option>
		 						<option>Codigo postal</option>
		 						<option>Telefono</option>
		 					</select>
		 				</li>
		 			</ul>
		 			<ul class='list-inline'>
		 				<li><input type='text' id="txt6" class='form-control' placeholder='Nombre de columna'></li>
		 				<li><select id="comb6" class='form-control'>
		 						<option>Seleccionar tipo de dato</option>
		 						<option>Nombre</option>
		 						<option>Apellido</option>
		 						<option>País</option>
		 						<option>Estado</option>
		 						<option>Municipio</option>
		 						<option>Codigo postal</option>
		 						<option>Telefono</option>
		 					</select>
		 				</li>
		 			</ul>
		 			<ul class='list-inline'>
		 				<li><input type='text' id="txt7" class='form-control' placeholder='Nombre de columna'></li>
		 				<li><select id="comb7" class='form-control'>
		 						<option>Seleccionar tipo de dato</option>
		 						<option>Nombre</option>
		 						<option>Apellido</option>
		 						<option>País</option>
		 						<option>Estado</option>
		 						<option>Municipio</option>
		 						<option>Codigo postal</option>
		 						<option>Telefono</option>
		 					</select>
		 				</li>
		 			</ul>
		 			<ul class='list-inline'>
		 				<li><input type='text' id="txt8" class='form-control' placeholder='Nombre de columna'></li>
		 				<li><select  id="comb8" class='form-control'>
		 						<option>Seleccionar tipo de dato</option>
		 						<option>Nombre</option>
		 						<option>Apellido</option>
		 						<option>País</option>
		 						<option>Estado</option>
		 						<option>Municipio</option>
		 						<option>Codigo postal</option>
		 						<option>Telefono</option>
		 					</select>
		 				</li>
		 			</ul>
		 			<ul class='list-inline'>
		 				<li><input type='text' id="txt9" class='form-control' placeholder='Nombre de columna'></li>
		 				<li><select id="comb9" class='form-control'>
		 						<option>Seleccionar tipo de dato</option>
		 						<option>Nombre</option>
		 						<option>Apellido</option>
		 						<option>País</option>
		 						<option>Estado</option>
		 						<option>Municipio</option>
		 						<option>Codigo postal</option>
		 						<option>Telefono</option>
		 					</select>
		 				</li>
		 			</ul>
		 			<ul class='list-inline'>
		 				<li><input type='text' id="txt10" class='form-control' placeholder='Nombre de columna'></li>
		 				<li><select id="comb10" class='form-control'>
		 						<option>Seleccionar tipo de dato</option>
		 						<option>Nombre</option>
		 						<option>Apellido</option>
		 						<option>País</option>
		 						<option>Estado</option>
		 						<option>Municipio</option>
		 						<option>Codigo postal</option>
		 						<option>Telefono</option>
		 					</select>
		 				</li>
		 			</ul>
		 		</div>			
  			</form>
		</div>





 
		<div class="col-md-8 col-md-offset-2">
			<div>

		  <!-- Nav tabs -->
		 		<ul class="nav nav-tabs" role="tablist">
		    		<li role="presentation" class="active"><a href="#csv" aria-controls="csv" role="tab" data-toggle="tab">Csv</a></li>
		   			<li role="presentation"><a href="#sql" aria-controls="sql" role="tab" data-toggle="tab">Sql</a></li>
		  		</ul>

		  <!-- Tab panes -->
		  		<div class="tab-content">

		    		<div role="tabpanel" class="tab-pane active" id="csv">
		    			<div class="container-fluid">
		  					<div class="row">
		  						<div class="col-md-12">
		  							<form>
		  								<div class="form-group">
		  							 		Caracter(es) delimitador(es) <input type="text" class="text-delim" placeholder="|">
		  								</div>
		  								<div class="form-group text-right">
											<button type="button" class="btn btn-xl" onclick="btnGenerateCsv()" >Generar</button>
										</div>
		  							</form>
		  						</div>
		  					</div>
		  				</div>	
		    		</div>

		    		<div role="tabpanel" class="tab-pane" id="sql">
		    			<div class="container-fluid">
		  					<div class="row">
		  						<div class="col-md-12">
		  							<form>
		  								<div class="form-group">
											<input type="text" class="text-name-table" placeholder="Nombre de la tabla">
										</div>
		  								<div class="form-group">
		  							 		<input type="CHECKBOX"> Entrecomillar nombres (tablas-columnas)
		  								</div>
		  								<div class="form-group text-right">
											<button type="button" class="btn btn-xl">Generar</button>
										</div>
		  							</form>
		  						</div>
		  					</div>
		  				</div>	
		    		</div>

		  		</div> <!-- end contenido pestañas -->

			</div><!-- end pestañas -->
		</div><!-- end col -->
	



<script src="js/jquery-1.12.0.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/addFilas.js"></script>


</body>
</html>



