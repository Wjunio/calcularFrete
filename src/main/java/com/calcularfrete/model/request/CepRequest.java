package com.calcularfrete.model.request;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.*;


// classe model, onde é definida as informações que estão sendo esperadas.
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CepRequest {
	
	@NotNull(message = "{cep.not.null}")
	@NotBlank(message = "{cep.not.blank}")
	@Pattern( regexp = "^\\d{5}-\\d{3}|^\\d{2}.\\d{3}-\\d{3}|\\d{8}", message = "{cep.schema}")
    private String cep;
}
