package com.github.ammirante.tcc.extracaobacen.resource;

import java.io.IOException;
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
import com.github.ammirante.tcc.extracaobacen.servico.ExtracaoService;

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
	ExtracaoService extracaoServico;
	
    /**
     * @param conteudo
     * @return
     * @throws URISyntaxException
     * @throws IOException 
     */
    @GET
    public RetornoBacen recuperarNormativos(@QueryParam("conteudo") String conteudo) throws URISyntaxException, IOException {
    	extracaoServico.extrairNormas(conteudo);
    	return null;
    }
    
}