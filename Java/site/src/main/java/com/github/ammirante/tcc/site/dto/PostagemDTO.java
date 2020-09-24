package com.github.ammirante.tcc.site.dto;

import java.util.Date;
import java.util.List;

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
	public DominioSituacaoDTO situacao;
	public PessoaDTO pessoa;
	public List<DominioCategoriaDTO> lstCategorias;

}
