<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="utf-8"/>
	<title>Generador</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>


<div class="container">
	<div class="row">
		<div class="col-md-8 col-md-offset-2">	
		 	<form  class="text-center">  	
				<ul class="list-inline">
					<li><input type="text" class="form-control" placeholder="Nombre de columna"></li>
					<li>
						<select class="form-control">
							<option value="">Nombre completo</option>
							<option value="">Jesus</option>
							<option value="">Jesus</option>
						</select>
					</li>
					<li><input type="text" class="form-control" placeholder="Columna"></li>
				</ul>
				
				<div class="form-group text-right">
					<input type="text" class="btn-addfilas" placeholder="Añadir"/>
					<button type="submit" class="btn btn-xl">fila(s)</button>	
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
		  							 		<input type="CHECKBOX"> Incluir sentencia create table
		  								</div>
		  								<div class="form-group">
		  							 		<input type="CHECKBOX"> Incluir sentencia drop table
		  								</div>
		  								<div class="form-group">
		  							 		<input type="CHECKBOX"> Entrecomillar nombres (tablas-columnas)
		  								</div>
		  							</form>
		  						</div>
		  					</div>
		  				</div>	
		    		</div>

		  		</div> <!-- end contenido pestañas -->

			</div><!-- end pestañas -->
		</div><!-- end col -->
	




		<div class="col-md-8 col-md-offset-2">
			<form class="text-right">
				<div class="form-group">
					<button class="btn btn-xl">Generar</button>
				</div>
			</form>
		</div><!-- end col -->
	</div><!-- end row -->
</div><!-- end container generar -->




<script src="js/jquery-1.12.0.js"></script>
<script src="js/bootstrap.js"></script>


</body>
</html>



