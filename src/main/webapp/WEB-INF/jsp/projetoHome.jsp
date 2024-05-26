<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<title>Home</title>

</head>
<body>
	<div class="d-flex flex-column mb-3" style="width: 100%;">
		<div class="p-2">
			<header>
				<nav class="navbar navbar-expand-lg navbar-light bg-light">
					<div class="container-fluid">
						<a class="navbar-brand" href="projetoCadastro">Projetos<i
							class="bi bi-plus-circle" style="padding-left: 15px;"></i></a>
					</div>
					<div>
						<input type="text" id="myInput" onkeyup="filterTable()"
							placeholder="Procurar projeto..">
					</div>
				</nav>
			</header>
		</div>
		<div class="d-flex flex-column mb-3 " style="width: 100%;">
			<div class="p-2">
				<form:form>
					<table class="table table-bordered" id="myTable">

						<tr>
							<th scope="col">Nome</th>
							<th scope="col">Responsável</th>
							<th scope="col">Orçamento</th>
							<th scope="col">Data Início</th>
							<th scope="col">Previsão de término</th>
							<th scope="col">Data Real de término</th>
							<th scope="col">Descrição</th>
							<th scope="col">Status</th>
							<th scope="col">Criticidade</th>
							<th scope="col"></th>
							<th scope="col"></th>
						</tr>
						<c:forEach var="p" items="${projetoList}">
							<tr>
								<td>${p.nome}</td>
								<td>${p.gpResponsavel.nome}</td>
								<td>${p.orcamento}</td>
								<td>${p.dtInicio}</td>
								<td>${p.dtPrevisaoTermino}</td>
								<td>${p.dtRealTermino}</td>
								<td>${p.descricao}</td>
								<td>${p.statusDescricao}</td>
								<td>${p.criticidadeDescricao}</td>
								<td><button type="button" class="btn btn-success">
										<a href="/edit/${p.id}">Editar</a>
									</button></td>
								<td><button type="button" class="btn btn-danger"
										onclick="alert(${p.id}, ${p.status})">Deletar</button></td>
							</tr>

						</c:forEach>

					</table>
				</form:form>
			</div>
		</div>
	</div>

	<script>
		function filterTable() {
			var input, filter, table, tr, td, i, txtValue;
			input = document.getElementById("myInput");
			filter = input.value.toUpperCase();
			table = document.getElementById("myTable");
			tr = table.getElementsByTagName("tr");
			for (i = 0; i < tr.length; i++) {
				td = tr[i].getElementsByTagName("td")[0];
				if (td) {
					txtValue = td.textContent || td.innerText;
					if (txtValue.toUpperCase().indexOf(filter) > -1) {
						tr[i].style.display = "";
					} else {
						tr[i].style.display = "none";
					}
				}
			}
		}
	</script>

	<script type="text/javascript">
		var msg;
		function alert(id, status) {
			console.log(status === 4 || status === 6 || status === 7)
			console.log(status);
			if(status === 4 || status === 6 || status === 7){
				console.log("entrou validacao");
				Swal.fire("Erro ao deletar, projeto com o status que não permitido exclusão");
			}else{
				window.location.href ="/delete/" + id
			}
		}
	</script>
</body>
</html>