var XMLHttp;
function startXMLHttp() {
    if(window.XMLHttpRequest){
        XMLHttp= new XMLHttpRequest();
    }else{
        XMLHttp= ActiveXObject("Microsoft.XMLHTTP");
    }
}
    
    
    
    function  btnGenerateSql(){
        startXMLHttp();
        var campos="";
        var atribut="";
        var iteracion=0;
        
        var nameBD=document.getElementById("txtNameBD").value;
        var nameTable=document.getElementById("txtNameTable").value;
        
        
        
        for (var i=1;i<11;i++){
            if(document.getElementById("comb"+i).value > 0){
                atribut+="txt"+i+"="+document.getElementById("txt"+i).value+"&";
                campos+=document.getElementById("comb"+i).value+",";
                iteracion++;
            }//end if
        }//end for
        
        if(iteracion===0){
                document.getElementById("resSQL").innerHTML="Nombre y tipo atributo vacio";
        }else if (nameBD === null || nameBD.length === 0 ){
            document.getElementById("resSQL").innerHTML="Base de datos sin nombre";
        }else if (nameTable === null || nameTable.length === 0 ){
            document.getElementById("resSQL").innerHTML="Tabla sin nombre";
        }else{
            document.getElementById("resSQL").innerHTML="";
            var valores="campos2="+campos+"&iteracion2="+iteracion+"&"+atribut+"&nameBD="+nameBD+"&nameTable="+nameTable;
            //alert(valores);
 
            XMLHttp.open("POST","ValoresCombos", true);
                XMLHttp.onreadystatechange = function (){
                        if(XMLHttp.readyState === 4 & XMLHttp.status === 200){
                                        document.getElementById("resSQL").innerHTML=XMLHttp.responseText;
                                        //alert(XMLHttp.responseText);
                        }
                }
            XMLHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
            XMLHttp.send(valores);
            }
}//end fuction




function btnGenerateCsv(){
    
       startXMLHttp();
        var campos2="";
        var atribut2="";
        var iteracion2=0;
        
        var delimitador=document.getElementById("txtDelimiter").value;
        var name=document.getElementById("txtNombreCvs").value;
        
        
        
        for (var i=1;i<11;i++){
            if(document.getElementById("comb"+i).value > 0){
                atribut2+="txt"+i+"="+document.getElementById("txt"+i).value+"&";
                campos2+=document.getElementById("comb"+i).value+",";
                iteracion2++;
            }//end if
        }//end for
        
        if(iteracion2===0){
                document.getElementById("resCVS").innerHTML="Nombre y tipo atributo vacio";
        }else if (name === null || name.length === 0 ){
            document.getElementById("resCVS").innerHTML="Ingresar nombre del archivo";
        }else if (delimitador === null || delimitador.length === 0 ){
            document.getElementById("resCVS").innerHTML="Delimitador vacio";
        }else{
            document.getElementById("resCVS").innerHTML="";
            var valores="campos2="+campos2+"&iteracion2="+iteracion2+"&"+atribut2+"&delimit="+delimitador+"&nameCVS="+name;
           alert(valores);
 
            XMLHttp.open("POST","GenerarCvs", true);
                XMLHttp.onreadystatechange = function (){
                        if(XMLHttp.readyState === 4 & XMLHttp.status === 200){
                                        document.getElementById("resSQL").innerHTML=XMLHttp.responseText;
                                        //alert(XMLHttp.responseText);
                        }
                }
            XMLHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
            XMLHttp.send(valores);
            }
    
}








