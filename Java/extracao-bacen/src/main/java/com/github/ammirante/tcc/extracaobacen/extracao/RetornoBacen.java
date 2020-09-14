package com.github.ammirante.tcc.extracaobacen.extracao;

import java.util.List;

/**
 * RetornoBacen
 *
 */
public class RetornoBacen {

	private Integer totalRows;
	private Integer rowCount;
	private List<Normativo> rows;
	
	/**
	 * 
	 */
	public RetornoBacen() {
		
	}
	
	/**
	 * @param totalRows
	 * @param rowCount
	 * @param rows
	 */
	public RetornoBacen(Integer totalRows, Integer rowCount, List<Normativo> rows) {
		super();
		this.totalRows = totalRows;
		this.rowCount = rowCount;
		this.rows = rows;
	}


	/**
	 * @return the totalRows
	 */
	public Integer getTotalRows() {
		return totalRows;
	}

	/**
	 * @param totalRows the totalRows to set
	 */
	public void setTotalRows(Integer totalRows) {
		this.totalRows = totalRows;
	}

	/**
	 * @return the rowCount
	 */
	public Integer getRowCount() {
		return rowCount;
	}

	/**
	 * @param rowCount the rowCount to set
	 */
	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}

	/**
	 * @return the rows
	 */
	public List<Normativo> getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(List<Normativo> rows) {
		this.rows = rows;
	}
}
