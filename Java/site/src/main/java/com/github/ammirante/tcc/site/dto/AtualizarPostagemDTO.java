package com.github.ammirante.tcc.site.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.github.ammirante.tcc.site.infra.DTO;
import com.github.ammirante.tcc.site.infra.ValidDTO;

/**
 * AtualizarPostagemDTO
 *
 */
@ValidDTO
public class AtualizarPostagemDTO extends CadastroDTO implements DTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3817699111275404246L;

	@NotEmpty
	@NotNull
	public String titulo;
	
	@NotEmpty
	@NotNull
	public String descricaoTexto;
	
	@NotEmpty
	@NotNull
	public String referenciaImagemCapa;
	
	@NotNull
	public List<DominioCategoriaDTO> lstDominioCategoria;
	
}
