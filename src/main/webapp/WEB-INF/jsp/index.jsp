<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<c:url value="/resources/css/main.css" />">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />" />
<meta charset="UTF-8">
<title>INPI | Sistema de GRU</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<div align="center">
					<img src="<c:url value="/resources/img/inpi_logo.jpg" />" class="inpi-logo" />
				</div>
				<div id="gru">
					<span>Por favor, digite o numero da GRU:</span>
					<br/>
					<br/>
					<input type="text" class="form-control" name="gru" id="gruInputText" placeholder="Digite o numero da GRU" />
					<br/>
					<br/>
					<input type="button" value="Pesquisar" id="pesquisarGRU" class="btn btn-primary" />
				</div>
				<br/>
				<div id="naturezaServico" style="display: none;">
					<span>Por favor, escolha a natureza do servico:</span> <br /> <br />
					<input type="radio" value="1" name="codigoNaturezaServico"> 1 - Deposito de Pedidos de Registro de (DI)</input> <br />
					<br/> 
						<input type="radio" value="2" name="codigoNaturezaServico"> 2 - Pedidos divididos</input>
						<br/>
						<br/> 
						<input type="submit" value="Salvar" id="naturezaSendButton" class="btn btn-primary" />
					<br/>
					<br/>
				</div>
				<div id="mensagemResposta" class="" role="alert" style="display:none;">
				</div>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
</body>
<script src="<c:url value="/resources/js/jquery-3.3.1.min.js" />"
	charset="utf-8" type="text/javascript"></script>
<script src="<c:url value="/resources/js/main.js" />" charset="utf-8"
	type="text/javascript"></script>
</html>