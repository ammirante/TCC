package com.github.ammirante.tcc.site.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Parameters;

/**
 * 
 * Pessoa
 *
 */
@Entity
@Table(name = "pessoa")
public class Pessoa extends PanacheEntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_pss")
	public Long codigoPessoa;
	
	@Column(name = "tx_nome", nullable = false)
	public String nome;
	
	@CreationTimestamp
	@Column(name = "ts_cad", nullable = false, updatable = false)
	public Date dataCadastro;
	
	/*@Column(name = "ts_nsc")
	public Date dataNascimento;*/
	
	@Column(name = "tx_mail", length = 100)
	public String email;
	
	@Column(name = "tx_nome_usr", unique = true, nullable = false, length = 30)
	public String nomeUsuario;
	
	@Column(name = "tx_snh", nullable = false)
	//@ColumnTransformer(read = "pgp_sym_decrypt(senha, ‘mySecretKey’)", write = "pgp_sym_encrypt(?, ‘mySecretKey’)")
	public String senha;
	
	@UpdateTimestamp
	@Column(name = "dt_atlc")
	public Date dataAtualizacao;
	
	/**
	 * Método responsável por recuperar uma Pessoa através do nome do usuário.
	 * @param nomeUsuario
	 * @return
	 */
	public static PanacheQuery<PanacheEntityBase> findByNomeUsuarioIgnoreCase(String nomeUsuario) {
		return Pessoa.find("UPPER(nomeUsuario) like UPPER(:nomeUsuario)", Parameters.with("nomeUsuario", nomeUsuario).map());
	}
	
}
