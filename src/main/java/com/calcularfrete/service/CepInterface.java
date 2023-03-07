package com.calcularfrete.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.calcularfrete.model.entity.CepEntinty;


//define o endereço que irá consumir a API, e disponibiliza a função buscaEndereco para ser chamada pela controller
@FeignClient(url= "https://viacep.com.br/ws/" , name = "viacep")
public interface CepInterface {
    @GetMapping("{cep}/json")
    CepEntinty buscaEndereco(@PathVariable("cep") String cep);
}
