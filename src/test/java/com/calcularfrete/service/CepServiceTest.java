package com.calcularfrete.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.calcularfrete.model.entity.CepEntinty;
import com.calcularfrete.model.request.CepRequest;
import com.calcularfrete.model.response.CepResponse;

@SpringBootTest
@AutoConfigureMockMvc
public class CepServiceTest {
	
	@InjectMocks
    private CepService service;
	
	@Mock
	private CepInterface cepInterface;

	@Test
	@DisplayName("Consultar Cep com SUCESSO!!!")
	void cacularFrete() {

		String valorFrete = "12,50";
		CepRequest cepRequest = new CepRequest("74483027");
		
		CepEntinty entinty = new CepEntinty();
		entinty.setLocalidade("Goias");
		entinty.setUf("GO");
		
		when(cepInterface.buscaEndereco(cepRequest.getCep())).thenReturn(entinty);
		
		CepResponse cepResponse = service.calcularFrete(cepRequest);
		
        assertEquals(valorFrete, cepResponse.getFrete());  
		
		
	}
}
