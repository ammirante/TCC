package com.github.ammirante.tcc.extracaobacen.resource;

import java.net.URISyntaxException;
import java.util.concurrent.CompletionStage;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.github.ammirante.tcc.extracaobacen.extracao.BacenExtracaoService;
import com.github.ammirante.tcc.extracaobacen.extracao.RetornoBacen;

@Path("/normativos")
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "normativo")
@ApplicationScoped
public class NormativoResource {

	@RestClient
	@Inject
	BacenExtracaoService bacenExtracaoService;
	
    @GET
    public RetornoBacen recuperarNormativos(@QueryParam("conteudo") String conteudo) throws URISyntaxException {
    	RetornoBacen retornoBance = bacenExtracaoService.getNormativos("ContentType:normativo AND contentSource:normativos AND open banking", "15", "0");
    	
    	return bacenExtracaoService.getNormativos("ContentType:normativo AND contentSource:normativos AND open banking", "15", "0");
    }
    
    @GET
    @Path("/async")
    public CompletionStage<RetornoBacen> async(@QueryParam("conteudo") String conteudo) {
    	return bacenExtracaoService.getNormativosAsync("ContentType:normativo AND contentSource:normativos AND open banking", "15", "0");
    }
}