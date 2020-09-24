package com.github.ammirante.tcc.site.dto;

import java.util.List;

import org.mapstruct.Mapper;

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
}
