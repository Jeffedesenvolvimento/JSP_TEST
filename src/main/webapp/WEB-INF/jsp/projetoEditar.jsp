<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="teste.com.projetos.projetos.model.Membro"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<title>Editar Projetos</title>
<style type="text/css">
.titulo {
	width: 100%;
	text-align: center;
}

.div-form {
	padding-left: 20%;
}

.datepicker td, th {
	text-align: center;
	padding: 8px 12px;
	font-size: 14px;
}

.subTitulo {
	font-size: 18px;
	text-decoration: blink black;
	font-weight: bold;
}
</style>
</head>
<body>
	<div class="d-flex flex-column mb-3" style="width: 100%;">
		<div class="p-2"
			style="width: 100%; background-color: #f8f9fa !important;">
			<header>
				<nav class="navbar navbar-light bg-light">
					<div class="container-fluid">
						<a class="navbar-brand titulo" href="#">Editar Projetos</a>
					</div>
				</nav>
			</header>
		</div>
		<div class="d-flex flex-column mb-3 div-form" style="width: 80%;">
			<div class="p-2">
				<h1 class="subTitulo">Editar Projeto</h1>
			</div>
			<div class="p-2">
				<form:form action="/editar" method="POST" modelAttribute="projeto">
					<div class="mb-3">
						<label for="nome" class="form-label" style="font-weight: bold;">Nome</label>
						<form:input type="text" class="form-control" style="width: 100%"
							id="nome" path="nome" />
					</div>

					<div class="d-inline-flex mb-3" style="width: 100%">
						<div style="width: 50%; padding-right: 2%">
							<label for="gpResponsavel" class="form-label"
								style="font-weight: bold;">Gerente Responsável</label> <select
								class="form-select" aria-label="Default select example"
								id="gpResponsavel" name="gpResponsavel">
								<%-- 								<option selected>${projeto.gpResponsavel.nome}</option> --%>
								<option selected>Selecione a criticidade</option>
								<%
								try {
									Class.forName("org.postgresql.Driver");
									Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "admin");
									String query = "select * from membro where membro_atribuicao_id = 1";
									PreparedStatement st = con.prepareStatement(query);
									ResultSet rs = st.executeQuery();
									int i = 0;
									while (rs.next()) {
										int id = rs.getInt("id");
										System.out.println("rs " + id);
								%>
								<option value=<%=id%>><%=rs.getString("nome")%></option>
								<%
								i++;
								}
								} catch (Exception e) {

								}
								%>
							</select>
						</div>
						<div style="width: 50%">
							<label class="form-label" style="font-weight: bold;">Orçamento
								total</label>
							<form:input type="text" class="form-control mask" id="orcamento"
								name="orcamento" path="orcamento" />
						</div>
					</div>
					<div class="d-inline-flex mb-3" style="width: 100%">

						<div class="d-flex flex-column " style="width: 33.33%">
							<div>
								<label for="dtInicio" class="form-label"
									style="font-weight: bold;">Data início</label>
							</div>

							<!-- Datepicker as text field -->
							<div class=" input-group date" style="width: 100%"
								data-date-format="dd/mm/yyyy">
								<form:input type="text" class="form-control"
									placeholder="dd/mm/yyyy" id="dtInicio" name="dtInicio"
									path="dtInicio" />
								<div class="input-group-addon">
									<span class="glyphicon glyphicon-th"></span>
								</div>
							</div>
						</div>

						<div class="d-flex flex-column"
							style="width: 33.33%; padding-right: 1.67%; padding-left: 1.67%">
							<div>
								<label for="dtPrevisaoTermino" class="form-label"
									style="font-weight: bold;">Previsão de término</label>
							</div>
							<div class="input-group date" style="width: 100%"
								data-date-format="dd/mm/yyyy">
								<form:input type="text" class="form-control"
									id="dtPrevisaoTermino" name="dtPrevisaoTermino"
									placeholder="dd/mm/yyyy" path="dtPrevisaoTermino" />
								<div class="input-group-addon">
									<span class="glyphicon glyphicon-th"></span>
								</div>
							</div>
						</div>
						<div class="d-flex flex-column" style="width: 33.33%">
							<div>
								<label for="dtRealTermino" class="form-label"> Data real
									de término</label>
							</div>
							<div class="input-group date" style="width: 100%"
								data-date-format="dd/mm/yyyy">
								<form:input type="text" class="form-control" id="dtRealTermino"
									name="dtRealTermino" placeholder="dd/mm/yyyy"
									path="dtRealTermino" />
								<div class="input-group-addon">
									<span class="glyphicon glyphicon-th"></span>
								</div>
							</div>
						</div>
					</div>
					<div class="d-inline-flex mb-3" style="width: 100%">
						<div style="width: 33.33%; padding-right: 2%">
							<label for="descricao" class="form-label"
								style="font-weight: bold;">Descrição</label>
							<form:input type="text" class="form-control" id="descricao"
								name="descricao" path="descricao" />
						</div>
						<div style="width: 33.33%; padding-right: 2%">
							<label for="status" class="form-label" style="font-weight: bold;">Status</label>
							<select class="form-select" id="status" name="status"
								aria-label="Default select example">
<%-- 								<option selected>${projeto.statusDescricao}</option> --%>
								<option selected>Selecione a criticidade</option>
								<option value=1>análise</option>
								<option value=2>análise realizada</option>
								<option value=3>análise aprovada</option>
								<option value=4>iniciado</option>
								<option value=5>planejado</option>
								<option value=6>em andamento</option>
								<option value=7>encerrado</option>
								<option value=8>cancelado</option>
							</select>
						</div>
						<div style="width: 33.33%">
							<label for="criticidade" class="form-label"
								style="font-weight: bold;">Criticidade</label> <select
								class="form-select" id="criticidade" name="criticidade"
								aria-label="Default select example">
<%-- 								<option selected>${projeto.criticidadeDescricao}</option> --%>
								<option selected>Selecione a criticidade</option>
								<option value=1>Baixo</option>
								<option value=2>Médio</option>
								<option value=3>Alta</option>
							</select>
						</div>
					</div>
					<div class="d-inline-flex" style="width: 100%">
						<div style="width: 50%; padding-right: 2%">
							<a href="/">
								<button type="button" class="btn btn-danger">Cancelar</button>
							</a>
						</div>
						<div class="d-flex justify-content-end" style="width: 50%">
							<button type="submit" class="btn btn-success">Cadastrar</button>
						</div>
					</div>
					<div hidden="true">
						<form:input type="text" class="form-control" style="width: 100%"
							id="id" path="id" />
					</div>
				</form:form>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.1/js/bootstrap-datepicker.min.js'></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery.inputmask/3.2.6/jquery.inputmask.bundle.min.js"></script>
	<script>
		$('.input-group.date').datepicker({
			format : "dd/mm/yyyy"
		});
	</script>
	<script>
		$(".mask").inputmask('Regex', {
			regex : "^[0-9]{1,6}(\\,\\d{1,2})?$"
		});
	</script>
</body>
</html>