package com.github.ammirante.tcc.extracaobacen.extracao;

import java.util.concurrent.CompletionStage;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 * BacenExtracaoService
 *
 */
@Path("/buscanormativos")
@RegisterRestClient
@Produces(MediaType.APPLICATION_JSON)
public interface BacenExtracaoService {

	@GET
	public RetornoBacen getNormativos(@QueryParam("querytext") String queryText, @QueryParam("rowlimit") String rowLimit, @QueryParam("startrow") String startRow);
	
	@GET
	public CompletionStage<RetornoBacen> getNormativosAsync(@QueryParam("querytext") String queryText, @QueryParam("rowlimit") String rowLimit, @QueryParam("startrow") String startRow); 
}
