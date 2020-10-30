package com.github.ammirante.tcc.extracaobacen.dto;

import com.github.ammirante.tcc.extracaobacen.infra.DTO;
import com.github.ammirante.tcc.extracaobacen.infra.ValidDTO;

/**
 * NormaDTO
 *
 */
@ValidDTO
public class DominioConteudoDTO extends CadastroDTO implements DTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -634379286057581160L;
	
	public Long codigoTipoNorma;
	public String nome;
}
