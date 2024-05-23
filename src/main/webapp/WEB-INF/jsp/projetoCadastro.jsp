<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<title>Cadastro de Projetos</title>
<style type="text/css">
.titulo {
	width: 100%;
	text-align: center;
}

.div-form {
	padding-left: 20px;
}

.datepicker td, th {
	text-align: center;
	padding: 8px 12px;
	font-size: 14px;
}
</style>
</head>
<body>
	<nav class="navbar navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand titulo" href="#">Cadastrar Projetos</a>
		</div>
	</nav>
	<div class="mb-3 div-form">
		<label for="nome" class="form-label">Nome</label> <input type="text"
			class="form-control" style="width: 400px" id="nome">
	</div>
	<div class="mb-3 div-form">
		<label for="dtInicio" class="form-label">Data início</label>

		<!-- Datepicker as text field -->
		<div class="input-group date" style="width: 400px"
			data-date-format="dd/mm/yyyy">
			<input type="text" class="form-control" placeholder="dd/mm/yyyy">
			<div class="input-group-addon">
				<span class="glyphicon glyphicon-th"></span>
			</div>
		</div>
	</div>
	<div class="mb-3 div-form">
		<label for="gpResponsavel" class="form-label">Gerente
			Responsável</label> <input type="text" style="width: 400px"
			class="form-control" id="gpResponsavel">
	</div>
	<div class="mb-3 div-form">
		<label for="dtTermino" class="form-label">Previsão de término</label>
		<div class="input-group date" style="width: 400px"
			data-date-format="dd/mm/yyyy">
			<input type="text" class="form-control" id="dtTermino"
				placeholder="dd/mm/yyyy">
			<div class="input-group-addon">
				<span class="glyphicon glyphicon-th"></span>
			</div>
		</div>
	</div>
	<div class="mb-3 div-form">
		<label for="dtRealTermino" class="form-label"> Data real de
			término</label>
		<div class="input-group date" style="width: 400px"
			data-date-format="dd/mm/yyyy">
			<input type="text" class="form-control" id="dtRealTermino"
				placeholder="dd/mm/yyyy">
			<div class="input-group-addon">
				<span class="glyphicon glyphicon-th"></span>
			</div>
		</div>
	</div>
	<div class="mb-3 div-form">
		<label for="orcamento" class="form-label">Orçamento total</label> <input
			type="number" style="width: 400px" class="form-control"
			id="orcamento">
	</div>
	<div class="mb-3 div-form">
		<label for="descricao" class="form-label">Descrição</label> <input
			type="text" style="width: 400px" class="form-control" id="descricao">
	</div>
	<div class="mb-3 div-form">
		<label for="dtInicio" class="form-label">Status</label> <select
			style="width: 400px" class="form-select" id="dtInicio"
			aria-label="Default select example">
			<option selected>Selecione um status</option>
			<option value="1">análise</option>
			<option value="2">análise realizada</option>
			<option value="3">análise aprovada</option>
			<option value="4">iniciado</option>
			<option value="5">planejado</option>
			<option value="6">em andamento</option>
			<option value="7">encerrado</option>
			<option value="8">cancelado</option>

		</select>
	</div>
	<div class="div-form" style="width: 400px">
		<button type="button" class="btn btn-danger">Cancelar</button>
		<button type="button" class="btn btn-success">Cadastrar</button>
	</div>

	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.1/js/bootstrap-datepicker.min.js'></script>
	<script>
		$('.input-group.date').datepicker({
			format : "dd/mm/yyyy"
		});
	</script>
</body>
</html>