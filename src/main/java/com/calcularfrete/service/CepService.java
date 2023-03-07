package com.calcularfrete.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.calcularfrete.exception.ResourceNotFound;
import com.calcularfrete.model.entity.CepEntinty;
import com.calcularfrete.model.enumerator.RegiaoBrasileiraEnum;
import com.calcularfrete.model.request.CepRequest;
import com.calcularfrete.model.response.CepResponse;
import com.calcularfrete.utils.Utilitarios;

@Service
public class CepService {

	@Autowired
	private CepInterface cepInterface;

	public CepResponse calcularFrete(CepRequest cepRequest) throws ResourceNotFound {

		try {

			CepEntinty entinty = cepInterface.buscaEndereco(Utilitarios.removerCaracteresEspeciais(cepRequest));

			CepResponse cepResponse = null;

			if (Objects.nonNull(entinty)
					&& (Objects.nonNull(entinty.getLocalidade()) || Objects.nonNull(entinty.getUf()))) {

				cepResponse = new CepResponse(entinty, RegiaoBrasileiraEnum.getValorFrete(entinty.getUf()));

			}

			return cepResponse;

		} catch (Exception e) {
			throw new ResourceNotFound("Error ao solicitar consultar do CEP", HttpStatus.NOT_FOUND);
		}
	}

}
