package com.github.ammirante.tcc.extracaobacen.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.github.ammirante.tcc.extracaobacen.infra.DTO;
import com.github.ammirante.tcc.extracaobacen.infra.ValidDTO;

/**
 * AdicionarDominioNormaDTO
 *
 */
@ValidDTO
public class AdicionarDominioNormaDTO extends CadastroDTO implements DTO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6516411070086753266L;

	@NotEmpty
	@NotNull
	public Long codigoTipoNorma;
	
	@NotEmpty
	@NotNull
	public String nome;
	
}
