package com.github.ammirante.tcc.site.resource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import com.github.ammirante.tcc.site.dto.DominioCategoriaDTO;
import com.github.ammirante.tcc.site.dto.DominioCategoriaMapper;
import com.github.ammirante.tcc.site.entidade.DominioCategoria;

/**
 * CategoriaResource
 *
 */
@Path("/categorias")
@Tag(name = "Categoria")
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class CategoriaResource {
	
	@Inject
	DominioCategoriaMapper dominioCategoriaMapper;

    /**
     * @return
     */
    @GET
    public List<DominioCategoriaDTO> recuperarPostagens() {
    	Stream<DominioCategoria> categorias = DominioCategoria.streamAll();
    	
    	return categorias.map(categoria -> dominioCategoriaMapper.toDominioCategoriaDTO(categoria)).collect(Collectors.toList());
    }
}