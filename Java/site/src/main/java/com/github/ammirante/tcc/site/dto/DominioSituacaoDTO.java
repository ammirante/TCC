package com.github.ammirante.tcc.site.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.github.ammirante.tcc.site.infra.DTO;
import com.github.ammirante.tcc.site.infra.ValidDTO;

/**
 * DominioSituacaoDTO
 *
 */
@ValidDTO
public class DominioSituacaoDTO extends CadastroDTO implements DTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4630251664953738447L;
	
	@NotEmpty
	@NotNull
	public String nome;
}
