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
@Path("/api")
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
	@Path("/search/app/normativos/buscanormativos")
	public RetornoBacen buscaNormativos(@QueryParam("querytext") String queryText, @QueryParam("rowlimit") String rowLimit, @QueryParam("startrow") String startRow);
	
	/**
	 * @param p1
	 * @param p2
	 */
	@GET
	@Path("/conteudo/app/normativos/exibenormativo")
	public DetalhamentoNormativo exibeNormativo(@QueryParam("p1") String p1, @QueryParam("p2") Integer p2);
	
	/**
	 * @param p1
	 * @param p2
	 */
	@GET
	@Path("/conteudo/app/normativos/exibeoutrasnormas")
	public DetalhamentoOutrosNormativos recuperarOutrasNormas(@QueryParam("p1") String p1, @QueryParam("p2") Integer p2);
	
	
}
