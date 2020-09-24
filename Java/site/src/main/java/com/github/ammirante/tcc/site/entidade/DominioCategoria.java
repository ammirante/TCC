package com.github.ammirante.tcc.site.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

/**
 * 
 * DominioCategoria
 *
 */
@Entity
@Table(name = "dominio_categoria")
public class DominioCategoria extends PanacheEntityBase {

	@Id
	@Column(name = "cd_cat")
	public Long codigoCategoria;
	
	@Column(name = "tx_nome", nullable = false, length = 50)
	public String nome;
}
