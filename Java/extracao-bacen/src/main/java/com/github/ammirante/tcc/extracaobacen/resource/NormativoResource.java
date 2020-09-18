package com.github.ammirante.tcc.extracaobacen.resource;

import java.net.URISyntaxException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import com.github.ammirante.tcc.extracaobacen.extracao.RetornoBacen;
import com.github.ammirante.tcc.extracaobacen.servico.ExtracaoServico;

/**
 * NormativoResource
 *
 */
@Path("/normativos")
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "normativo")
@ApplicationScoped
public class NormativoResource {
	
	@Inject
	ExtracaoServico extracaoServico;
	
    /**
     * @param conteudo
     * @return
     * @throws URISyntaxException
     */
    @GET
    public RetornoBacen recuperarNormativos(@QueryParam("conteudo") String conteudo) throws URISyntaxException {
    	extracaoServico.teste();
    	return null;
    }
    
}