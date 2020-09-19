package com.github.ammirante.tcc.extracaobacen.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Parameters;

/**
 * 
 * DominioNorma
 *
 */
@Entity
@Table(name = "dominio_tipo_norma")
public class DominioNorma extends PanacheEntityBase {

	@Id
	@Column(name = "cd_tipo_Norm", unique = true, nullable = false, insertable = true, updatable = true)
	public Long codigoTipoNorma;
	
	@Column(name = "tx_nome", nullable = false)
	public String nome;
	
	/**
	 * Método responsável por recuperar um Domínio Tipo Norma por nome.
	 * @param nome
	 * @return
	 */
	public static PanacheQuery<PanacheEntityBase> findByNomeIgnoreCase(String nome) {
		return DominioNorma.find("UPPER(nome) = UPPER(:nome)", Parameters.with("nome", nome).map());
	}
}
