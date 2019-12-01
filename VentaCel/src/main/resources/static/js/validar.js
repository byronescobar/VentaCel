function validar(){
	var nombre,especie,raza,peso,edad;	
	
	nombre= document.getElementById("nombre").value;
	especie= document.getElementById("especie").value;
	raza= document.getElementById("raza").value;
	peso= document.getElementById("peso").value;
	edad= document.getElementById("edad").value
	
	if(nombre== "" || especie =="" || raza=="" ||peso=="" || edad=="" ){
		alert("Todos los campos son obligatorios");
		return false;
	}
    

}