package com.github.ammirante.tcc.site.resource;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import com.github.ammirante.tcc.site.dto.AdicionarPessoaDTO;
import com.github.ammirante.tcc.site.dto.PessoaMapper;
import com.github.ammirante.tcc.site.entidade.Pessoa;
import com.github.ammirante.tcc.site.infra.ConstraintViolationResponse;
import com.github.ammirante.tcc.site.security.TokenService;

/**
 * UsuarioResource
 *
 */
@Path("/usuarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResource {
	
	@Inject
	TokenService tokenService;
	
	@Inject
	PessoaMapper pessoaMapper;
	
	/**
	 * @param adicionarPessoaDTO
	 * @return
	 */
	@POST
	@Path("cadastrar")
	@Transactional
	@APIResponse(responseCode = "201", description = "Pessoa cadastrada com suecsso.")
    @APIResponse(responseCode = "400", content = @Content(schema = @Schema(allOf = ConstraintViolationResponse.class)))
	public Pessoa cadastrar(AdicionarPessoaDTO adicionarPessoaDTO) {
		Pessoa pessoa = pessoaMapper.toPessoa(adicionarPessoaDTO);
		pessoa.persist();
		return pessoa;
	}
	
    /**
     * @param login
     * @param senha
     * @return
     */
    @GET
    @Path("/login")
    public String login(@QueryParam("login")String login, @QueryParam("senha") String senha) {
        Pessoa pessoa = Pessoa.find("nomeUsuario", login).firstResult();
        if(pessoa == null || !pessoa.senha.equals(senha)) {
            throw new WebApplicationException(Response.status(404).entity("Usuário ou senha inválido.").build());
        }
        return tokenService.generateAdminToken(pessoa.email, senha);
    }

}
