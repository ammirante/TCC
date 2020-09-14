package com.github.ammirante.tcc.extracaobacen.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

/**
 * 
 * DominioNorma
 *
 */
@Entity
@Table(name = "dominio_tipo_norma")
@XmlRootElement(name = "dominio_tipo_norma")
public class DominioNorma extends PanacheEntityBase {

	@Id
	@Column(name = "cd_tipo_Norm")
	public Long codigoTipoNorma;
	
	@Column(name = "tx_nome", nullable = false)
	public String nome;
	
}
