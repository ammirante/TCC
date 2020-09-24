package com.github.ammirante.tcc.site.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.github.ammirante.tcc.site.entidade.Postagem;

/**
 * PostagemMapper
 *
 */
@Mapper(componentModel = "cdi")
public interface PostagemMapper {

	/**
	 * @param adicionarPostagemDTO
	 * @return
	 */
	@Mapping(source = "lstDominioCategoria", target = "lstCategorias")
	@Mapping(source = "referenciaImagemCapa", target = "referenciaImagemCapa")
	@Mapping(source = "descricaoTexto", target = "descricaoTexto")
	@Mapping(target = "dataAtualizacao", ignore = true)
	@Mapping(target = "codigoPostagem", ignore = true)
	@Mapping(target = "dataPostagem", ignore = true)
	@Mapping(target = "situacao", ignore = true)
	@Mapping(source = "titulo", target = "titulo")
	public Postagem toPostagem(AdicionarPostagemDTO adicionarPostagemDTO);
	
	/**
	 * @param postagem
	 * @return
	 */
	@Mapping(source = "situacao", target = "situacao")
	public PostagemDTO toPostagemDTO(Postagem postagem);
	
	/**
	 * @param dto
	 * @param postagem
	 * @return
	 */
	@Mapping(source = "lstDominioCategoria", target = "lstCategorias")
	@Mapping(target = "situacao", ignore = true)
	@Mapping(target = "dataAtualizacao", ignore = true)
	@Mapping(target = "dataPostagem", ignore = true)
	@Mapping(target = "codigoPostagem", ignore = true)
	public Postagem toPostagem(AtualizarPostagemDTO dto, @MappingTarget Postagem postagem);
}
