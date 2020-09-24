package com.github.ammirante.tcc.site.dto;

import java.sql.Date;

import javax.json.bind.annotation.JsonbDateFormat;

/**
 * PessoaDTO
 *
 */
public class PessoaDTO extends CadastroDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8450222920465045726L;

	public Long codigoPessoa;
	public String nome;
	public String email;
	public String nomeUsuario;

	@JsonbDateFormat(value = "yyyy-MM-dd")
	public Date dataNascimento;
}
