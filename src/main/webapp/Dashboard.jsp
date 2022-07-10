<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<!-- Metaetiquetas requeridas -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Responsive -->

<title>Página principal</title>

<!-- Jquery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<!-- Boxicons CSS -->
<link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css'
	rel='stylesheet'>

<!-- Pure -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
<link rel="stylesheet"
	href="https://unpkg.com/purecss@2.0.6/build/grids-responsive-min.css">

<!-- Estilos -->
<link rel="stylesheet" type="text/css" href="css/nav.css">
<link rel="stylesheet" type="text/css" href="css/form.css">

<link rel="shortcut icon" href="images/syslab.ico" />

</head>
<body>

	<div class="sidebar">
		<div class="logo-details">
			<i class='bx bx-barcode'></i> <span class="logo_name">Cars</span>
		</div>
		<ul class="nav-links">
			<li><a href="Dashboard.jsp"> <i class='bx bx-grid-alt'></i>
					<span class="link_name">Dashboard</span>
			</a>						
		</ul>
	</div>


	<section class="home-section">

		<div class="home-content">
			<i class='bx bx-menu'></i> <span class="text"></span>
		</div>

		<div class="container">

			<div class="title">Seleccion de Vehiculo</div>

			<form action="#">

				<div class="user-details">

					<div class="input-box">
						<span class="details">Categoria</span> <select id="cbo_categoria"
							name="cbo_categoria"
							onchange="if (this.selectedIndex) select_anidado_categoria();"
							onclick="opcion_en_blanco();">
							<option style="font-weight: bold;" value="${categoria}">${categoria}</option>
						</select>
					</div>

					<div class="input-box">
						<span class="details">Vehiculos</span> <select id="cbo_vehiculo"
							name="cbo_vehiculo"
							onchange="if (this.selectedIndex) mostrar_caracteristicas();">
							<option style="font-weight: bold;" value="${vehiculo}">${vehiculo}</option>
						</select>
					</div>

					<input type="hidden" id="txt_id" value="${id}"></input>

				</div>
			</form>
		</div>

		<div class="container">

			<table class="pure-table pure-table-bordered"
				style="width: 80%;" id="table">
				<thead>
					<tr>
						<th scope="col" style="color: white">Caracteristica</th>
						<th scope="col" style="color: white">Detalle</th>
					</tr>
				</thead>
				<tbody>

				</tbody>
			</table>

		</div>

	</section>



	<script src="js/nav.js">
		
	</script>

	<script src="js/vehiculos.js">
		
	</script>


</body>
</html>