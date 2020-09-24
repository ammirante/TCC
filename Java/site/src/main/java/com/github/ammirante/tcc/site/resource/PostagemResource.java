package com.github.ammirante.tcc.site.resource;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import com.github.ammirante.tcc.site.dto.AdicionarPostagemDTO;
import com.github.ammirante.tcc.site.entidade.Postagem;
import com.github.ammirante.tcc.site.infra.ConstraintViolationResponse;
import com.github.ammirante.tcc.site.servico.PostagemServico;

@Path("/postagens")
@Tag(name = "Postagem")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class PostagemResource {
	
	@Inject
	PostagemServico postagemServico;

    /**
     * @param adicionarPostagemDTO
     * @return
     */
    @POST
    @APIResponse(responseCode = "201", description = "Postagem cadastrada com suecsso.")
    @APIResponse(responseCode = "400", content = @Content(schema = @Schema(allOf = ConstraintViolationResponse.class)))
    public Postagem adicionarRestaurante(@Valid AdicionarPostagemDTO adicionarPostagemDTO) {
    	postagemServico.cadastrarPostagem(adicionarPostagemDTO);
    	return null;
    }
}