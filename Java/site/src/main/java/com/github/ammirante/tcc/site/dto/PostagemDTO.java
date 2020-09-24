package com.github.ammirante.tcc.site.dto;

import java.util.Date;
import java.util.List;

import com.github.ammirante.tcc.site.entidade.DominioCategoria;
import com.github.ammirante.tcc.site.entidade.DominioSituacao;

/**
 * PostagemDTO
 *
 */
public class PostagemDTO extends CadastroDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1677368832998072129L;

	public Long codigoPostagem;
	public String titulo;
	public Date dataPostagem;
	public Date dataAtualizacao;
	public String descricaoTexto;
	public String referenciaImagemCapa;
	public DominioSituacao situacao;
	public PessoaDTO pessoa;
	public List<DominioCategoria> lstCategorias;

}
