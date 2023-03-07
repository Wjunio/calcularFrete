package com.calcularfrete.model.response;

import com.calcularfrete.model.entity.CepEntinty;

import lombok.*;


// classe model, onde é definida as informações que serão retornadas ao consultar o serviço de buscaCEP
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class CepResponse {
	private String cep;
    private String rua;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String frete;
    
    public CepResponse(CepEntinty entity, String frete) {    	
    	this.cep = entity.getCep();
    	this.rua = entity.getLogradouro();
    	this.complemento = entity.getComplemento();
    	this.bairro = entity.getBairro();
    	this.cidade = entity.getLocalidade();
    	this.estado = entity.getUf();
    	this.frete = frete;
    }
}
