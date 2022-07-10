		
		function opcion_en_blanco() { //Al seleccionar opcion en blanco, se limpia el combo dependiente
	    	   		 	
	    	var categoria = document.getElementById('cbo_categoria').value;
	    	if (categoria == 0) {  
				var select = document.getElementById("cbo_vehiculo");
				var length = select.options.length;					
				for (i = length - 1; i >= 0; i--) {
		    		select.options[i] = null;
				}
				
				 $("#table > tbody").empty(); //Limpiar tabla
				
	    	}
	    	
	}	
		
	//------------------------------------------------------------------------------------------------------------	
	
	 select_listado_categoria();
    
	function select_listado_categoria() {
			  	   
	    $.ajax({
			type : 'POST',
			data : {			    
				
				
			    action : "listado_categoria"
			},
			url : 'Controlador_Vehiculos',
			success : function(result) {
			   
			    var str1 = result.replaceAll("Served at: /store","");
			    str1 = str1.replaceAll("{", "{\"");
			    str1 = str1.replaceAll("}", "\"}");
			    str1 = str1.replaceAll("=", "\":\"");
			    str1 = str1.replaceAll("descripcion","\"descripcion");
			    str1 = str1.replaceAll("}\",", "},");
			    const str = str1.replaceAll(", \"descripcion","\", \"descripcion");

			    $(document).ready(function() {
					var $select = $('#cbo_categoria');
					//Rellenar select tras parsear el str a Json.
														
					$.each(JSON.parse(str), function(id,descripcion) {
						$select.append('<option value=' + descripcion.id + '>' + descripcion.descripcion  + '</option>');
					});
				    });
			}
		 })

	}	
		
	//------------------------------------------------------------------------------------------------------------				
				
	function select_anidado_categoria() {

	    var categoria = document.getElementById('cbo_categoria').value;
	         	    	  	    
	    $.ajax({
			type : 'POST',
			data : {
			    categoria : categoria,
			    action : "anidado_categoria"
			},
			url : 'Controlador_Vehiculos',
			success : function(result) {
			    //Limpiar select antes de rellenarlo    
			    var select = document.getElementById("cbo_vehiculo");
			    var length = select.options.length;
			    for (i = length - 1; i >= 0; i--) {
					select.options[i] = null;
			    }

			    var str1 = result.replaceAll("Served at: /store","");
			    str1 = str1.replaceAll("{", "{\"");
			    str1 = str1.replaceAll("}", "\"}");
			    str1 = str1.replaceAll("=", "\":\"");
			    str1 = str1.replaceAll("descripcion","\"descripcion");
			    str1 = str1.replaceAll("}\",", "},");
			    const str = str1.replaceAll(", \"descripcion","\", \"descripcion");

			    $(document).ready(function() {
					var $select = $('#cbo_vehiculo');
					//Rellenar select tras parsear el str a Json.
					
					$select.append('<option>' + '</option>');
					
					$.each(JSON.parse(str), function(id,descripcion) {
						$select.append('<option value=' + descripcion.id + '>' + descripcion.descripcion  + '</option>');
					});
				 });				 				
				 
			}
		 })
		 
	}
	
	//------------------------------------------------------------------------------------------------------------	
		    		    
	function mostrar_caracteristicas() {
	   
	     var vehiculo = document.getElementById('cbo_vehiculo').value;
	     
	     
	     	     		
			$.ajax({
		    	type : 'POST',
		    	data : {
					vehiculo : vehiculo,
									    
					action : "mostrar_caracteristicas"
		    	},
		    	url : 'Controlador_Vehiculos',
		    	success : function(caracteristicas) { 
		    	    
		    		caracteristicas = JSON.parse(caracteristicas.replaceAll("Served at: /store",""));
		    				    		
		    		let listadoHtml = '';
		    		
 					 for (let caracteristica of caracteristicas) {
	   						 
    						let caracteristicaHtml = 
    						
    						'<tr><th>Marca</th><td>' + caracteristica.marca + '</td></tr>' +
    						'<tr><th>Modelo</th><td>' + caracteristica.modelo + '</td></tr>' +
    						'<tr><th>Año</th><td>' + caracteristica.anio + '</td></tr>' +
    						'<tr><th>Cambio</th><td>' + caracteristica.cambio + '</td></tr>' +
    						'<tr><th>Potencia</th><td>' + caracteristica.potencia + '</td></tr>' +
    						'<tr><th>Plazas</th><td>' + caracteristica.plazas + '</td></tr>' +
    						'<tr><th>Combustible</th><td>' + caracteristica.combustible + '</td></tr>' +
    						'<tr><th>Cilindrada(cc)</th><td>' + caracteristica.cilindrada + '</td></tr>' +
    						'<tr><th>Velocidad Máxima(Km/h)</th><td>' + caracteristica.velocidad_maxima + '</td></tr>' +
    						'<tr><th>Precio($)</th><td>' + caracteristica.precio + '</td></tr>';
    						
    						listadoHtml += caracteristicaHtml;
  					 }
  					 
					 document.querySelector('#table tbody').outerHTML = listadoHtml;
		    	    		    	    		    	    					
		    	}
			})
	    
	}
				
	//------------------------------------------------------------------------------------------------------------	
	
	


  


	
	
		