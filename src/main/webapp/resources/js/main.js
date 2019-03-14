function ajaxGetGru(numeroGru) {
	$.ajax({
		type: 'GET',
		url: 'http://localhost:8080/grus/' + numeroGru,
		headers: {
			'Content-Type': 'application/json'
		},
		success: function (response) {
			$('div#naturezaServico').show();
		},
		error: function (xhr) {
			$('div#naturezaServico').hide();
			$('div#mensagemResposta').attr('class', 'alert alert-danger');
			$('div#mensagemResposta').text(xhr.responseJSON.message);
			$('div#mensagemResposta').show();
		}
	});
}

function ajaxPutGru(numeroGru, codigoNaturezaServico) {
	$.ajax({
		type: 'PUT',
		url: 'http://localhost:8080/grus/' + numeroGru + '?codigoNaturezaServico=' + codigoNaturezaServico,
		headers: {
			'Content-Type': 'application/json'
		},
		success: function (response) {
			$('div#naturezaServico').hide();
			$('div#mensagemResposta').attr('class', 'alert alert-success');
			$('div#mensagemResposta').text('GRU atualizada com sucesso.');
			$('div#mensagemResposta').show();
		},
		error: function (xhr) {
			$('div#naturezaServico').hide();
			$('div#mensagemResposta').attr('class', 'alert alert-danger');
			$('div#mensagemResposta').text(xhr.responseJSON.message);
			$('div#mensagemResposta').show();
		}
	});
}

$(document).ready(function () {
	$('div#naturezaServico').hide();
	
	$('#pesquisarGRU').click(function () {
		$('div#mensagemResposta').hide();
		var numeroGru = $('#gruInputText').val();
		if(!numeroGru) {
			$('div#naturezaServico').hide();
			$('input[name="codigoNaturezaServico"]').attr('checked', '');
			$('div#mensagemResposta').attr('class', 'alert alert-danger');
			$('div#mensagemResposta').text('Número da GRU obrigatório.');
			$('div#mensagemResposta').show();
			return false;
		}
		
		if(!(/^[0-9]*$/g).test(numeroGru)) {
			$('div#naturezaServico').hide();
			$('input[name="codigoNaturezaServico"]').attr('checked', '');
			$('div#mensagemResposta').attr('class', 'alert alert-danger');
			$('div#mensagemResposta').text('Número da GRU inválido.');
			$('div#mensagemResposta').show();
			return false;
		}
		
		ajaxGetGru(numeroGru);
	});
	
	$('#naturezaSendButton').click(function () {
		$('div#mensagemResposta').hide();
		var codigoNaturezaServico = $('input[name="codigoNaturezaServico"]:checked').val();
		if(!codigoNaturezaServico) {
			$('div#mensagemResposta').attr('class', 'alert alert-danger');
			$('div#mensagemResposta').text('Por favor, escolha a natureza do serviço.');
			$('div#mensagemResposta').show();
			return false;
		}
		
		var numeroGru = $('#gruInputText').val();
		if(!numeroGru) {
			$('div#naturezaServico').hide();
			$('input[name="codigoNaturezaServico"]').attr('checked', '');
			$('div#mensagemResposta').attr('class', 'alert alert-danger');
			$('div#mensagemResposta').text('Número da GRU invalido.');
			$('div#mensagemResposta').show();
			return false;
		}
		if(!(/^[0-9]*$/g).test(numeroGru)) {
			$('div#naturezaServico').hide();
			$('input[name="codigoNaturezaServico"]').attr('checked', '');
			$('div#mensagemResposta').attr('class', 'alert alert-danger');
			$('div#mensagemResposta').text('Número da GRU inválido.');
			$('div#mensagemResposta').show();
			return false;
		}
		
		ajaxPutGru(numeroGru, codigoNaturezaServico);
	});
});

