package com.github.ammirante.tcc.extracaobacen.extracao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 * BacenExtracaoAPI
 *
 */
@Path("/buscanormativos")
@RegisterRestClient
@Produces(MediaType.APPLICATION_JSON)
public interface BacenExtracaoAPI {

	/**
	 * @param queryText
	 * @param rowLimit
	 * @param startRow
	 * @return
	 */
	@GET
	public RetornoBacen getNormativos(@QueryParam("querytext") String queryText, @QueryParam("rowlimit") String rowLimit, @QueryParam("startrow") String startRow);
	
}
