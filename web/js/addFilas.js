var XMLHttp;
	function startXMLHttp() {
		if(window.XMLHttpRequest){
			XMLHttp= new XMLHttpRequest();
		}else{
			XMLHttp= ActiveXObject("Microsoft.XMLHTTP");
		}
    }
    
    
    
    function  abc(){
        startXMLHttp();
        var campos="";
        var iteracion=0;
        
        for (var i=1;i<11;i++){
            
          if(document.getElementById("comb"+i).value > 0){
              
              campos+=document.getElementById("comb"+i).value+",";
              iteracion++;
          }//end if
        }//end for
        
        var valores;
        valores="campos2="+campos+"&iteracion2="+iteracion;
        alert(valores);
         
         
        XMLHttp.open("POST","ValoresCombos", true);
            XMLHttp.onreadystatechange = function (){
                    if(XMLHttp.readyState === 4 & XMLHttp.status === 200){
                                    document.getElementById("abc").innerHTML=XMLHttp.responseText;
                                    //alert(XMLHttp.responseText);
                    }
            }
    XMLHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    XMLHttp.send(valores);
}//end fuction





























/*function combBusqueda(a){
    var tipo=document.getElementById("comb"+a).value; 
    if(tipo>0){
        generarArray("comb"+a,tipo);
    }   
}


function consultar(){
    startXMLHttp();
    XMLHttp.open("POST","ConsultasGenerales", true);
            XMLHttp.onreadystatechange = function (){
                    if(XMLHttp.readyState === 4 & XMLHttp.status === 200){
                                    document.getElementById("abc").innerHTML=XMLHttp.responseText;
                                    //alert(XMLHttp.responseText);
                    }
            }
    XMLHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    XMLHttp.send("valor="+1);
    
}
*/

/*

function generarArray(combo,tipo){   
    startXMLHttp();
    var valores="combo="+combo+"&tipo="+tipo;
    alert(valores);

    XMLHttp.open("POST","ConsultasGenerales", true);
            XMLHttp.onreadystatechange = function (){
                    if(XMLHttp.readyState === 4 & XMLHttp.status === 200){
                                    document.getElementById("abc").innerHTML=XMLHttp.responseText;
                                    //alert(XMLHttp.responseText);
                    }
            }
    XMLHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    XMLHttp.send(valores);
}

*/



//botton establesido en linea 206 del index.php
function btnGenerateSql(){//se ejecuta este metodo al dar click para generar el archivo(txt) en  crearTxt.php
    generarArchivo("btnSql"); //este valor es para identificar el metodo a ejecutar
    //alert("SQL");
}

//botton establesido en linea 206 del index.php
function btnGenerateCsv(){//se ejecuta este metodo al dar click para generar el archivo(txt) en  crearTxt.php
    generarArchivo("btnCvs"); //este valor es para identificar el metodo a ejecutar
    //alert("CVS");
     
}


function generarArchivo(tipo){
	startXMLHttp();
        var datos=obtenerDatos()+"&valor="+tipo;

		XMLHttp.open("POST","GenerarArchivo", true);
			XMLHttp.onreadystatechange = function (){
				if(XMLHttp.readyState === 4 & XMLHttp.status === 200){
						document.getElementById("abc").innerHTML=XMLHttp.responseText;
						//alert(XMLHttp.responseText);
				}
			}
		XMLHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
   		XMLHttp.send();
}

function obterDatos(){
    var valores;
    for(var i=0;i<10;i++){
        valores=valores+"comb"+i+"="+document.getElementById("comb"+i).value+"&";
    }
    alert(valores);
}


