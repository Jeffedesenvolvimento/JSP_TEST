<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<title>Home</title>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">Projetos</a>
				<div class="collapse navbar-collapse" id="home">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0" style="padding-left: 0px;">
						<li class="nav-item">
							<a class="nav-link active" aria-current="page" href="projetoCadastro">
								<i class="bi bi-plus-circle"></i>
							</a>
						</li>
	
					</ul>
					<form class="d-flex">
						<input class="form-control me-2" type="search"
							placeholder="Pesquisar" aria-label="Search">
						<button class="btn btn-outline-success" type="submit">Pesquisar</button>
					</form>
				</div>
			</div>
		</nav>
	</header>

</body>
</html>