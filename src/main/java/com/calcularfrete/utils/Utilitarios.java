package com.calcularfrete.utils;


import com.calcularfrete.model.request.CepRequest;

public class Utilitarios {
	
	public static String removerCaracteresEspeciais(CepRequest cep) {
		
		return cep.getCep().replaceAll("[^a-zA-Z0-9]", "");
		
	}

}
