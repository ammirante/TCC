package com.github.ammirante.tcc.extracaobacen.dto;

import com.github.ammirante.tcc.extracaobacen.infra.DTO;
import com.github.ammirante.tcc.extracaobacen.infra.ValidDTO;

/**
 * DominioNormaDTO
 *
 */
@ValidDTO
public class DominioNormaDTO extends CadastroDTO implements DTO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4356571659973292139L;
	
	public Long codigoTipoConteudo;
	public String nome;
}
