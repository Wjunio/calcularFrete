package com.calcularfrete.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.calcularfrete.exception.ResourceNotFound;
import com.calcularfrete.model.request.CepRequest;
import com.calcularfrete.model.response.CepResponse;
import com.calcularfrete.service.CepService;

@SpringBootTest
@AutoConfigureMockMvc
class CepControllerTests {

    @InjectMocks
	private CepController controller;

    @Mock
    private CepService service;

	@Test
	@DisplayName("Consultar Cep com SUCESSO!!!")
	void cacularFrete() {
		
		CepRequest cepRequest = new CepRequest("74483027");
		
		CepResponse cepResponse = new CepResponse();
		
		when(service.calcularFrete(cepRequest)).thenReturn(cepResponse);
		
		controller.cacularFrete(cepRequest);
		
		assertNotNull(cepResponse);
		
	}
	
	@Test
	@DisplayName("Consultar Cep com SUCESSO, POREM VAZIO!!!")
	void cacularFreteError() throws ResourceNotFound {
		
		CepRequest cepRequest = new CepRequest("74483027");
		
		CepResponse cepResponse = null;
		
		when(service.calcularFrete(cepRequest)).thenReturn(cepResponse);
		
		ResourceNotFound requisicaoInvalida = Assertions.assertThrows(ResourceNotFound.class, () -> {    		
			controller.cacularFrete(cepRequest);
		});
		
        assertEquals(ResourceNotFound.class, requisicaoInvalida.getClass()); 
		
		
	}
	
	@Test
	@DisplayName("Consultar Cep com ERRO, parametro errado!!!")
	void cacularFreteErrorParametro() throws ResourceNotFound {
		
		CepRequest cepRequest = new CepRequest("74483027a");
		
		CepResponse cepResponse = null;
		
		when(service.calcularFrete(cepRequest)).thenReturn(cepResponse);
		
		ResourceNotFound requisicaoInvalida = Assertions.assertThrows(ResourceNotFound.class, () -> {    		
			controller.cacularFrete(cepRequest);
		});
		
        assertEquals(ResourceNotFound.class, requisicaoInvalida.getClass()); 
		
		
	}

}
