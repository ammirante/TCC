package com.github.ammirante.tcc.site.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Parameters;

/**
 * 
 * DominioSituacao
 *
 */
@Entity
@Table(name = "dominio_situacao")
public class DominioSituacao extends PanacheEntityBase {

	@Id
	@Column(name = "cd_sit")
	public Long codigoSituacao;
	
	@Column(name = "tx_nome", nullable = false, length = 50)
	public String nome;
	
	/**
	 * Método responsável por recuperar um Domínio de Situação pelo nome.
	 * @param nomeUsuario
	 * @return
	 */
	public static PanacheQuery<PanacheEntityBase> findByNomeIgnoreCase(String nome) {
		return DominioSituacao.find("UPPER(nome) = UPPER(:nome)", Parameters.with("nome", nome).map());
	}
}
