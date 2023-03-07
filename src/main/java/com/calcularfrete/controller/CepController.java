package com.calcularfrete.controller;

import com.calcularfrete.exception.ResourceNotFound;
import com.calcularfrete.model.request.CepRequest;
import com.calcularfrete.model.response.CepResponse;
import com.calcularfrete.model.response.ResponseError;
import com.calcularfrete.service.CepService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Consultar Endereço", tags = { "Recursos para consultar endereço e encontrar o valor do Frete" })
public class CepController {
	
	private static final String MSG = "CEP não encontrado.";

	@Autowired
	private CepService cepService;

	// Na classe controller, recebemos o parâmetro CEP, validamos o mesmo,
	// solicitamos o
	// consumo da api a classe de serviço e retornamos os dados de acordo com as
	// variáveis
	// definidas na classe model.
	@ApiResponses({
		@ApiResponse(code = 200, message = "Solicitacao da consulta do cep realizada com sucesso", response = CepResponse.class),
		@ApiResponse(code = 400, message = "Informacoes enviadas na requisicao sao invalidas", response = ResponseError.class),
		@ApiResponse(code = 404, message = "Solicitacao da consulta do cep realizada, CEP não encontrado."),
		@ApiResponse(code = 412, message = "Requisicao de participante que viola alguma regra de negocio da aplicacao.", response = ResponseError.class),
		@ApiResponse(code = 500, message = "Servico nao esta disponivel no momento. Serviço solicitado pode estar em manutencao ou fora da janela de funcionamento.", response = ResponseError.class)
	})
	@ApiOperation(value = "Consultar Cep e calcular Frete")
	@RequestMapping(value = "/api/v1/consulta-endereco", method = RequestMethod.POST)
	public ResponseEntity<?> cacularFrete(@RequestBody @Valid CepRequest cep){
		
		CepResponse response = cepService.calcularFrete(cep);
		
		if (Objects.isNull(response)) {
			throw new ResourceNotFound(MSG, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<CepResponse>(response, HttpStatus.OK);

	}
}
