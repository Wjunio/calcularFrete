package com.calcularfrete.model.enumerator;

import org.springframework.http.HttpStatus;

import com.calcularfrete.exception.ResourceNotFound;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RegiaoBrasileiraEnum {

	REGIAO_SUDESTE("SP; MG; ES; RJ", "7,85"),
	REGIAO_NORDESTE("MA; PI; BA; CE; PE; SE; Al; PB; RN", "15,98"),
	REGIAO_CENTRO_OESTE("GO; MT; MS","12,50"),
	REGIAO_SUL("PR; SC; RS", "17,30"),
	REGIAO_NORTE("AC;AM;RR;RO;PA;AP;TO", "20,83");
	

	private String regioes;
	private String valor;
	
	public static String getValorFrete(String uf) {
		
		for (RegiaoBrasileiraEnum regiao : RegiaoBrasileiraEnum.values()) {
			if (regiao.getRegioes().contains(uf)) {
				return regiao.getValor();
			}
		}
		
		throw new ResourceNotFound("Estado não encontrado.", HttpStatus.NOT_FOUND);
	}
	
}
