package com.github.ammirante.tcc.extracaobacen.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.github.ammirante.tcc.extracaobacen.entidade.DominioNorma;
import com.github.ammirante.tcc.extracaobacen.infra.DTO;
import com.github.ammirante.tcc.extracaobacen.infra.ValidDTO;

/**
 * AdicionarNormaDTO
 *
 */
@ValidDTO
public class AdicionarNormaDTO extends CadastroDTO implements DTO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9003095946697235403L;

	@NotEmpty
	@NotNull
	public String assunto;

	@NotNull
	public Date dataDocumento;
	
	@NotNull
	public Integer numeroNorma;
	
	@NotNull
	public DominioNorma dominioNorma;
	
	@NotEmpty
	@NotNull
	public String texto;
	
	public String normasVinculadas;
	
	public String diarioOficialUniao;
	
	public String referencia;
}
