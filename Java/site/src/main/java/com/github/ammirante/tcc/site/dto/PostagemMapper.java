package com.github.ammirante.tcc.site.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.github.ammirante.tcc.site.entidade.Postagem;

/**
 * PostagemMapper
 *
 */
@Mapper(componentModel = "cdi")
public interface PostagemMapper {

	@Mapping(source = "lstDominioCategoria", target = "lstCategorias")
	@Mapping(source = "referenciaImagemCapa", target = "referenciaImagemCapa")
	@Mapping(source = "descricaoTexto", target = "descricaoTexto")
	@Mapping(target = "dataAtualizacao", ignore = true)
	@Mapping(target = "codigoPostagem", ignore = true)
	@Mapping(target = "dataPostagem", ignore = true)
	@Mapping(source = "titulo", target = "titulo")
	public Postagem toPostagem(AdicionarPostagemDTO adicionarPostagemDTO);
}
