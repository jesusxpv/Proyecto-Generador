var XMLHttp;
	function startXMLHttp() {
		if(window.XMLHttpRequest){
			XMLHttp= new XMLHttpRequest();
		}else{
			XMLHttp= ActiveXObject("Microsoft.XMLHTTP");
		}
	}





function start(){
	generar("1");
}

function btnGenerateCsv(){
	generar("2");
}


function generar(tipo){
	startXMLHttp();
	
		XMLHttp.open("POST","php/crearTxt.php", true);
			XMLHttp.onreadystatechange = function (){
				if(XMLHttp.readyState == 4 & XMLHttp.status == 200){
						document.getElementById("abc").innerHTML=XMLHttp.responseText;
						//alert(XMLHttp.responseText);
				}
			}
		XMLHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
   		XMLHttp.send("valor="+tipo);
}




