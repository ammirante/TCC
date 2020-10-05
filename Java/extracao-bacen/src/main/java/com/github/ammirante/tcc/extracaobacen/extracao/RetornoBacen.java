package com.github.ammirante.tcc.extracaobacen.extracao;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * RetornoBacen
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RetornoBacen {

	@JsonProperty("TotalRows")
	private Integer totalRows;
	
	@JsonProperty("RowCount")
	private Integer rowCount;
	
	@JsonProperty("Rows")
	private List<Normativo> rows;
	
	public RetornoBacen() {
		
	}
	
	/**
	 * @return the totalRows
	 */
	public Integer getTotalRows() {
		return totalRows;
	}

	/**
	 * @return the rowCount
	 */
	public Integer getRowCount() {
		return rowCount;
	}

	/**
	 * @return the rows
	 */
	public List<Normativo> getRows() {
		return rows;
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return "RetornoBacen [totalRows=" + totalRows + ", rowCount=" + rowCount + ", rows=" + rows + "]";
	}
}
