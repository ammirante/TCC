package com.github.ammirante.tcc.site.dto;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.github.ammirante.tcc.site.entidade.DominioCategoria;

/**
 * DominioCategoriaMapper
 *
 */
@Mapper(componentModel = "cdi")
public interface DominioCategoriaMapper {

	/**
	 * @param dominioCategoriaDTO
	 * @return
	 */
	public List<DominioCategoria> toDominioCategoria(List<DominioCategoriaDTO> dominioCategoriaDTO);
	
	/**
	 * @param categoria
	 * @return
	 */
	@Mapping(source = "codigoCategoria", target = "codigoCategoria")
	@Mapping(source = "nome", target = "nome")
	public DominioCategoriaDTO toDominioCategoriaDTO(DominioCategoria categoria);
}
