package com.github.ammirante.tcc.extracaobacen.dto;

import java.util.Date;

import com.github.ammirante.tcc.extracaobacen.infra.DTO;
import com.github.ammirante.tcc.extracaobacen.infra.ValidDTO;

/**
 * NormaDTO
 *
 */
@ValidDTO
public class NormaDTO extends CadastroDTO implements DTO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6723538943552346374L;

	public Long codigoNorma;
	public Integer numeroNorma;
	public String assunto;
	public String responsavel;
	public DominioNormaDTO dominioNorma;
	public DominioConteudoDTO dominioConteudo;
	public Date dataDocumento; 
	public String texto;
	public String diarioOficialUniao;
}
