package com.github.ammirante.tcc.extracaobacen.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.github.ammirante.tcc.extracaobacen.entidade.DominioNorma;

/**
 * DominioNormaMapper
 *
 */
@Mapper(componentModel = "cdi")
public interface DominioNormaMapper {

    @Mapping(target = "codigoTipoNorma", numberFormat = "Long")
    @Mapping(target = "nome")
    public DominioNorma toDominioNorma(AdicionarDominioNormaDTO dt);
	
}
