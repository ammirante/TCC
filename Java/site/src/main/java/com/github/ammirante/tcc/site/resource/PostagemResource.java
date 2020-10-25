package com.github.ammirante.tcc.site.resource;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import com.github.ammirante.tcc.site.dto.AdicionarPostagemDTO;
import com.github.ammirante.tcc.site.dto.AtualizarPostagemDTO;
import com.github.ammirante.tcc.site.dto.DominioCategoriaMapper;
import com.github.ammirante.tcc.site.dto.PostagemDTO;
import com.github.ammirante.tcc.site.dto.PostagemMapper;
import com.github.ammirante.tcc.site.entidade.DominioSituacao;
import com.github.ammirante.tcc.site.entidade.Postagem;
import com.github.ammirante.tcc.site.infra.ConstraintViolationResponse;
import com.github.ammirante.tcc.site.servico.PostagemServico;

/**
 * PostagemResource
 *
 */
@Path("/postagens")
@Tag(name = "Postagem")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class PostagemResource {
	
	@Inject
	PostagemServico postagemServico;
	
	@Inject
	PostagemMapper postagemMapper;
	
	@Inject
	DominioCategoriaMapper dominioCategoriaMapper;

    /**
     * @param adicionarPostagemDTO
     * @return
     */
    @POST
    @APIResponse(responseCode = "201", description = "Postagem cadastrada com suecsso.")
    @APIResponse(responseCode = "400", content = @Content(schema = @Schema(allOf = ConstraintViolationResponse.class)))
    public Response adicionarPostagem(@Valid AdicionarPostagemDTO adicionarPostagemDTO) {
    	postagemServico.cadastrarPostagem(adicionarPostagemDTO);
    	return Response.status(Status.CREATED).build();
    }
    
    @PUT
    @Path("{id}")
    @Transactional
    public void atualizarPostagem(@PathParam("id") Long idPostagem, AtualizarPostagemDTO atualizarPostagemDTO) {
    	Optional<Postagem> postagemOp = Postagem.findByIdOptional(idPostagem);
    	
    	if(postagemOp.isEmpty()) {
    		throw new NotFoundException("Postagem não encontrada.");
    	}
    	
    	Postagem postagem = postagemOp.get();
    	postagemMapper.toPostagem(atualizarPostagemDTO, postagem);
    	postagem.persist();
    }
    
    /**
     * @param idPostagem
     */
    @DELETE
    @Path("{id}")
    @Transactional
    public void deletarPostagem(@PathParam("id") Long idPostagem) {
    	Optional<Postagem> postagemOp = Postagem.findByIdOptional(idPostagem);
    	
    	postagemOp.ifPresentOrElse(Postagem::delete, () -> {
    		throw new NotFoundException("Postagem não encontrada.");
    	});
    }
    
    /**
     * @param idPostagem
     * @return
     */
    @GET
    @Path("{id}")
    public PostagemDTO recuperarPostagem(@PathParam("id") Long idPostagem) {
    	Optional<Postagem> postagemOp = Postagem.findByIdOptional(idPostagem);
    	
    	if(postagemOp.isEmpty()) {
    		throw new NotFoundException("Postagem não encontrada.");
    	}
    	
    	Postagem postagem = postagemOp.get();
    	
    	return postagemMapper.toPostagemDTO(postagem);
    }
    
    /**
     * @return
     */
    @GET
    @Transactional
    public List<PostagemDTO> recuperarPostagens() {
    	Stream<Postagem> postagens = Postagem.streamAll();
    	
    	return postagens.map(postagem -> postagemMapper.toPostagemDTO(postagem)).collect(Collectors.toList());
    }
    
    /**
     * @param idPostagem
     */
    @PATCH
    @Path("{id}/ativar")
    @Transactional
    public void ativarPostagem(@PathParam("id") Long idPostagem) {
    	Optional<Postagem> postagemOp = Postagem.findByIdOptional(idPostagem);
    	
    	if(postagemOp.isEmpty()) {
    		throw new NotFoundException("Postagem não encontrada.");
    	}
    	
    	Postagem postagem = postagemOp.get();
    	postagem.situacao = DominioSituacao.findByNomeIgnoreCase("Inativo").firstResult();
    	postagem.persist();
    }
    
    /**
     * @param idPostagem
     */
    @PATCH
    @Path("{id}/inativar")
    @Transactional
    public void inativarPostagem(@PathParam("id") Long idPostagem) {
    	Optional<Postagem> postagemOp = Postagem.findByIdOptional(idPostagem);
    	
    	if(postagemOp.isEmpty()) {
    		throw new NotFoundException("Postagem não encontrada.");
    	}
    	
    	Postagem postagem = postagemOp.get();
    	postagem.situacao = DominioSituacao.findByNomeIgnoreCase("Ativo").firstResult();
    	postagem.persist();
    }
}