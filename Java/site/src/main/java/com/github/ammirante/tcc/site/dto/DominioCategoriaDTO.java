package com.github.ammirante.tcc.site.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.github.ammirante.tcc.site.infra.DTO;
import com.github.ammirante.tcc.site.infra.ValidDTO;

/**
 * DominioCategoriaDTO
 *
 */
@ValidDTO
public class DominioCategoriaDTO extends CadastroDTO implements DTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5636681731957775291L;
	
	@NotNull
	@NotEmpty
	public String nome;
	
}
