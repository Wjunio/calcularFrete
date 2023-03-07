package com.calcularfrete.model.entity;

import lombok.*;


// classe model, onde é definida as informações que serão retornadas ao consultar o serviço de buscaCEP
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class CepEntinty {
	private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;
}
