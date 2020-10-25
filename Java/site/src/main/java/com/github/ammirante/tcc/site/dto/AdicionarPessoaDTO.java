package com.github.ammirante.tcc.site.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.github.ammirante.tcc.site.infra.DTO;
import com.github.ammirante.tcc.site.infra.ValidDTO;

/**
 * AdicionarPessoaDTO
 *
 */
@ValidDTO
public class AdicionarPessoaDTO extends CadastroDTO implements DTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -986173242950821275L;

	@NotEmpty
	@NotNull
	public String nome;
	
	@NotEmpty
	@NotNull
	public String email;
	
	@NotEmpty
	@NotNull
	public String nomeUsuario;
	
	@NotNull
	@NotEmpty
	public String senha;
}
