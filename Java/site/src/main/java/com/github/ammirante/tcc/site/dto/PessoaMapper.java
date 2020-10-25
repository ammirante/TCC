package com.github.ammirante.tcc.site.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.github.ammirante.tcc.site.entidade.Pessoa;

/**
 * PessoaMapper
 *
 */
@Mapper(componentModel = "cdi")
public interface PessoaMapper {

	/**
	 * @param adicionarPostagemDTO
	 * @return
	 */
	@Mapping(target = "codigoPessoa", ignore = true)
	@Mapping(target = "dataCadastro", ignore = true)
	@Mapping(target = "dataAtualizacao", ignore = true)
	@Mapping(source = "nome", target = "nome")
	@Mapping(source = "email", target = "email")
	@Mapping(source = "nomeUsuario", target = "nomeUsuario")
	@Mapping(source = "senha", target = "senha")
	public Pessoa toPessoa(AdicionarPessoaDTO adicionarPessoaDTO);
	
}
