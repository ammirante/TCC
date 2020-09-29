package com.github.ammirante.tcc.extracaobacen.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

import com.github.ammirante.tcc.extracaobacen.entidade.Norma;

/**
 * DominioNormaMapper
 *
 */
@Mapper(componentModel = "cdi")
public interface NormaMapper {

    @Mapping(target = "codigoNorma", ignore = true)
    @Mapping(source = "numeroNorma", target = "numeroNorma", numberFormat = "Integer", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    @Mapping(source = "dataDocumento", target = "dataDocumento")
    @Mapping(source = "assunto", target = "assunto", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    @Mapping(source = "dominioNorma", target = "dominioNorma", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    @Mapping(source = "diarioOficialUniao", target = "diarioOficialUniao")
    @Mapping(source = "referencia", target = "referencia")
    @Mapping(target = "atualizacoes", ignore = true)
    @Mapping(target = "responsavel", ignore = true)
    @Mapping(source = "texto", target = "texto", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    @Mapping(source = "normasVinculadas", target = "normasVinculadas")
    @Mapping(source = "responsavel", target = "responsavel")
    public Norma toNorma(AdicionarNormaDTO dt);
	
}
